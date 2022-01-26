package visitor.omstulecturesvisitor.WebDrivers;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverController {
    static WebDriver driver = new ChromeDriver();
    public static void startSession() {
        try {
            driver.get("google.com");

            Thread.sleep(1000);
            WebElement lastName = driver.findElement(By.xpath("//input[@placeholder='Введите фамилия']"));
            WebElement firstName = driver.findElement(By.xpath("//input[@placeholder='Введите имя']"));
            WebElement button = driver.findElement(By.xpath("//button[@color='success']"));

            lastName.sendKeys("Хто");
            firstName.sendKeys("Я 202");
            Thread.sleep(1000);
            button.click();
            Thread.sleep(5000);

            WebElement secButton = driver.findElement(By.xpath("//button[@color='success']"));
            secButton.click();
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
    }

    public static void endSession(){
        driver.close();
    }
}
