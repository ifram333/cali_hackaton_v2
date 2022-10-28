package pages;

import io.appium.java_client.pagefactory.AndroidFindBy;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebElement;

import static java.lang.Thread.sleep;
import static org.testng.Assert.assertTrue;
import static org.testng.Assert.fail;

public class MediaCenterPage extends BasePage {

	private final Logger logger = LogManager.getLogger( );
	private final String loaderIconImageView = "android.widget.ImageView";

	@AndroidFindBy( accessibility = "Media Center" )
	private RemoteWebElement mediaCenterLabel;

	@AndroidFindBy( xpath = "//android.widget.Button/parent::android.view.View" )
	private RemoteWebElement videoView;

	@AndroidFindBy( xpath = "//android.widget.ImageView[@content-desc=\"PlayBack Rate\"]/preceding-sibling::android.view.View[3]" )
	private RemoteWebElement timeInProgressLabel;

	@AndroidFindBy( xpath = "//android.widget.ImageView[@content-desc=\"PlayBack Rate\"]/preceding-sibling::android.view.View[4]" )
	private RemoteWebElement timeLeftLabel;

	@AndroidFindBy( xpath = "//android.widget.ImageView[@content-desc=\"PlayBack Rate\"]/preceding-sibling::android.view.View[5]" )
	private RemoteWebElement progressBar;

	@AndroidFindBy( xpath = "//android.widget.ImageView[@content-desc=\"PlayBack Rate\"]/preceding-sibling::android.view.View[4]" )
	private RemoteWebElement afterVideoFinishedPlayingProgressBar;

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

	public void validateVideoIsPlaying ( ) throws InterruptedException {
		DateTimeFormatter dateTimeFormatter = DateTimeFormat.forPattern( "mm:ss" );

		waitForElementToDisappear( By.className( loaderIconImageView ) );
		videoView.click( );
		DateTime timePlayed = dateTimeFormatter.parseLocalTime( timeInProgressLabel.getAttribute( "content-desc" ) ).toDateTimeToday( );

		sleep( 5000 );
		videoView.click( );
		DateTime timePlayed2 = dateTimeFormatter.parseLocalTime( timeInProgressLabel.getAttribute( "content-desc" ) ).toDateTimeToday( );

		if ( timePlayed.isBefore( timePlayed2 ) ) {
			logger.info( "The video is playing" );
		} else {
			fail( "the video is not playing" );
		}
	}

	public void validateVideoFinishedPlaying ( ) throws InterruptedException {
		DateTimeFormatter dateTimeFormatter = DateTimeFormat.forPattern( "mm:ss" );

		waitForElementToDisappear( By.className( loaderIconImageView ) );
		videoView.click( );

		DateTime timeLeft = dateTimeFormatter.parseLocalTime( timeLeftLabel.getAttribute( "content-desc" ).replaceAll( "[^\\d:\\d]", "" ) ).toDateTimeToday( );

		logger.info( "Wait " + timeLeft.toString( dateTimeFormatter ) + " minutes for the video to finish playing" );
		sleep( ( timeLeft.getSecondOfDay( ) + 1 ) * 1000L );
		logger.info( "The video has finished playing" );
	}

	public void swipeProgressBarRight ( ) {
		waitForElementToDisappear( By.className( loaderIconImageView ) );
		videoView.click( );
		swipeRight( progressBar );
		logger.info( "The video is fast forwarded" );
	}

	public void swipeProgressBarLeft ( ) {
		videoView.click( );
		swipeLeft( afterVideoFinishedPlayingProgressBar );
		logger.info( "The video is rewound" );
	}

}
