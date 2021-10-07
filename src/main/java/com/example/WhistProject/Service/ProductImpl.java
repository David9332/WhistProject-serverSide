package com.example.WhistProject.Service;

import com.example.WhistProject.Beans.Product;
import com.example.WhistProject.Beans.Sales;
import com.example.WhistProject.Exception.UserErrorException;
import com.example.WhistProject.Repositories.ProductRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductImpl implements ProductService {
    private final ProductRepo productRepo;

    public boolean login(String email, String password) throws UserErrorException {
        String adminEmail = "admin@admin.com";
        String adminPassword = "admin";
        if ((adminEmail.equals(email) && adminPassword.equals(password))) {
            return true;
        }
        throw new UserErrorException("* Login failed. You either typed wrong details, or this account doesn't exist.");
    }

    public void addProductsListToDB(List<Product> products) throws UserErrorException {
        for (Product product : products) {
            productRepo.save(product);
        }
    }

    /**
     * Gets all products in the DB into a list.
     *
     * @return - A list of products.
     */
    @Override
    public List<Product> getAllProducts() {
        return productRepo.findAll();
    }

    /**
     * Receives a Coupon object from the user, first checks the validation conditions, then checks if the coupon
     * already exists in the data base, and if it doesn't - adds it to the data base and to the company's
     * coupons list.
     *
     * @param product - A Product object. Given by the user.
     * @throws UserErrorException - The coupon already exists in the database.
     */
    @Override
    public void addProduct(Product product) throws UserErrorException {
        if (product.getTitle().equals("")) {
            throw new UserErrorException("* The 'title' field can't be empty." +
                    " \nAdding failed.");
        }
        if (product.getDescription().equals("")) {
            throw new UserErrorException("* The 'description' field can't be empty." +
                    " \nAdding failed.");
        }
        if (product.getImage().equals("")) {
            throw new UserErrorException("* The 'image' field can't be empty." +
                    " \nAdding failed.");
        }
        if (product.getPrice() < 0) {
            throw new UserErrorException("* The price can't be below zero." +
                    " \nAdding failed.");
        }
        productRepo.save(product);
    }

    /**
     * Receives a Coupon object from the user, checks if the coupon already exists in the
     * data base, and if it does - updates it by the coupon object.
     *
     * @param product - A Product object. Given by the user.
     * @throws UserErrorException - The coupon does not exist.
     */
    @Override
    public void updateProduct(Product product) throws UserErrorException {
        if (product.getTitle().equals("")) {
            throw new UserErrorException("* The 'title' field can't be empty." +
                    " \nUpdate failed.");
        }
        if (product.getDescription().equals("")) {
            throw new UserErrorException("* The 'description' field can't be empty." +
                    " \nUpdate failed.");
        }
        if (product.getImage().equals("")) {
            throw new UserErrorException("* The 'image' field can't be empty." +
                    " \nUpdate failed.");
        }
        if (product.getPrice() < 0) {
            throw new UserErrorException("* The price can't be below zero." +
                    " \nUpdate failed.");
        }
        productRepo.saveAndFlush(product);
    }

    /**
     * Checks if a coupon exists in the data base (by id), and if it does - deletes it.
     *
     * @param productId - The id of the coupon.
     * @throws UserErrorException - The coupon does not exist in the data base.
     */
    @Override
    public void deleteProduct(int productId) throws UserErrorException {
        productRepo.deleteById(productId);
    }
//
//    /**
//     * Gets a coupon from the data base (by id), checks that:
//     * 1. It wasn't already purchased by the customer.
//     * 2. That there are more the 0 coupons of that kind.
//     * 3. That its end-date had not already passed.
//     * If all the above are ture, it adds a purchase and decreases the amount of coupons by 1.
//     *
//     * @param couponId - The id of the coupon.
//     * @throws UserErrorException   - 1. coupon already purchased by that customer.
//     *                              2. There is no customer with that id.
//     * @throws CouponStockException - 1. There are no more coupons of that kind in our stock.
//     *                              2. The end date of this coupon has already passed
//     */
//    @Override
//    public void purchaseProduct(int couponId) throws UserErrorException {
//        Product product = productRepo.findById(couponId).orElseThrow(() -> new UserErrorException("* There is no coupon with that id. Purchase failed."));
//        productRepo.save(product);
//    }
}
