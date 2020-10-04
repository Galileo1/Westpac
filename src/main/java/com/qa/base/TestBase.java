package com.qa.base;


	import java.io.File;
	import java.io.FileInputStream;
	import java.io.FileNotFoundException;
	import java.io.IOException;
	import java.util.Properties;
	import java.util.concurrent.TimeUnit;

	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.chrome.ChromeDriver;

import com.qa.util.TestUtil;



	public class TestBase {

		
		public static WebDriver driver;
		public static Properties prop;
		
		{
			prop= new Properties();
			FileInputStream fis;
			try {
				// Getting ClassLoader obj
				ClassLoader classLoader = this.getClass().getClassLoader();
				// Getting resource(File) from class loader
				File configFile = new File(classLoader.getResource("config.properties").getFile());
				fis = new FileInputStream(configFile);
				try {
					prop.load(fis);
				} catch (FileNotFoundException e) {
						e.printStackTrace();
				}
			} catch (IOException e) {
						e.printStackTrace();
			}
				
		}
		
		public static void initialization()
		{
			prop.getProperty("browser");
			String osname =System.getProperty("os.name").toLowerCase();
			String projectLocation = System.getProperty("user.dir");
			if (osname.contains("windows") && prop.getProperty("browser").contains("chrome")) {
				System.setProperty("webdriver.chrome.driver", projectLocation + "//src//main//resources//win//chromedriver.exe");
			} else if (osname.contains("mac os") && prop.getProperty("browser").contains("chrome")) {
				System.setProperty("webdriver.chrome.driver", projectLocation + "//src//main//resources//mac//chromedriver");
			}
			driver=new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().pageLoadTimeout(TestUtil.Page_Load_Timeout, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(TestUtil.Implicit_Wait, TimeUnit.SECONDS);
			driver.get(prop.getProperty("url"));
			
		}
		
		public void TearDown()
		{
			driver.quit();
		}

	}



