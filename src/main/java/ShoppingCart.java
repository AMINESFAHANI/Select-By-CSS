import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class ShoppingCart {



    public static void findProductAndAddToCart(List<WebElement> products, String name, WebDriver driver) throws InterruptedException {

        WebDriverWait wait=new WebDriverWait(driver, 5);
        for(int i = 0; i< products.size(); i++){
            System.out.println(products.get(i).getText());
            if(products.get(i).getText().contains(name)){
                List<WebElement> p= driver.findElements(By.xpath("//*[@id=\"root\"]/div/div[1]/div/div/div[3]/button"));
                wait.until(ExpectedConditions.visibilityOf(p.get(i)));
                p.get(i).click();
                Thread.sleep(1000);


                //*[@id="root"]/div/div[1]/div/div[6]/div[3]/button
                //*[@id="root"]/div/div[1]/div/div[6]/h4

                //*[@id="root"]/div/div[1]/div/div[7]/div[3]/button
                //*[@id="root"]/div/div[1]/div/div[7]/h4


                break;
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        WebDriverWait wait=new WebDriverWait(driver, 5);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS) ;

        driver.manage().window().maximize();
        driver.navigate().to("https://rahulshettyacademy.com/seleniumPractise");
        driver.navigate().refresh();
        List<WebElement> products = driver.findElements(By.cssSelector("h4.product-name"));

        findProductAndAddToCart(products, "Cucumber", driver);
        findProductAndAddToCart(products, "Carrot", driver);
        findProductAndAddToCart(products, "Bean", driver);
        findProductAndAddToCart(products, "Tomato", driver);


        driver.close();
    }
}