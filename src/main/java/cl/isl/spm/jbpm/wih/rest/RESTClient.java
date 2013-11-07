package cl.isl.spm.jbpm.wih.rest;

import java.net.URI;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import cl.isl.spm.jbpm.wih.handlers.RESTHandler;

public class RESTClient {
	
	public static final String METHOD_GET= "GET";
	public static final String METHOD_POST= "POST";
	
	private String path;
	
	private String method;
	
	private String body;
	
	private Integer responseCode;
	


	public RESTClient(String method, String path, String body) {
		super();
		this.path = path;
		this.method = method;
		this.body = body;
	}

	public RESTClient(String path, String body) {
		this(METHOD_POST, path, body);
	}
	
	public RESTClient(String path) {
		this(METHOD_GET, path, null);
	}




	public String executeService() throws RESTException{
		HttpClient httpClient = null;
		HttpRequestBase request = null;
		HttpResponse response = null;
		System.out.println("REST Client:"+method+" "+path);
		
		try {
			URI uri = new URI(path);
			if (method.toUpperCase().equals(METHOD_GET)) {
				request = new HttpGet(uri);
			}
			else {
				System.out.println(body);
				StringEntity entity = new StringEntity(body);
				entity.setContentType("application/json");
				HttpPost hp = new HttpPost(uri);
				hp.setEntity(entity);
				
				request = hp;
			}
			
			httpClient = new DefaultHttpClient();
			response = httpClient.execute(request);

			responseCode = response.getStatusLine().getStatusCode();
			if (responseCode!=200)
				return  response.getStatusLine().getReasonPhrase();
			 
			String ret = EntityUtils.toString(response.getEntity());
			System.out.println("REST Client RESULT:"+ret);
			return ret;
			
		} catch (Exception e) {
			throw new RESTException("Error al ejecutar RESClient", e);
		
		}finally {
			
			//request.
		}
		
	}

	@Override
	public String toString() {
		return "RESTClient [path=" + path + ", method=" + method
				 + "]";
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getMethod() {
		return method;
	}

	public void setMethod(String method) {
		this.method = method;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public Integer getResponseCode() {
		return responseCode;
	}
	
	
}
