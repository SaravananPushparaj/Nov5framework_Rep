package PageObject_Component;

import io.appium.java_client.AppiumDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PageObject_Search {
	//2nd section
	
	@FindBy(id="com.bigbasket.mobileapp:id/homePageSearchBox")
	public WebElement Search_txtbox;
	
	@FindBy(id="com.bigbasket.mobileapp:id/homePageSearchBox")
	public WebElement Search_txtbox2;
	
	@FindBy(id="com.bigbasket.mobileapp:id/txtEmptyMsg1")
	public WebElement Invalid_msg;
	
	@FindBy(id="com.bigbasket.mobileapp:id/txtProductCount")
	public WebElement Valid_item;
	
	
	
	
	
	//1st section
	public PageObject_Search(AppiumDriver driver)
	{
		PageFactory.initElements(driver, this);
		
	}
	
	
	
	//3rd Section
	
	public void EnterSearch(String Search_Item)
	{
		Search_txtbox.click();
		Search_txtbox2.sendKeys(Search_Item +"\n");
		
	}
	
	
	public String getInvalidmsg()
	{
		return Invalid_msg.getText();
		
	}
	
	
	public String getValiditem()
	{
		return Valid_item.getText();
		
	}
	
	
	
	
	
	
	
	
	
	
	
	

}
