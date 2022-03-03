package com.c6.TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.awt.List;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import com.c6.CommonBrowsers.BrowsersList;
import com.c6.CommonMethods.BaseMethods;
import com.c6.DataDriven.DataDrivenClass;
import com.c6.DataDriven.Data_pojo;
import com.c6.ExtentReport.ExtentReportClass;
import com.c6Xpaths.XpathsUnique;


public class ImplementCases extends ExtentReportClass {
	
//	Use Xpaths here from 'XpathsUnique' class.
	public By User_Id = By.xpath(XpathsUnique.userId);
	public By pass_Id = By.xpath(XpathsUnique.passId);
	public By logIn = By.xpath(XpathsUnique.log_in);
	public By new_account=By.xpath(XpathsUnique.Register_newaccount);
	public By confirm_pass=By.xpath(XpathsUnique.confirm_password);
	public By register_email=By.xpath(XpathsUnique.userId1);
	public By r_login=By.xpath(XpathsUnique.reg_login);
	public By pass_one=By.xpath(XpathsUnique.passId1);
	public By pass_two=By.xpath(XpathsUnique.passId2);
	public By message_nact=By.xpath(XpathsUnique.non_txt);
	public By emailtext=By.xpath(XpathsUnique.textbox);
	public By clickbtn= By.xpath(XpathsUnique.yclick);
	public By verifyemail=By.xpath(XpathsUnique.emailverify);
	public By forgpass=By.xpath(XpathsUnique.forgotpassword);
	public By foremail=By.xpath(XpathsUnique.forgotemail);

	

	
	
//  Create or initialize objects here.	
	BrowsersList bl = new BrowsersList();

	
//  All test cases started from here.
	@Test(priority = 0)
	public void firstCase() throws IOException, InterruptedException {
		
		extentTest = extent.startTest("firstCase");	      // We will write this line to use 'Extent Report'.
		
     // To Open Browser.
		bl.initialize();
		Thread.sleep(3000);
		
	 // To Open Url.	
	    bl.urlStack();	
		driver.manage().window().maximize();   
		Thread.sleep(3000);
		String cURL=driver.getCurrentUrl();
		System.out.println("Current URL is:" +cURL);
		try{
			Thread.sleep(3000);
		String URL1="https://slic4rfe-ng-ngx.fabheads.in/login";
		Assert.assertEquals(URL1, cURL);
		System.out.println("User is on login page.");
		}
		catch(InterruptedException e) {
			e.printStackTrace();
		}
		
			
	}
	@Test(priority=1)
	public void registrationpage() throws InterruptedException {
		extentTest = extent.startTest("registrationpage");
		Thread.sleep(2000);
		
		driver.findElement(new_account).click();
		Thread.sleep(3000);
		String cURL1=driver.getCurrentUrl();
		System.out.println("Current URL is:" +cURL1);
		try{
			Thread.sleep(3000);
		String URL2="https://slic4rfe-ng-ngx.fabheads.in/register";
		Assert.assertEquals(URL2, cURL1);
		System.out.println("User is on register page.");
		}
		catch(InterruptedException e) {
			e.printStackTrace();
		}
			
		
	}
	public static String StoredRandoms;
	@Test(priority=2)
	public void registration() throws InterruptedException {
		extentTest = extent.startTest("registration");
		Thread.sleep(3000);
		

		int n=9;
	String Randomname = BaseMethods.RequiredString(n);
	 StoredRandoms = Randomname;
	System.out.println(StoredRandoms);
		 driver.findElement(register_email).sendKeys(StoredRandoms+"@yopmail.com");
		Thread.sleep(5000);
		driver.findElement(pass_one).sendKeys("Test@12345");
		Thread.sleep(5000);
		driver.findElement(pass_two).sendKeys("Test@12345");
		Thread.sleep(5000);
		driver.findElement(r_login).click();
		Thread.sleep(5000);
		String toastMsg = null;
		JavascriptExecutor jse = (JavascriptExecutor)driver;
        WebElement shadowRoot = (WebElement) jse.executeScript("return document.querySelector('ion-toast').shadowRoot.querySelector('div>div>div>div')");
          toastMsg = shadowRoot.getText();
         if(toastMsg==null) {
        	 System.out.println("Validation message did not appear!");
         }
         else {
             System.out.println(toastMsg);
         }
         try {
        	 Thread.sleep(1000);
         Assert.assertNotEquals(toastMsg, null);
         }
         catch(InterruptedException e) {
 			e.printStackTrace();
         }
         
	}

	@Test(priority=3)
	public void verificationemail() throws InterruptedException {
		extentTest = extent.startTest("verificationemail");
		Thread.sleep(3000);
		driver.navigate().to("https://yopmail.com/en/");
		driver.findElement(emailtext).sendKeys(StoredRandoms);
		Thread.sleep(3000);
		driver.findElement(clickbtn).click();
		/*Thread.sleep(5000);
		driver.findElement(verifyemail).click();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,250)", "");
		WebElement l = driver.findElement(verifyemail);

		Actions at = new Actions(driver);
		at.moveToElement(l).click().perform();
		        */
		    }
		
		
		        
		    
		
		
	
	@Test(priority=4)
	public void nonactivated() throws InterruptedException {
		extentTest = extent.startTest("nonactivated");
		Thread.sleep(3000);
		driver.navigate().to("https://slic4rfe-ng-ngx.fabheads.in/login");  
		driver.findElement(User_Id).sendKeys("test345@yopmail.com");
		driver.findElement(pass_Id).sendKeys("Test@12345");
		Thread.sleep(5000);
		driver.findElement(logIn).click();
		Thread.sleep(5000);
		String Ntext=null;
		 Ntext= driver.findElement(message_nact).getText();
	
		 if(Ntext==null) {
        	 System.out.println("Validation message did not appear!");
         }
         else {
             System.out.println(Ntext);
         }
         try {
        	 Thread.sleep(1000);
         Assert.assertNotEquals(Ntext, null);
         }
         catch(InterruptedException e) {
 			e.printStackTrace();
         }
         
	}
		
		
	
@Test(priority=5)
public void invalidemail() throws InterruptedException{
	extentTest = extent.startTest("invalidemail");
	Thread.sleep(3000);
	
	driver.navigate().to("https://slic4rfe-ng-ngx.fabheads.in/login");

	int n=9;
String Randomname=BaseMethods.RequiredString(n);
	driver.findElement(User_Id).sendKeys(Randomname+".com");
	driver.findElement(pass_Id).sendKeys("Test@12345");
	driver.findElement(logIn).click();
	Thread.sleep(5000);
	String invalidemail=null;
	 invalidemail= driver.findElement(message_nact).getText();
	
	if(invalidemail==null) {
   	 System.out.println("Validation message did not appear!");
    }
    else {
        System.out.println(invalidemail);
    }
    try {
   	 Thread.sleep(1000);
    Assert.assertNotEquals(invalidemail, null);
    }
    catch(InterruptedException e) {
		e.printStackTrace();
    }
	
	
	
	Thread.sleep(5000);
	


      /*   
		WebElement el = driver.findElement(By.className("toast-message"));
		Thread.sleep(5000);
	   System.out.println( el.getAttribute("innerHTML"));
	    System.out.println(el.getAttribute("innerText"));*/


		//WebElement elem = driver
		//elem.getAttribute("innerHTML");
		//driver.findElement(verify_msg).click();
		
		/*
		WebElement button=driver.findElement(r_login);
		BaseMethods.waitTillElementClickable(button);*/
		
}
		//System.out.println("Enter Password: " + userDetails.getDetails2());
		
		
	private void assertThat(boolean displayed) {
		// TODO Auto-generated method stub
		
	}

@Test(priority=6)
public void invalidpassword() throws InterruptedException{
	extentTest = extent.startTest("invalidpassword");
	Thread.sleep(3000);
	
	driver.navigate().to("https://slic4rfe-ng-ngx.fabheads.in/login");
	driver.findElement(User_Id).sendKeys("test345@yopmail.com");
	driver.findElement(pass_Id).sendKeys("Test@12345678");
	Thread.sleep(5000);
	
	driver.findElement(logIn).click();
	Thread.sleep(5000);
	String etext=null;
	 etext= driver.findElement(message_nact).getText();
	System.out.println(etext);
	if(etext==null) {
	   	 System.out.println("Validation message did not appear!");
	    }
	    else {
	        System.out.println(etext);
	    }
	    try {
	   	 Thread.sleep(1000);
	    Assert.assertNotEquals(etext, null);
	    }
	    catch(InterruptedException e) {
			e.printStackTrace();
	    }
	
	


}
@Test(priority=7)
public void forgotpasswordpage() throws InterruptedException {
	extentTest = extent.startTest("forgotpasswordpage");
	driver.navigate().to("https://slic4rfe-ng-ngx.fabheads.in/login");
	Thread.sleep(3000);
	driver.findElement(forgpass).click();
	
	try{
		Thread.sleep(5000);
		String cURL3=driver.getCurrentUrl();
		System.out.println("Current URL is:" +cURL3);
String URLFP="https://slic4rfe-ng-ngx.fabheads.in/forgot";
	Assert.assertEquals(cURL3,URLFP);
	System.out.println("User is on Forgot Password page.");
	}
	catch(InterruptedException e) {
		e.printStackTrace();
	}
		

	


	


}
@Test(priority=8)
public void forgotpasswordnonregestired() throws InterruptedException{
	extentTest = extent.startTest("forgotpasswordnonregestired");
	Thread.sleep(3000);
	
	driver.navigate().to("https://slic4rfe-ng-ngx.fabheads.in/login");
	Thread.sleep(3000);
	
	driver.findElement(forgpass).click();
	Thread.sleep(5000);
	driver.findElement(foremail).sendKeys("test1234@yopmail.com");
	driver.findElement(r_login).click();
	Thread.sleep(5000);
	String fortext=null;
	 fortext= driver.findElement(message_nact).getText();
	Thread.sleep(5000);
	if(fortext==null) {
	   	 System.out.println("Validation message did not appear!");
	    }
	    else {
	        System.out.println(fortext);
	    }
	    try {
	   	 Thread.sleep(1000);
	    Assert.assertNotEquals(fortext, null);
	    }
	    catch(InterruptedException e) {
			e.printStackTrace();
	    }
		
	
	

	
	
}
@Test(priority=9)
public void forgotpasswordregisteredemail() throws InterruptedException {
	extentTest = extent.startTest("forgotpasswordregisteredemail");
	driver.navigate().to("https://slic4rfe-ng-ngx.fabheads.in/login");
	Thread.sleep(3000);
	
	driver.findElement(forgpass).click();
	Thread.sleep(5000);
	driver.findElement(foremail).sendKeys("test345@yopmail.com");
	driver.findElement(r_login).click();
	String toastMsg2=null;

	Thread.sleep(2000);
JavascriptExecutor jse1 = (JavascriptExecutor)driver;
    WebElement shadowRoot1 = (WebElement) jse1.executeScript("return document.querySelector('ion-toast').shadowRoot.querySelector('div>div>div>div')");
     toastMsg2 = shadowRoot1.getText();
     System.out.println(toastMsg2);
     if(toastMsg2==null) {
    	 System.out.println("Validation message did not appear!");
     }
     else {
         System.out.println(toastMsg2);
     }
     try {
    	 Thread.sleep(1000);
     Assert.assertNotEquals(toastMsg2, null);
     }
     catch(InterruptedException e) {
			e.printStackTrace();
     }
	
	
}
@Test(priority=10)
public void forgotpasswordemail() throws InterruptedException{
	extentTest = extent.startTest("forgotpasswordemail");
driver.navigate().to("https://slic4rfe-ng-ngx.fabheads.in/login");
	
	driver.findElement(forgpass).click();
	Thread.sleep(5000);
	driver.findElement(foremail).sendKeys("test1234@yopmail.com");
	driver.findElement(r_login).click();
	driver.navigate().to("https://yopmail.com/en/");
	driver.findElement(emailtext).sendKeys("Test@12345");
	driver.findElement(clickbtn).click();
	
}

@Test(priority=11)
public void resetpassword() throws InterruptedException {
	extentTest = extent.startTest("resetpassword");
	driver.navigate().to("https://slic4rfe-ng-ngx.fabheads.in/login");
	Thread.sleep(3000);
	driver.findElement(forgpass).click();
	Thread.sleep(3000);
	driver.findElement(foremail).sendKeys("test1234@yopmail.com");
	Thread.sleep(3000);
	driver.findElement(r_login).click();
	Thread.sleep(5000);
	String PURL1=driver.getCurrentUrl();
	System.out.println("Current URL is:" +PURL1);

	try{
		Thread.sleep(5000);
		
	String PWURL="https://slic4rfe-ng-ngx.fabheads.in/login";
//	Assert.assertEquals(PURL1,PWURL);
	if(PURL1.equals(PWURL))
	System.out.println("User is directed to login page.");
	}
	catch(InterruptedException e) {
		e.printStackTrace();
	}
	

	
	
}


@Test(priority=12)
public void login() throws InterruptedException {
	extentTest = extent.startTest("login");
	driver.navigate().to("https://slic4rfe-ng-ngx.fabheads.in/login"); 
	driver.findElement(User_Id).sendKeys("abhijeet@fabheads.in");
	driver.findElement(pass_Id).sendKeys("fab123fab");
	Thread.sleep(5000);
	driver.findElement(logIn).click();
	
	try{
		Thread.sleep(3000);
		String cURL4=driver.getCurrentUrl();
		System.out.println("Current URL is:" +cURL4);
	String PURL2="https://slic4rfe-ng-ngx.fabheads.in/jobs";
	Assert.assertEquals(PURL2, cURL4);
	System.out.println("User has logged in successfully.");
	}
	catch(InterruptedException e) {
		e.printStackTrace();
	}
	
	
}

}
	
	
	


