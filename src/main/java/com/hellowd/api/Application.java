/*
 *  Copyright(c) 2015 Helloworld. All rights reserved.
 *  This software is the proprietary information of Helloworld.
 */

package com.hellowd.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Helloworld
 * User : USER
 * Date : 2015-11-02
 * Time : 오후 6:32
 * To change this template use File | Settings | File and Code Templates.
 */
@Configuration
@ComponentScan("uk.ac.ed.ca")
@EnableAutoConfiguration
public class Application {

    public static void main(String[] args)
    {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    @ConfigurationProperties(prefix="ldap.contextSource")
    public LdapContextSource contextSource() {
        LdapContextSource contextSource = new LdapContextSource();
        return contextSource;
    }

    @Bean
    public LdapTemplate ldapTemplate(ContextSource contextSource) {
        return new LdapTemplate(contextSource);
    }

}