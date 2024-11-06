package com.auto.steps;

import com.auto.pojo.CreateUserPojo;
import com.auto.utils.ConfigReader;
import com.auto.utils.RestAssuredUtils;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class RequestSteps {
    @Given("user wants to call {string} end point")
    public void user_wants_to_call_endPoint(String endPoint) {
        RestAssuredUtils.setEndPoint(endPoint);
    }

    @Given("set header {string} to {string}")
    public void set_header_to(String key, String value) {
        RestAssuredUtils.setHeader(key, value);
    }

    @Given("set request body from file {string}")
    public void set_request_body_from_file(String filePath) throws Exception {
        String content = RestAssuredUtils.getDataFromJsonFile(filePath);
        ObjectMapper objectMapper = new ObjectMapper();
        CreateUserPojo requestPojo = objectMapper.readValue(content, CreateUserPojo.class);
        RestAssuredUtils.setBody(requestPojo);
        ConfigReader.setProperty("request_pojo", content);
    }

    @When("user performs post call")
    public void user_performs_post_call() {
        RestAssuredUtils.post();
    }
    @When("user performs put call")
    public void user_performs_put_call() {
        RestAssuredUtils.put();
    }

    @When("user performs delete call")
    public void user_performs_delete_call() {
        RestAssuredUtils.delete();
    }

    @When("user performs get call")
    public void user_performs_get_call() {
        RestAssuredUtils.get();
    }

}
