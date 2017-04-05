package ua.kiev.prog.testngexamples;

import org.testng.annotations.*;

public class TestConfiguration {

	@BeforeGroups("shopping")
    public void beforeGroups() {
		System.out.println("@BeforeGroups");
	}

	@AfterGroups("shopping")
	public void afterGroups() {
		System.out.println("@AfterGroups");
	}

	@BeforeClass
	public void beforeClass() {
		System.out.println("@BeforeClass");
	}

	@AfterClass
	public void afterClass() {
		System.out.println("@AfterClass");
	}

	@BeforeMethod
	public void beforeMethod() {
		System.out.println("@BeforeMethod");
	}

	@AfterMethod
	public void afterMethod() {
		System.out.println("@AfterMethod");
	}

	@Test(groups = "shopping")
	public void runTest1() {
		System.out.println("@Test - runTest1");
	}

	@Test
	public void runTest2() {
		System.out.println("@Test - runTest2");
	}
}