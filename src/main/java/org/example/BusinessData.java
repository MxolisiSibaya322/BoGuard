package org.example;

import java.util.Map;

public class BusinessData {
    public double revenue= 0.0;
    public double expenses= 0.0;
    private Map<String,Map<String,Object>> productInfo;

    
    public Map<String, Map<String, Object>> getProductInfo() {
        return productInfo;
    }

    public void setProductInfo(Map<String, Map<String, Object>> productInfo) {
        this.productInfo = productInfo;
    }

    public double getExpenses() {

        return expenses;
    }

    public void setExpenses() {
        for(Map<String,Object> product: productInfo.values()){
            this.expenses += Integer.parseInt(String.valueOf(product.get("amount")))-Integer.parseInt(String.valueOf(product.get("cost price")));
        }

//        this.expenses =;
    }

    public double getRevenue() {
        return revenue;
    }

    public void setRevenue(double revenue) {
        this.revenue = revenue;
    }


    // Other relevant metrics


}

