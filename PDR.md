
# Especificación de automatización Front-End con Screenplay

## Objetivo general

Automatizar en una aplicación web tres flujos funcionales usando el patrón **Screenplay** con Serenity BDD, garantizando separación de responsabilidades, mantenibilidad y cobertura de escenarios positivos y negativos.

Los flujos a automatizar son:

1. **Registro exitoso de un nuevo usuario**
2. **Registro fallido con correo ya registrado**
3. **Generación exitosa de factura al finalizar un pedido**

---

# Alcance

La automatización debe cubrir:

* navegación hacia las pantallas necesarias
* ingreso de datos
* interacción con formularios, botones y elementos dinámicos
* validación de mensajes de éxito y error
* validación del resultado esperado de cada flujo

La solución debe implementarse con el patrón **Screenplay**, evitando mezclar localizadores, lógica de negocio y validaciones en una misma clase.

---

# Requisitos técnicos de implementación

## Patrón obligatorio

Se debe usar **Screenplay**, separando como mínimo:

* **Actor**
* **Tasks**
* **Questions**
* **Targets**
* **Step Definitions**
* **Runner**

## Criterios de diseño

* Cada **Task** debe tener una sola responsabilidad.
* Los localizadores deben centralizarse en clases de UI.
* Los escenarios deben ser independientes.
* No debe compartirse estado entre escenarios.
* Los datos de prueba deben poder parametrizarse.
* Las validaciones deben hacerse mediante **Questions** o asserts desacoplados.

## Estructura sugerida

* `tasks/`
* `questions/`
* `ui/`
* `models/`
* `utils/`
* `stepdefinitions/`
* `runners/`

---

# Funcionalidad 1: Registro de usuarios

## Objetivo

Validar tanto el comportamiento exitoso como el comportamiento de rechazo del sistema durante el registro de usuarios.

---

## Escenario 1: Registro exitoso de un nuevo usuario

### Objetivo

Validar que un usuario puede registrarse correctamente al ingresar datos válidos y únicos, y que el sistema muestra un mensaje de confirmación exitosa.

### Precondiciones

* La aplicación debe estar disponible.
* El correo usado en la prueba no debe existir previamente.
* El usuario no debe estar autenticado.

### Datos de prueba

* **Email único:** `testuser+timestamp@foodtech.com`
* **Password válida:** `Test1234!`
* **Nombre:** `Kelvin Test`
* Otros campos obligatorios con valores válidos

### Selectores recomendados

* Email: `input[name="email"]` o `data-testid="register-email-input"`
* Password: `input[name="password"]` o `data-testid="register-password-input"`
* Nombre: `input[name="name"]` o `data-testid="register-name-input"`
* Botón registro: `button[type="submit"]` o `data-testid="register-button"`
* Mensaje de éxito: `data-testid="register-success-message"`

### Resultado esperado

El sistema registra correctamente al usuario y muestra un mensaje visible de registro exitoso.

### Validaciones mínimas

* el formulario acepta datos válidos
* el registro se envía correctamente
* aparece el mensaje de éxito
* el mensaje de éxito es visible
* no aparece mensaje de error

---

## Escenario 2: Registro fallido con correo ya registrado

### Objetivo

Validar que el sistema impide el registro cuando se usa un correo que ya existe y muestra un mensaje de error apropiado.

### Precondiciones

* La aplicación debe estar disponible.
* Debe existir previamente una cuenta con el correo usado en la prueba.
* El usuario no debe estar autenticado.

### Datos de prueba

* **Email existente:** `existing.user@foodtech.com`
* **Password válida:** `Test1234!`
* **Nombre:** `Kelvin Test`
* Otros campos obligatorios con valores válidos

### Selectores recomendados

* Email: `input[name="email"]` o `data-testid="register-email-input"`
* Password: `input[name="password"]` o `data-testid="register-password-input"`
* Nombre: `input[name="name"]` o `data-testid="register-name-input"`
* Botón registro: `button[type="submit"]` o `data-testid="register-button"`
* Mensaje de error: `data-testid="register-error-message"`
* Mensaje de éxito: `data-testid="register-success-message"`

### Resultado esperado

El sistema no permite completar el registro y muestra un mensaje indicando que el correo ya existe o que ya se encuentra registrado.

### Validaciones mínimas

* el formulario se envía con datos válidos
* el correo usado ya existe en el sistema
* aparece mensaje de error
* no aparece mensaje de éxito
* el usuario no queda registrado
* opcionalmente, permanece en la pantalla de registro

---

## Gherkin unificado para registro

```gherkin
Feature: Registro de usuarios

  Scenario: Registro exitoso de un nuevo usuario
    Given que el usuario se encuentra en la pantalla de registro
    When completa el formulario con datos válidos y únicos
    And envía la solicitud de registro
    Then debería visualizar un mensaje de registro exitoso

  Scenario: Registro fallido con correo ya registrado
    Given que el usuario se encuentra en la pantalla de registro
    And existe previamente una cuenta registrada con ese correo
    When completa el formulario con un correo ya registrado
    And envía la solicitud de registro
    Then debería visualizar un mensaje indicando que el correo ya existe
    And no debería completarse el registro
```

---

# Funcionalidad 2: Generación de factura al finalizar pedido

## Escenario 3: Generación exitosa de factura luego de registrar un pedido

### Objetivo

Validar que un usuario autenticado puede seleccionar una mesa, agregar productos, enviar el pedido y generar correctamente una factura.

### Precondiciones

* La aplicación debe estar disponible.
* El usuario debe existir y tener credenciales válidas.
* Debe existir al menos una mesa disponible.
* Debe haber productos demo disponibles.
* Debe existir la opción de generar factura después del pedido.

### Datos de prueba

* Usuario autenticado
* Mesa demo disponible
* Productos demo
* Datos del cliente para factura, si el sistema los solicita

### Selectores recomendados

#### Login

* `input[name="email"]`
* `input[name="password"]`
* `button[data-testid="login-button"]`

#### Mesa

* `div[data-testid="table-item-{id}"]`

#### Producto

* `div[data-testid="product-item-{name}"]`

#### Pedido

* `button[data-testid="add-order-btn"]`
* `button[data-testid="send-to-kitchen-btn"]`

#### Factura

* `button[data-testid="generate-invoice-btn"]`
* `data-testid="invoice-success-message"`

### Resultado esperado

El sistema permite completar el pedido y genera la factura exitosamente, mostrando un mensaje visible de confirmación.

### Validaciones mínimas

* el usuario inicia sesión correctamente
* la mesa queda seleccionada
* se agrega al menos un producto al pedido
* el pedido se envía a cocina
* se genera la factura
* aparece el mensaje de éxito de factura

---

## Gherkin para facturación

```gherkin
Feature: Facturación de pedidos

  Scenario: Generación exitosa de factura al finalizar un pedido
    Given que el usuario inicia sesión correctamente en la plataforma
    And selecciona una mesa disponible
    And agrega productos válidos al pedido
    When envía el pedido a cocina
    And genera la factura del pedido
    Then debería visualizar un mensaje de factura generada exitosamente
```

---

# Modelo de datos sugerido

## `UserData`

Campos sugeridos:

* `name`
* `email`
* `password`

## `OrderData`

Campos sugeridos:

* `tableId`
* `productName`
* `customerName`
* `customerDocument`
* `customerEmail`

---

# Targets sugeridos

## Registro

* `REGISTER_NAME_INPUT`
* `REGISTER_EMAIL_INPUT`
* `REGISTER_PASSWORD_INPUT`
* `REGISTER_BUTTON`
* `REGISTER_SUCCESS_MESSAGE`
* `REGISTER_ERROR_MESSAGE`

## Login y pedido

* `LOGIN_EMAIL_INPUT`
* `LOGIN_PASSWORD_INPUT`
* `LOGIN_BUTTON`
* `TABLE_ITEM`
* `PRODUCT_ITEM`
* `ADD_ORDER_BUTTON`
* `SEND_TO_KITCHEN_BUTTON`
* `GENERATE_INVOICE_BUTTON`
* `INVOICE_SUCCESS_MESSAGE`

Para elementos dinámicos como mesa y producto, se recomienda definir métodos parametrizados para construir el `Target`.

---

# Tasks sugeridas

## Para registro

### `OpenRegistrationPage`

Abre la pantalla de registro.

### `RegisterWithValidData`

Diligencia el formulario con datos válidos y únicos.

### `RegisterWithExistingEmail`

Diligencia el formulario con un correo ya registrado.

### `SubmitRegistration`

Envía el formulario de registro.

## Para pedido y facturación

### `LoginWithValidCredentials`

Autentica al usuario.

### `SelectAvailableTable`

Selecciona una mesa disponible.

### `ChooseProduct`

Selecciona un producto.

### `AddProductToOrder`

Agrega el producto al pedido.

### `SendOrderToKitchen`

Envía el pedido.

### `GenerateInvoice`

Genera la factura.

---

# Questions sugeridas

## Registro

### `RegistrationSuccessMessageDisplayed`

Valida visibilidad del mensaje de éxito.

### `RegistrationErrorMessageDisplayed`

Valida visibilidad del mensaje de error.

### `RegistrationWasNotCompleted`

Valida que el registro no se completó.

## Facturación

### `InvoiceSuccessMessageDisplayed`

Valida visibilidad del mensaje de factura generada.

### `GenerateInvoiceButtonEnabled`

Opcionalmente valida habilitación del botón de facturación.

---

# Criterios de aceptación generales

## Registro exitoso

Se considera exitoso si:

* el sistema permite registrar al usuario
* se muestra el mensaje de éxito
* no se presenta error

## Registro fallido

Se considera correcto si:

* el sistema rechaza el registro con correo existente
* se muestra mensaje de error
* no se muestra mensaje de éxito

## Facturación exitosa

Se considera exitosa si:

* el usuario inicia sesión
* selecciona mesa
* agrega productos
* envía el pedido
* genera factura
* el sistema muestra mensaje de éxito

---

# Reglas de independencia de escenarios

## Registro exitoso

Debe usar un correo único en cada ejecución.

## Registro fallido

Debe usar un correo previamente existente y estable en el ambiente.

## Facturación

Debe iniciar sesión desde cero y no depender del registro del escenario anterior.

Ningún escenario debe depender del orden de ejecución.

---

# Riesgos a contemplar

## Registro

* el correo duplicado no existe en el ambiente
* el mensaje de error cambia
* el mensaje de éxito tarda en aparecer
* el formulario tiene validaciones frontend adicionales

## Facturación

* no hay mesas disponibles
* no hay productos demo
* el botón de generar factura no se habilita
* el flujo requiere campos extra de cliente
* hay latencia o loaders entre pasos

---

# Conjunto final de escenarios

```gherkin
Feature: Automatización Front-End con Screenplay

  Scenario: Registro exitoso de un nuevo usuario
    Given que el usuario se encuentra en la pantalla de registro
    When completa el formulario con datos válidos y únicos
    And envía la solicitud de registro
    Then debería visualizar un mensaje de registro exitoso

  Scenario: Registro fallido con correo ya registrado
    Given que el usuario se encuentra en la pantalla de registro
    And existe previamente una cuenta registrada con ese correo
    When completa el formulario con un correo ya registrado
    And envía la solicitud de registro
    Then debería visualizar un mensaje indicando que el correo ya existe
    And no debería completarse el registro

  Scenario: Generación exitosa de factura al finalizar un pedido
    Given que el usuario inicia sesión correctamente en la plataforma
    And selecciona una mesa disponible
    And agrega productos válidos al pedido
    When envía el pedido a cocina
    And genera la factura del pedido
    Then debería visualizar un mensaje de factura generada exitosamente
```