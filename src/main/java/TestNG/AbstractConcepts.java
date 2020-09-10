package TestNG;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AbstractConcepts {

	public static WebDriver driver;
	public static void driveropen() {
		System.setProperty("webdriver.chrome.driver", ".\\browser\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();

	}
	public static void url() {
		driver.get("https://www.brainyquote.com/authors");
		List<WebElement> allAuthorsName = driver.findElements(By.xpath("//span[@class='authorContentName']"));
		for (WebElement authorname : allAuthorsName) {
			if(author.equals(authorname.getText())) {
				authorname.click();	
				break;
			}
		}
	}
	public static String author;
	public static List<String> quotes=new ArrayList<String>(); 
	public static List<WebElement> allQuotesEle=new ArrayList<WebElement>();
	public static List<WebElement> tagEle=new ArrayList<WebElement>();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String giventagname="";
		String containsvalue="";
		author="A. P. J. Abdul Kalam";
		driveropen();
		url();

		if(giventagname.isEmpty()) {

			allQuotesEle=driver.findElements(By.xpath("//a[@title='view quote']"));

		}
		else {
			allQuotesEle=driver.
					findElements(By.xpath("//div[@class='kw-box']/a[text()='"+giventagname+"']/preceding::div[3]/child::a[@title='view quote'][1]"));
		}
		for (WebElement singleQuote : allQuotesEle) 
		{
			quotes.add(singleQuote.getText());
			System.out.println(singleQuote.getText());
			containsvalue=singleQuote.getAttribute("class");
			tagEle = driver.
					findElements(By.xpath("//a[@class='"+containsvalue+"']//ancestor::div[starts-with(@class,'m-brick grid')]//descendant::div[6]//a"));
			for (WebElement tag:tagEle) {			
				System.out.println(tag.getText());
			}

		}


	}
}



