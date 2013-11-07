package cl.isl.spm.jbpm.wih.handlers;

import java.util.Map;

import cl.isl.spm.jbpm.wih.rest.RESTException;

public interface RESTHandler {

	Map<String, Object> execute(String method, String uri,
			Map<String, Object> parameters) throws RESTException;

}
