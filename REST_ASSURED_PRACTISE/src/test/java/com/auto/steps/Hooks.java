package com.auto.steps;

import com.auto.utils.ConfigReader;
import io.cucumber.java.Before;
import io.restassured.RestAssured;

public class Hooks {

    @Before
    public void setUp(){
        ConfigReader.initConfig();
        RestAssured.baseURI = "https://reqres.in/api";
    }

}
