package com.homework.flow.exts.web;

import com.homework.flow.exts.domain.Extension;
import com.homework.flow.exts.service.extension.ExtsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ExtsController {

    private final ExtsService service;

    @GetMapping("/exts")
    public List<Extension> getAllExtensions() {
        return service.findAll();
    }

    @GetMapping("/hi")
    public String sayHi(){
        return "hi";
    }
}
