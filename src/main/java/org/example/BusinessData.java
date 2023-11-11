package org.example;

import java.util.List;
import java.util.Map;

public class BusinessData {
    public double revenue= 0.0;
    public double expenses= 0.0;
    private List<Map<String,Map<String,Object>>> productInfo;

    
    public List<Map<String,Map<String,Object>>> getProductInfo() {
        return productInfo;
    }

    public void setProductInfo(List<Map<String, Map<String, Object>>> productInfo) {
        this.productInfo = productInfo;
    }

    public double getExpenses() {

        return expenses;
    }

    public void setExpenses() {

        for(Map<String, Map<String, Object>> entry : productInfo){
            for(Map.Entry<String, Map<String, Object>> innerEntry : entry.entrySet() ){
                Map<String, Object> innerMap = innerEntry.getValue();
                this.expenses += Integer.parseInt(String.valueOf(innerMap.get("amount")))-Integer.parseInt(String.valueOf(innerMap.get("cost price")));
            }
        }



    }

    public double getRevenue() {
        return revenue;
    }

    public void setRevenue(double revenue) {
        this.revenue = revenue;
    }


    // Other relevant metrics


}

