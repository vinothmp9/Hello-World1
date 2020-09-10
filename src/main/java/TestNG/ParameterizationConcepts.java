package TestNG;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import org.apache.poi.ddf.EscherColorRef.SysIndexSource;
import org.apache.poi.util.SystemOutLogger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class ParameterizationConcepts {
	SoftAssert softassert=new SoftAssert();

	@Parameters({"name","pass"})
	//@Test
	public static void browser(String name,String pass)
	{
		System.out.println("username"+name+"password"+pass);
		Assert.assertEquals(true, true);
		Assert.assertNotEquals(true, false);
		Assert.assertTrue(true, "hi");
		Assert.assertFalse(false, "hi");

	}
	@DataProvider
	public static Object[][] logindata() {
		return new Object[][] {{"vinoth","pandian"},{"vinoth","pandian"},{"vinoth","pandian"}};
	}
	//@Test(dataProvider="logindata")
	public void dataread(String a,String b) {
		softassert.assertEquals(false, true);
		System.out.println("happy ");
		System.out.println("birthday ");
		softassert.assertAll();
	}
	public static WebDriver driver;
	public static void ratsnumber() {

		int j=0;
		int number=16;
		int a=number;
		int s = 0;
		if(number>0) 
		{	while(a!=0)
		{
			j=j*10+a%10;;
			a=a/10;
		}
		s=number+j;
		}
		else if(number<0) {
			s=-1;
		}
		System.out.println(s);
	}

	public static void listExamples() {
		List<String> first=new ArrayList<String>();
		first.add("vinoth");
		first.add("vinith");
		List<String> last=new ArrayList<String>();
		last.add("pandian");
		last.add("vini");
		last.addAll(first);
		Collections.sort(last);
		Iterator<String> a=last.iterator();
		while(a.hasNext()) {
			System.out.println(a.next());
		}
	}
	//@Test
	public void convertListToSet() {

		Integer b[]= {10,20,30,40,50,50,50};
		List<Integer> li=Arrays.asList(b);
		Set<Integer> se=new LinkedHashSet<Integer>(li);
		for (Integer integer : se) {
			System.out.println(integer);
		}

	}	

	public void repetativewords() {

		Map<String, Integer> times=new LinkedHashMap<String, Integer>();
		String[] tagname= {"java","java","java","vinoth","jino"};
		for (String tag : tagname) {
			if(times.containsKey(tag)) {
				Integer in=times.get(tag);
				times.put(tag, in+1);
			}
			else {
				times.put(tag, 1);
			}
		}

		Set<Entry<String, Integer>> entrySet = times.entrySet();
		for (Entry<String, Integer> entry : entrySet) {
			if (entry.getValue()>1) {
				System.out.println(entry);
			}
		}}}