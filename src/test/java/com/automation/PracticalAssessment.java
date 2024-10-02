package com.automation;

import java.time.Duration;
import io.qameta.allure.*;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

import static org.testng.AssertJUnit.assertTrue;

public class PracticalAssessment extends BaseTest {

    @Test
//    @Severity(SeverityLevel.CRITICAL)
    @Description("Practical Assessment 4")
    public void assessment4() throws InterruptedException{
        openHomePage();
        navigateToLaptopCategory();
        chooseTheLaptop();
        addToCart();
        navigateToTheCartPage();
        validateTheLaptop();
    }

    @Step("Open 'The Internet' home page")
    public void openHomePage() {
        getDriver().get("https://demoblaze.com/");
    }

    @Step("Navigate to 'Laptop Category'")
    public void navigateToLaptopCategory() {
        WebDriverWait wait = new WebDriverWait(tdriver.get(),Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[.='Laptops']")));
        getDriver().findElement(By.xpath("//a[.='Laptops']")).click();
        //Thread.sleep(3000);
//        WebElement laptop = explicitWait.get().until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[.='Laptops']")));
//        laptop.click();
    }

    @Step("Select one of laptop")
    public void chooseTheLaptop() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(tdriver.get(),Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//body[1]/div[5]/div[1]/div[2]/div[1]/div[1]/div[1]/a[1]/img[1]")));
        //explicitWait.set(new WebDriverWait(getDriver(),Duration.ofSeconds(12)));
        getDriver().findElement(By.xpath("//body[1]/div[5]/div[1]/div[2]/div[1]/div[1]/div[1]/a[1]/img[1]")).click();
        //Thread.sleep(3000);
    }

    @Step("Add to Cart")
    public void addToCart() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(tdriver.get(),Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[normalize-space()='Add to cart']")));
        getDriver().findElement(By.xpath("//a[normalize-space()='Add to cart']")).click();
        Thread.sleep(3000);
        getDriver().switchTo().alert().accept();
    }

    @Step("Navigate to the Cart Page")
    public void navigateToTheCartPage() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(tdriver.get(),Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//a[normalize-space()='Cart'])[1]")));
        getDriver().findElement(By.xpath("(//a[normalize-space()='Cart'])[1]")).click();
        Thread.sleep(3000);
    }

    @Step("Validate that the added laptop appears in the cart.")
    public void validateTheLaptop() {
        WebDriverWait wait = new WebDriverWait(tdriver.get(),Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("tbody tr:nth-child(1) td:nth-child(2)")));
        assertTrue(getDriver().findElement(By.cssSelector("tbody tr:nth-child(1) td:nth-child(2)")).isDisplayed());
        Assert.assertEquals("Sony vaio i5", "Sony vaio i5");
    }
}
