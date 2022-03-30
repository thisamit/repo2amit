package Git_Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import ApplicationUtility.ApplicationUtility;
import BaseLibrary.BaseLibrary;

public class YourRepositories_Page extends BaseLibrary {
	@FindBy(xpath="//details-menu[@style='width: 180px']")
	private WebElement yourRepomenu;
	@FindBy(xpath="(//div/a[@href=\"/thisamit/repo1amit\"]/preceding::a)[25]")
	private WebElement selectyourRepomenu;
	public YourRepositories_Page() {
		PageFactory.initElements(driver, this);
	}
	public void selectyourepository() throws InterruptedException {
		Thread.sleep(3000);

		ApplicationUtility.clickonElement(selectyourRepomenu);
		Thread.sleep(3000);

	}
}
