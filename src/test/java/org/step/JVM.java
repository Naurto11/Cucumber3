package org.step;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

//import net.masterthought.cucumber.Configuration;
//import net.masterthought.cucumber.ReportBuilder;

public class JVM {

	public static void genarateJvmReport(String json) {

		File f = new File(System.getProperty("user.dir") + "target\\JvmReports");

	//	Configuration con = new Configuration(f, "facebok");

//		con.addClassifications("Browser", "chrome");
//
//		con.addClassifications("platform", "Windows10");
//
//		con.addClassifications("chrome version", "103.0.5060");
//
//		con.addClassifications("sprint", "4");

		List<String> li = new ArrayList<String>();

		li.add("\\target\\JvmReports");

	//	ReportBuilder r = new ReportBuilder(li, con);
		
	 //         r.generateReports();

	}

}
