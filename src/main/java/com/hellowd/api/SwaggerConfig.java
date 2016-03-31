/*
 *  Copyright(c) 2015 Helloworld. All rights reserved.
 *  This software is the proprietary information of Helloworld.
 */

package com.hellowd.api;

import org.springframework.context.annotation.Configuration;

/**
 * Created by Helloworld
 * User : USER
 * Date : 2015-11-02
 * Time : 오후 6:31
 * To change this template use File | Settings | File and Code Templates.
 */
@Configuration
@EnableSwagger
@EnableAutoConfiguration
public class SwaggerConfig {

    private SpringSwaggerConfig springSwaggerConfig;

    @Autowired
    public void setSpringSwaggerConfig(SpringSwaggerConfig springSwaggerConfig) {
        this.springSwaggerConfig = springSwaggerConfig;
    }

    @Bean
    public SwaggerSpringMvcPlugin customImplementation() {
        return new SwaggerSpringMvcPlugin(this.springSwaggerConfig)
                //Root level documentation
                .apiInfo(new ApiInfo(
                        "Central Authorisation Service JSON API",
                        "This service provides a JSON representation of the LDAP identity data held in the Central Authorisation Service",
                        null,
                        null,
                        null,
                        null
                ))
                .useDefaultResponseMessages(false)
                        //Map the specific URL patterns into Swagger
                .includePatterns("/id/.*","/my");
    }

}