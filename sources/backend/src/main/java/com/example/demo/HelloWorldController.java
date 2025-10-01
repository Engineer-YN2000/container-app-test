package com.example.demo;
import java.util.Random;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

    @GetMapping("/hello")
    public ResponseEntity<String> sayHello() {
        if (new Random().nextDouble() < 0.3) {
            System.out.println("Intentional error triggered!");

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                                    .body("💥 An intentional error occurred in the backend!");
        } else {
            return ResponseEntity.ok("Hello World from Java! 🌍");
        }
    }
}
