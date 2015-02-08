package cl.isl.spm.jbpm.wih.handlers;

import java.util.HashMap;
import java.util.Map;

import cl.isl.spm.jbpm.wih.rest.RESTClient;
import cl.isl.spm.jbpm.wih.rest.RESTException;
import cl.isl.spm.jbpm.wih.util.JSONUtil;

public class DefaultRESTHandler implements RESTHandler {

	


	@Override
	public Map<String, Object> execute(String method, String uri,
			Map<String, Object> parameters) throws RESTException {

		if (parameters == null) {
			parameters = new HashMap<String, Object>();
		}
		RESTClient restClient = new RESTClient(method, uri,
				JSONUtil.convertMapToJSON(parameters));
		String resultado = null;

		resultado = restClient.executeService();

		if (restClient.getResponseCode() != 200) {
			System.err.println("Error ejecutando RESTWorkItemHandler " + uri);
			System.err.println("HTTP STATUS CODE: "
					+ restClient.getResponseCode());
			System.err.println("HTTP STATUS MESSAGE: " + resultado);
			throw new RESTException("Error " + restClient.getResponseCode()
					+ ": " + resultado);
		}
		
		Map<String, Object> results = JSONUtil.convertJsonToMap(resultado);
		return results;
		
	}

}
