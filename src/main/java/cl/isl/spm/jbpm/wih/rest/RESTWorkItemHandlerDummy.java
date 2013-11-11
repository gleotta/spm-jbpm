package cl.isl.spm.jbpm.wih.rest;

import cl.isl.spm.jbpm.wih.handlers.RESTHandler;
import cl.isl.spm.jbpm.wih.handlers.dummy.FacturacionR01HandlerDummy;
import cl.isl.spm.jbpm.wih.handlers.dummy.FacturacionR03HandlerDummy;
import cl.isl.spm.jbpm.wih.handlers.dummy.R01HandlerDummy;
import cl.isl.spm.jbpm.wih.handlers.dummy.R02HandlerDummy;
import cl.isl.spm.jbpm.wih.handlers.dummy.R04HandlerDummy;
import cl.isl.spm.jbpm.wih.handlers.dummy.R05HandlerDummy;
import cl.isl.spm.jbpm.wih.handlers.dummy.R06HandlerDummy;
import cl.isl.spm.jbpm.wih.handlers.dummy.RR01HandlerDummy;
import cl.isl.spm.jbpm.wih.handlers.dummy.RR02HandlerDummy;

public class RESTWorkItemHandlerDummy extends RESTWorkItemHandler {

	@Override
	protected RESTHandler resolveHandler(String path) {
		String vals[] = path.split("/");
		String rest = vals[vals.length - 1];
		String api = vals[vals.length - 2];
		if (api.equals("cuentaMedica")) {
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
			else if (rest.equals("rr01"))
				return new RR01HandlerDummy();
			else if (rest.equals("rr02"))
				return new RR02HandlerDummy();
			
		}
		
		if (api.equals("factura")) {
			if (rest.equals("r01"))
				return new FacturacionR01HandlerDummy();
			if (rest.equals("r03"))
				return new FacturacionR03HandlerDummy();
			
			
		}
		
		
		throw new RESTException("No exsite implementación para " + rest);
	}

}
