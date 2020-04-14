package org.apache.cordova.logcat;
import java.io.File;
import java.io.IOException;
import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.json.JSONArray;
import org.json.JSONException;
import android.os.Environment;


public class LogCat extends CordovaPlugin {
	protected void pluginInitialize() {
	  }

	  public boolean execute(String action, JSONArray args, CallbackContext callbackContext) 
	      throws JSONException {
	    if (action.equals("sendLogs")) {
                        // save logcat in file
		    //System.out.println(Environment.getDataDirectory());
                File outputFile = new File(getExternalFilesDir(Environment.getDataDirectory().getAbsolutePath()).getAbsolutePath()+
                        "logcat.txt");
                try {
                    Runtime.getRuntime().exec(
                            "logcat -f " + outputFile.getAbsolutePath());
			//System.out.println(outputFile.getAbsolutePath());
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
             return true;
	    }
          else{        
	    return false;
	  }
      }
}
