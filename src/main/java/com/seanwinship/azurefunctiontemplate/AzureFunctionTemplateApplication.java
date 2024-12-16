package com.seanwinship.azurefunctiontemplate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(exclude = {org.springframework.boot.autoconfigure.gson.GsonAutoConfiguration.class})
public class AzureFunctionTemplateApplication {

    public static void main(String[] args) {
        SpringApplication.run(AzureFunctionTemplateApplication.class, args);
    }
    
}
