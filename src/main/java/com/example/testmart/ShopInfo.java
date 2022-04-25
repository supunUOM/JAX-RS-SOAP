package com.example.testmart;

import com.example.exception.InvalidInputException;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

@WebService
@SOAPBinding(style = SOAPBinding.Style.RPC) //RPC type will omit validated with xsd schema document
                                            //Default type is Style.Document
public class ShopInfo {

    @WebMethod
    @WebResult(partName = "lookupOutput") //override the return property name (return -> lookupOutput)
    public String getShopInfo(@WebParam(partName = "lookupInput") String property) {
        String response = "invalid property";
        if (property.equals("shopName")) {
            response = "Test Mart";
        } else if (property.equals("since")) {
            response = "since 2012";
        }
        return response;
    }

    /** getShopInfo()
     * //request
     *  <S:Body xmlns:ns2="http://testmart.example.com/">
     *         <ns2:getShopInfo>
     *             <lookupInput>shopName</lookupInput>
     *         </ns2:getShopInfo>
     *  </S:Body>
     *
     * //response
     *  <S:Body xmlns:ns2="http://testmart.example.com/">
     *         <ns2:getShopInfoResponse>
     *             <lookupOutput>Test Mart</lookupOutput>
     *         </ns2:getShopInfoResponse>
     *  </S:Body>
     */

    //test for exception handling
    @WebMethod
    public String getShopDetails(@WebParam(partName = "lookupInput") String property) throws InvalidInputException{
        String response = "invalid property";
        if (property.equals("shopName")) {
            response = "Test Mart";
        } else if (property.equals("since")) {
            response = "since 2012";
        }else if(property.equals("invalid")){
            throw new InvalidInputException("invalid input", property+" is not valid input");
        }
        return response;
    }
}
