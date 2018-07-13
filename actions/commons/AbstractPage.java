package commons;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AbstractPage {
	public void openAnyUrl (WebDriver driver, String url)
	{
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	
	public String getTitle(WebDriver driver) {
		return driver.getTitle();
	}
	public String getCurrentUrl(WebDriver driver) {
		return driver.getCurrentUrl();
	}
	
	public String getPageSource(WebDriver driver) {
		return driver.getPageSource();
	}
	public void back (WebDriver driver) {
		driver.navigate().back();
	}
	public void clickToElement(WebDriver driver, String locator) 
	{
		WebElement element = driver.findElement(By.xpath(locator));
		element.click();
	}
	
	public void sendkeyToElement (WebDriver driver, String locator, String value )
	{
		WebElement field = driver.findElement(By.xpath(locator));
		field.sendKeys(value);
	}
	
	public void selectItemInDropDown (WebDriver driver, String locator,String textItem) {
		WebElement element = driver.findElement(By.xpath(locator));
		Select select = new Select (element);
		select.selectByVisibleText(textItem);
	}
	
	public String getFistItemSelected(WebDriver driver, String locator) {
		WebElement element = driver.findElement(By.xpath(locator));
		Select select = new Select(element);
		return select.getFirstSelectedOption().getText();
	}
	
	public String getAttributeValue(WebDriver driver,String locator,String attribute) {
		WebElement element = driver.findElement(By.xpath(locator));
		return element.getAttribute(attribute);
	}
	
	public String getTextElement(WebDriver driver,String locator) {
		WebElement element = driver.findElement(By.xpath(locator));
		return element.getText();
	}
	
	public int getSizeElement (WebDriver driver,String locator) {
		List<WebElement> elements = driver.findElements(By.xpath(locator));
		return elements.size();
	}
	
	public void checkToCheckbox(WebDriver driver,String locator)
	{
		WebElement element = driver.findElement(By.xpath(locator));
		if(!element.isSelected()) {
			element.click();
		}
	}
	public void checkToUnCheckbox(WebDriver driver,String locator)
	{
		WebElement element = driver.findElement(By.xpath(locator));
		if(element.isSelected()) {
			element.click();
		}
	}
	public boolean isControlDisplayed(WebDriver driver,String locator) {
		WebElement element = driver.findElement(By.xpath(locator));
		return element.isDisplayed();
	}
	
	public boolean isControlEnabled(WebDriver driver,String locator) {
		WebElement element = driver.findElement(By.xpath(locator));
		return element.isEnabled();
	}
	
	public void acceptAlert (WebDriver driver) {
		Alert alert = driver.switchTo().alert();
		alert.accept();
	}
	
	public void cancelAlert (WebDriver driver) {
		Alert alert = driver.switchTo().alert();
		alert.dismiss();
	}
	
	public String getTextAlert (WebDriver driver) {
		Alert alert = driver.switchTo().alert();
		return alert.getText();
	}
	
	public void sendKeyToAlert (WebDriver driver, String value) {
		Alert alert = driver.switchTo().alert();
		alert.sendKeys(value);
	}
	
	public void dbClickToElement (WebDriver driver, String locator) {
		WebElement element = driver.findElement(By.xpath(locator));
		Actions action = new Actions(driver);
		action.doubleClick(element);
	}
	
	public void hoverToElement (WebDriver driver, String locator) {
		WebElement element = driver.findElement(By.xpath(locator));
		Actions action = new Actions(driver);
		action.moveToElement(element);
	}
	
	public void rightClickToElement (WebDriver driver, String locator) {
		WebElement element = driver.findElement(By.xpath(locator));
		Actions action = new Actions(driver);
		action.contextClick(element);
	}
	
	public void waitForControlPresence (WebDriver driver, String locator) {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		By by = By.xpath(locator);
		wait.until(ExpectedConditions.presenceOfElementLocated(by));
	}
	
	public void waitForControlVisible(WebDriver driver, String locator) {
		WebElement element = driver.findElement(By.xpath(locator));	
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	public void waitForControlClickable(WebDriver driver, String locator) {
		WebElement element = driver.findElement(By.xpath(locator));	
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	public void waitForControlInvisible(WebDriver driver, String locator) {
		By by = By.xpath(locator);
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(by));
	}
	
	public void waitForAlertPresence(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.alertIsPresent());
	}
}
