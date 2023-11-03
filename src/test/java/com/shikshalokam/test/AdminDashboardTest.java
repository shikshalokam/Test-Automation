package com.shikshalokam.test;

import org.testng.annotations.Test;
import java.util.Map;

import org.testng.annotations.Test;

import com.shikshalokam.annotation.Author;
import com.shikshalokam.pages.actions.AdminDashboardAction;
import com.shikshalokam.pages.actions.LoginPageAction;
import com.shikshalokam.pages.actions.ProgramDashboardAction;
import com.shikshalokam.utils.gSheet.TestData;
import com.shikshalokam.utils.prop.PropUtlis;

public class AdminDashboardTest {
		Map<String, String> loginTestData;
	    Map<String, String> observationPageTestData;
	    String appUrl;
	   
	    
	    public LoginPageAction getLoginPageActions() throws Exception {
	        return new LoginPageAction();
	    }
	    public ProgramDashboardAction getProgramDashboardActions() throws Exception {
	        return new ProgramDashboardAction();
	    }
	    
	    public AdminDashboardAction getAdminDashboardActions() throws Exception {
	        return new AdminDashboardAction();
	    }
	   
	    public String getEnvironmentValue() throws Exception {
	    	return appUrl = PropUtlis.readConfig("webAppConfig", "appUrl");
	    }
	    
	    public void switchEnvironment() throws Exception {
	    	if(getEnvironmentValue().contains("preprod") || getEnvironmentValue().contains("prod")) {
	        	getLoginPageActions().clickOnExploreDiksha();
	        }}

	    	
	    	  @Test(description = "login as Admin ")
	    	    @Author(name = "SHREEJITH")
	    	    public void adminDashboard() throws Exception {
	    	        loginTestData = TestData.getFullGoogleSheetDataAsMapString("LoginTestData!H:I");
	    	
	    	        switchEnvironment();
	    	        getLoginPageActions().BMCLSelection();
	    	        Thread.sleep(2000);
	    	        getLoginPageActions().clickOnGuest();
	    	        getLoginPageActions().clickOnLogin();
	    	        getLoginPageActions().enterUserName(loginTestData.get("userName"));
	    	        getLoginPageActions().enterPassword(loginTestData.get("password"));
	    	        getLoginPageActions().clickOnLoginButton();
	    	        
	    	        
	    	        Thread.sleep(10000);
	    	        getLoginPageActions().refreshpage();
	    	        Thread.sleep(5000); 
	    	       
	    	        
	    	        getLoginPageActions().clickOnGuest();
	    	        //getProgramDashboardActions().clickOnProfileIcon();
	    	   
	    	        getAdminDashboardActions().clickOnadmindashboard();
	    	        getAdminDashboardActions().verifyReportsandDatasetsTab();
	    	        getAdminDashboardActions().verifyGlobalSearchfilter();
	    	       
	    	        getAdminDashboardActions().searchAndSelectImprovementsProjectReport();
	    	        getAdminDashboardActions().verifySelectedReportInTableFormat();
	    	        getAdminDashboardActions().verifyLocalSearchfilter();
	    	        getAdminDashboardActions().searchAndSelectParameter();
	    	        Thread.sleep(10000);
	    	        getAdminDashboardActions().verifyGraphsTab();
	    	        getAdminDashboardActions().verifyImprovementProjectsStatusByDistrictTab();
	    	        getAdminDashboardActions().verifyImprovementProjectsStatusByBlockTab();
	    	        getAdminDashboardActions().selectProjectFilters();
	    	        getAdminDashboardActions().ExportAs();
	    	        getAdminDashboardActions().clickOnBackButton();
	    	        
	    	        getAdminDashboardActions().searchAndSelectObservationWithRubricsReport();
	    	        getAdminDashboardActions().verifySelectedReportInTableFormat();
	    	        getAdminDashboardActions().searchAndSelectParameter();
	    	        getAdminDashboardActions().verifyGraphsTab();
	    	        getAdminDashboardActions().verifyDistrictWiseObservationStatusAndEntitiesObservedTab();
	    	        getAdminDashboardActions().selectObservationFilters();
	    	        getAdminDashboardActions().ExportAs();
	    	        getAdminDashboardActions().clickOnBackButton();
	    	        
	    	        getAdminDashboardActions().searchAndSelectSurveyReport();
	    	        getAdminDashboardActions().verifySelectedReportInTableFormat();
	    	        getAdminDashboardActions().searchAndSelectParameter();
	    	        getAdminDashboardActions().verifyGraphsTab();
	    	        getAdminDashboardActions().selectObservationFilters();
	    	        getAdminDashboardActions().ExportAs();
	    	       
	    	        
	    	  }
	    	  
	    	  //---------------------------------------REG------------------------------------//
	    	  
	    	  @Test(description = "To verify clicking on Reset button all the previous selected values on the filter should get erased.")
	    	    @Author(name = "SHREEJITH")
	    	    public void resetFiltersButtonAD_REG() throws Exception {
	    	        loginTestData = TestData.getFullGoogleSheetDataAsMapString("LoginTestData!H:I");
	    	
	    	        switchEnvironment();
	    	        getLoginPageActions().BMCLSelection();
	    	        Thread.sleep(2000);
	    	        getLoginPageActions().clickOnGuest();
	    	        getLoginPageActions().clickOnLogin();
	    	        getLoginPageActions().enterUserName(loginTestData.get("userName"));
	    	        getLoginPageActions().enterPassword(loginTestData.get("password"));
	    	        getLoginPageActions().clickOnLoginButton();
	    	        
	    	        
	    	        Thread.sleep(10000);
	    	        getLoginPageActions().refreshpage();
	    	        Thread.sleep(5000); 
	    	       
	    	        
	    	        getLoginPageActions().clickOnGuest();
	    	        getAdminDashboardActions().clickOnadmindashboard();
	    	        getAdminDashboardActions().verifyGlobalSearchfilter();
	    	       
	    	        getAdminDashboardActions().searchAndSelectImprovementsProjectReport();
	    	        getAdminDashboardActions().verifyLocalSearchfilter();
	    	        getAdminDashboardActions().searchAndSelectParameter();
	    	        Thread.sleep(10000);
	    	        getAdminDashboardActions().selectProjectFilters();
	    	        getAdminDashboardActions().clickOnResetFiltersButton();
	    	        getAdminDashboardActions().verifySelectedFiltersAreRemoved();

	    	  }
	    	  
	    	  @Test(description = "To verify clicking on Page numbers users should be able to see the data on the selected page.")
	    	    @Author(name = "SHREEJITH")
	    	    public void paginationAD_REG() throws Exception {
	    	        loginTestData = TestData.getFullGoogleSheetDataAsMapString("LoginTestData!H:I");
	    	
	    	        switchEnvironment();
	    	        getLoginPageActions().BMCLSelection();
	    	        Thread.sleep(2000);
	    	        getLoginPageActions().clickOnGuest(); 
	    	        getLoginPageActions().clickOnLogin();
	    	        getLoginPageActions().enterUserName(loginTestData.get("userName"));
	    	        getLoginPageActions().enterPassword(loginTestData.get("password"));
	    	        getLoginPageActions().clickOnLoginButton();
	    	        
	    	        
	    	        Thread.sleep(10000);
	    	        getLoginPageActions().refreshpage();
	    	        Thread.sleep(5000); 
	    	       
	    	        
	    	        getLoginPageActions().clickOnGuest();
	    	        getAdminDashboardActions().clickOnadmindashboard();
	    	        getAdminDashboardActions().clickOnPage2();
	    	        getAdminDashboardActions().verifyNavigatedToPage2();
	    	       
	    	  }
	    	  
	    	  @Test(description = "Verify if district is not selected then user will not be able to select any block in the block filter"
	    	  		+ "  Verify If a user tries to select block level filter without selecting any district an error message will come up on the screen")
	    	    @Author(name = "SHREEJITH")
	    	    public void errorMessageToSelectDistrictFirstAD_REG() throws Exception {
	    	        loginTestData = TestData.getFullGoogleSheetDataAsMapString("LoginTestData!H:I");
	    	
	    	        switchEnvironment();
	    	        getLoginPageActions().BMCLSelection();
	    	        Thread.sleep(2000);
	    	        getLoginPageActions().clickOnGuest();
	    	        getLoginPageActions().clickOnLogin();
	    	        getLoginPageActions().enterUserName(loginTestData.get("userName"));
	    	        getLoginPageActions().enterPassword(loginTestData.get("password"));
	    	        getLoginPageActions().clickOnLoginButton();
	    	        
	    	        
	    	        Thread.sleep(10000);
	    	        getLoginPageActions().refreshpage();
	    	        Thread.sleep(5000); 
	    	       
	    	        
	    	        getLoginPageActions().clickOnGuest();
	    	        //getProgramDashboardActions().clickOnProfileIcon();
	    	   
	    	        getAdminDashboardActions().clickOnadmindashboard();
	    	       
	    	        getAdminDashboardActions().searchAndSelectImprovementsProjectReport();
	    	        getAdminDashboardActions().searchAndSelectParameter();
	    	        Thread.sleep(10000);
	    	        getAdminDashboardActions().clickOnBlockFilter();
	    	        getAdminDashboardActions().verifyErrorMessageToSelectDistrictFirst();
	    	        getAdminDashboardActions().clickOnBackButton();
	    	        
	    	        getAdminDashboardActions().searchAndSelectImprovementsConsumptionReport();
	    	        getAdminDashboardActions().searchAndSelectParameter();
	    	        Thread.sleep(10000);
	    	        getAdminDashboardActions().clickOnBlockFilter();
	    	        getAdminDashboardActions().verifyErrorMessageToSelectDistrictFirst();
	    	        getAdminDashboardActions().clickOnBackButton();
	    	        
	    	        
	    	        getAdminDashboardActions().searchAndSelectObservationReport();
	    	        getAdminDashboardActions().searchAndSelectParameter();
	    	        Thread.sleep(10000);
	    	        getAdminDashboardActions().clickOnBlockFilter();
	    	        getAdminDashboardActions().verifyErrorMessageToSelectDistrictFirst();
	    	        getAdminDashboardActions().clickOnBackButton();
	    	        
	    	        getAdminDashboardActions().searchAndSelectObservationWithRubricsReport();
	    	        getAdminDashboardActions().searchAndSelectParameter();
	    	        Thread.sleep(10000);
	    	        getAdminDashboardActions().clickOnBlockFilter();
	    	        getAdminDashboardActions().verifyErrorMessageToSelectDistrictFirst();
	    	        getAdminDashboardActions().clickOnBackButton();
	    	       
	    	        getAdminDashboardActions().searchAndSelectObservationConsumptionReport();
	    	        getAdminDashboardActions().searchAndSelectParameter();
	    	        Thread.sleep(10000);
	    	        getAdminDashboardActions().clickOnBlockFilter();
	    	        getAdminDashboardActions().verifyErrorMessageToSelectDistrictFirst();
	    	       
	    	      
	    	  }

}
