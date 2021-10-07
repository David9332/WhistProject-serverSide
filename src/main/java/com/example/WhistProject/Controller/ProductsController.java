package com.example.WhistProject.Controller;

import com.example.WhistProject.Beans.Product;
import com.example.WhistProject.Beans.UserDetails;
import com.example.WhistProject.Exception.UserErrorException;
import com.example.WhistProject.Service.ProductImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("products")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:3000", allowedHeaders = "*")
public class ProductsController {
    private final ProductImpl productImpl;

    @PostMapping("login")
    public boolean login(@RequestBody UserDetails userDetails) throws UserErrorException {
        return productImpl.login(userDetails.getEmail(), userDetails.getPassword());
    }

    @GetMapping("getAllProducts")
    public ResponseEntity<?> getAllProducts() throws UserErrorException{
        return new ResponseEntity<>(productImpl.getAllProducts(), HttpStatus.OK);
    }

    @DeleteMapping("deleteProduct/{productId}")
    @ResponseStatus(code = HttpStatus.OK)
    public void deleteProduct(@PathVariable int productId) throws UserErrorException {
        productImpl.deleteProduct(productId);
    }

    @PostMapping("addProduct")
    @ResponseStatus(code = HttpStatus.CREATED)
    public void addProduct(@RequestBody Product product) throws UserErrorException {
        productImpl.addProduct(product);
    }

    @PostMapping("updateProduct")
    @ResponseStatus(code = HttpStatus.ACCEPTED)
    public void updateProduct(@RequestBody Product product) throws UserErrorException {
        productImpl.updateProduct(product);
    }
}
