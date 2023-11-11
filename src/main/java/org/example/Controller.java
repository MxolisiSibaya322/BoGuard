package org.example;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import io.javalin.http.Context;
import io.javalin.http.Handler;

import java.io.IOException;
import java.util.*;



public class Controller {

    static List<JsonNode> productsData = new ArrayList<>();
    public static final Handler add_product = context -> {
        String product = "product";
        Map<String, JsonNode> viewmodel = new HashMap<>();
        for(int i=0; i < productsData.size(); i++){
            viewmodel.put(product+String.valueOf(i), productsData.get(i));
        }
        Map<String, Map<String, JsonNode>> finData = Map.of("products", viewmodel);
        context.render("/addproduct.html", finData );
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



        //get all params from form
        String hashMap=Web3Engine.addProduct(Web3Engine.web3j, Web3Engine.credentials, Web3Engine.contractAddress, manufacturer, manufactureDateTime, expiryDate, productDescription,locationManufactured,batchNumber );
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode jsonNode = objectMapper.createObjectNode()
                .put("manufacturer", manufacturer)
                .put("manufactureDateTime", manufactureDateTime)
                .put("expiryDate", expiryDate)
                .put("productDescription", productDescription)
                .put("locationManufactured", locationManufactured)
                .put("batchNumber", batchNumber)
                .put("hash", hashMap);
        productsData.add(jsonNode);
        context.result("Product set successfully!");


//        Map<String, Object> viewModel = Map.of("town", locationManufactured, "province", productDescription, "schedule", Schedule);

        //interact with API to get the schedules needed
        context.redirect(Routes.ADD_PRODUCT);
    };

    public static final Handler verfification = context ->{

        String hash = context.pathParam("hashcode");
        JsonNode product = new ObjectMapper().createObjectNode();
        Map<String, Object> viewModel;
        boolean verified = false;
        try{
        if (Web3Engine.confirmTransactionHash(hash)){
            for(JsonNode i: productsData){
                if(i.get("hash").asText().equalsIgnoreCase(hash)){
                    verified= true;
                    viewModel = Map.of("manufacturer", i.get("manufacturer"),
                                    "manufactureDateTime", i.get("manufactureDateTime"),
                                    "expiryDate", i.get("expiryDate"),
                                    "productDescription", i.get("productDescription"),
                                    "locationManufactured", i.get("locationManufactured"),
                                    "batchNumber", i.get("batchNumber"),
                                    "hash", i.get("hashMap"),
                            "verified", verified);
                                    QRCodeGenerator.generateQRCode(i.get("hashmap").asText());
                                    verified = true;
                                    context.render("/verification.html");

                                    break;

                                    }

            }

        }


        }catch (NoSuchElementException e){
            viewModel = Map.of("verified", verified);
            context.render("/verification.html", viewModel);
        }
    };




    public static final Handler trendAnalysisHandler = context ->{
        BusinessData businessData = generateSampleData();


        context.render("/TrendAnalysis.html", Map.of("businessData", businessData));
    };

    private static BusinessData generateSampleData() throws IOException {
        // Generate or retrieve sample business data
        // ...
        BusinessData data = new BusinessData();
        List<Map<String, Map<String, Object>>> sampleData = Database.readJsonFile("src/database.json");

        data.setProductInfo(sampleData);
        data.setExpenses();
        return data;
    }


}
