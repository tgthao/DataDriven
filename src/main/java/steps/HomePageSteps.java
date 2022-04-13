package steps;

import net.thucydides.core.annotations.Screenshots;
import net.thucydides.core.annotations.Step;
import pages.HomePage;

public class HomePageSteps {
	
	
	
	HomePage home;
	
	@Step("Performing Login")
	@Screenshots(onlyOnFailures = false)
	public void doLogin(String username) {
		
		
		home.navigate();
		home.enterUsername(username);
		
	}
	
	
	@Step("Entering Password")
	public void doEnterPassword(String password) {
		
		
		
		home.clickNextBtn();
		home.enterPassword(password);
	}
	

}
