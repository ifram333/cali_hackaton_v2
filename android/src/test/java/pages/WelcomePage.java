package pages;

import extensions.UiAutomator2Extension;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.remote.RemoteWebElement;

import static org.testng.Assert.assertTrue;

public class WelcomePage extends BasePage {

	private final Logger logger = LogManager.getLogger( );

	@AndroidFindBy( accessibility = "Welcome to Elevate" )
	private RemoteWebElement welcomeToElevateLabel;

	@AndroidFindBy( accessibility = "With the Elevate Technical App, you have quick access to technical documents you need, whenever and wherever you are." )
	private RemoteWebElement elevateDescriptionLabel;

	@AndroidFindBy( accessibility = "NEXT" )
	private RemoteWebElement nextButton;

	@AndroidFindBy( accessibility = "Choose a Region" )
	private RemoteWebElement chooseARegionLabel;

	@AndroidFindBy( accessibility = "Choose a region to access the technical docs you are looking for." )
	private RemoteWebElement chooseDescriptionLabel;

	@AndroidFindBy( accessibility = "Select Location" )
	private RemoteWebElement selectLocationLabel;

	@AndroidFindBy( accessibility = "SELECT REGION" )
	private RemoteWebElement selectRegionButton;

	@AndroidFindBy( accessibility = "Tell us who you are" )
	private RemoteWebElement tellUsWhoYouAreLabel;

	@AndroidFindBy( accessibility = "We want to know you better, please select the option that matches your profile." )
	private RemoteWebElement weWantToKnowYouBetterLabel;

	@AndroidFindBy( accessibility = "SELECT A PROFILE" )
	private RemoteWebElement selectAProfileButton;

	@AndroidFindBy( accessibility = "START USING THE APP" )
	private RemoteWebElement startUsingTheAppButton;

	@AndroidFindBy( accessibility = "FEATURE!\n" +
			"Change Settings\n" +
			"You can change your region by going to the MORE menu and choosing the option that suits your needs.\n" +
			"FEATURE!\n" +
			"My Files\n" +
			"You can add documents and review them in the My Files section.\n" +
			"FEATURE!\n" +
			"More menu\n" +
			"Here you can find some useful content such as Find a Contractor/Sales Rep.\n" +
			"FEATURE!\n" +
			"Log In\n" +
			"Log in and discover more features related to your role." )
	private RemoteWebElement bottomSheet;

	public void clickNextButton ( ) {
		nextButton.click( );
		logger.info( "Click on the 'NEXT' button" );
	}

	public void clickRegionRadioButton ( String region ) {
		RemoteWebElement element = getElementByDescriptionMatchScroll( region );
		element.click( );
		logger.info( "Click on the '" + region.toUpperCase( ) + "' radio button" );
	}

	public void clickLocationRadioButton ( String location ) {
		RemoteWebElement element = getElementByDescriptionMatchScroll( location );
		element.click( );
		logger.info( "Click on the '" + location.toUpperCase( ) + "' radio button" );
	}

	public void clickSelectRegionButton ( ) {
		selectRegionButton.click( );
		logger.info( "Click on the 'SELECT REGION' button" );
	}

	public void clickProfileRadioButton ( String profile ) {
		RemoteWebElement element = getElementByDescriptionMatchScroll( profile );
		element.click( );
		logger.info( "Click on the '" + profile.toUpperCase( ) + "' radio button" );
	}

	public void clickStartUsingTheAppButton ( ) {
		startUsingTheAppButton.click( );
		logger.info( "Click on the 'START USING THE APP' button" );
	}

	public void swipeDownBottomSheet ( ) {
		UiAutomator2Extension.swipe( UiAutomator2Extension.DIRECTION.DOWN, bottomSheet );
		logger.info( "Swipe down the 'FEATURES' bottom sheet" );
	}

	public void validateWelcomeToElevateLabel ( ) {
		assertTrue( welcomeToElevateLabel.isDisplayed( ), "The 'WELCOME TO ELEVATE' label is not displayed" );
		logger.info( "The 'WELCOME TO ELEVATE' label is displayed" );
	}

	public void validateElevateDescriptionLabel ( ) {
		assertTrue( elevateDescriptionLabel.isDisplayed( ), "The 'WITH THE ELEVATE TECHNICAL APP, YOU HAVE QUICK ACCESS TO TECHNICAL DOCUMENTS YOU NEED, WHENEVER AND WHEREVER YOU ARE.' label is not displayed" );
		logger.info( "The 'WITH THE ELEVATE TECHNICAL APP, YOU HAVE QUICK ACCESS TO TECHNICAL DOCUMENTS YOU NEED, WHENEVER AND WHEREVER YOU ARE.' is displayed" );
	}

	public void validateChooseARegionLabel ( ) {
		assertTrue( chooseARegionLabel.isDisplayed( ), "The 'CHOOSE A REGION' label is not displayed" );
		logger.info( "The 'CHOOSE A REGION' label is displayed" );
	}

	public void validateChooseDescriptionLabel ( ) {
		assertTrue( chooseDescriptionLabel.isDisplayed( ), "The 'CHOOSE A REGION TO ACCESS THE TECHNICAL DOCS YOU ARE LOOKING FOR.' label is not displayed" );
		logger.info( "The 'CHOOSE A REGION TO ACCESS THE TECHNICAL DOCS YOU ARE LOOKING FOR.' label is displayed" );
	}

	public void validateSelectLocationLabel ( ) {
		assertTrue( selectLocationLabel.isDisplayed( ), "The 'SELECT LOCATION' label is not displayed" );
		logger.info( "The 'SELECT LOCATION' label is displayed" );
	}

	public void validateSelectRegionButtonNoClickable ( ) {
		assertTrue( "false".equalsIgnoreCase( selectRegionButton.getAttribute( "clickable" ) ), "The 'SELECT REGION' button is clickable" );
		logger.info( "The 'SELECT REGION' button is not clickable" );
	}

	public void validateSelectRegionButtonClickable ( ) {
		assertTrue( "true".equalsIgnoreCase( selectRegionButton.getAttribute( "clickable" ) ), "The 'SELECT REGION' button is not clickable" );
		logger.info( "The 'SELECT REGION' button is clickable" );
	}

	public void validateTellUsWhoYouAreLabel ( ) {
		assertTrue( tellUsWhoYouAreLabel.isDisplayed( ), "The 'TELL US WHO YOU ARE' label is not displayed" );
		logger.info( "The 'TELL US WHO YOU ARE' label is displayed" );
	}

	public void validateWeWantToKnowYouBetterLabel ( ) {
		assertTrue( weWantToKnowYouBetterLabel.isDisplayed( ), "The 'WE WANT TO KNOW YOU BETTER, PLEASE SELECT THE OPTION THAT MATCHES YOUR PROFILE.' label is not displayed" );
		logger.info( "The 'WE WANT TO KNOW YOU BETTER, PLEASE SELECT THE OPTION THAT MATCHES YOUR PROFILE.' label is displayed" );
	}

	public void validateSelectAProfileButtonNoClickable ( ) {
		assertTrue( "false".equalsIgnoreCase( selectAProfileButton.getAttribute( "clickable" ) ), "The 'SELECT REGION' button is clickable" );
		logger.info( "The 'SELECT REGION' button is not clickable" );
	}

	public void validateStartUsingTheAppButton ( ) {
		assertTrue( startUsingTheAppButton.isDisplayed( ), "The 'START USING THE APP' button is not displayed" );
		logger.info( "The 'START USING THE APP' button is displayed" );
	}

	public void validateStartUsingTheAppButtonClickable ( ) {
		assertTrue( "true".equalsIgnoreCase( startUsingTheAppButton.getAttribute( "clickable" ) ), "The 'START USING THE APP' button is not clickable" );
		logger.info( "The 'START USING THE APP' button is clickable" );
	}

	public void validateBottomSheet ( ) {
		assertTrue( bottomSheet.isDisplayed( ), "The 'FEATURE' bottom sheet is not displayed" );
		logger.info( "The 'FEATURE' bottom sheet is displayed" );
	}

}
