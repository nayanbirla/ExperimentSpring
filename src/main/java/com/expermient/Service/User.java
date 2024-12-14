package com.expermient.Service;

import jakarta.annotation.PostConstruct;
import org.springframework.context.annotation.Scope;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class User {
    public User() {
    }
    @PostConstruct
    public void init(){
        System.out.println("User Object hashCode: "+this.hashCode());
    }

    @Async
    public void usercall() throws Exception
    {
        System.out.println("namaste");
        System.out.println(Thread.currentThread().getName());
        Thread.sleep(20000);
        System.out.println("india");
    }
}
