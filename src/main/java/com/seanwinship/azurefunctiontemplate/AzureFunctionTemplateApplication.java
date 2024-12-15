package com.seanwinship.azurefunctiontemplate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan
public class AzureFunctionTemplateApplication {

    public static void main(String[] args) {
        SpringApplication.run(AzureFunctionTemplateApplication.class, args);
    }
    
}
