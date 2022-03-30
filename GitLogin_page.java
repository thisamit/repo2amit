package Git_Pages;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import ApplicationUtility.ApplicationUtility;
import BaseLibrary.BaseLibrary;
public class GitLogin_page extends BaseLibrary {
		@FindBy(xpath="//div/a[@href=\"/login\"]")
		private WebElement signin;
		@FindBy(xpath="//input[@id=\"login_field\"]")
		private WebElement userlogin;
		@FindBy(xpath="//input[@id=\"password\"]")
		private WebElement userpassword;
		@FindBy(xpath="//input[@value=\"Sign in\"]")
		private WebElement signinbutton;
		public GitLogin_page(){
			PageFactory.initElements(driver,this);
		}
		public void gettile() {
			System.out.println(driver.getTitle());
		}
		public void gitsignin(String username,String password) throws InterruptedException {
			ApplicationUtility.clickonElement(signin);
			userlogin.sendKeys(username);
			userpassword.sendKeys(password);
			ApplicationUtility.clickonElement(signinbutton);
			String GithubLoginTitle=driver.getTitle();
			Assert.assertEquals(GithubLoginTitle, "GitHub","Title Matched");
		
		}
	}


