package com.sauce.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sauce.qa.base.TestBase;

public class CheckoutOverviewPage extends TestBase{
	
	@FindBy(xpath="//div[@class='inventory_item_name']")
	WebElement item;
	
	@FindBy(xpath="//button[@id='finish']")
	WebElement finish;
	
	public CheckoutOverviewPage() {
		PageFactory.initElements(driver, this);
	}
	
	public String getItemName() {
		return item.getText();
	}
	
	public CheckoutCompletePage clickFinish() {
		finish.click();
		return new CheckoutCompletePage();
	}

}
