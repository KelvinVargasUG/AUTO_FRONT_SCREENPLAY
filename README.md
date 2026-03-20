# AUTO_FRONT_SCREENPLAY

Automatización de pruebas Front-End usando **Serenity BDD** con el patrón **Screenplay**, **Cucumber** y **Gradle**.

## Prerrequisitos

- Java 17+
- Google Chrome instalado
- Aplicación web corriendo en `http://localhost:5173`
- [FoodTech-Kitchen-Services](https://github.com/KelvinVargasUG/FoodTech-Kitchen-Services/tree/main)
- [FoodTech-Front](https://github.com/KelvinVargasUG/FoodTech-Front/tree/main)
- Ejecutar Script inicial [seed_data.sh](scripts/seed_data.sh)

## Estructura del proyecto

```
app/src/test/
├── java/com/automation/
│   ├── models/          # Modelos de datos de prueba
│   ├── questions/       # Preguntas (validaciones)
│   ├── runners/         # Runner de Cucumber con Serenity
│   ├── stepdefinitions/ # Definiciones de pasos
│   ├── tasks/           # Tareas del actor
│   └── ui/              # Localizadores (Targets)
└── resources/
    ├── features/        # Escenarios Gherkin
    └── serenity.conf    # Configuración de Serenity
```

## Ejecución de tests

```bash
./gradlew clean test
```

## Reportes

Los reportes de Serenity se generan en:

```
app/target/site/serenity/index.html
```
