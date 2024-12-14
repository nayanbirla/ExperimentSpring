package com.expermient.controller;

import com.expermient.Service.User;
import com.expermient.dto.Employee;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@RestController
@RequestMapping(value = "/api/")
public class TestController1 {

    @Autowired
    User user;

    public TestController1() {
        System.out.println("Test controller1 instance initialzation");
    }

    @PostConstruct
    public void init(){
        System.out.println("testController1 Object hashcode: "+this.hashCode()+" User Object hashCode: "+ user.hashCode());
    }

    @GetMapping(path = "/fetchUser")
    public ResponseEntity<String> getUserDetails(@Value("${name}")String name) throws Exception{
        System.out.println("fetchUser api invoked "+ this.hashCode());
        System.out.println("User api invoked "+ user.hashCode());
        System.out.println(name +" current: "+Thread.activeCount());
        Thread.getAllStackTraces().keySet().forEach(thread -> {
            System.out.println("Thread Name: " + thread.getName() +
                    ", State: " + thread.getState() +
                    ", Is Daemon: " + thread.isDaemon());
        });
        user.usercall();

        return ResponseEntity.status(HttpStatus.OK).body("");
    }

    // for gzip
    @GetMapping("/employees")
    public List<Employee> getLargeResponse() {
        List<String> genders = Arrays.asList("Male", "Female", "Other");
        List<String> departments = Arrays.asList("HR", "Finance", "Engineering", "Sales", "Marketing");
        List<String> skills = Arrays.asList("Java", "Spring Boot", "SQL", "Kafka", "MongoDB");

        return IntStream.rangeClosed(1, 10000)
                .mapToObj(i -> new Employee(
                        i,
                        "emp" + i,
                        String.valueOf(new Random().nextLong(1000000000L)),
                      "address" + i,
                        genders.get(new Random().nextInt(genders.size())),
                        departments.get(new Random().nextInt(departments.size())),
                        skills.get(new Random().nextInt(skills.size()))
                ))
                .collect(Collectors.toList());
    }
}
