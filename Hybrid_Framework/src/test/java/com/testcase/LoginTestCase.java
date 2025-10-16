package com.testcase;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.Utilities.BaseClass;

public class LoginTestCase extends BaseClass  {
	
	@Test(dataProvider = "TestData")
	void testLogin(String emailid, String password, String isData)
	{
		lp.email(emailid);
		lp.password(password);
		lp.remember();
		lp.submit();
		
		if(isData.equals("1"))
		{
			Assert.assertEquals(driver.getTitle(),"Welcome to My Store");
		}
		if(isData.equals("2"))
		{
			Assert.assertEquals(lp.EmailError(),"Please enter a valid email address.");
		}
		if(isData.equals("3"))
		{
			Assert.assertEquals(lp.passworsError(),"Please enter a password.");
		}
		if(isData.equals("4"))
		{
			Assert.assertEquals(lp.passworsError(),"Please enter a password.");
		}
		if(isData.equals("5"))
		{
			Assert.assertEquals(lp.EmailError(),"Please enter a valid email address.");
		}
		if(isData.equals("6"))
		{
			Assert.assertEquals(lp.EmailError(),"Invalid username or password");
		}
		
		
		
		
	}
	
	@DataProvider (name = "TestData")
	String [][] testdata()
	{
		return new  String[][]
				{{"shrutikuhikar01@gmail.com","shrutikuhikar01","1"},
			{"shrutikuhikar01gmail.com","shrutikuhikar01","2"},
			{"shrutikuhikar01@gmail.com","@shruti123","3"},
			{"shrutikuhikar01@gmail.com","","4"},
			{"","shrutikuhikar01","5"},
			{"","","6"}};
	}
	

}
