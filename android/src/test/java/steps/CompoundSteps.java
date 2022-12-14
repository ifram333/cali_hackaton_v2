package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import pages.BrowsePage;
import pages.MediaCenterPage;
import pages.MorePage;
import pages.WelcomePage;
import sections.TabSection;

/*
This class contains all the steps that are made up of different actions
 */
public class CompoundSteps extends BaseSteps {

	@Given( "I am a user located in {string} - {string} with profile {string}" )
	public void i_am_a_user_located_in_with_profile ( String region, String location, String profile ) {
		instanceOf( WelcomePage.class ).validateWelcomeToElevateLabel( );
		instanceOf( WelcomePage.class ).validateElevateDescriptionLabel( );
		instanceOf( WelcomePage.class ).clickNextButton( );
		instanceOf( WelcomePage.class ).validateChooseARegionLabel( );
		instanceOf( WelcomePage.class ).validateChooseDescriptionLabel( );
		instanceOf( WelcomePage.class ).validateSelectRegionButtonNoClickable( );
		instanceOf( WelcomePage.class ).clickRegionRadioButton( region );
		instanceOf( WelcomePage.class ).validateSelectLocationLabel( );
		instanceOf( WelcomePage.class ).validateSelectRegionButtonNoClickable( );
		instanceOf( WelcomePage.class ).clickLocationRadioButton( location );
		instanceOf( WelcomePage.class ).validateSelectRegionButtonClickable( );
		instanceOf( WelcomePage.class ).clickSelectRegionButton( );
		instanceOf( WelcomePage.class ).validateTellUsWhoYouAreLabel( );
		instanceOf( WelcomePage.class ).validateWeWantToKnowYouBetterLabel( );
		instanceOf( WelcomePage.class ).validateSelectAProfileButtonNoClickable( );
		instanceOf( WelcomePage.class ).clickProfileRadioButton( profile );
		instanceOf( WelcomePage.class ).validateStartUsingTheAppButton( );
		instanceOf( WelcomePage.class ).validateStartUsingTheAppButtonClickable( );
		instanceOf( WelcomePage.class ).clickStartUsingTheAppButton( );
		instanceOf( WelcomePage.class ).validateBottomSheet( );
		instanceOf( WelcomePage.class ).swipeDownBottomSheet( );
	}

	@When( "I search for the document {string} using the search document input and open it" )
	public void i_search_for_the_document_using_the_search_document_input_and_open_it ( String document ) {
		instanceOf( BrowsePage.class ).validateBrowserYourDocsAndGuidelinesLabel( );
		instanceOf( BrowsePage.class ).validateSearchDocumentsInput( );
		instanceOf( BrowsePage.class ).validateAllCategoriesLabel( );
		instanceOf( BrowsePage.class ).clickSearchDocumentsInput( );
		instanceOf( BrowsePage.class ).validateSearchDocumentsInput2( );
		instanceOf( BrowsePage.class ).validateTrySearchingLabel( );
		instanceOf( BrowsePage.class ).fillSearchDocumentsInput2( document );
		instanceOf( BrowsePage.class ).validateSuggestedSearchesLabel( );
		instanceOf( BrowsePage.class ).clickDocumentView( document );
		instanceOf( BrowsePage.class ).validateResultsLabel( );
		instanceOf( BrowsePage.class ).clickDocumentImageView( document );
	}

	@When( "I open the document {string} that is in the path {string} > {string} > {string}" )
	public void i_open_the_document_that_is_in_the_path ( String document, String category, String subcategory, String segment ) {
		instanceOf( BrowsePage.class ).validateBrowserYourDocsAndGuidelinesLabel( );
		instanceOf( BrowsePage.class ).validateSearchDocumentsInput( );
		instanceOf( BrowsePage.class ).validateAllCategoriesLabel( );
		instanceOf( BrowsePage.class ).clickCategoryView( category );
		instanceOf( BrowsePage.class ).validateCategoryLabel( category );
		instanceOf( BrowsePage.class ).clickSubcategoryView( subcategory );
		instanceOf( BrowsePage.class ).validateSubcategoryLabel( subcategory );
		instanceOf( BrowsePage.class ).validateAddToQuickLinksLabel( );
		instanceOf( BrowsePage.class ).clickSegmentView( segment );
		instanceOf( BrowsePage.class ).validateSegmentLabel( segment );
		instanceOf( BrowsePage.class ).validateAddToQuickLinksLabel( );
		instanceOf( BrowsePage.class ).clickDocumentImageView( document );
	}

	@When( "I open the video {string} that is located in the category {string}" )
	public void i_open_the_video_category_and_open_the_video ( String videoName, String category ) {
		instanceOf( TabSection.class ).clickMoreTab( );
		instanceOf( MorePage.class ).validateMoreMenuLabel( );
		instanceOf( MorePage.class ).validateMediaCenterButton( );
		instanceOf( MorePage.class ).clickMediaCenterButton( );
		instanceOf( MediaCenterPage.class ).validateMediaCenterLabel( );
		instanceOf( MediaCenterPage.class ).validateVideoCategoryImageView( category );
		instanceOf( MediaCenterPage.class ).clickVideoCategoryImageView( category );
		instanceOf( MediaCenterPage.class ).validateVideoCategoryLabel( category );
		instanceOf( MediaCenterPage.class ).validateVideoImageView( videoName );
		instanceOf( MediaCenterPage.class ).clickVideoImageView( videoName );
		instanceOf( MediaCenterPage.class ).validateVideoLabel( videoName );
		instanceOf( MediaCenterPage.class ).clickPlayVideoView( videoName );
	}

}
