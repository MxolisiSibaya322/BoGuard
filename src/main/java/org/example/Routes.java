package org.example;

import static io.javalin.apibuilder.ApiBuilder.post;
import static io.javalin.apibuilder.ApiBuilder.get;


public class Routes {

    public static final String ADD_PRODUCT = "/addproduct";
    public static final String VERIFY_PRODUCT = "/verify";
    public static final String PRODUCT_ACTION = "/product.action";


    public static void configure(Application server) {
        server.routes(() -> {
//            get(VERIFY_PRODUCT, ); //TODO
            get(ADD_PRODUCT, Controller.add_product ); //TODO
            post(PRODUCT_ACTION, Controller.product_action);
        });
    }
}
