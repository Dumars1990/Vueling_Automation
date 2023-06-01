package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.time.LocalDate;

public class HomePage {
    public WebDriver ldriver;
    public int diaFechaSalida;

    public HomePage(WebDriver rdriver) {
        ldriver = rdriver;
        PageFactory.initElements(rdriver, this);
    }

    @FindBy(id = "onetrust-accept-btn-handler")
    @CacheLookup
    WebElement policyAcceptButton;

    @FindBy(id = "originInput")
    @CacheLookup
    WebElement originInput;

    @FindBy(id = "headerPopupCalendar")
    @CacheLookup
    WebElement encabezadoDelCalendario;

    @FindBy(id = "destinationInput")
    @CacheLookup
    WebElement destinationInput;

    @FindBy(xpath = "//p[normalize-space()='Madrid']")
    @CacheLookup
    WebElement madridDestino;

    @FindBy(id = "adultsIncrease")
    @CacheLookup
    WebElement addAdult;

    @FindBy(xpath = "//vy-pax-popup[@class='searchbar-popup passengers-popup show-flex discount']")
    @CacheLookup
    WebElement visibleComponentePasajeros;

    @FindBy(id = "childrenIncrease")
    @CacheLookup
    WebElement addChild;

    @FindBy(id = "btnSubmitHomeSearcher")
    @CacheLookup
    WebElement clickBuscarVuelo;


    public void acceptPolitica() {
        policyAcceptButton.click();
    }

    public boolean politicaEsVisible() {
        policyAcceptButton.isDisplayed();
        return false;
    }

    public void introducirOrigen() throws InterruptedException {
        originInput.sendKeys("Barcelona", Keys.ENTER);
        Thread.sleep(500);
    }

    public void introducirDestino() throws InterruptedException {
        destinationInput.sendKeys("Madrid");
        madridDestino.click();
        new WebDriverWait(ldriver, Duration.ofSeconds(3)).until(ExpectedConditions.elementToBeClickable(By.id("headerPopupCalendar")));
    }

    public void actualTime(int diaFechaSalida) {
        this.diaFechaSalida = diaFechaSalida;
    }

    public void selectDates(int diaFechaRegreso) throws InterruptedException {
        Thread.sleep(500);
        // Obtener la fecha actual
        LocalDate fechaActual = LocalDate.now();

        // Calcular la fecha de salida (3 días desde la fecha actual)
        LocalDate fechaSalida = fechaActual.plusDays(this.diaFechaSalida);

        // Calcular la fecha de retorno (x días desde la fecha de salida)
        LocalDate fechaRetorno = fechaSalida.plusDays(diaFechaRegreso);

        /* Vemos que el id de cada día en el calendario es "calendarDaysTable" seguido de la fecha en formato yyyyMMdd
           Por lo que creamos un id con la base "calendarDaysTable" concatenado con los días de salida y retorno
           Restando 1 al mes, ya que los meses van de 0-11.*/
        String dateStringId = "//td[@id='calendarDaysTable" + fechaSalida.getYear() + "" + (fechaSalida.getMonthValue() - 1) + "" + fechaSalida.getDayOfMonth() + "']/a";
        WebElement datePickerButton = ldriver.findElement(By.xpath(dateStringId));
        datePickerButton.click();

        dateStringId = "//td[@id='calendarDaysTable" + fechaRetorno.getYear() + "" + (fechaRetorno.getMonthValue() - 1) + "" + fechaRetorno.getDayOfMonth() + "']/a";
        datePickerButton = ldriver.findElement(By.xpath(dateStringId));
        datePickerButton.click();
    }


    public void seleccionarNumeroPasajeros(int adultos, int child) {
        new WebDriverWait(ldriver, Duration.ofSeconds(3)).until(ExpectedConditions.visibilityOf(visibleComponentePasajeros));
        for (int i = 2; i <= adultos; i++) {
            addAdult.click();
        }

        String numAdultos = "//div[@role='status'][normalize-space()='" + adultos + "']";
        WebElement adultosMostrados = ldriver.findElement(By.xpath(numAdultos));
        assert adultosMostrados.isDisplayed();

        for (int i = 1; i <= child; i++) {
            addChild.click();
        }

        String numChilds = "//div[@role='status'][normalize-space()='" + child + "']";
        WebElement childsMostrados = ldriver.findElement(By.xpath(numChilds));
        assert childsMostrados.isDisplayed();
    }

    public void buscarVuelos() {
        clickBuscarVuelo.click();
    }
}