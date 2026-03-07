package com.ashir.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;

import java.time.Duration;

public class LoginTest {
    WebDriver driver;

    @BeforeClass
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void loginTest() {
        try {
            driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(9));
            Thread.sleep(3000);

            WebElement username = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[1]/div/div[2]/input"));
            username.sendKeys("Admin");
            Thread.sleep(3000);

            WebElement pwd = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[2]/div/div[2]/input"));
            pwd.sendKeys("admin123");
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));

            WebElement ClickLogin = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button"));
            ClickLogin.click();

            //Get the page title.
            String PageTitle = driver.getTitle();
            System.out.println("Page title is: " + PageTitle);


            //Validate the page
            if (PageTitle.equals("OrangeHRM")) {
                System.out.println("Successfully");
            } else {
                System.out.println("Failed");
            }

        } catch (Exception e) {
            e.printStackTrace();  //e.printStackTrace() is a method that prints a detailed description of the exception e
        } finally {
            //driver.quit();
        }
    }
}
