package Git_Pages;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import ApplicationUtility.ApplicationUtility;
import BaseLibrary.BaseLibrary;
import ScreenshotUtility.ScreenshotUtility;
public class UploadFile_page extends BaseLibrary {
	@FindBy(xpath="(//div/a[@href=\"/thisamit/repo2amit\"]/preceding::a)[25]")
	private WebElement selectyourRepomenu;
@FindBy(xpath="//a[text()='uploading an existing file']")
private WebElement clickonupload;
@FindBy(xpath="/html/body/div[5]/div/main/div[2]/div/div[2]/form[2]/file-attachment/p/input")
private WebElement choosefile;

public UploadFile_page() {
	PageFactory.initElements(driver, this);
}

public void uploadfile(String path) throws InterruptedException {
	ApplicationUtility.clickonElement(selectyourRepomenu);
	ApplicationUtility.clickonElement(clickonupload);
	Thread.sleep(2000);
	Actions act=new Actions(driver); 
	Thread.sleep(2000);
	act.moveToElement(choosefile).click().build().perform();;
	try {
		StringSelection s1=new StringSelection(path);
		Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
		clipboard.setContents(s1, null);
		Robot rb=new Robot();
		rb.keyPress(KeyEvent.VK_ENTER);
		rb.delay(250);

		rb.keyRelease(KeyEvent.VK_ENTER);

		rb.keyPress(KeyEvent.VK_CONTROL);
		rb.delay(250);
		rb.keyPress(KeyEvent.VK_V);
	

		rb.keyRelease(KeyEvent.VK_V);
		rb.delay(250);

		rb.keyRelease(KeyEvent.VK_CONTROL);
		rb.keyPress(KeyEvent.VK_ENTER);
		rb.delay(250);
		rb.keyRelease(KeyEvent.VK_ENTER);
		ScreenshotUtility.getscreenshot("passed", "uploadfile.png");
	}
	catch(Exception e){
		System.out.println(e);
	}
}
}
