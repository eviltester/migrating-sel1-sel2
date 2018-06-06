package com.eviltester.gwtshowcase.pageObjects;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.eviltester.gwtshowcase.pageObjects.BasicButtonPanel;

public class SideMenu {

	private MenuHeading widgets;
	private MenuHeading listsAndMenus;
	private MenuHeading textInput;
	private MenuHeading tables;
	private MenuHeading cellWidgets;
	private WebDriver driver;
	private WebDriverWait wait;
	private ExpectedConditionFactory weCanSee;
	private String apphost;

	public SideMenu(WebDriver driver, String apphost) {
		  this.driver = driver;
		  this.apphost = apphost;
			widgets = new MenuHeading(driver,"Widgets", "Checkbox");
			listsAndMenus = new MenuHeading(driver,"Lists and Menus", "List Box");
			textInput = new MenuHeading(driver,"Text Input", "Basic Text");
			tables = new MenuHeading(driver,"Tables", "Grid");
			cellWidgets = new MenuHeading(driver,"Cell Widgets", "Cell List");
			
			wait = new WebDriverWait(driver,20);
			weCanSee = new ExpectedConditionFactory();			
	}

	public MenuHeading widgets(){
		return this.widgets;
	}
	
	public HyperLinksPanel selectWidgetsHyperlink() {
		clickSubMenuItem("Hyperlink");
		return new HyperLinksPanel(driver);	
	}
	
	public RadioButtonsPanel selectWidgetsRadioButton() {
		clickSubMenuItem("Radio Button");
		return new RadioButtonsPanel(driver);	
	}

	public BasicButtonPanel selectWidgetsBasicButton() {
		clickSubMenuItem("Basic Button");
		return new BasicButtonPanel(driver);	
	}

	private void clickSubMenuItem(String subMenuText) {
		String xpathExpression = "//div[@class='GALD-WOBF' and .='" + subMenuText + "']";
		driver.findElement(By.xpath(xpathExpression)).click();	
		wait.until(weCanSee.GWTTitleMatches(subMenuText));
	}
	
	
	public MenuHeading listsAndMenus(){
		return this.listsAndMenus;
	}		


	public MenuHeading textInput() {
		return this.textInput;
	}
	
	public BasicTextPanel selectTextInputBasicText() {
		clickSubMenuItem("Basic Text");
		return new BasicTextPanel(driver);	
	}

	public MenuHeading tables() {
		return this.tables;
	}

	public FlexTablePanel selectTablesFlexTable() {
		clickSubMenuItem("Flex Table");
		return new FlexTablePanel(driver);	
	}

	public MenuHeading cellWidgets() {
		return this.cellWidgets;
	}

	public CellTablePanel selectCellWidgetsCellTable() {
		clickSubMenuItem("Cell Table");
		return new CellTablePanel(driver);
	}
}
