package org.sigom.demo.shared;

import com.google.gwt.user.client.rpc.IsSerializable;

public class BPMProcess implements IsSerializable {


	public String Id;
	public String Key;
	public String Name;
	
	public BPMProcess(String id, String key, String name) {
		Id = id;
		Key = key;
		Name = name; 
	}

	public BPMProcess() {
		Id = null;
		Key = null;
		Name = null; 
	}

}
