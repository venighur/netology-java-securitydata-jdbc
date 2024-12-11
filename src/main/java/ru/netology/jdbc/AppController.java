package ru.netology.jdbc;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AppController {
    private final AppRepository repository;

    public AppController(AppRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/products/fetch-product")
    public List<String> getProductName(@RequestParam String name) {
        return repository.getProductName(name);
    }
}
