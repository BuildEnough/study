package com.example.demo;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CoffeeMaker {

    @Autowired
    private List<CoffeeMachine> coffeeMachines;

    @PostConstruct
    public void makeCoffee() {
        for (CoffeeMachine coffeeMachine : coffeeMachines) {
            System.out.println(coffeeMachine.brew());
        }
    }
}
