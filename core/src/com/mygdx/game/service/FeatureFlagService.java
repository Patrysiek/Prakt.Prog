package com.mygdx.game.service;

import java.util.HashMap;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONObject;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Net.HttpMethods;
import com.badlogic.gdx.Net.HttpRequest;
import com.badlogic.gdx.Net.HttpResponse;
import com.badlogic.gdx.Net.HttpResponseListener;
import com.badlogic.gdx.net.HttpRequestBuilder;
import com.mygdx.game.IRequestCallback;

public class FeatureFlagService {

	
	public static final String REQUEST_URL = "http://patrysiek.pythonanywhere.com/tutorialClicker/api/v1.0/features";
	public static final String FEATURE_SHOP = "FEATURE_SHOP";
	
	

	private Map<String,Boolean> featureMap;
	
	public FeatureFlagService(){
		
		featureMap = new HashMap<String,Boolean>();
		
	}
	
	

	public void makeRequest(final IRequestCallback requestCallback) {
		
		HttpRequestBuilder requestBuilder = new HttpRequestBuilder(); 
		HttpRequest httpRequest = requestBuilder.newRequest().method(HttpMethods.GET).url(REQUEST_URL).build();
		Gdx.net.sendHttpRequest(httpRequest, new HttpResponseListener() {
			
			@Override
			public void handleHttpResponse(HttpResponse httpResponse) {

				
				
				parseResponse(httpResponse.getResultAsString());
				 requestCallback.onSucceed();
			}
			


			@Override
			public void failed(Throwable t) {
				requestCallback.onError();
				
			}
			
			@Override
			public void cancelled() {
				requestCallback.onError();
				
			}
		});
	}
	
	
	private void parseResponse(String resultAsString) {
		System.out.println(resultAsString);
		
	try {
		JSONObject obj = new JSONObject(resultAsString);
		JSONArray jsonArray = obj.getJSONArray("features");
		for(int i=0; i< jsonArray.length(); i++)
		{
			
			JSONObject innerObj = jsonArray.getJSONObject(i);
			featureMap.put((String)innerObj.get("name"),(Boolean)innerObj.get("active"));
			
		}
		System.out.println("testing parsed map");
		System.out.println("Map: "+ featureMap);
		
	} 
	catch (Exception e) {
		e.printStackTrace();
	}
		
		
	}
	
public boolean hasFeature(String s) {
		
	if(featureMap.containsKey(s))
		return featureMap.get(s);
	else
		return false;
	
	
}
	
	
}
