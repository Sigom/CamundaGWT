package org.sigom.demo.client;

import com.google.gwt.user.client.rpc.AsyncCallback;


public interface BPMProcExecServiceAsync {
	void StartProcess(String key, AsyncCallback<String> callback) throws IllegalArgumentException;
}
