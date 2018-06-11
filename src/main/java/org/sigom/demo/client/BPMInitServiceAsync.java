package org.sigom.demo.client;

import java.util.List;

import org.sigom.demo.shared.BPMProcess;

import com.google.gwt.user.client.rpc.AsyncCallback;


public interface BPMInitServiceAsync {
	void InitBPM(AsyncCallback<List<BPMProcess>> callback) throws IllegalArgumentException;
}
