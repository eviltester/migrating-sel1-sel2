package com.eviltester.gwtshowcase.pageObjects;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.pagefactory.ElementLocatorFactory;
import org.openqa.selenium.support.FindBy;

public class FlexTablePanel {

	private WebDriver driver;
	
	@FindBy(xpath="//td[@id='gwt-debug-cwFlexTable-0-1']//button[.='Remove a row']")
	private WebElement removeRowButton;
	
	@FindBy(xpath="//td[@id='gwt-debug-cwFlexTable-0-1']//button[.='Add a row']")
	private WebElement addRowButton;	

	@FindBy(xpath="//table[@id='gwt-debug-cwFlexTable']/tbody")
	private WebElement flexTable;
	
	public FlexTablePanel(WebDriver driver) {
		ElementLocatorFactory finder = new AjaxElementLocatorFactory(driver,10);
		PageFactory.initElements(finder,this);
		this.driver = driver;
	}

	public boolean isPageTitleCorrect() {
		return driver.getTitle().endsWith("Flex Table");
	}

	public int getNumberOfRows() {
		return flexTable.findElements(By.xpath("tr")).size()-1;
	}

	public void addRow(){
		addRowButton.click();
	}
	
	public void removeRow(){
		removeRowButton.click();
	}
	
}
