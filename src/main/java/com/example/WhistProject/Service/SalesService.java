package com.example.WhistProject.Service;

import com.example.WhistProject.Beans.Product;
import com.example.WhistProject.Beans.Sales;
import com.example.WhistProject.Exception.UserErrorException;

import java.util.List;

public interface SalesService {

    void addSalesListToDB(List<Sales> salesList) throws UserErrorException;

    void updateSale(Product product) throws UserErrorException;

    }
