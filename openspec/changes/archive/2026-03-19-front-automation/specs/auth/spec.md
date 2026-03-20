# Auth Specification

## Purpose
Automate the registration process of users on the FoodTech platform, validating successful and failed registration flows as per the Screenplay automation test suite.

## Requirements

### Requirement: Successful User Registration
The system MUST allow a new user to register and see a success confirmation when providing unique and valid data.

#### Scenario: Successful registration with a new email
- GIVEN the user is on the registration screen
- WHEN they complete the form with valid and unique data (Name, Email, Password)
- AND they submit the registration request
- THEN they MUST see a successful registration message
- AND the registration MUST NOT show an error message

### Requirement: Failed User Registration with Existing Email
The system MUST prevent registering a new account using an email that is already registered, and show an appropriate error message.

#### Scenario: Failed registration with an existing email
- GIVEN the user is on the registration screen
- AND there is an existing account with the email "existing.user@foodtech.com"
- WHEN they complete the form with the already registered email
- AND they submit the registration request
- THEN they MUST see an error message indicating the email already exists
- AND the registration MUST NOT be completed
