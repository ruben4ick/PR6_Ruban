package org.example;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TheInternetTest {

    WebDriver driver;

    @BeforeAll
    static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void setup() {
        driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/tables");
    }

    @AfterEach
    void teardown() {
        driver.quit();
    }

    @Test
    public void testEditButtonFirstRow() {
        WebElement editButton = driver.findElement(By.xpath("//table[@id='table1']/tbody/tr[1]/td[6]/a[contains(@href, 'edit')]"));
        assertTrue(editButton.isDisplayed(), "Edit button should be displayed in the first row");
    }

    @Test
    public void testEmailSecondRow() {
        WebElement email = driver.findElement(By.xpath("//table[@id='table1']/tbody/tr[2]/td[3]"));
        assertEquals("fbach@yahoo.com", email.getText(), "The email in the second row should be correct");
    }

    @Test
    public void testSortingByLastName() throws InterruptedException {
        WebElement lastNameHeader = driver.findElement(By.xpath("//table[@id='table1']/thead/tr/th[1]/span"));
        lastNameHeader.click();
        Thread.sleep(1000); //some time to sort

        WebElement firstRowLastName = driver.findElement(By.xpath("//table[@id='table1']/tbody/tr[1]/td[1]"));
        assertEquals("Bach", firstRowLastName.getText(), "The first row should show 'Bach' after sorting by last name");
    }
}
