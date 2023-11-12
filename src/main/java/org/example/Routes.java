package org.example;

import static io.javalin.apibuilder.ApiBuilder.post;
import static io.javalin.apibuilder.ApiBuilder.get;


public class Routes {

    public static final String ADD_PRODUCT = "/addproduct";
    public static final String VERIFY_PRODUCT = "/verify/{hashcode}";
    public static final String PRODUCT_ACTION = "/product.action";
    public  static final String TREND_ANALYSIS ="/trend-analysis";



    public static void configure(Application server) {
        server.routes(() -> {
            get(VERIFY_PRODUCT, Controller.verfification);
            get(ADD_PRODUCT, Controller.add_product );
            post(PRODUCT_ACTION, Controller.product_action);
            get(TREND_ANALYSIS,Controller.trendAnalysisHandler);
            get("/signupComplete",Controller.signupComplete);
        });
    }
}
