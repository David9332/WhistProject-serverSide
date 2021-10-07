package com.example.WhistProject.Controller;

import com.example.WhistProject.Beans.Product;
import com.example.WhistProject.Beans.Sales;
import com.example.WhistProject.Exception.UserErrorException;
import com.example.WhistProject.Service.SalesImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;

@RestController
@RequestMapping("Sales")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:3000", allowedHeaders = "*")
public class SalesController {
    private final SalesImpl salesImpl;

//    @PostMapping("addSale")
//    @ResponseStatus(code = HttpStatus.CREATED)
//    public void addSalesListToDB(@RequestBody List<Sales> salesList) throws UserErrorException {
//        salesImpl.addSalesListToDB(salesList);
//    }

    @PostMapping("updateSale")
    @ResponseStatus(code = HttpStatus.ACCEPTED)
    public void updateSale(@RequestBody Product product) throws UserErrorException {
        salesImpl.updateSale(product);
    }
}

