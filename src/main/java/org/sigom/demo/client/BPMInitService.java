package org.sigom.demo.client;

import java.util.List;

import org.camunda.bpm.engine.repository.ProcessDefinition;
import org.sigom.demo.shared.BPMProcess;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;


@RemoteServiceRelativePath("BPMInitService")
public interface BPMInitService extends RemoteService {
	List<BPMProcess> InitBPM() throws IllegalArgumentException;
}
