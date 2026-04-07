# TEST INVENTORY — AUTO_FRONT_SCREENPLAY
# Proyecto: Serenity BDD + Cucumber + Screenplay Pattern
# Aplicación bajo prueba: FoodTech-Front (http://localhost:5173)

---

## Identificadores del proyecto

| Item | Valor |
|------|-------|
| Framework | Serenity BDD 4.1.20 + Cucumber 7.14.0 |
| Patrón | Screenplay (Actor / Task / Question) |
| Runner | `com.automation.runners.CucumberTestSuite` |
| Glue | `com.automation.stepdefinitions` |
| Lenguaje features | Español (`#language: es`) |
| Base URL | `http://localhost:5173` |
| Credenciales válidas | `demo@foodtech.com` / `kv20012001` |
| Comando de ejecución | `./gradlew test` |

---

## Feature 1 — Registro de Usuarios
**Archivo:** `src/test/resources/features/registro_usuarios.feature`
**StepDefs:** `com.automation.stepdefinitions.RegistrationStepDefinitions`

| # | Escenario | Identificador Cucumber |
|---|-----------|----------------------|
| 1.1 | Registro exitoso de un nuevo usuario | `Registro de usuarios::Registro exitoso de un nuevo usuario` |
| 1.2 | Registro fallido con correo ya registrado | `Registro de usuarios::Registro fallido con correo ya registrado` |

**Capas Screenplay involucradas:**
- UI: `RegisterPage` (locators: `#username`, `#email`, `#password`, `[data-testid='login-button']`)
- Tasks: `OpenRegistrationPage`, `RegisterUser`
- Questions: `RegistrationSuccessMessageDisplayed`, `RegistrationErrorMessageDisplayed`, `RegistrationWasNotCompleted`

---

## Feature 2 — Facturación de Pedidos
**Archivo:** `src/test/resources/features/facturacion.feature`
**StepDefs:** `com.automation.stepdefinitions.FacturacionStepDefinitions`

| # | Escenario | Identificador Cucumber |
|---|-----------|----------------------|
| 2.1 | Generación exitosa de factura para un pedido completado | `Facturación de pedidos::Generación exitosa de factura para un pedido completado` |

**Capas Screenplay involucradas:**
- UI: `LoginPage`, `InvoicePage` (locators: `[data-testid='completed-orders-btn']`, `[data-testid='invoice-btn-{index}']`, `[data-testid='invoice-toast']`)
- Tasks: `Login`, `NavigateToCompletedOrders`, `InvoiceOrder`
- Questions: `InvoiceSuccessMessageDisplayed`

---

## Feature 3 — Catálogo de Productos (Admin) ← NUEVO
**Archivo:** `src/test/resources/features/catalogo_productos.feature`
**StepDefs:** `com.automation.stepdefinitions.CatalogoStepDefinitions`

| # | Escenario | Identificador Cucumber |
|---|-----------|----------------------|
| 3.1 | Creación exitosa de un producto nuevo | `Catálogo de Productos (Admin)::Creación exitosa de un producto nuevo` |
| 3.2 | Visualización del catálogo con productos existentes | `Catálogo de Productos (Admin)::Visualización del catálogo con productos existentes` |

**Capas Screenplay involucradas:**
- UI: `AdminPage` (locators: `a[href='/admin']`, `#name`, `#type`, `#category`, `#price`, `button[type='submit']`, `.text-green-400 p`, `.space-y-3 > div`)
- Model: `ProductData` (builder con name, type, category, price)
- Tasks: `Login`, `NavigateToAdmin`, `CreateProduct`
- Questions: `ProductCreatedSuccessMessageDisplayed`, `ProductListedInCatalog`

---

## Feature 4 — Carga Masiva de Productos ← NUEVO
**Archivo:** `src/test/resources/features/carga_masiva.feature`
**StepDefs:** `com.automation.stepdefinitions.CargaMasivaStepDefinitions`

| # | Escenario | Identificador Cucumber |
|---|-----------|----------------------|
| 4.1 | Visualización de la pantalla de carga masiva | `Carga Masiva de Productos::Visualización de la pantalla de carga masiva` |
| 4.2 | Carga exitosa de productos mediante archivo CSV | `Carga Masiva de Productos::Carga exitosa de productos mediante archivo CSV` |

**Capas Screenplay involucradas:**
- UI: `BulkUploadPage` (locators: `a[href='/admin/carga-masiva']`, `[aria-label='Zona de carga de archivo CSV']`, `[data-testid='csv-file-input']`, `button.text-primary.text-sm.underline`, `h3`)
- Tasks: `Login`, `NavigateToBulkUpload`, `UploadCSVFile`
- Questions: `UploadSummaryIsDisplayed`
- Test Data: `src/test/resources/files/productos_prueba.csv`

---

## Resumen total de escenarios

| Feature | Escenarios | Estado |
|---------|-----------|--------|
| Registro de usuarios | 2 | Preexistente |
| Facturación de pedidos | 1 | Preexistente |
| Catálogo de Productos | 2 | NUEVO |
| Carga Masiva | 2 | NUEVO |
| **Total** | **7** | |

---

## Árbol de archivos creados (NUEVOS)

```
app/src/test/
├── java/com/automation/
│   ├── models/
│   │   └── ProductData.java
│   ├── ui/
│   │   ├── AdminPage.java
│   │   └── BulkUploadPage.java
│   ├── tasks/
│   │   ├── NavigateToAdmin.java
│   │   ├── NavigateToBulkUpload.java
│   │   ├── CreateProduct.java
│   │   └── UploadCSVFile.java
│   ├── questions/
│   │   ├── ProductCreatedSuccessMessageDisplayed.java
│   │   ├── ProductListedInCatalog.java
│   │   └── UploadSummaryIsDisplayed.java
│   └── stepdefinitions/
│       ├── CatalogoStepDefinitions.java
│       └── CargaMasivaStepDefinitions.java
└── resources/
    ├── features/
    │   ├── catalogo_productos.feature
    │   └── carga_masiva.feature
    └── files/
        └── productos_prueba.csv
```
