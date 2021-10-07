package com.example.WhistProject.CLR;

import com.example.WhistProject.Beans.Product;
import com.example.WhistProject.Beans.Sales;
import com.example.WhistProject.Service.ProductImpl;
import com.example.WhistProject.Service.SalesImpl;
import com.example.WhistProject.Utills.Art;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
@RequiredArgsConstructor
public class BuildingDB implements CommandLineRunner {
    private final ProductImpl productImpl;
    private final SalesImpl salesImpl;

    @Override
    public void run(String... args) throws Exception {
        System.out.println(Art.sperator);
        System.out.println();
        System.out.println(Art.INIT_DATABASE);

        Product product1 = Product.builder().title("BugZapper").description("Best Electric Indoor Bug Zappers").price(25.0).image("https://th.bing.com/th/id/OIP.8sMKKbDJm0wWjS5DGOmPmAHaHa?pid=ImgDet&rs=1").build();
        Product product2 = Product.builder().title("Printer").description("Canon PIXMA TS6420 Wireless Inkjet All-in-One Printer 4462C002").price(1200.0).image("https://www.bhphotovideo.com/images/images2500x2500/canon_4462c002_pixma_ts6420_wireless_inkjet_1591705.jpg").build();
        Product product3 = Product.builder().title("Laptop").description("LG 13.3\" gram Multi-Touch Laptop 13Z990-A.AAS5U1 B&H").price(3600.0).image("https://www.bhphotovideo.com/images/images2500x2500/lg_13z990_a_aas5u1_gram_i5_8265u_8gb_256ssd_1459830.jpg").build();
        Product product4 = Product.builder().title("Microwave").description("BALAY MICROONDAS 3WGX-2018").price(800.0).image("https://www.electrodomesticosopalo.es/cache/f/1/a/1/5/f1a15a7160452fa04193338d8dd9f68a43c3f57e.jpg").build();
        Product product5 = Product.builder().title("TV").description("10 LCD TV Png Icon Images").price(900.0).image("http://www.newdesignfile.com/postpic/2014/10/lcd-flat-screen-tv_244818.png").build();
        Product product6 = Product.builder().title("Toaster").description("Kenwood 2 Slice Toaster Metal TCM01.A0BK").price(150.0).image("https://securecontent.jackyselectronics.com/Images/product-images/ee71f8b5-0aeb-4cff-bb0b-d17cd96f3b2b.jpg").build();
        Product product7 = Product.builder().title("Drone").description("Ferngesteuerte Drohne Yuneec Q500 4k Kaufen").price(1000.0).image("https://global-uploads.webflow.com/5993a9fb6c6b200001c5318a/5bf391a0830b15460e29b6fc_DJI%20Tello%20For%20Sale.jpg").build();
        Product product8 = Product.builder().title("DishWasher").description("Siemens iQ700 SN278I36TE 60cm Jubilee Freestanding Dishwasher – STAINLESS STEEL").price(3600.0).image("https://www.hellomagazine.com/imagenes/homes/2020102398925/best-budget-dishwashers-and-smart-eco-friendly-options/0-476-575/siemens-dishwasher-z.jpg").build();
        Product product9 = Product.builder().title("Refrigerator").description("HA10TG31SS -10.1 Cu. Ft. Top Freezer Refrigerator | Haier ").price(2100.0).image("https://products.haierappliances.com/MarketingObjectRetrieval/Dispatcher?RequestType=Image&Variant=Original&Name=HA10TG31SS-688057308463_2.jpg").build();
        Product product10 = Product.builder().title("Oven").description("Whirlpool 5.0 cu. ft. Single Wall Oven with True Convection - WOS97ES0ES").price(1800.0).image("https://www.peterboroughappliances.com/files/image/attachment/14160/WOS97ES0ES2.jpg").build();

        List<Product> products = Arrays.asList(product1, product2, product3, product4, product5, product6, product7, product8, product9, product10);
        productImpl.addProductsListToDB(products);

        Sales sales1 = Sales.builder().title("BugZapper").sold(0).build();
        Sales sales2 = Sales.builder().title("Printer").sold(0).build();
        Sales sales3 = Sales.builder().title("Laptop").sold(0).build();
        Sales sales4 = Sales.builder().title("Microwave").sold(0).build();
        Sales sales5 = Sales.builder().title("TV").sold(0).build();
        Sales sales6 = Sales.builder().title("Toaster").sold(0).build();
        Sales sales7 = Sales.builder().title("Drone").sold(0).build();
        Sales sales8 = Sales.builder().title("DishWasher").sold(0).build();
        Sales sales9 = Sales.builder().title("Refrigerator").sold(0).build();
        Sales sales10 = Sales.builder().title("Oven").sold(0).build();

        List<Sales> salesList = Arrays.asList(sales1, sales2, sales3, sales4, sales5, sales6, sales7, sales8, sales9, sales10);
        salesImpl.addSalesListToDB(salesList);

//        salesImpl.addSale("Printer");
//        salesImpl.addSale("Printer");
//        salesImpl.addSale("Laptop");
//        salesImpl.addSale("Printer");
//        salesImpl.addSale("Printer");
//        salesImpl.addSale("TV");
//        salesImpl.addSale("Microwave");
//        salesImpl.addSale("TV");
//        salesImpl.addSale("Microwave");


        System.out.println(Art.sperator);
        System.out.println();
        System.out.println(Art.DATABASE_READY);

    }
}
