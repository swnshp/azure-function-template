package com.seanwinship.azurefunctiontemplate.functions;

import java.util.Optional;

import org.springframework.stereotype.Component;

import com.microsoft.azure.functions.ExecutionContext;
import com.microsoft.azure.functions.HttpMethod;
import com.microsoft.azure.functions.HttpRequestMessage;
import com.microsoft.azure.functions.HttpResponseMessage;
import com.microsoft.azure.functions.HttpStatus;
import com.microsoft.azure.functions.annotation.AuthorizationLevel;
import com.microsoft.azure.functions.annotation.FunctionName;
import com.microsoft.azure.functions.annotation.HttpTrigger;
import com.microsoft.azure.functions.annotation.WarmupTrigger;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class Function {

    /**
     * 
     * This function will be code when a node starts up.  If it's a scaled out note, it will not be available to the
     * load balancer until this completes.  If the function should warm up any caches, do it here.
     */
    @FunctionName("Warmup")
    public void warmup( @WarmupTrigger Object warmupContext, ExecutionContext context) throws InterruptedException {

    } 

    /**
     * 
     * This function can be called by the Azure Health Check.  It must be anonymous as
     * per https://learn.microsoft.com/en-us/azure/app-service/monitor-instances-health-check?tabs=java#authentication-and-security
     *  
     */
    @FunctionName("health")
    public HttpResponseMessage health(@HttpTrigger( 
        name = "req",
        methods = {HttpMethod.GET},
        authLevel = AuthorizationLevel.ANONYMOUS)
        HttpRequestMessage<Optional<String>> request,
            final ExecutionContext context) {

        return request.createResponseBuilder(HttpStatus.OK).build();
    }

    /**
     * 
     * This HTTP trigger demonstrates how the logging works
     */
    @FunctionName("logSomething")
    public HttpResponseMessage logSomething(
            @HttpTrigger( 
                name = "req",
                methods = {HttpMethod.GET, HttpMethod.POST},
                authLevel = AuthorizationLevel.FUNCTION)
                HttpRequestMessage<Optional<String>> request,
            final ExecutionContext context) {

        log.debug("Debug");
        log.info("Info");
        log.warn("Warning");
        log.error("Error");

        return request.createResponseBuilder(HttpStatus.OK).build();
    }
}
