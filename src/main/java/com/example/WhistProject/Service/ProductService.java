package com.example.WhistProject.Service;

import com.example.WhistProject.Beans.Product;
import com.example.WhistProject.Beans.Sales;
import com.example.WhistProject.Exception.UserErrorException;

import java.util.List;

public interface ProductService {

    boolean login(String email, String password) throws UserErrorException;

    void addProductsListToDB(List<Product> products) throws UserErrorException;

    List<Product> getAllProducts();

    void addProduct(Product product) throws UserErrorException;

    void updateProduct(Product product) throws UserErrorException;

    void deleteProduct(int productId) throws UserErrorException;
}
