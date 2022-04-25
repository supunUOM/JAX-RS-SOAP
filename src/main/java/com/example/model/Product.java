package com.example.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(namespace = "Product")  //JAXB(Java Architecture of Xml Binding) annotation
@XmlType(propOrder = {"price", "sku", "name"})  //JAXB annotation for determine order
public class Product {

    private String name;
    private String sku;
    private double price;

    public Product(){} // JAXB need the default constructor

    public Product(String name, String sku, double price) {
        this.name = name;
        this.sku = sku;
        this.price = price;
    }


    @XmlElement(name = "ProductName")  //JAXB annotation for customize property name
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
