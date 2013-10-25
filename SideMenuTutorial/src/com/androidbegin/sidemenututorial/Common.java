package com.androidbegin.sidemenututorial;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.util.Log;

public class Common{
	static ArrayList<Users> users;

	public static ArrayList<Users> parseJSON(String result) 
	{
	    ArrayList<Users> users = new ArrayList<Users>();
	    try 
	    {   
	        JSONArray jArray = new JSONArray(result);
	        for (int i = 0; i < jArray.length(); i++) 
	        {
	            JSONObject json_data = jArray.getJSONObject(i);
	            Users user = new Users();
	            user.setId(json_data.getInt("id"));
	            user.setRestaurant(json_data.getString("restaurant"));
	            user.setUsername(json_data.getString("username"));
	            user.setCountry(json_data.getString("country"));
	            user.setCity(json_data.getString("city"));
	            user.setWebsite(json_data.getString("website"));
	            user.setResumee(json_data.getString("resumee"));
	            users.add(user);
	        }
	    } 
	    catch (JSONException e) 
	    {
	        Log.e("log_tag", "Error parsing data " + e.toString());  
	    }
	    return users; 
	}
}