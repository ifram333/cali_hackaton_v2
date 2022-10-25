package pages;

import io.appium.java_client.pagefactory.AndroidFindBy;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebElement;

import static org.testng.Assert.assertTrue;

public class MediaCenterPage extends BasePage {

	private final Logger logger = LogManager.getLogger( );

	@AndroidFindBy( accessibility = "Media Center" )
	private RemoteWebElement mediaCenterLabel;

	public void clickVideoCategoryImageView ( String category ) {
		RemoteWebElement element = getElementByDescriptionContainsScroll( category );
		element.click( );
		logger.info( "Click on the '" + category.toUpperCase( ) + "' image view" );
	}

	public void clickVideoImageView ( String video ) {
		RemoteWebElement element = getElementByDescriptionContainsScroll( video );
		element.click( );
		logger.info( "Click on the '" + video.toUpperCase( ) + "' image view" );
	}

	public void clickPlayVideoView ( String video ) {
		RemoteWebElement element = ( RemoteWebElement ) driver.findElement( By.xpath( "//android.view.View[@content-desc=\"" + video + "\"]/preceding-sibling::android.view.View" ) );
		element.click( );
		logger.info( "Click on the '" + video.toUpperCase( ) + "' play button" );
	}

	public void validateMediaCenterLabel ( ) {
		assertTrue( mediaCenterLabel.isDisplayed( ), "The 'MEDIA CENTER' label is not displayed" );
		logger.info( "The 'MEDIA CENTER' label is displayed" );
	}

	public void validateVideoCategoryImageView ( String category ) {
		RemoteWebElement element = getElementByDescriptionContainsScroll( category );
		assertTrue( element.isDisplayed( ), "The '" + category.toUpperCase( ) + "' image view is not displayed" );
		logger.info( "The '" + category.toUpperCase( ) + "' image view is displayed" );
	}

	public void validateVideoCategoryLabel ( String category ) {
		RemoteWebElement element = getElementByDescriptionContainsScroll( category );
		assertTrue( element.isDisplayed( ), "The '" + category.toUpperCase( ) + "' label is not displayed" );
		logger.info( "The '" + category.toUpperCase( ) + "' label is displayed" );
	}

	public void validateVideoImageView ( String video ) {
		RemoteWebElement element = getElementByDescriptionContainsScroll( video );
		assertTrue( element.isDisplayed( ), "The '" + video.toUpperCase( ) + "' image view is not displayed" );
		logger.info( "The '" + video.toUpperCase( ) + "' image view is displayed" );
	}

	public void validateVideoLabel ( String video ) {
		RemoteWebElement element = getElementByDescriptionContainsScroll( video );
		assertTrue( element.isDisplayed( ), "The '" + video.toUpperCase( ) + "' label is not displayed" );
		logger.info( "The '" + video.toUpperCase( ) + "' label is displayed" );
	}

}
