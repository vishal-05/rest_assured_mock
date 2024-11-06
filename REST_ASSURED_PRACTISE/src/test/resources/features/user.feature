Feature: Validate Create User End Point

  Scenario: User performs end to end testing
    Given user wants to call "/users?page=2" end point
    When user performs get call
    Then verify status code is 200

    Given user wants to call "/users" end point
    And set header "Content-Type" to "application/json"
    And set request body from file "create_user.json"
    When user performs post call
    Then verify status code is 201

    Given user wants to call "/users/2" end point
    And set header "Content-Type" to "application/json"
    And set request body from file "create_user.json"
    And user performs put call
    Then verify status code is 200

    Given user wants to call "/users" end point
    And user performs delete call
    Then verify status code is 204

    Given user wants to call "/register" end point
    And set header "Content-Type" to "application/json"
    And set request body from file "register_user.json"
    When user performs post call
    Then verify status code is 200
    And verify response body has a field is "token"

    Given user wants to call "/login" end point
    And set header "Content-Type" to "application/json"
    And set request body from file "register_user.json"
    When user performs post call
    Then verify status code is 200

