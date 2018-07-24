package nytimes.siddarth.com.nytimes.utils;

import org.json.JSONException;
import org.json.JSONObject;

public class ErrorUtils {


    private ErrorUtils(){

    }

    public static String parseBaseError(String response){

        String errorMsg = null;

        try {
            JSONObject jsonObject = new JSONObject(response);
            errorMsg = jsonObject.getString("message");
        }catch (JSONException e){
            e.printStackTrace();
        }

        return errorMsg;
    }
}

