package org.sigom.demo.camunda;

import java.util.Random;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

public class CheckWeatherDelegate implements JavaDelegate {

	@Override
	public void execute(DelegateExecution execution) throws Exception {
		Random rando = new Random();
		
		execution.setVariable("name", "Oleg");
		execution.setVariable("weatherOk", rando.nextBoolean());
	}

}
