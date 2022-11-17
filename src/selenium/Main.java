package selenium;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "src/resources/chromedriver.exe");


        WebDriver driver = new ChromeDriver();// otvara browser
        driver.manage().window().maximize();

        String url = "https://the-internet.herokuapp.com/login";
        driver.get(url);


        WebElement username = driver.findElement(By.cssSelector("input[type='text']"));

        username.sendKeys("tomsmith");

        WebElement password = driver.findElement(By.cssSelector("input[name='password']"));
        password.sendKeys("SuperSecretPassword!");

        WebElement loginButton = driver.findElement(By.cssSelector(".radius"));
        loginButton.click();

        WebElement loginUserText = driver.findElement(By.xpath("//div[@id='flash']"));
        String actualText = loginUserText.getText();
        System.out.println("Actual text: " + actualText);

        //actualText.split()

        String adjustedActualText = actualText.substring(0, actualText.length()-1);

        System.out.println("adjustedActualText " + adjustedActualText);

        String expectedText = "You logged into a secure area!";

        if (adjustedActualText.trim().equals(expectedText.trim())){
            System.out.println("Test Passed");
        }else {
            System.out.println("Test Failed");
        }

        driver.quit();

    }


}
