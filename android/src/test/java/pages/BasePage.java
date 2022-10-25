package pages;

import drivers.AndroidAppDriver;
import extensions.UiAutomator2Extension;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.RemoteWebElement;

public class BasePage extends Page {

	protected final AndroidDriver driver = AndroidAppDriver.androidDriver;

	protected final String scrollTextMatch = "new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(new UiSelector().textMatches(\"(?i)";
	protected final String scrollDescriptionMatch = "new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(new UiSelector().descriptionMatches(\"(?i)";
	protected final String scrollDescriptionContains = "new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(new UiSelector().descriptionContains(\"";

	protected final String wrapper = "\"))";

	protected RemoteWebElement getElementByDescriptionMatchScroll ( String description ) {
		return UiAutomator2Extension.getElement( AppiumBy.androidUIAutomator( scrollDescriptionMatch + description + wrapper ) );
	}

	protected RemoteWebElement getElementByDescriptionContainsScroll ( String description ) {
		return UiAutomator2Extension.getElement( AppiumBy.androidUIAutomator( scrollDescriptionContains + description + wrapper ) );
	}

	protected void swipeUp ( RemoteWebElement element ) {
		UiAutomator2Extension.swipe( UiAutomator2Extension.DIRECTION.UP, element );
	}

}
