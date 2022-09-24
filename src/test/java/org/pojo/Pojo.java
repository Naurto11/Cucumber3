package org.pojo;

import org.base.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Pojo extends BaseClass {

	public Pojo() {

		PageFactory.initElements(driver, this);
	}
	
	

	@FindBy(xpath="//input[@id='email']")
	
	private WebElement txtBox;
	
	
	@FindBy(xpath="//input[@type='password']")
	
	private WebElement txtPass;
	
	@FindBy(xpath="//button[text()='Log In']")
	
	private WebElement pressBtn;
	
	
	@FindBy(xpath="//div[text()='Account Settings']")
	
	private WebElement clkAct;
	
	
	@FindBy(xpath="//span[text()='Log Out']")
	
	private WebElement closeFb;


	public WebElement getTxtBox() {
		return txtBox;
	}


	public WebElement getTxtPass() {
		return txtPass;
	}


	public WebElement getPressBtn() {
		return pressBtn;
	}


	public WebElement getClkAct() {
		return clkAct;
	}


	public WebElement getCloseFb() {
		return closeFb;
	}

}
