package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Set;

public class FlightSelectionPage {

    public WebDriver ldriver;

    public FlightSelectionPage(WebDriver rdriver) {
        ldriver = rdriver;
        PageFactory.initElements(ldriver, this);
    }

    @FindBy(id = "flightCardsContainer")
    @CacheLookup
    WebElement tablonVuelos;

    @FindBy(css= "#outboundFlightCardsContainer #flightCardsContainer > div:nth-child(1)")
    @CacheLookup
    WebElement seleccionVueloIdaAleatorio;

    @FindBy(css= "#inboundFlightCardsContainer #flightCardsContainer > div:nth-child(1) #flightCardContent")
    @CacheLookup
    WebElement seleccionVueloRetornoAleatorio;

    @FindBy(id = "flightCardContent")
    @CacheLookup
    WebElement vueloSeleccionado;

    @FindBy(id = "optimaFareBox")
    @CacheLookup
    WebElement tarifaOptima;

    @FindBy(id = "basicFareBox")
    @CacheLookup
    WebElement tarifaBasica;

    @FindBy(id = "stvContinueButton")
    @CacheLookup
    WebElement botonContinuar;


    public void esperaCargaTablonVuelos() throws InterruptedException {
        new WebDriverWait(ldriver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(tablonVuelos));
    }

    public void seleccionarVueloIdaAzar() throws InterruptedException {
        seleccionVueloIdaAleatorio.click();
    }

    public void seleccionarVueloRetornoAzar() throws InterruptedException {
        new WebDriverWait(ldriver, Duration.ofSeconds(3)).until(ExpectedConditions.visibilityOf(vueloSeleccionado));
        seleccionVueloRetornoAleatorio.click();
    }

    public void handleTabs(){
        String mainTab = ldriver.getWindowHandle();

        Set<String> handles = ldriver.getWindowHandles();

        for(String actual : handles){

            if(!actual.equalsIgnoreCase(mainTab)){
                ldriver.switchTo().window(actual);
            }
        }
    }
    public void seleccionarTarifa(String tarifa){
        if(tarifa.equalsIgnoreCase("Basica")){
            tarifaBasica.click();
        } else if (tarifa.equalsIgnoreCase("Optima")) {
            tarifaOptima.click();
        }
    }
    public void pulsarContinuar(){
        botonContinuar.click();
    }

}
