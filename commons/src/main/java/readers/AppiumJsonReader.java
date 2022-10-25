package readers;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class AppiumJsonReader {

	private static final Object lock = new Object( );
	private static final List< HashMap< String, Object > > servers = new ArrayList<>( );
	private static volatile AppiumJsonReader instance;
	private static HashMap< String, Object > configs = new HashMap<>( );
	private static HashMap< String, Object > apps = new HashMap<>( );
	private static HashMap< String, Object > capabilities = new HashMap<>( );

	public static void getInstance ( ) {
		if ( instance == null ) {
			synchronized ( lock ) {
				if ( instance == null ) {
					instance = new AppiumJsonReader( );
					instance.loadAppiumJson( );
				}
			}
		}
	}

	public static String getAndroidSDKPath ( ) {
		return configs.get( "android" ).toString( );
	}

	public static String getJavaHomePath ( ) {
		return configs.get( "java" ).toString( );
	}

	public static String getNodePath ( ) {
		return configs.get( "node" ).toString( );
	}

	public static String getExecutablePath ( ) {
		return configs.get( "executable" ).toString( );
	}

	public static String getLogPath ( ) {
		return configs.get( "log" ).toString( );
	}

	public static String getIP ( int index ) {
		return servers.get( index ).get( "ip" ).toString( );
	}

	public static int getPort ( int index ) {
		return ( ( int ) servers.get( index ).get( "port" ) );
	}

	public static String getDevice ( int index ) {
		return servers.get( index ).get( "device" ).toString( );
	}

	public static String getApp ( int index ) {
		return servers.get( index ).get( "app" ).toString( );
	}

	public static String getAppName ( String app ) {
		return apps.get( app ).toString( );
	}

	public static HashMap< String, String > capabilities ( String device ) {
		return ( HashMap< String, String > ) capabilities.get( device );
	}

	private void loadAppiumJson ( ) {
		String jsonString = new BufferedReader( new InputStreamReader( Objects.requireNonNull( this.getClass( ).getClassLoader( ).getResourceAsStream( "appium.json" ) ), StandardCharsets.UTF_8 ) ).lines( ).collect( Collectors.joining( "\n" ) );
		JSONObject appiumJson = new JSONObject( jsonString );

		configs = ( HashMap< String, Object > ) appiumJson.getJSONObject( "configs" ).getJSONObject( System.getProperty( "config" ) ).toMap( );
		apps = ( HashMap< String, Object > ) appiumJson.getJSONObject( "apps" ).toMap( );

		JSONArray serversArray = appiumJson.getJSONArray( "servers" );
		for ( int i = 0; i < serversArray.length( ); i++ ) {
			servers.add( ( HashMap< String, Object > ) serversArray.getJSONObject( i ).toMap( ) );
		}

		capabilities = ( HashMap< String, Object > ) appiumJson.getJSONObject( "capabilities" ).toMap( );
	}

}
