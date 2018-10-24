package com.zephyr.stepdefinition;

import org.testng.asserts.SoftAssert;

import com.zephyr.common.LaunchBrowser;
import com.zephyr.generic.Excel_Lib;
import com.zephyr.generic.Property_Lib;
import com.zephyr.reusablemethods.BasePage;
import com.zephyr.reusablemethods.ImportPage;
import com.zephyr.reusablemethods.LoginPage;
import com.zephyr.reusablemethods.ProjectPage;
import com.zephyr.reusablemethods.ReleasePage;
import com.zephyr.reusablemethods.TestRepositoryPage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


public class Import_Create_Map_MinFields_802965 extends LaunchBrowser
{
	LaunchBrowser lb;
	LoginPage lp;
	ProjectPage pp;
	BasePage bp;
	ReleasePage rp;
	TestRepositoryPage tr;
	ImportPage ip;
	String fileName="Import_Create_Map_MinFields_802965";
	
	boolean[] actual=new boolean[5];
	  SoftAssert soft=new SoftAssert();
	@Given("^User is present in TestRepository$")
	public void user_is_present_in_TestRepository() throws Throwable 
	{
		try
		{
//		lb=new LaunchBrowser();
//		   lb.preCond();
//		   lp=new LoginPage(driver);
//		   String Uname=Excel_Lib.getData(INPUT_PATH,"Login",2,0);
//		   String Pass=Excel_Lib.getData(INPUT_PATH,"Login",2,1);
//		   lp.enterUname(Uname);
//		   lp.enterPass(Pass);
//		   lp.clickOnLogin();
		pp=new ProjectPage(driver);
		String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE,"Normal_Project_1");
		actual[0]= pp.selectProject(projectName);
		   String releaseName=Excel_Lib.getData(INPUT_PATH,"Releases",1,0);
		   actual[1]= pp.selectRelease(releaseName);
		   rp= new ReleasePage(driver);
		   rp.clickOnTestRep(); 
		}
		catch(Exception e)
		{
			lb=new LaunchBrowser();
			lb.getScreenShot(fileName);	
			driver.close();
			Relogin rl=new Relogin();
			rl.reLogin();
			throw e;
		}
	}

	@When("^User Navigates to the ReleaseName$")
	public void user_Navigates_to_the_ReleaseName() throws Throwable 
	{
		try
		{
		 tr=new TestRepositoryPage(driver);
		 String releaseName=Excel_Lib.getData(INPUT_PATH,"Releases",1,0);
		 actual[2]=tr.doubleClickOnRelease(releaseName);
		}
		catch(Exception e)
		{
			lb=new LaunchBrowser();
			lb.getScreenShot(fileName);	
			driver.close();
			Relogin rl=new Relogin();
			rl.reLogin();
			throw e;
		}
	}

	@When("^User Cliks on Import$")
	public void user_Cliks_on_Import() throws Throwable 
	{
		try
		{
		 ip= new ImportPage(driver);
		 bp=new BasePage();
		 actual[3]=ip.clickOnImport();
		   bp.waitForElement();
		}
		catch(Exception e)
		{
			lb=new LaunchBrowser();
			lb.getScreenShot(fileName);	
			driver.close();
			Relogin rl=new Relogin();
			rl.reLogin();
			throw e;
		}
	}

	@When("^User Performs the Create Map Operations$")
	public void user_Performs_the_Create_Map_Operations() throws Throwable 
	{
		try
		{
		bp=new BasePage();
		String mapname=Excel_Lib.getData(INPUT_PATH, "Create_Map", 1, 0);
		int rownum=Excel_Lib.getNumberData(INPUT_PATH, "Create_Map", 1, 1);
		String descrimi=Excel_Lib.getData(INPUT_PATH, "Create_Map", 2, 2);
		String desc=Excel_Lib.getData(INPUT_PATH, "Create_Map", 1, 3);
		String name=Excel_Lib.getData(INPUT_PATH, "Create_Map", 1, 4);
		String testSteps=Excel_Lib.getData(INPUT_PATH, "Create_Map", 1, 5);
		String expResults=Excel_Lib.getData(INPUT_PATH, "Create_Map", 1, 6);
		String extrID=Excel_Lib.getData(INPUT_PATH, "Create_Map", 1, 7);
		ImportPage ip= new ImportPage(driver);
		actual[4]=ip.createMap(mapname, rownum, descrimi, desc, name, testSteps, expResults, extrID);
	    bp.waitForElement();
	    ip.closeInstruction.click();
	    bp.waitForElement();
		}
		catch(Exception e)
		{
			lb=new LaunchBrowser();
			lb.getScreenShot(fileName);	
			driver.close();
			Relogin rl=new Relogin();
			rl.reLogin();
			throw e;
		}
	}

	@Then("^Map should be Created Successfully$")
	public void map_should_be_Created_Successfully() throws Throwable 
	{
		try
		{
			for(int k=0;k<=actual.length-1;k++)
		       {
		        soft.assertEquals(actual[k], true);
		       }
		       soft.assertAll();
		 log.info("Pass - Map should be created Successfully");
		}
		catch(Exception e)
		{
			lb=new LaunchBrowser();
			lb.getScreenShot(fileName);	
			driver.close();
			Relogin rl=new Relogin();
			rl.reLogin();
			throw e;
		}
	}

}
