package com.example.demo;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component("dripCoffeeMachine")
//@Primary
public class DripCoffeeMachine implements CoffeeMachine {

    public String brew() {
        return "Brewing coffee with Drip Coffee Machine";
    }
}
