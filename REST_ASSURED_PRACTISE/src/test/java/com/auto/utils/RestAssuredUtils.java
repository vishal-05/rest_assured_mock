package com.auto.utils;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class RestAssuredUtils {
    static RequestSpecification reqSpecification = RestAssured.given();
    static Response response;
    static String endPoint;

    public static void setEndPoint(String endPoint) {
        RestAssuredUtils.endPoint = endPoint;
    }

    public static void setHeader(String header, String value){
        reqSpecification.header(header, value);
    }

    public static void setBody(Object pojo){
        try{
            reqSpecification.body(pojo);
        } catch(Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void get(){
        reqSpecification.log().all();
        response =reqSpecification.get(endPoint);
        response.then().log().all();
    }

    public static void post(){
        reqSpecification.log().all();
        response =reqSpecification.post(endPoint);
        response.then().log().all();
    }

    public static void put(){
        reqSpecification.log().all();
        response =reqSpecification.put(endPoint);
        response.then().log().all();
    }

    public static void delete(){
        reqSpecification.log().all();
        response =reqSpecification.delete(endPoint);
        response.then().log().all();
    }

    public static int getStatusCode(){
        return response.getStatusCode();
    }
    public static String getDataFromJsonFile(String fileName) throws FileNotFoundException {
        String jsonFolderPath = "src/test/resources/data/";
        Scanner sc = new Scanner(new FileInputStream(jsonFolderPath + fileName));
        String body = sc.useDelimiter("\\Z").next();
        return body;
    }
    public static Response getResponse() {
        return response;
    }

}
