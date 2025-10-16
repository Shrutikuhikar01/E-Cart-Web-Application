package com.Utilities;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class MyScreenShots extends BaseClass{
	public static String  getInstance(String name) {
		
		String path = System.getProperty("user.dir")+"/ScreenShots/"+name+".png";
		TakesScreenshot tks =(TakesScreenshot)driver;
			File source = tks.getScreenshotAs(OutputType.FILE);
			
			File target = new File(path);
			
			try {
				FileUtils.copyFile(source, target);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return path;
	}
	
}
