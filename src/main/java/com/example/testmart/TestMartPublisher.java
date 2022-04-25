package com.example.testmart;

import javax.xml.ws.Endpoint;

public class TestMartPublisher {
    /**
     * this JAX-WS app previously deployed with glassfish app server
     * but this is run with jdk (no need Java EE jdk)
     * <h1>Metro</h1> is doing all things for us
     */
    public static void main(String[] args) {
        Endpoint.publish("http://localhost:1234/productCatalog", new ProductCatalog());
    }
}
