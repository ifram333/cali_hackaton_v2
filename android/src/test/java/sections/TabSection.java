package sections;

import io.appium.java_client.pagefactory.AndroidFindBy;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.remote.RemoteWebElement;
import pages.BasePage;

public class TabSection extends BasePage {

	private final Logger logger = LogManager.getLogger( );

	@AndroidFindBy( accessibility = "HOME\n" +
			"Tab 1 of 3" )
	private RemoteWebElement homeTab;

	@AndroidFindBy( accessibility = "MY FILES\n" +
			"Tab 2 of 3" )
	private RemoteWebElement myFilesTab;

	@AndroidFindBy( accessibility = "MORE\n" +
			"Tab 3 of 3" )
	private RemoteWebElement moreTab;

	public void clickHomeTab ( ) {
		homeTab.click( );
		logger.info( "Click on the 'HOME' tab" );
	}

	public void clickMyFilesTab ( ) {
		myFilesTab.click( );
		logger.info( "Click on the 'MY FILES' tab" );
	}

	public void clickMoreTab ( ) {
		moreTab.click( );
		logger.info( "Click on the 'MORE' tab" );
	}

}
