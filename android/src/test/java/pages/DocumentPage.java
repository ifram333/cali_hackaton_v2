package pages;

import io.appium.java_client.pagefactory.AndroidFindBy;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;
import net.sourceforge.tess4j.util.LoadLibs;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.remote.RemoteWebElement;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.testng.Assert.assertTrue;
import static org.testng.Assert.fail;

public class DocumentPage extends BasePage {

	private final Logger logger = LogManager.getLogger( );

	@AndroidFindBy( className = "android.widget.ImageView" )
	private RemoteWebElement documentImageView;

	public String getStringFromImageView ( ) {
		try {
			Tesseract tesseract = new Tesseract( );

			String ocrImagesFolder = Files.createDirectories( Paths.get( "target/ocrImages" ) ).toFile( ).getAbsolutePath( );
			File documentImage = documentImageView.getScreenshotAs( OutputType.FILE );
			File targetImage = new File( ocrImagesFolder + "/image.png" );

			FileUtils.copyFile( documentImage, targetImage );

			tesseract.setDatapath( LoadLibs.extractTessResources( "tessdata" ).getAbsolutePath( ) );
			return tesseract.doOCR( targetImage );
		} catch ( IOException e ) {
			fail( "There was an error taking screenshot of the document" );
		} catch ( TesseractException e ) {
			fail( "There was an error reading the document image" );
		}
		return null;
	}

	public void validateEachPageView ( String documentTitle ) {
		String pageOfRegex = "Page \\d+ of \\d+";

		do {
			String documentText = getStringFromImageView( );
			Pattern pagePattern = Pattern.compile( pageOfRegex, Pattern.CASE_INSENSITIVE );
			Matcher matcher = pagePattern.matcher( documentText );

			if ( documentText.contains( documentTitle ) ) {
				logger.info( "The document has the title " + documentTitle.toUpperCase( ) );
			} else {
				fail( "The document does not have the title " + documentTitle.toUpperCase( ) );
			}

			if ( matcher.find( ) ) {
				String pageFromTo = matcher.group( 0 );

				String[] fromTo = pageFromTo.replaceAll( "[^0-9of]", "" ).split( "of" );
				int from = Integer.parseInt( fromTo[ 0 ] );
				int to = Integer.parseInt( fromTo[ 1 ] );
				logger.info( "Page " + from + " of " + to + " is displayed" );

				if ( from == to ) {
					break;
				} else {
					swipeUp( documentImageView );
					logger.info( "Scroll to the next document page" );
				}
			} else {
				logger.info( "The document does not have a page counter section (Page X of Y)" );
				break;
			}
		} while ( true );
	}

	public void validateDocumentLabel ( String document ) {
		RemoteWebElement element = getElementByDescriptionContainsScroll( document );
		assertTrue( element.isDisplayed( ), "The '" + document.toUpperCase( ) + "' label is not displayed" );
		logger.info( "The '" + document.toUpperCase( ) + "' label is displayed" );
	}

}
