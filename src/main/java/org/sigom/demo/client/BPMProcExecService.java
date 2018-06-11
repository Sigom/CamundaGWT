package org.sigom.demo.client;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;


@RemoteServiceRelativePath("BPMProcExecService")
public interface BPMProcExecService extends RemoteService {
	String StartProcess(String key) throws IllegalArgumentException;
}
