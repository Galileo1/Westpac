package com.qa.testcase;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.base.TestBase;
import com.qa.pages.KiwiSaverCalc;


public class KiwiSaverCalctest extends TestBase{
	
	public WebDriver driver;
	public KiwiSaverCalc kiwisaverpage;
	
	
	public KiwiSaverCalctest()
	{
		super();
	}
	
	@BeforeMethod
	public void Setup()
	{
		initialization();
		kiwisaverpage=new KiwiSaverCalc();
		
		
	}
	
	@Test

	public void TC1_ShowInfoMessageForAge()
	{	  
		kiwisaverpage.ClickonCalc();
		 String actualCurrentAgeMessage = kiwisaverpage.VerifyInfomessage();

	        String expectedTitlePage = "This calculator has an age limit of 18 to 64 years old.";
	        Assert.assertEquals(actualCurrentAgeMessage, expectedTitlePage);		
		    
	}
	
	@Test
	
	public  void VerifyUS1TC1(String ageval, String salary) {
		
		initialization();
		kiwisaverpage=new KiwiSaverCalc();
		kiwisaverpage.ClickonCalc();
        boolean  balance= kiwisaverpage.US2TC1("30", "82000");
        
       Assert.assertTrue(balance, "KiwiSaver balance is estimated to be:$436,365" );
	}
	
     @Test
	
	public  void VerifyUS2TC2(String ageval, String salary, String kiwi_saver_balanceVal, String voluntary_contributionVal,
            String goal_requirementVal) {
		
		initialization();
		kiwisaverpage=new KiwiSaverCalc();
		kiwisaverpage.ClickonCalc();
        boolean  balance= kiwisaverpage.US2TC2("45","100000","90", "290000");
        
       Assert.assertTrue(balance, "KiwiSaver balance is estimated to be:$436,365" );
	}

     @Test
     
     public  void VerifyUS2TC3(String ageval, String salary, String kiwi_saver_balanceVal, String voluntary_contributionVal,
             String goal_requirementVal) {
 		
 		initialization();
 		kiwisaverpage=new KiwiSaverCalc();
 		kiwisaverpage.ClickonCalc();
         boolean  balance= kiwisaverpage.US2TC2("55","1400000","10", "200000");
         
        Assert.assertTrue(balance, "KiwiSaver balance is estimated to be:$436,365" );
 	}
     
	
	@AfterClass
	public void CloseApplication()
	{
		TearDown();
	}
	

}
