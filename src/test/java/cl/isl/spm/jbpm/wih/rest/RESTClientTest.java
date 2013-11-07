package cl.isl.spm.jbpm.wih.rest;

import static org.junit.Assert.*;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;

public class RESTClientTest {
	
	private static Logger log = Logger.getLogger(RESTClientTest.class);

	private RESTClient rc;
	
	@Before
	public void init() {
		rc = new RESTClient("POST", "http://localhost:8090/isl-spm/api/cuentaMedica/r01", "{\"cid\":1234}");
	}
	
	@Test
	public void testExecuteService() {
		
		try {
			String result = rc.executeService();
			assertEquals(result, rc.getResponseCode(), new Integer(200));
			log.info("result: "+result);
			
		} catch (Exception e) {
			log.error(e.getMessage(),e);
			fail(e.getMessage());
		}
		
		
	}

}
