package cl.isl.spm.jbpm.wih.rest;

import cl.isl.spm.jbpm.wih.handlers.RESTHandler;
import cl.isl.spm.jbpm.wih.handlers.dummy.R01HandlerDummy;
import cl.isl.spm.jbpm.wih.handlers.dummy.R02HandlerDummy;
import cl.isl.spm.jbpm.wih.handlers.dummy.R04HandlerDummy;
import cl.isl.spm.jbpm.wih.handlers.dummy.R05HandlerDummy;
import cl.isl.spm.jbpm.wih.handlers.dummy.R06HandlerDummy;

public class RESTWorkItemHandlerDummy extends RESTWorkItemHandler{

	@Override
	protected RESTHandler resolveHandler(String path) {
		String vals[] = path.split("/");
		String rest = vals[vals.length-1];
		if (rest.equals("r01"))
			return new R01HandlerDummy();
		else if (rest.equals("r02"))
			return new R02HandlerDummy();
		if (rest.equals("r04"))
			return new R04HandlerDummy();
		else if (rest.equals("r05"))
			return new R05HandlerDummy();
		else if (rest.equals("r06"))
			return new R06HandlerDummy();
		else
			throw new RESTException("No exsite implementación para "+rest);
	}

}
