package steps;

import io.cucumber.java.en.Then;
import pages.MediaCenterPage;

/*
This class contains all the steps that are only swipes
 */
public class SwipeSteps extends BaseSteps {

	@Then( "I fast forward the video" )
	public void i_fast_forward_the_video ( ) {
		instanceOf( MediaCenterPage.class ).swipeProgressBarRight( );
	}

	@Then( "I rewind the video" )
	public void i_rewind_the_video ( ) {
		instanceOf( MediaCenterPage.class ).swipeProgressBarLeft( );
	}

}
