package com.homework.flow.exts.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExtsController {

    @GetMapping("/hi")
    public String sayHi(){
        return "hi";
    }
}
