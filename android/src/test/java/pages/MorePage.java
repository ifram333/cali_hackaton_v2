package pages;

import io.appium.java_client.pagefactory.AndroidFindBy;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.remote.RemoteWebElement;

import static org.testng.Assert.assertTrue;

public class MorePage extends BasePage {

	private final Logger logger = LogManager.getLogger( );

	@AndroidFindBy( accessibility = "More menu" )
	private RemoteWebElement moreMenuLabel;

	@AndroidFindBy( accessibility = "Media Center" )
	private RemoteWebElement mediaCenterButton;

	public void clickMediaCenterButton ( ) {
		mediaCenterButton.click( );
		logger.info( "Click on the 'MEDIA CENTER' button" );
	}

	public void validateMoreMenuLabel ( ) {
		assertTrue( moreMenuLabel.isDisplayed( ), "The 'MORE MENU' label is not displayed" );
		logger.info( "The 'MORE MENU' label is displayed" );
	}

	public void validateMediaCenterButton ( ) {
		assertTrue( mediaCenterButton.isDisplayed( ), "The 'MEDIA CENTER' button is not displayed" );
		logger.info( "The 'MEDIA CENTER' button is displayed" );
	}

}
