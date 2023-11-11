package org.example;

import io.javalin.http.Handler;

import java.util.Map;
import java.util.Objects;



public class Controller {


    public static final Handler add_product = context -> {
        context.render("/addproduct.html");
    };

    public static final Handler product_action = context -> {
        String manufacturer = context.formParamAsClass("manufacturer", String.class)
                .check(Objects::nonNull, "Manufacturer is required")
                .get();
        String manufactureDateTime = context.formParamAsClass("manufactureDateTime", String.class)
                .check(Objects::nonNull, "manufactureDateTime is required")
                .get();
        String expiryDate = context.formParamAsClass("expiryDate", String.class)
                .check(Objects::nonNull, "Manufacturer is required")
                .get();
        String productDescription = context.formParamAsClass("productDescription", String.class)
                .check(Objects::nonNull, "manufactureDateTime is required")
                .get();
        String locationManufactured = context.formParamAsClass("locationManufactured", String.class)
                .check(Objects::nonNull, "Manufacturer is required")
                .get();
        String batchNumber = context.formParamAsClass("batchNumber", String.class)
                .check(Objects::nonNull, "manufactureDateTime is required")
                .get();

        System.out.println(Web3Engine.credentials);

        //get all params from form
        Web3Engine.addProduct(Web3Engine.web3j, Web3Engine.credentials, Web3Engine.contractAddress, manufacturer, manufactureDateTime, expiryDate, productDescription,locationManufactured,batchNumber );
        context.result("Product set successfully!");



//        Map<String, Object> viewModel = Map.of("town", locationManufactured, "province", productDescription, "schedule", Schedule);

        //interact with API to get the schedules needed
        context.redirect(Routes.ADD_PRODUCT);
    };
}
