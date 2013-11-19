package cl.isl.spm.jbpm.wih.handlers.dummy;

import java.util.HashMap;
import java.util.Map;

import org.apache.http.entity.StringEntity;

import cl.isl.spm.jbpm.wih.handlers.RESTHandler;
import cl.isl.spm.jbpm.wih.rest.RESTClient;
import cl.isl.spm.jbpm.wih.rest.RESTException;
import cl.isl.spm.jbpm.wih.util.JSONUtil;

public class FacturacionR07HandlerDummy implements RESTHandler {

	@Override
	public Map<String, Object> execute(String method, String uri,
			Map<String, Object> parameters) throws RESTException {

		String body = JSONUtil.convertMapToJSON(parameters);

		System.out.println("REST Client:" + method + " " + uri);
		System.out.println(body);

		Integer cid = new Integer((String) parameters.get("fid"));
		Map<String, Object> ret = new HashMap<String, Object>();
		
		ret.put("sucess",true);
		String res = JSONUtil.convertMapToJSON(ret);
		System.out.println("REST Client RESULT:" + res);

		return ret;
	}

}
