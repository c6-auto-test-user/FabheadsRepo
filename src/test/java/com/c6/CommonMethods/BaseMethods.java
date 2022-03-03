package com.c6.CommonMethods;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.c6.CommonBrowsers.BrowsersList;

public class BaseMethods extends BrowsersList
{
	
	public BaseMethods(WebDriver driver) {
		
		this.driver = driver; 
	}


    public void baseSimpleWait() {
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	public static void waitTillElementPresent(){
		
		WebDriverWait dw = new WebDriverWait(driver, 50);
		dw.until(ExpectedConditions.presenceOfElementLocated(null));
    }

//	ExpectedConditions.elementToBeClickable() can accept only the type By. 
	public static void waitTillElementClickable(WebElement element){
		
		WebDriverWait wd = new WebDriverWait(driver, 70);
		wd.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	public static void scrollWindow(int input) throws InterruptedException {
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy("+input+",document.body.scrollHeight)");
	}
	
	public static void windowMax() throws InterruptedException{
		driver.manage().window().maximize();
	}
	
    public static void switchWindow(int input) throws InterruptedException {               // Parameters: (type/input) -> input type.
    	ArrayList<String> tab = new ArrayList<String>(driver.getWindowHandles());
    	try {
			driver.switchTo().window(tab.get(input));
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
    
    
    	public static String RequiredString(int n)
    	{
    	    String AlphaNumericString = "abcdefghijklmnopqrstuvxyz" + "0123456789" + "0123456789";
    	    StringBuilder s = new StringBuilder(n);
    	    int y;
    	    for ( y = 0; y < n; y++)
    	    {
    	        int index = (int)(AlphaNumericString.length() * Math.random());
    	        s.append(AlphaNumericString.charAt(index));
    	    }
    	    return s.toString();
    }
}