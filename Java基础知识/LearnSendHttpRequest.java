
import java.net.*;
import java.io.*;

public class LearnSendHttpRequest {
	public static void main(String[] args) {
		LearnSendHttpRequest MyHttp = new LearnSendHttpRequest();
		MyHttp.sendRequest("http://59.77.15.17:4999/version?type=info&name=Hive&VerNu=1.0", "GET", "23323");
	}

	//
	public void sendRequest(String targetURL, String method, String urlParameters) {
		HttpURLConnection connection = null;
		try {
			long startTime = System.nanoTime();

			
			URL url = new URL(targetURL);
			connection = (HttpURLConnection) url.openConnection();
			connection.setRequestMethod(method);
			
			System.out.println("using proxy? "+connection.usingProxy());
			System.out.println("connect time out: "+connection.getConnectTimeout());
			System.out.println("read time out: "+connection.getReadTimeout());
			
/*			connection.setRequestProperty("Content-Type","application/x-www-form-urlencoded");
			connection.setRequestProperty("Content-Length",Integer.toString(urlParameters.getBytes().length));
			connection.setRequestProperty("Content-Language", "en-US");
			
			connection.setDoOutput(true);*/
			connection.setUseCaches(false); 
			
			
			int responseCode = connection.getResponseCode();
			if (responseCode == 200) {
				InputStream is = connection.getInputStream();
				byte[] buffer = new byte[1024];
				while (is.read(buffer) != -1) {
					System.out.println(new String(buffer, "utf-8"));
				}
				is.close();
			} else {
				System.out.println("server return:" + responseCode);
			}
			
			
			long endTime = System.nanoTime();
			long duration = (endTime - startTime) / 1000000;
			System.out.println("spend " + duration + " ms");

			connection.clo
			
/*			DataOutputStream wr = new DataOutputStream(connection.getOutputStream());
			wr.writeBytes(urlParameters);
			wr.close();
			//Get Response 
			InputStream is = connection.getInputStream();
			BufferedReader rd = new BufferedReader(new
			InputStreamReader(is)); StringBuilder response = new
			StringBuilder(); // or StringBuffer if Java version 5+ String
			line; while ((line = rd.readLine()) != null) {
			response.append(line); response.append('\r'); } rd.close();
			System.out.println("response:"+response.toString());*/
			 

		} catch (Exception e) {
			System.out.println("Exception:" + e);
		} finally{
			if(connection != null){
				connection.disconnect();
			}
		}

	}
}