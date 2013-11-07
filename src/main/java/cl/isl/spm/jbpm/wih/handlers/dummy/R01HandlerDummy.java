package cl.isl.spm.jbpm.wih.handlers.dummy;

import java.util.HashMap;
import java.util.Map;

import org.apache.http.entity.StringEntity;

import cl.isl.spm.jbpm.wih.handlers.RESTHandler;
import cl.isl.spm.jbpm.wih.rest.RESTClient;
import cl.isl.spm.jbpm.wih.rest.RESTException;
import cl.isl.spm.jbpm.wih.util.JSONUtil;

public class R01HandlerDummy implements RESTHandler {

	@Override
	public Map<String, Object> execute(String method, String uri,
			Map<String, Object> parameters) throws RESTException {

		String body = JSONUtil.convertMapToJSON(parameters);

		System.out.println("REST Client:" + method + " " + uri);
		System.out.println(body);

		Integer cid = new Integer((String) parameters.get("cid"));
		Map<String, Object> ret = new HashMap<String, Object>();
		if (cid == 11111) {
			ret.put("errores", true);
			ret.put("cuentaEnPapel", true);
		} else if (cid == 10011) {
			ret.put("errores", false);
			ret.put("cuentaEnPapel", true);
		} else if (cid == 11100) {
			ret.put("errores", true);
			ret.put("cuentaEnPapel", false);
		} else if (cid == 10000) {
			ret.put("errores", false);
			ret.put("cuentaEnPapel", false);
		} else {
			ret.put("errores", true);
			ret.put("cuentaEnPapel", true);
		}
		String res = JSONUtil.convertMapToJSON(ret);
		System.out.println("REST Client RESULT:" + res);

		return ret;
	}

}
