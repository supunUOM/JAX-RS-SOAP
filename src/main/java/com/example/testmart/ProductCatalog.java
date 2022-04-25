package com.example.testmart;

import com.example.business.ProductServiceImpl;
import com.example.model.Product;

import javax.jws.WebService;
import java.util.List;

@WebService(endpointInterface = "com.example.testmart.ProductCatalogI",
        portName = "TestMartCatalogPort",
        serviceName = "TestMartCatalogService",
        targetNamespace = "https://www.testmart.com")
//portName, serviceName, targetNameSpace depending on each implementation
public class ProductCatalog implements ProductCatalogI {

    ProductServiceImpl productService = new ProductServiceImpl();

    @Override
    public List<String> getProductCategories() {
        return productService.getProductCategories();
    }

    @Override
    public List<String> getProducts(String category) {
        return productService.getProducts(category);
    }

    @Override
    public List<Product> getProductsV2(String category) {
        return productService.getProductsV2(category);
    }

    @Override
    public boolean addProduct(String category, String product) {
        return productService.addProduct(category, product);
    }
}
