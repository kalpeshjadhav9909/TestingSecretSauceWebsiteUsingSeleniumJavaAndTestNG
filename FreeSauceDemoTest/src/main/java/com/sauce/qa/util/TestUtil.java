package com.sauce.qa.util;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;

import com.sauce.qa.base.TestBase;

public class TestUtil extends TestBase{
	
	public static long implicitWait = 10;
	
	//Switching Between Frames
	
	public static void switchToFrame(int index) {
		driver.switchTo().frame(index);
	}
	public static void switchToFrame(String nameorID) {
		driver.switchTo().frame(nameorID);
	}
	public static void switchToFrame(WebElement frameElement) {
		driver.switchTo().frame(frameElement);
	}
	public static void switchToParentFrame() {
		driver.switchTo().parentFrame();
	}
	
	//Switching Between Windows
	
	public static void switchWindow() {
		
	}
	
	//Taking ScreenShot
	
	public static void takeScreenShot() throws IOException {
		Date dt=new Date();
		String fileName=dt.toString().replace(" ", "_").replace(":", "-");
		File screenshot=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshot, new File(".//Evidences//Screenshots//"+fileName+".png"));
	}
	public static void takeScreenShot(String name) throws IOException {
		Date dt=new Date();
		String fileName=dt.toString().replace(" ", "_").replace(":", "-");
		File screenshot=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshot, new File(".//Evidences//Screenshots//"+name+"("+fileName+")"+".png"));
	}

}
