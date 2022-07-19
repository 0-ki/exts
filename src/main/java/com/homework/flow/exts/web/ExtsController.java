package com.homework.flow.exts.web;

import com.homework.flow.exts.domain.Extension;
import com.homework.flow.exts.dto.extension.ExtensionDTO;
import com.homework.flow.exts.service.extension.ExtsService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
public class ExtsController {

    private final ExtsService service;
    @GetMapping("/exts")
    public List<Extension> getAllExtensions() {
        return service.findAll();
    }

    @PostMapping("/exts/{id}")
    public String edit(@PathVariable(required = true)int id, @RequestBody ExtensionDTO extensionDTO) {
        log.info("extensionDTO={extensionDTO}");
        service.update(extensionDTO);
        return "";
    }
}
