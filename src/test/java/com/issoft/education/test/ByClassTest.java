<<<<<<<< HEAD:src/test/java/mail/ByClassTest.java
package mail;
========
package com.issoft.education.test;
>>>>>>>> master:src/test/java/com/issoft/education/test/ByClassTest.java

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



public class ByClassTest  {
    private WebDriver driver;
    private static WebDriverWait wait;
    private By idLocator;
    private By xpathLocator;
    private By nameLocator;
    private By cssLocator;

    public ByClassTest(WebDriver driver,WebDriverWait wait) {
        this.driver= driver;
        this.wait = wait;
    }
    public void loginButtonInitclick(String css){
        cssLocator=By.cssSelector(css);
        WebElement  loginButtonInit=driver.findElement(cssLocator);
        loginButtonInit.click();
    }
    public void loginButtonClick(String xpath){
        xpathLocator=By.xpath(xpath);
        WebElement  loginButton=driver.findElement(xpathLocator);
        loginButton.click();
    }
    public void inputLogin(String id,String login){
        idLocator=By.id(id);
        WebElement loginField = driver.findElement(idLocator);
        loginField.sendKeys(login);
    }
    public void inputPassword(String name,String pwd){
        nameLocator=By.name(name);
        wait.until(ExpectedConditions.visibilityOfElementLocated(nameLocator));
        WebElement passwordField = driver.findElement(nameLocator);
        passwordField.sendKeys(pwd);
}

}
