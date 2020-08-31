import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.JSONArray;
import org.json.JSONObject;

public class SendHTTPRequest {
	public static void main(String[] args) {
		try {
	        SendHTTPRequest.call_me();
		} catch (Exception e) {
	        e.printStackTrace();
		}
	}


	public static void call_me() throws Exception {
		String url = "http://localhost:8080/product";
	        URL obj = new URL(url);
	        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
	        // optional default is GET
	        con.setRequestMethod("GET");
	        //add request header
	        con.setRequestProperty("User-Agent", "Mozilla/5.0");
	        int responseCode = con.getResponseCode();
	        System.out.println("\nSending 'GET' request to URL : " + url);
	        System.out.println("Response Code : " + responseCode);
	        BufferedReader in = new BufferedReader(
	                new InputStreamReader(con.getInputStream()));
	        String inputLine;
	        
	        StringBuffer response = new StringBuffer();
	        while ((inputLine = in.readLine()) != null) {
	        	response.append(inputLine);
	        }
	        in.close();
	        
	        //print in String
	        System.out.println(response.toString());
	        
	        JSONArray jsonArray = new JSONArray(response.toString());
	        for(int i=0; i<jsonArray.length(); i++)
	        {
	        	System.out.println(jsonArray.get(i).toString());
	        }
	       
	        JSONObject jsonObject = new JSONObject(jsonArray.get(0).toString());
	        System.out.println(jsonObject.get("id"));
	        System.out.println(jsonObject.get("pname"));
	        System.out.println(jsonObject.get("batchno"));
	        System.out.println(jsonObject.get("price"));
	        System.out.println(jsonObject.get("noofproduct"));

	         
		    }
	}


