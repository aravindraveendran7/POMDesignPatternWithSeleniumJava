package com.demo.tests;

import java.util.Map;

import org.assertj.core.api.Assertions;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.demo.dataprovider.ExtractDataFromExcel;
import com.demo.pages.LoginPage;
import com.demo.reports.ExtentReport;

//making the class final as this cannot be extended
public final class LoginPageTests extends BaseTest {

	private LoginPageTests() {
		//prohibits from creating object for this class
	}

	@Test(dataProvider= "getData",dataProviderClass=ExtractDataFromExcel.class)
	public void orangeHRMLoginLogoutTest(Map<String,String> map) {	
		String title=new LoginPage().enterUsername(map.get("Username")).enterPassword(map.get("Password")).clickLogin()
		.clickWelcome().logOut()
		.getLoginPageTitle();
		Assertions.assertThat(title)
		.isEqualTo("OrangeHRM");
	}
	
	

}
