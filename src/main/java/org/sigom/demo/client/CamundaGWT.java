package org.sigom.demo.client;

import java.util.List;

import org.sigom.demo.shared.BPMProcess;


import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Grid;
import com.google.gwt.user.client.ui.HTMLTable.Cell;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.VerticalPanel;


public class CamundaGWT implements EntryPoint {

	private final BPMInitServiceAsync BPMInitService = GWT.create(BPMInitService.class);
	private final BPMProcExecServiceAsync BPMProcExecService = GWT.create(BPMProcExecService.class);

    Grid ProcList = new Grid(5, 4);
	

	public void onModuleLoad() {

		final Label BPM_hello = new Label();
		final VerticalPanel panel = new VerticalPanel();
		
		BPM_hello.setText("BPM Engine init, wait...");
		panel.add(BPM_hello);

	    ProcList.setBorderWidth(3);


	    ProcList.getColumnFormatter().setWidth(0, "50px"); 
	    ProcList.getColumnFormatter().setWidth(1, "50px"); 
	    ProcList.getColumnFormatter().setWidth(2, "100px"); 
	    
	    ProcList.setTitle("BPM Procesess");
	    
	  
    	
	    ProcList.setText(0, 0, "ID");
	    ProcList.setText(0, 1, "KEY");
	    ProcList.setText(0, 2, "NAME");
	    ProcList.setText(0, 3, "RUN");

	    panel.add(ProcList);

		RootPanel.get().add(panel);
		
		class StartProcHandler implements ClickHandler{

			public void onClick(ClickEvent event) {
								
				Cell cell = ProcList.getCellForEvent(event);
								
				BPMProcExecService.StartProcess(ProcList.getText(cell.getRowIndex(), 1), new AsyncCallback<String>() {
					public void onFailure(Throwable caught) {
						BPM_hello.setText("BPM Start Process Failure: "+caught.getMessage());
					}
					public void onSuccess(String result) {
						BPM_hello.setText("BPM Start Process Result: "+result);	
					}
				});

			}

		}
		
		BPMInitService.InitBPM(new AsyncCallback<List<BPMProcess>>() {
			public void onFailure(Throwable caught) {
				BPM_hello.setText("BPM Init Failure: "+caught.getMessage());
			}

			public void onSuccess(List<BPMProcess> result) {
				BPM_hello.setText("BPM Service started");
				for (BPMProcess process : result) {
				    for (int row = 1; row < result.size() + 1; ++row) {
					    ProcList.setText(row, 0, process.Id);
					    ProcList.setText(row, 1, process.Key);
					    ProcList.setText(row, 2, process.Name);

					    Button startTaskButton = new Button("Start Process");
						startTaskButton.addClickHandler(new StartProcHandler());
					
					    ProcList.setWidget(row, 3, startTaskButton);						   
					    }
				}
			}
		});
		
	}
}
