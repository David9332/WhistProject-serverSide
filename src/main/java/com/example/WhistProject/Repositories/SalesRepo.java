package com.example.WhistProject.Repositories;

import com.example.WhistProject.Beans.Product;
import com.example.WhistProject.Beans.Sales;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SalesRepo extends JpaRepository<Sales, Integer> {

    Sales findByTitle(String title);

}
