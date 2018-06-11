package org.sigom.demo;

import org.sigom.demo.client.CamundaGWTTest;
import com.google.gwt.junit.tools.GWTTestSuite;
import junit.framework.Test;
import junit.framework.TestSuite;

public class CamundaGWTSuite extends GWTTestSuite {
	public static Test suite() {
		TestSuite suite = new TestSuite("Tests for CamundaGWT");
		suite.addTestSuite(CamundaGWTTest.class);
		return suite;
	}
}
