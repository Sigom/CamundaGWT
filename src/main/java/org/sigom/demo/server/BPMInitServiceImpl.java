package org.sigom.demo.server;

import java.util.ArrayList;
import java.util.List;

import org.camunda.bpm.engine.ProcessEngine;
import org.camunda.bpm.engine.repository.ProcessDefinition;
import org.sigom.demo.client.BPMInitService;
import org.sigom.demo.shared.BPMProcess;
import org.sigom.demo.camunda.BPM_Engine;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;



@SuppressWarnings("serial")
public class BPMInitServiceImpl extends RemoteServiceServlet implements BPMInitService {

	public List<BPMProcess> InitBPM() throws IllegalArgumentException {
		BPM_Engine.DeployProcesses(); 

		ProcessEngine ProcEngine = BPM_Engine.getProcessEngine();
		
		List<ProcessDefinition> processDefinitions = ProcEngine.getRepositoryService().createProcessDefinitionQuery().list();
		List<BPMProcess> BPMProcesses = new ArrayList<BPMProcess>();
        
		for (ProcessDefinition procDef : processDefinitions) {
        	BPMProcesses.add(new BPMProcess(procDef.getId(), procDef.getKey(), procDef.getName()));
        }
		
		
		return BPMProcesses;
	}

}
