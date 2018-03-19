package pe.com.bvlTest;

import java.util.LinkedHashMap;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.api.json.JSONConfiguration;

public class ClientRest {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		
		final String URI = "http://localhost:8080/SpringRestSecurityOauth/oauth/token?";
		
		// TODO Auto-generated method stub
		ClientConfig clientConfig = new DefaultClientConfig();
		clientConfig.getFeatures().put(JSONConfiguration.FEATURE_POJO_MAPPING, Boolean.TRUE);
		Client client = Client.create(clientConfig);
		Object o;
		WebResource webResource = client.resource(""
				+ "http://localhost:8080/SpringRestSecurityOauth/oauth/token?grant_type=password&client_id=restapp&client_secret=restapp&username=beingjavaguys&password=spring@java");
//		ClientResponse response = webResource.type("application/json").post(ClientResponse.class);
		ClientResponse response = webResource.type("application/json").get(ClientResponse.class);
		o = response.getEntity(Object.class);
		LinkedHashMap< String, String> lHashMap = new LinkedHashMap<>();
		lHashMap = (LinkedHashMap<String, String>) o;
		System.out.println("access token:  "+lHashMap.get("access_token"));
		System.out.println("toke type:  "+lHashMap.get("token_type"));
		System.out.println("refres token:  "+lHashMap.get("refresh_token"));		
//		System.out.println("expires in: "+lHashMap.get("expires_in"));
		System.out.println("aca termina todo");
//		System.out.println("hola response "+response);
	}

}
