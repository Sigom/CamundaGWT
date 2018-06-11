package org.sigom.demo.camunda;

import java.io.File;

import org.camunda.bpm.engine.ProcessEngine;
import org.camunda.bpm.engine.ProcessEngineConfiguration;
import org.camunda.bpm.engine.RepositoryService;
import org.camunda.bpm.model.bpmn.Bpmn;
import org.camunda.bpm.model.bpmn.BpmnModelInstance;

public class BPM_Engine {
	
	private static ProcessEngine processEngine;
	
	
	
	public static ProcessEngine getProcessEngine() {
		if (processEngine == null) {
			try {
				processEngine = ProcessEngineConfiguration.createStandaloneInMemProcessEngineConfiguration()
				  .setDatabaseSchemaUpdate(ProcessEngineConfiguration.DB_SCHEMA_UPDATE_TRUE)
				  .setJdbcUrl("jdbc:h2:mem:my-own-db;DB_CLOSE_DELAY=1000")
				  .setJobExecutorActivate(true)
				  .buildProcessEngine();
	    	} catch (RuntimeException ex) {
	    		System.out.println("BPM_Engine getProcessEngine ERROR: "+ ex.getMessage());
	    		throw ex;
	    	}
		}
		
		
		return processEngine;
		
	}
	
	public static void DeployProcesses() {
		RepositoryService repositoryService = getProcessEngine().getRepositoryService();
		
		try {
			System.out.println(System.getProperty("user.dir"));
			File file = new File("resources/CheckWeather.bpmn");
			BpmnModelInstance bpmnModel = Bpmn.readModelFromFile(file);

			repositoryService.createDeployment()
				.addModelInstance("CheckWeather.bpmn", bpmnModel)
				.deploy();
			
		} catch (RuntimeException ex) {
			System.out.println("BPM_Engine DeployProcesses ERROR: "+ ex.getMessage());
			throw ex;
		}
}
	

}
