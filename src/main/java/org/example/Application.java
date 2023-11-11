package org.example;

import io.javalin.apibuilder.EndpointGroup;
import io.javalin.plugin.rendering.template.JavalinThymeleaf;
import io.javalin.Javalin;
import io.javalin.http.staticfiles.Location;
import nz.net.ultraq.thymeleaf.layoutdialect.LayoutDialect;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;
import org.web3j.abi.datatypes.generated.Uint256;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.http.HttpService;
import org.web3j.tx.gas.DefaultGasProvider;

import java.math.BigInteger;

public class Application {

    public static final int DEFAULT_PORT = 7000;
    private final String html = "/html";
    private Javalin server;

    public static void main(String[] args) {
        Application app = new Application();
        app.configureHttpServer();
        app.start();
    }



    private Javalin configureHttpServer(){
        JavalinThymeleaf.configure(templateEngine());
        server = Javalin.create( config -> {config.addStaticFiles(html, Location.CLASSPATH);});
        Routes.configure(this);
        return server;
    }

    public void routes(EndpointGroup group) {
        server.routes(group);
    }
    public void start(){
        server.start( DEFAULT_PORT );
    }

    private TemplateEngine templateEngine() {
        TemplateEngine templateEngine = new TemplateEngine();
        ClassLoaderTemplateResolver resolver = new ClassLoaderTemplateResolver();
        resolver.setPrefix(html);
        templateEngine.setTemplateResolver(resolver);
        templateEngine.addDialect(new LayoutDialect());
        return templateEngine;
    }
}
