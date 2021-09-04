package com.saas.pages;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.saas.utills.Constants;
import com.saas.utills.ElementUtil;



public class HomePage {
	
	private WebDriver driver;
	private ElementUtil elementUtil;
	
// 2. constructors
	public HomePage(WebDriver driver) {
		this.driver = driver;
		elementUtil = new ElementUtil(driver);
	}

	private By NavigatorIcon = By.xpath("//a[@title='Navigator']");
	
	
//	HomePage homePage=new HomePage();

	@FindBy(xpath = "//table[contains(@id,'pt1:_UISmmp2')]")
	public WebElement tblNavigatorOptions;

	@FindBy(xpath = "//a[@title='Navigator']")
	public WebElement iconNavigator;

	@FindBy(xpath = "//*[contains(@id,'pt1:_UIShome::icon')]")
	public WebElement HomePage_HomeIcon;

	@FindBy(xpath = "//a[@id='_FOpt1:_UIShome']")
	public WebElement HomeIcon;

	@FindBy(css = "a[id*='UIShome']")
	public WebElement iconHome;

	@FindBy(xpath = "//*[text()='Me']")
	public WebElement lnkMe;

	@FindBy(xpath = "//a[text()='My Client Groups']")
	public WebElement MyClientGroupsTab;

	@FindBy(xpath = "//a[text()='Person Management']")
	public WebElement PersonManagement;

	@FindBy(xpath = "//a[text()='New Person']")
	public WebElement NewPersonLink;

	

	@FindBy(css = "a[id$='nvcil2']")
	public WebElement nvrMenuIcnHome;

	@FindBy(xpath = "//div[@title='My Client Groups']")
	public WebElement secMyClientGroups;

	@FindBy(xpath="//span[text()='Expenses']")
	public WebElement navExpensesLink;

	public String getHomePageTitle() {
		return elementUtil.waitForTitle(5, Constants.LOGIN_PAGE_TITLE);
	}
	
	public void clickOnNavigationIcon() {
		elementUtil.doClick(NavigatorIcon);
		System.out.println("Navigation Icon is clicked");
	}

	public String getUserNameFromHomePage() {
		String strUserName = null;
		try {
			driver.findElement(By.xpath("//img[contains(@id,'pt1:_UIScmil2u::icon')]")).isDisplayed();
			strUserName = driver.findElement(By.xpath("//img[contains(@id,'pt1:_UIScmil2u::icon')]"))
					.getAttribute("title");
			System.out.println("UserName captured from HomePage: " + strUserName);
		} catch (Exception e) {
			System.out.println("UserName could not be captured from HomePage");
		}
		return strUserName;
	}

//	public boolean clickOnHomeIcon() {
//
//		boolean flag = false;
//		try {
//			iconHome.click();
//			log.info("Clicked on Home icon");
//			flag = true;
//		} catch (Exception e) {
//			log.info("Unable to click Home icon");
//			e.printStackTrace();
//		}
//		return flag;
//	}
//	
//	
//	public Object clickOnMeLink() {
//		try {
//			cmnLib.waitForElementToBeVisible(lnkMe);
//			cmnLib.clickByJSE(lnkMe);
//			log.info("Me Link is Clicked");
//			
//		} catch (Exception e) {
//			// TODO: handle exception
//			log.info("Me Link is Not Clicked");
//			return null;
//		}
//		return HomePage_HomeIcon;
//		
//	}
//	public boolean verifyLoginSuccessful() {
//		return cmnLib.waitForElementToBeVisible(HomePage_HomeIcon,60);
//	}
//	
//	public ExpenseReportSubmission navigateToExpensesPage() {
//		//Click on Navigator Icon
//		clickOnNavigationIcon();
//		//Click On Expenses from Navigator Links
//		clickOnMeLink();
//		clickOnExpensesLink();
//		return PageFactory.initElements(getDriver(), ExpenseReportSubmission.class);
//	}
//	public  ExpenseReportSubmission clickOnExpensesLink() {
//		try {
//			cmnLib.waitForElementToBeVisible(navExpensesLink);
//			navExpensesLink.click();
//			log.info("Expenses Link is Clicked");
//			
//		} catch (Exception e) {
//			// TODO: handle exception
//			log.info("Expenses Link is Not Clicked");
//			return null;
//		}
//		return PageFactory.initElements(getDriver(), ExpenseReportSubmission.class);
//	}

}
