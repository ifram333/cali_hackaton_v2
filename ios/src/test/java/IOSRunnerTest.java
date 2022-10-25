import appium.AppiumServer;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

@CucumberOptions(
		features = "src/test/resources/features",
		glue = { "hooks", "steps" },
		plugin = {
				"pretty",
				"io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm",
				"rerun:target/rerun.txt"
		} )
public class IOSRunnerTest extends AbstractTestNGCucumberTests {

	@BeforeClass
	public void setUpAppium ( ) {
		/*
		Get the server index sent in the maven run command.
		 */
		int serverIndex = Integer.parseInt( System.getProperty( "server" ) );
		/*
		Start APPIUM Server.
		 */
		AppiumServer.start( serverIndex );
	}

	@AfterClass
	public void tearDownAppium ( ) {
		/*
		Stop APPIUM Server
		 */
		if ( AppiumServer.isRunning( ) ) AppiumServer.stop( );
	}
}
