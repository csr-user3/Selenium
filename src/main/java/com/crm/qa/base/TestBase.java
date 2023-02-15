package com.crm.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.crm.qa.util.TestUtil;

public class TestBase {
	
	public static WebDriver driver;
	public static Properties prop;
	
	public TestBase() {
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream("C:\\Users\\cmanikon\\eclipse-workspace\\"
					+ "TPM\\ProjectOne\\src\\main\\java\\com\\crm\\qa\\config\\config.properties");
			prop.load(ip);
		
		}
		catch(FileNotFoundException e) {
			e.printStackTrace();
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}
	public static void initialization() {
		String browsername = prop.getProperty("browser");
		
		if(browsername.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\cmanikon\\Downloads\\chromedriver_win32 (8)\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		else if(browsername.equals("FF")) {
			System.setProperty("webdriver.gecko.driver", "C:\\Users\\cmanikon\\Downloads\\geckodriver-v0.32.0-win32 (1)\\geckodriver.exe");
			driver = new FirefoxDriver();
		}
		driver.get(prop.getProperty("url"));
		//driver.get("https://classic.freecrm.com/index.html");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(TestUtil.PAGELOAD_TIMEOUT));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(TestUtil.IMPLICIT_WAIT));
		
		
		
	}
}
