/*
 *  Copyright(c) 2015 Helloworld. All rights reserved.
 *  This software is the proprietary information of Helloworld.
 */

package com.hellowd.api.controller;

import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

/**
 * Created by Helloworld
 * User : USER
 * Date : 2015-11-02
 * Time : 오후 6:30
 * To change this template use File | Settings | File and Code Templates.
 */
@RestController
public class UserLookupController {

    @Autowired
    LdapService ldapService;

    @ApiOperation(value="Get the currently logged in users details",notes="Uses the remote user logged in")
    @RequestMapping(value="/my",method= RequestMethod.GET)
    public @ResponseBody
    Person getMyDetails(HttpServletRequest request) throws ServletException
    {
        if (request.getRemoteUser()==null)
        {
            throw new ServletException("Remote user is null.");
        }
        return ldapService.getPerson(request.getRemoteUser());
    }

    @ApiOperation(value="Get a specific users details",notes="Requires uid of user to look up")
    @RequestMapping(value="/id/{uid}",method=RequestMethod.GET)
    public @ResponseBody Person getUserDetails(@PathVariable("uid") String uid)
    {
        return ldapService.getPerson(uid);
    }

}