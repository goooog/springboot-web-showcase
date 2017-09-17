package com.goooog.springboot.showcase;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

import java.awt.*;
import java.net.URI;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class WebStarter extends SpringBootServletInitializer {

    /**
     * Configure your application when it’s launched by the servlet container
     */
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(WebStarter.class);
    }

    public static void main(String[] args) throws Exception {

        SpringApplication.run(WebStarter.class, args);
        System.setProperty("java.awt.headless", "false");
        Desktop.getDesktop().browse(new URI("http://127.0.0.1:8080"));
    }

}

