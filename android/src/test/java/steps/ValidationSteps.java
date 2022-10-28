package steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.DocumentPage;
import pages.MediaCenterPage;

/*
This class contains all the steps that are only validations
 */
public class ValidationSteps extends BaseSteps {

	@Then( "The document {string} is displayed with the title {string} on each page" )
	public void the_document_is_displayed_with_the_title_on_each_page ( String document, String documentTitle ) {
		instanceOf( DocumentPage.class ).validateDocumentLabel( document );
		instanceOf( DocumentPage.class ).validateEachPageView( documentTitle );
	}

	@Then( "The video starts playing" )
	public void the_video_starts_playing ( ) throws InterruptedException {
		instanceOf( MediaCenterPage.class ).validateVideoIsPlaying( );
	}

	@Then( "The video keeps playing" )
	public void the_video_keeps_playing ( ) throws InterruptedException {
		instanceOf( MediaCenterPage.class ).validateVideoIsPlaying( );
	}

	@When( "The video has finished playing" )
	public void the_video_has_finished_playing ( ) throws InterruptedException {
		instanceOf( MediaCenterPage.class ).validateVideoFinishedPlaying( );
	}

}
