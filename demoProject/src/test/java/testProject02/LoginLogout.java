package testProject02;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class LoginLogout {
    static WebDriver cdriver;
    //Elements
    static WebElement signUpAndLoginButton;
    static WebElement loginStringElement;
    static WebElement emailAddressLabel;
    static WebElement passwordLabel;
    static WebElement loginButton;
    static WebElement loggedInText;
    static WebElement logoutButton;
    static String expectedHomePageUrl = "https://automationexercise.com/";
    static String actualHomePageUrl;
    static String expectedLoginPageUrl = "https://automationexercise.com/login";
    static String actualLoginPageUrl;
    static String email = "testerjay@gmail.com";
    static String password = "123456";
    @BeforeClass
    public static void setUp() {
        cdriver = new ChromeDriver();
        cdriver.manage().window().maximize();
        cdriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

        cdriver.get("http://automationexercise.com");
    }
    @AfterClass
    public static void tearDown() {
        cdriver.quit();
    }
    @Test
    public void test01() {
        actualHomePageUrl=cdriver.getCurrentUrl();
        Assert.assertEquals(actualHomePageUrl,expectedHomePageUrl);
        System.out.println("Actual URL: " + actualHomePageUrl);
    }
    @Test
    public void test02() {
        signUpAndLoginButton = cdriver.findElement(By.cssSelector("a[href='/login']"));
        signUpAndLoginButton.click();
    }
    @Test
    public void test03() {
        loginStringElement = cdriver.findElement(By.xpath("//h2[text()='Login to your account']"));
        Assert.assertTrue(loginStringElement.isDisplayed());
    }
    @Test
    public void test04() {
        emailAddressLabel = cdriver.findElement(By.xpath("//input[@data-qa='login-email']"));
        passwordLabel = cdriver.findElement(By.xpath("//input[@placeholder='Password']"));
        emailAddressLabel.sendKeys(email);
        passwordLabel.sendKeys(password);
    }
    @Test
    public void test05() {
        loginButton = cdriver.findElement(By.xpath("//button[normalize-space()='Login']"));
        loginButton.click();
    }
    @Test
    public void test06() {
        loggedInText = cdriver.findElement(By.xpath("//a[text()=' Logged in as ']"));
        Assert.assertTrue(loggedInText.isDisplayed());
    }
    @Test
    public void test07() {
        logoutButton = cdriver.findElement(By.xpath("//a[text()=' Logout']"));
        logoutButton.click();
    }
    @Test
    public void test08() {
        actualLoginPageUrl = cdriver.getCurrentUrl();
        Assert.assertEquals(actualLoginPageUrl,expectedLoginPageUrl);
        System.out.println("Actual Login Page Url: " + actualLoginPageUrl);
    }
}
