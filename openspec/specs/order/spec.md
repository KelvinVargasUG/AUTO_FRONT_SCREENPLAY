# Order Specification

## Purpose
Automate the process of a waiter or user selecting an available demo table, adding products, sending the order to the kitchen, and generating an invoice successfully on the FoodTech platform using Screenplay.

## Requirements

### Requirement: Successful Invoice Generation
The system MUST allow an authenticated user to create an order and generate an invoice successfully after checkout.

#### Scenario: Successful invoice generation after an order
- GIVEN the user is successfully logged into the platform
- AND they select an available table
- AND they add valid products to the order
- WHEN they send the order to the kitchen
- AND they generate an invoice for the order
- THEN they MUST see a success message indicating the invoice was generated
