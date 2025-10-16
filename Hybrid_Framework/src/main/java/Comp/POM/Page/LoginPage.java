package Comp.POM.Page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	@FindBy(name = "username")WebElement txtEmail;
	@FindBy(name = "password")WebElement txtPassword;
	@FindBy(name = "remember")WebElement CheckRemember;
	@FindBy(name = "submit")WebElement btnSubmit;
	
	@FindBy(id="login-username-error") WebElement emailerror;
	@FindBy(id="login-password-error") WebElement passworderror;

	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	public void email(String mail)
	{
		txtEmail.sendKeys(mail);
	}
	public void password(String pass)
	{
		txtPassword.sendKeys(pass);
	}
	public void remember()
	{
		CheckRemember.click();
	}
	public void submit()
	{
		btnSubmit.click();
	}
	public String EmailError() {
		return emailerror.getText();
	}
	public String passworsError()
	{
		return passworderror.getText();
	}}
