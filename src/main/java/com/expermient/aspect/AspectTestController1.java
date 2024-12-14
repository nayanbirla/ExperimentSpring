package com.expermient.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class AspectTestController1 {

    @Before("execution(* com.expermient.controller.TestController1.getUserDetails(String))")
    public void beforeMethod() {
        System.out.println("Aspect for TestController1 method invocation");
    }


}
