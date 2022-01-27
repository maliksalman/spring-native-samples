package com.example.demo;

import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class HelloController {

    @GetMapping("/hello")
    public Hello sayHello() {
        return Hello.builder()
                .index(100)
                .message("Hello, world!")
                .build();
    }

    @Data
    @Builder
    static class Hello {

        private String message;
        private int index;
    }
}
