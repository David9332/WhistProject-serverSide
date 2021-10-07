package com.example.WhistProject.Service;

import com.example.WhistProject.Beans.Product;
import com.example.WhistProject.Beans.Sales;
import com.example.WhistProject.Exception.UserErrorException;
import com.example.WhistProject.Repositories.ProductRepo;
import com.example.WhistProject.Repositories.SalesRepo;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Setter
@Getter
public class SalesImpl implements SalesService {
    private final SalesRepo salesRepo;

    public void addSalesListToDB(List<Sales> salesList) throws UserErrorException {
        for (Sales sales : salesList) {
            salesRepo.save(sales);
        }
    }

    public void updateSale(Product product) throws UserErrorException {
        Sales itemSold = salesRepo.findByTitle(product.getTitle());
        if (itemSold != null) {
            itemSold.setSold(itemSold.getSold() + 1);
            salesRepo.save(itemSold);
        }
    }
}
