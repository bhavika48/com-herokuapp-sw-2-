package testsuite;

import browserfactory.BaseTest;
import org.checkerframework.checker.units.qual.A;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginTest extends BaseTest {
    String baseUrl = "http://the-internet.herokuapp.com/login";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }
    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials(){
        WebElement userName = driver.findElement(By.id("username"));
        userName.sendKeys("tomsmith");
        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("SuperSecretPassword!");
        driver.findElement(By.xpath("//i[@class='fa fa-2x fa-sign-in']")).click();
        String expectedMessage="Secure Area";
       WebElement actualTextElement= driver.findElement(By.xpath("//h2[text()=' Secure Area']"));
      String actualMessage=actualTextElement.getText();
      Assert.assertEquals("Secure Area",expectedMessage,actualMessage);

    }


    @Test
   public void verifyTheUsernameErrorMessage(){
        // verifying login page
        WebElement userName = driver.findElement(By.id("username"));
        userName.sendKeys("tomsmith1");
        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("SuperSecretPassword!");
        driver.findElement(By.xpath("//i[@class='fa fa-2x fa-sign-in']")).click();
        String expectedMessage = "Your username is invalid!\n" +
                "×";
        WebElement actualTextElement = driver.findElement(By.id("flash"));
        String actualMessage = actualTextElement.getText();
        Assert.assertEquals(" Your username is invalid is not displayed",expectedMessage, actualMessage);
    }

    @Test
    public void verifyThePasswordErrorMessage() {
        // verifying login page and message :your password is invalid
        WebElement userName = driver.findElement(By.id("username"));
        userName.sendKeys("tomsmith");
        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("SuperSecretPassword");
        driver.findElement(By.xpath("//i[@class='fa fa-2x fa-sign-in']")).click();

        String expectedMessage = "Your password is invalid!\n×";
       WebElement actualTextElement= driver.findElement(By.id("flash"));
       String actualMessage=actualTextElement.getText();
       Assert.assertEquals("Your Password is invalid is not displayed",expectedMessage,actualMessage);

    }

    @After
    public void tearDown() {
         closeBrowser();
    }


}
