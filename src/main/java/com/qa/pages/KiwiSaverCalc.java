package com.qa.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.TestBase;
import com.qa.util.TestUtil;


public class KiwiSaverCalc extends TestBase{
	

		
		//WebDriver driver;
		
		KiwiSaverCalc kiwisaverpage;
		
		TestUtil testutil;
		
		@FindBy(id = "ubermenu-section-link-kiwisaver-ps")
		 WebElement kiwisaver;
		
		@FindBy(id = "ubermenu-item-cta-kiwisaver-calculators-ps")
		 WebElement kiwisavercalc;
		
		@FindBy(xpath = "//a[contains(.,'Click here to get started.')]")
		WebElement clickstart;
		
		@FindBy(xpath = "//div[@help-id='CurrentAge']//div[@class='control-well']")
		WebElement current_age;

		@FindBy(className= ("icon"))
		WebElement icon;

		@FindBy(css= ".field-message.message-info.ng-binding")
		WebElement current_age_info;


		@FindBy(xpath = "//div[@help-id='CurrentAge']//div[@class='control-well']")
		WebElement age;
		
		
		@FindBy(xpath = "//div[@help-id='EmploymentStatus']//i[@class='ir dropdown-arrow']")
		WebElement estatus;
		
		@FindBy(xpath ="//div[@class='dropdown']//li[@value='employed']")
		WebElement estatus_employed;
		
		@FindBy(xpath="//span[@class='ng-scope' and text()='Self-employed']")
		WebElement estatus_selfemp;
		
		@FindBy(xpath= "//span[@class='ng-scope' and text()='Not employed']")
		WebElement estatus_notemployed;
		
		@FindBy(xpath= "//div[@help-id='AnnualIncome']//input[@class='ng-pristine ng-valid']")
		WebElement sal;
		
		@FindBy(xpath="//input[@id='radio-option-04F']")
		WebElement KiwiSaverContri;
		
		@FindBy(xpath="//div[@help-id ='KiwiSaverBalance']//div[@class='control-well']")
		WebElement KiwiSaverBal;
		
		@FindBy(xpath="//div[@help-id='VoluntaryContributions']//div[@class='control-cell']")
		WebElement contri;
		
		@FindBy(xpath="//div[@class='dropdown']//li[@value='fortnight']")
		WebElement frequency1;
		
		@FindBy(xpath="//div[@class='dropdown']//li[@value='year']")
		WebElement frequency2;
		
		@FindBy(xpath="//input[@id='radio-option-016']")
		WebElement riskprofile_conservative;
		
		@FindBy(xpath="//input[@id='radio-option-013']")
		WebElement riskprofile_defensive;
		
		@FindBy(xpath="//input[@id='radio-option-019']")
		WebElement riskprofile_balanced;
		
		@FindBy(xpath="//div[@help-id='SavingsGoal']//input[@class='ng-pristine ng-valid']")
		WebElement saving_goal;
		
		@FindBy(xpath="//button[@class='btn btn-regular btn-results-reveal btn-has-chevron']")
		WebElement button;
		
		@FindBy(xpath="//span [@class='result-value result-currency ng-binding']")
		WebElement result;
		
		public KiwiSaverCalc()
		{
			PageFactory.initElements(driver, this);
			testutil = new TestUtil();
		}
		
		
		
		public void ClickonCalc() 
		 {
			Actions action=new Actions(driver);
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);		
			action.moveToElement(kiwisaver).click(kiwisavercalc).build().perform();
			testutil.waitForPageLoaded();
			clickstart.click();
			 
		 }
		
		public String VerifyInfomessage()
		
		{
			testutil.waitForPageLoaded();
			testutil.switchtoFrame();
			   icon.click();
			   return current_age_info.getText();
			
		}
		
		
		public boolean US2TC1(String ageval, String salary)
		{
			testutil.switchtoFrame();
		    age.sendKeys(ageval);
		    estatus_employed.click();
		    sal.sendKeys(salary);
		    KiwiSaverContri.click();
		    riskprofile_defensive.click();
		    button.click();
		    System.out.println("Result is" + result);
		    return result.isDisplayed();
		}

		public boolean US2TC2(String ageval, String kiwi_saver_balanceVal, String voluntary_contributionVal,
                String goal_requirementVal)
		{
			testutil.switchtoFrame();
		    age.sendKeys(ageval);
		    estatus_selfemp.click();
		    KiwiSaverBal.sendKeys(kiwi_saver_balanceVal);
		    frequency1.click();
		    contri.sendKeys(voluntary_contributionVal);
		    riskprofile_conservative.click();
		    saving_goal.sendKeys(goal_requirementVal);
		    button.click();
		    System.out.println("Result is" + result);
		    return result.isDisplayed();
		}

		public boolean US2TC3(String ageval, String kiwi_saver_balanceVal, String voluntary_contributionVal,
                String goal_requirementVal)
		{
			testutil.switchtoFrame();
		    age.sendKeys(ageval);
		    estatus_notemployed.click();
		    KiwiSaverBal.sendKeys(kiwi_saver_balanceVal);
		    frequency2.click();
		    contri.sendKeys(voluntary_contributionVal);
		    riskprofile_balanced.click();
		    saving_goal.sendKeys(goal_requirementVal);
		    button.click();
		    System.out.println("Result is" + result);
		    return result.isDisplayed();
		}

		

}
