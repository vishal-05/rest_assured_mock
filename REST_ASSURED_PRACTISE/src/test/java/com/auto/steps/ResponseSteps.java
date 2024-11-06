package com.auto.steps;

import com.auto.pojo.CreateUserPojo;
import com.auto.utils.RestAssuredUtils;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.restassured.response.Response;
import org.junit.Assert;

public class ResponseSteps {
    @Then("verify status code is {int}")
    public void verify_status_code_is(int statusCode){
        Assert.assertEquals(RestAssuredUtils.getStatusCode(), statusCode);
    }

    @And("verify response body has a field is {string}")
    public void verifyResponseBodyHasAFieldIs(String value) {
        Assert.assertEquals("token", value);
    }
}
