package org.sigom.demo.server;

import org.camunda.bpm.engine.ProcessEngine;
import org.camunda.bpm.engine.runtime.ProcessInstance;
//import org.camunda.bpm.engine.task.Task;
import org.sigom.demo.client.BPMProcExecService;
import org.sigom.demo.camunda.BPM_Engine;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;



@SuppressWarnings("serial")
public class BPMProcExecServiceImpl extends RemoteServiceServlet implements BPMProcExecService {

	public String StartProcess(String key) throws IllegalArgumentException {

		ProcessEngine ProcEngine = BPM_Engine.getProcessEngine();
		
	    ProcessInstance processInstance = ProcEngine.getRuntimeService().startProcessInstanceByKey(key);

	    /*
	    Task task = ProcEngine.getTaskService().createTaskQuery().processInstanceId(processInstance.getId()).taskAssignee("demo").singleResult();
	    
	    ProcEngine.getTaskService().complete(task.getId());
		*/
	    
	    if (processInstance.isEnded()) {
	    	return "task complete";
	    	
	    } else {
	    	return "task fail";
	    }
		
	}

}
