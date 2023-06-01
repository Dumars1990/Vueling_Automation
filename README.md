# Automatización de la web de venta de billetes de Vueling

Este proyecto es una automatización de la web de venta de billetes de Vueling, utilizando Java, Selenium, TestNG y el patrón de diseño Page Object Model.

## Requisitos

- Java JDK 8 o superior
- Maven
- WebDriver (ChromeDriver o GeckoDriver)
- IDE (recomendado: IntelliJ IDEA)

## Configuración del entorno

1. Clona el repositorio en tu máquina local:
git clone https://github.com/Dumars1990/Vueling_Automation.git

markdown
Copy code

2. Importa el proyecto en tu IDE (por ejemplo, IntelliJ IDEA) como un proyecto Maven existente.

3. Descarga el WebDriver correspondiente a tu navegador preferido:
- Para Chrome: [ChromeDriver](https://chromedriver.chromium.org/)
- Para Firefox: [GeckoDriver](https://github.com/mozilla/geckodriver/releases)

4. Coloca el archivo del WebDriver en la ubicación adecuada dentro del proyecto. Por ejemplo, puedes crear una carpeta `drivers` en la raíz del proyecto y colocar el archivo allí.

## Ejecución de las pruebas

1. Abre tu IDE y navega hasta la clase `TestRunner` ubicada en `src/test/java/com/vueling/runners/`.

2. Haz clic derecho en la clase `TestRunner` y selecciona la opción "Run 'TestRunner'" para ejecutar todas las pruebas.

## Estructura del proyecto
Vueling_Automation

Vueling_Automation
├___src
│   ├___ main
│   │   └── java
│   │       └── com
│   │           └── vueling
│   │               ├── pages
│   │               │   ├── HomePage.java
│   │               │   ├── FlightSelectionPage.java
│   │               │   └── BookingPage.java
│   │               ├── tests
│   │               │   └── FlightBookingTest.java
│   │               └── utils
│   │                   └── WebDriverFactory.java
│   └── test
│       └── java
│           └── com
│               └── vueling
│                   └── runners
│                       └── TestRunner.java
├── .gitignore
├── LICENSE
├── pom.xml
└── README.md


- `pages`: Contiene las clases que representan las páginas web y los métodos para interactuar con ellas utilizando el patrón Page Object Model.
- `tests`: Contiene las clases de prueba que utilizan los métodos de las páginas para ejecutar las pruebas.
- `utils`: Contiene la clase `WebDriverFactory`, que se encarga de inicializar y configurar el WebDriver.

## Reporting

Para generar informes detallados de las pruebas ejecutadas. Los informes se generan automáticamente después de cada ejecución y se guardan en la carpeta `test-output/cucumber-reports`.

## Contribución

Si deseas contribuir a este proyecto, siéntete libre de hacerlo. Puedes abrir un problema (issue) para informar de errores o sugerir mejoras. También puedes enviar solicitudes de extracción (pull requests) con tus cambios propuestos.

## Licencia

Este proyecto está bajo la licencia MIT. Para más detalles, consulta el archivo [LICENSE](LICENSE).

