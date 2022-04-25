package com.example.testmart;

import com.example.model.Product;

import javax.jws.WebMethod;
import javax.jws.WebResult;
import javax.jws.WebService;
import java.util.List;

@WebService(name = "TestMartCatalog")
//don't provide values in @WebService for portName, serviceName, targetNameSpace
//because these values should depend on interface implementations
public interface ProductCatalogI {

    @WebMethod(action = "fetch_categories", operationName = "fetchCategories")
        //@WebMethod -this is optional (all the public methods are considered as web methods)
    List<String> getProductCategories();

    @WebMethod(exclude = true)
    List<String> getProducts(String category);

    @WebMethod
         //when changing the existing method name obviously going to change wsdl also
         //So we create new version on behalf of getProducts() method.
    @WebResult(name = "Product")
        //default result <return>...<price></price><sku></sku><ProductName></ProductName>...</return>
        //using name property of @WebResult <Product>...other_values...</Product>
    List<Product> getProductsV2(String category);

    @WebMethod(exclude = true)
        //we can exclude method using exclude property
    boolean addProduct(String category, String product);
}
