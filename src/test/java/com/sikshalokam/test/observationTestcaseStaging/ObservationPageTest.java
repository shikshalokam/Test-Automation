package com.sikshalokam.test.observationTestcaseStaging;

import java.util.Map;

import org.testng.annotations.Test;

import com.sikshalokam.annotation.Author;
import com.sikshalokam.pages.actions.LoginPageAction;
import com.sikshalokam.pages.actions.ObservationPageAction;
import com.sikshalokam.pages.actions.ReportPageAction;
import com.sikshalokam.utils.gSheet.TestData;
import com.sikshalokam.utils.prop.PropUtlis;

public class ObservationPageTest {
	Map<String, String> loginTestData;
    Map<String, String> observationPageTestData;
    String appUrl;
    public LoginPageAction getLoginPageActions() throws Exception {
        return new LoginPageAction();
    }
    
    public ObservationPageAction getObservationPageActions() throws Exception {
        return new ObservationPageAction();
    }
    
    public ReportPageAction getReportPageActions() throws Exception {
    	return new ReportPageAction();
    }
    
    @Test(description = "save and submit observation")
    @Author(name = "Manjunatha K")
    public void saveAndSubmitObservation() throws Exception {
        loginTestData = TestData.getFullGoogleSheetDataAsMapString("LoginTestData!A:B");
        observationPageTestData = TestData.getFullGoogleSheetDataAsMapString("Observation!A:B");
        //getLoginPageActions().clickOnExploreDiksha();
        appUrl = PropUtlis.readConfig("webAppConfig", "appUrl");
        if(appUrl.contentEquals("https://preprod.ntp.net.in/"))
        {
        	getLoginPageActions().clickOnExploreDiksha();
        }
        getLoginPageActions().BMCLSelection();
        getLoginPageActions().clickOnGuest();
        getLoginPageActions().clickOnLogin();
        getLoginPageActions().enterUserName(loginTestData.get("userName"));
        getLoginPageActions().enterPassword(loginTestData.get("password"));
        getLoginPageActions().clickOnLoginButton();
        getObservationPageActions().verifyObservationButton();
        getObservationPageActions().clickOnObservationButton();
        Thread.sleep(5000);
        getObservationPageActions().verifyObservationTitle();
        getObservationPageActions().clickOnObservationParentChild();
        getObservationPageActions().clickOnObserveAgainButton();
        getObservationPageActions().verifyObserveAgainPopupTitle();
        getObservationPageActions().clickOnObserveAgainYesConfirmation();
       // getObservationPageActions().clickOnObservation1();
        getObservationPageActions().clickOnStartButtonOnObservation();
        getObservationPageActions().verifyParent1QuestionTitle();
        getObservationPageActions().clickOnParent1QuestionFirstAnswer();
        getObservationPageActions().verifyParent1Child1QuestionTitle();
        getObservationPageActions().clickOnParent1Child1QuestionFirstAnswer();
        getObservationPageActions().verifyParent2QuestionTitle();
        getObservationPageActions().clickOnParent2QuestionSecondAnswer();
        getObservationPageActions().verifyParent2Child2QuestionTitle();
        getObservationPageActions().clickOnParent2Child2QuestionSecondAnswer();
        getObservationPageActions().verifyparent3QuestionTitle();
        getObservationPageActions().clickOnParent3QuestionFirstAnswer();
        getObservationPageActions().verifyParent3Child1QuestionTitle();
        getObservationPageActions().clickOnParent3Child1FirstAnswer();
        
        getObservationPageActions().clickOnSaveObservationForm();
        getObservationPageActions().clickOnSaveFormConirmationYes();
        getObservationPageActions().verifyFormSaveSuccessMsg(observationPageTestData.get("observationFormSaveSuccessMsg"));
        getObservationPageActions().clickOnContinueButtonOnSaveObservationForm();
        getObservationPageActions().clickOnSubmitButtonOnObservationSaveForm();
        getObservationPageActions().clickOnYesForSubmitFormConfirmation();
        getObservationPageActions().verifyFormSubmitSuccessMsg(observationPageTestData.get("observationFormSubmitSuccessMsg"));
        
        //for report tab
        //getObservationPageActions().clickOnOkButtonOnSubmitFormSuccess();
        //getLoginPageActions().clickOnProfileIcon();
        //getReportPageActions().clickOnMyReportsTab();
    }
}
