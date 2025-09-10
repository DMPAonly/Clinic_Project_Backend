package com.example.demo.Controllers;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.products;
import com.example.demo.repository.ProductsRepository;

@CrossOrigin(origins = {"http://localhost:5173/"}, methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PATCH, RequestMethod.DELETE})
@RestController
@RequestMapping("/products")
public class ProductsController {
    private final ProductsRepository productsRepository;

    public ProductsController(ProductsRepository productsRepository) {
        this.productsRepository = productsRepository;
    }

    @GetMapping("/getAll") 
    public List<products> getAllProducts() {
        return productsRepository.findAll();
    }

    @PostMapping("/insertProduct")
    public String insertProduct(@RequestBody products product) {
        productsRepository.save(product);
        return "Product inserted";
    }

    @PatchMapping("/updateProduct")
    public String updateProduct(@RequestBody products product) {
        productsRepository.save(product);
        return "Product Updated";
    }

    @DeleteMapping("/deleteProduct/{id}")
    public String deleteProduct(@PathVariable String id) {
        productsRepository.deleteById(id);
        return "Product Deleted";
    }
}
