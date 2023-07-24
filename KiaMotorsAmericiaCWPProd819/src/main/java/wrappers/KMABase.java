package wrappers;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

import org.junit.AfterClass;
import org.mozilla.javascript.Context;
import org.testng.ITestClass;
import org.testng.ITestContext;
import org.testng.ITestResult;

import utils.DataInputProvider;

public class KMABase extends GenericWrappers {

	public String browserName;
	public String dataSheetName;

	@BeforeTest
	public void beforeTest() {
		startResult();
		loadObjects();

	}
	
	@Parameters({ "browser", "testCaseName", "testDescription", "category", "authors" })
	@BeforeClass
	public void beforeClass(ITestContext testContext,String browserName, String testCaseName, String testDescription, String category,
			String authors) {
		String classname =this.getClass().getSimpleName();
		System.out.println(classname);
		startTest(classname, testDescription);
	}

	@Parameters({ "browser", "category", "authors"  })
	@BeforeMethod
	public void beforeMethod(Method method, String browserName, String category,
			String authors) {
		String description = getDescription(method);
		String testName = getTestName(method);
		System.out.println(testName);
		test = startTestCase(testName, description);
		test.assignCategory(category);
		test.assignAuthor(authors);
		invokeApp(browserName);
	}
	@AfterClass
	public void afterClass() {
		endTest();
	}
	@AfterTest
	public void afterTest() throws InterruptedException {
		unloadObjects();
		endResult();
	}

	@AfterMethod
	public void afterMethod() throws InterruptedException {
		endTestcase();
		closeAllBrowsers();

	}

	@DataProvider(name = "fetchData")
	public Object[][] getData(ITestContext context) {
		String dataSheetName = context.getCurrentXmlTest().getParameter("dataSheetName");
		return DataInputProvider.getAllSheetData("./data/" + dataSheetName + ".xlsx");
	}

}