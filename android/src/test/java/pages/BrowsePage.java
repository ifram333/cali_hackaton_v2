package pages;

import io.appium.java_client.pagefactory.AndroidFindBy;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.remote.RemoteWebElement;

import static org.testng.Assert.assertTrue;

public class BrowsePage extends BasePage {

	private final Logger logger = LogManager.getLogger( );

	@AndroidFindBy( accessibility = "Browse your\n" +
			"docs and guidelines" )
	private RemoteWebElement browserYourDocsAndGuidelinesLabel;

	@AndroidFindBy( accessibility = "SEARCH DOCUMENTS" )
	private RemoteWebElement searchDocumentsInput;

	@AndroidFindBy( accessibility = "All Categories" )
	private RemoteWebElement allCategoriesLabel;

	@AndroidFindBy( uiAutomator = scrollTextMatch + "SEARCH DOCUMENTS" + wrapper )
	private RemoteWebElement searchDocumentsInput2;

	@AndroidFindBy( accessibility = "Try searching using a keyword or the name of a document.\n" +
			"Use &&/AND to find the documents where all the terms exist anywhere in the text. e.g. EPDM && TIS" )
	private RemoteWebElement trySearchingLabel;

	@AndroidFindBy( accessibility = "Suggested searches:" )
	private RemoteWebElement suggestedSearchesLabel;

	@AndroidFindBy( uiAutomator = scrollDescriptionMatch + "RESULTS.*" + wrapper )
	private RemoteWebElement resultsLabel;

	public void clickSearchDocumentsInput ( ) {
		searchDocumentsInput.click( );
		logger.info( "Click on the 'SEARCH DOCUMENTS' input" );
	}

	public void clickDocumentView ( String document ) {
		RemoteWebElement element = getElementByDescriptionContainsScroll( document );
		element.click( );
		logger.info( "Click on the '" + document.toUpperCase( ) + "' view" );
	}

	public void clickDocumentImageView ( String document ) {
		RemoteWebElement element = getElementByDescriptionContainsScroll( document );
		element.click( );
		logger.info( "Click on the '" + document.toUpperCase( ) + "' image view" );
	}

	public void fillSearchDocumentsInput2 ( String document ) {
		searchDocumentsInput2.click( );
		searchDocumentsInput2.clear( );
		searchDocumentsInput2.sendKeys( document );
		logger.info( "Fill the 'SEARCH DOCUMENTS' input" );
	}

	public void validateBrowserYourDocsAndGuidelinesLabel ( ) {
		assertTrue( browserYourDocsAndGuidelinesLabel.isDisplayed( ), "The 'BROWSE YOUR DOCS AND GUIDELINES' label is not displayed" );
		logger.info( "The 'BROWSE YOUR DOCS AND GUIDELINES' label is displayed" );
	}

	public void validateSearchDocumentsInput ( ) {
		assertTrue( searchDocumentsInput.isDisplayed( ), "The 'SEARCH DOCUMENTS' input is not displayed" );
		logger.info( "The 'SEARCH DOCUMENTS' input is displayed" );
	}

	public void validateSearchDocumentsInput2 ( ) {
		assertTrue( searchDocumentsInput2.isDisplayed( ), "The 'SEARCH DOCUMENTS' input is not displayed" );
		logger.info( "The 'SEARCH DOCUMENTS' input is displayed" );
	}

	public void validateAllCategoriesLabel ( ) {
		assertTrue( allCategoriesLabel.isDisplayed( ), "The 'ALL CATEGORIES' label is not displayed" );
		logger.info( "The 'ALL CATEGORIES' label is displayed" );
	}

	public void validateTrySearchingLabel ( ) {
		assertTrue( trySearchingLabel.isDisplayed( ), "The 'TRY SEARCHING USING A KEYWORD OR THE NAME OF A DOCUMENT.\n" +
				"USE &&/AND TO FIND THE DOCUMENTS WHERE ALL THE TERMS EXIST ANYWHERE IN THE TEXT. E.G. EPDM && TIS' label is not displayed" );
		logger.info( "The 'TRY SEARCHING USING A KEYWORD OR THE NAME OF A DOCUMENT.\n" +
				"USE &&/AND TO FIND THE DOCUMENTS WHERE ALL THE TERMS EXIST ANYWHERE IN THE TEXT. E.G. EPDM && TIS' label is displayed" );
	}

	public void validateSuggestedSearchesLabel ( ) {
		assertTrue( suggestedSearchesLabel.isDisplayed( ), "The 'SUGGESTED SEARCHES' label is not displayed" );
		logger.info( "The 'SUGGESTED SEARCHES' label is displayed" );
	}

	public void validateResultsLabel ( ) {
		assertTrue( resultsLabel.isDisplayed( ), "The 'RESULTS' label is not displayed" );
		logger.info( "The '" + resultsLabel.getAttribute( "content-desc" ).toUpperCase( ) + "' label is displayed" );
	}

}
