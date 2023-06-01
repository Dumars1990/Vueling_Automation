package StepsDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.FlightSelectionPage;
import pages.HomePage;
import pages.ResumePage;

public class Steps extends BaseClass{

    public WebDriver driver;
    public HomePage homePage;
    public FlightSelectionPage flightSelectionPage;

    @Given("El usuario se encuentra en la página de inicio de Vueling")
    public void elUsuarioSeEncuentraEnLaPáginaDeInicioDeVueling() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();

        homePage = new HomePage(driver);
        flightSelectionPage = new FlightSelectionPage(driver);
        resumePage = new ResumePage(driver);

        driver.get("https://vueling.com/es");
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();

        if(homePage.politicaEsVisible()){
        }else{ homePage.acceptPolitica();}
    }

    @When("El usuario selecciona un billete de ida y vuelta de Barcelona a Madrid")
    public void elUsuarioSeleccionaUnBilleteDeIdaYVueltaDeBarcelonaAMadrid() throws InterruptedException {
        homePage.introducirOrigen();
        homePage.introducirDestino();
    }

    @And("La fecha de salida es {int} días desde la fecha actual")
    public void laFechaDeSalidaEsDiasDesdeFechaActualDíasDesdeLaFechaActual(int diasDesdeFechaActual) {
        homePage.actualTime(diasDesdeFechaActual);
    }

    @And("La fecha de regreso es {int} días después de la fecha de salida")
    public void laFechaDeRegresoEsDiasDespuesFechaSalidaDíasDespuésDeLaFechaDeSalida(int diasDespuesFechaSalida) throws InterruptedException {
        homePage.selectDates(diasDespuesFechaSalida);
    }

    @And("El billete seleccionado debe ser para {int} adultos y {int} niño")
    public void elBilleteSeleccionadoDebeSerParaAdultosYNiño(int numeroAdultos, int numeroChilds) throws InterruptedException {
        homePage.seleccionarNumeroPasajeros(numeroAdultos,numeroChilds);
    }

    @And("El usuario hace clic en `Buscar vuelos`")
    public void elUsuarioHaceClicEnBuscarVuelos() {
        homePage.buscarVuelos();
    }

    @And("El usuario selecciona un vuelo al azar de la lista de resultados")
    public void elUsuarioSeleccionaUnVueloAlAzarDeLaListaDeResultados() throws InterruptedException {
        flightSelectionPage.handleTabs();
        flightSelectionPage.esperaCargaTablonVuelos();
        flightSelectionPage.seleccionarVueloIdaAzar();
        flightSelectionPage.seleccionarVueloRetornoAzar();
    }

    @And("La tarifa seleccionada es {string} Basica u Optima")
    public void laTarifaSeleccionadaEsTarifaBasicaOptima(String tarifaa) {
        flightSelectionPage.seleccionarTarifa(tarifaa);
    }

    @And("El usuario hace clic en ´Continuar´")
    public void elUsuarioHaceClicEnContinuar() {
        flightSelectionPage.pulsarContinuar();
    }

    @Then("El usuario debería ser redirigido a la página de pasajeros")
    public void elUsuarioDeberíaSerRedirigidoALaPáginaDePasajeros() {
        resumePage.cogerTitulo();
        driver.quit();
    }
}
