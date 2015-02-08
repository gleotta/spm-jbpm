package cl.isl.spm.jbpm.wih.rest;

import java.util.HashMap;
import java.util.Map;

import org.drools.runtime.process.WorkItem;
import org.drools.runtime.process.WorkItemHandler;
import org.drools.runtime.process.WorkItemManager;

import cl.isl.spm.jbpm.wih.handlers.DefaultRESTHandler;
import cl.isl.spm.jbpm.wih.handlers.RESTHandler;



public class RESTWorkItemHandler implements WorkItemHandler {
	
	//public static final String IN_URL_BASE="urlBase";
	public static final String IN_METHOD="method";
	public static final String IN_PATH="path";
	
	public static final String SYSTEM_URL_BASE="spm.jbpm.url.base";
	public static final String URL_BASE_DEFAULT="localhost:8080/isl-spm";
	
	
	protected String urlBase;
		
	protected String path;
	
	protected String method = "POST";
	
	protected Map<String, Object> parametersBody;
	
	
	private void resolveParameters(Map<String, Object> parameters) {
		Map<String, Object> ret = new HashMap<String, Object>(parameters);
		urlBase = System.getProperty(SYSTEM_URL_BASE, URL_BASE_DEFAULT);
//		if (parameters.containsKey(IN_URL_BASE)) {
//			String serverP = (String) parameters.get(IN_URL_BASE);
//			//es una propiedad
//			if (serverP.trim().startsWith("$")) {
//				urlBase = System.getProperty(serverP.trim().substring(2, serverP.trim().length()-1));
//			} else {
//				urlBase = serverP;
//			}
//			
//			ret.remove(IN_URL_BASE);		
//		}
//		
		
		
		if (parameters.containsKey(IN_PATH)) {
			path = (String) parameters.get(IN_PATH);
			ret.remove(IN_PATH);		
		}
		
		if (parameters.containsKey(IN_METHOD)) {
			method = (String) parameters.get(IN_METHOD);
			ret.remove(IN_METHOD);		
		}
		
		ret.remove("TaskName");
		
		parametersBody = ret;
	}

	protected RESTHandler resolveHandler(String path) {
		return new DefaultRESTHandler();
	}
	
	@Override
	public void executeWorkItem(WorkItem workItem, WorkItemManager manager) {
	
		try {
			resolveParameters(workItem.getParameters());
			String uri = "http://"+urlBase+path;
			RESTHandler rh = resolveHandler(path);
			Map<String,Object> results = rh.execute(method, uri, parametersBody);
			//System.out.println("Results enviados: "+results);
			manager.completeWorkItem(workItem.getId(), results);
		} catch (Exception e) {
			e.printStackTrace();
			manager.abortWorkItem(workItem.getId());
		}
	}

	@Override
	public void abortWorkItem(WorkItem workItem, WorkItemManager manager) {
		System.out.println("Abortando ejecución de RESTWorkItemHandler: "+this);
	}

	@Override
	public String toString() {
		return "RESTWorkItemHandler [urlBase=" + urlBase + ", path=" + path
				+ ", method=" + method + ", parametersBody=" + parametersBody
				+ "]";
	}

	
}
