# Tasks: Front-End Automation with Screenplay

## Phase 1: Infrastructure & Configuration

- [x] 1.1 Update `app/build.gradle` to include Serenity BDD, Screenplay, Cucumber, and JUnit dependencies. Remove `apply plugin: 'application'` if redundant.
- [x] 1.2 Delete `app/src/test/java/com/automation/AppTest.java` (default gradle scaffolding test) to prevent runner pollution.
- [x] 1.3 Create `app/src/test/resources/serenity.conf` globally defining webdriver properties, base URL, and credentials (environments `prod` or `dev`).
- [x] 1.4 Create `app/src/test/resources/features/registro_usuarios.feature` containing the scenarios for user registration.
- [x] 1.5 Create `app/src/test/resources/features/facturacion.feature` containing the scenario for billing/orders.

## Phase 2: Core Models & UI Targets

- [x] 2.1 Create `app/src/test/java/com/automation/models/UserData.java` as a Data Record with name, email, and password.
- [x] 2.2 Create `app/src/test/java/com/automation/models/OrderData.java` as a Data Record with tableId, productName, etc.
- [x] 2.3 Create `app/src/test/java/com/automation/ui/RegisterPage.java` defining static `Target` fields for name, email, password, submit button, and success/error messages.
- [x] 2.4 Create `app/src/test/java/com/automation/ui/LoginPage.java` defining static `Target` fields.
- [x] 2.5 Create `app/src/test/java/com/automation/ui/OrderPage.java` defining static non-dynamic and dynamic (parameterized) `Target` fields for tables and products.

## Phase 3: Screenplay Tasks & Questions

- [x] 3.1 Create `app/src/test/java/com/automation/tasks/OpenRegistrationPage.java`.
- [x] 3.2 Create `app/src/test/java/com/automation/tasks/RegisterUser.java` (handles filling out user data and submitting).
- [x] 3.3 Create `app/src/test/java/com/automation/tasks/Login.java`.
- [x] 3.4 Create `app/src/test/java/com/automation/tasks/SelectTable.java`.
- [x] 3.5 Create `app/src/test/java/com/automation/tasks/AddProduct.java`.
- [x] 3.6 Create `app/src/test/java/com/automation/tasks/GenerateInvoice.java` (including sending to kitchen and capturing invoice string).
- [x] 3.7 Create questions for Auth: `RegistrationSuccessMessageDisplayed`, `RegistrationErrorMessageDisplayed`, `RegistrationWasNotCompleted`.
- [x] 3.8 Create questions for Orders: `InvoiceSuccessMessageDisplayed`.

## Phase 4: Step Definitions & Runners

- [x] 4.1 Create `app/src/test/java/com/automation/runners/CucumberTestSuite.java` using `@RunWith(CucumberWithSerenity.class)`.
- [x] 4.2 Create `app/src/test/java/com/automation/stepdefinitions/RegistrationStepDefinitions.java` binding Gherkin to the Auth tasks.
- [x] 4.3 Create `app/src/test/java/com/automation/stepdefinitions/FacturacionStepDefinitions.java` binding Gherkin to Order/Login tasks.
- [ ] 4.4 Run `gradle clean test` and verify that Serenity finds the runner and steps (expected to fail until UI is implemented, but ensures wiring).