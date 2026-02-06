package testBase;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class TestBase 
{
	public WebDriver driver;
	public Properties prop;
	
	@Parameters({"os","browser"})
	@BeforeClass
	public void setUp(String os, String browser) throws IOException
	{
		FileReader file = new FileReader("./src\\test\\resources\\config.properties");
		prop = new Properties();
		prop.load(file);
		
		switch (browser.toLowerCase()) 
		{
		case "chrome":driver = new ChromeDriver();
		break;
		case "edge":driver = new EdgeDriver();
		break;
		case "firefox" : driver = new FirefoxDriver();
		break;
		default: System.out.println("Invalid browser");
		return;
		}
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get(prop.getProperty("url"));
				
	}
	
	@AfterClass
	public void tearDown()
	{
		driver.close();
	}

	
//	public String captureScreenshot(String tname)
//	{
//		SimpleDateFormat df = new SimpleDateFormat("yyyy.MM.dd.hh.mm.ss");
//		Date dt = new Date();
//		String timeStamp = df.format(dt);
//		
//		TakesScreenshot ts = (TakesScreenshot)driver;
//		File srcFile = ts.getScreenshotAs(OutputType.FILE);
//		
//		String filePath = System.getProperty("user.dir")+"\\screenshots\\" + tname + "_" + timeStamp + ".png";
//		File targetFile = new File(filePath);
//		srcFile.renameTo(targetFile);
//		
//		return filePath;
//	}

	
}
