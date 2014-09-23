package automation.scripts;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.testng.IReporter;
import org.testng.IResultMap;
import org.testng.ISuite;
import org.testng.ISuiteResult;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.xml.XmlSuite;

public class ReportGenerator implements IReporter {

	public static String testResult;
	// private final NumberFormat formatter = new DecimalFormat("#,##0.0");
	private PrintWriter out;

	@Override
	public void generateReport(List<XmlSuite> xmlSuite, List<ISuite> suites,
			String outputDir) {
		try {
			out = createWriter(outputDir);
		} catch (Exception e) {
		}
		generateSuiteSummaryReport(suites);

		out.flush();
		out.close();

	}

	public void generateSuiteSummaryReport(List<ISuite> suites) {

		startHTML();
		for (ISuite suite : suites) {

			Map<String, ISuiteResult> tests = suite.getResults();

			Set<Map.Entry<String, ISuiteResult>> set = tests.entrySet();

			for (Entry<String, ISuiteResult> entry : set) {

				String suiteName = entry.getKey();
				ISuiteResult suiteResult = entry.getValue();

				ITestContext context = suiteResult.getTestContext();

				IResultMap failedConfigs = context.getFailedConfigurations();
				IResultMap successTests = context.getPassedTests();
				IResultMap failedTests = context.getFailedTests();
				IResultMap skippedTests = context.getSkippedTests();
				IResultMap failedSuccess = context
						.getFailedButWithinSuccessPercentageTests();

				int[] count = new int[4];

				count[0] = successTests.size();
				count[1] = failedTests.size();
				count[2] = skippedTests.size();
				count[3] = count[0] + count[1] + count[2];

				createSummary(suiteName, count);

				Set<ITestResult> failedConfigResults = failedConfigs
						.getAllResults();
				Set<ITestResult> failedResults = failedTests.getAllResults();
				Set<ITestResult> successResults = successTests.getAllResults();
				Set<ITestResult> skippedResults = skippedTests.getAllResults();

				Set<ITestResult> fsResults = failedSuccess.getAllResults();

				if (!failedConfigResults.isEmpty()) {
					createTitle("Configuration Failed Cases");
					startTable();
					createTableHeader();
					parseTableRow(failedConfigResults, "failed");
					endTable();
				}

				if (!failedResults.isEmpty()) {
					createTitle("Failed Test Cases");
					startTable();
					createTableHeader();
					parseTableRow(failedResults, "failed");
					endTable();
				}

				if (!successResults.isEmpty()) {
					createTitle("Passed Test Cases");
					startTable();
					createTableHeader();
					parseTableRow(successResults, "success");
					parseTableRow(fsResults, "success");
					endTable();
				}

				if (!skippedResults.isEmpty()) {
					createTitle("Skipped Test Cases");
					startTable();
					createTableHeader();
					parseTableRow(skippedResults, "skipped");
					endTable();
				}
			}

		}

		endHTML();
	}

	protected void parseTableRow(Set<ITestResult> testResults, String cssClass) {

		for (ITestResult iTestResult : testResults) {

			String[] rows = new String[5];
			rows[0] = getDate(iTestResult.getStartMillis());
			rows[1] = "";

			/*
			 * if (iTestResult.getMethod().getDescription() != null) { rows[1]
			 * += " Description: " +
			 * iTestResult.getMethod().getDescription()+"<br>"; }
			 */
			try {
				rows[2] = "<b>" + iTestResult.getThrowable().getMessage()
						+ "<br></b>";
			} catch (Exception e) {
			}
			if (rows[2] == null) {
				rows[2] = "-";
			}
			Object[] params = iTestResult.getParameters();
			if (params.length >= 1) {
				rows[1] += "";
				for (Object p : params) {
					rows[1] += "  " + p + "";
				}
			}

			rows[3] = String.valueOf("   "
					+ ((iTestResult.getEndMillis() - iTestResult
							.getStartMillis())) + "  Milli Seconds");
			try {
				StackTraceElement[] trace = iTestResult.getThrowable()
						.getStackTrace();
				rows[4] = "";
				for (StackTraceElement se : trace) {
					rows[4] += se + "\n";
				}

			} catch (Exception e) {
			}

			createTableRow(cssClass, rows);
		}

	}

	protected void createCssContent() {

		out.println("<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.1//EN http://www.w3.org/TR/xhtml11/DTD/xhtml11.dtd\">");
		out.println("<html xmlns=\"http://www.w3.org/1999/xhtml\">");
		out.println("<head>" + "<style>" + ".summary {"
				+ "font-family: Arial, Helvetica, sans-serif;"
				+ "background-color: #800000;" + "color: #ffffff;"
				+ "text-align: left;" + "font-size: 12px;"
				+ "line-height: 20px;" + "}" +

				".failed {" + "font-family: Arial, Helvetica, sans-serif;"
				+ "background-color: #FF0000;" + "text-align: left;"
				+ "font-size: 12px;" + "color: #ffffff;" + "line-height: 20px;"
				+ "}" +

				".success {" + "font-family: Arial, Helvetica, sans-serif;"
				+ "background-color: #008000;" + "text-align: left;"
				+ "font-size: 12px;" + "line-height: 20px;" + "color: #ffffff;"
				+ "}" +

				".skipped {" + "font-family: Arial, Helvetica, sans-serif;"
				+ "background-color: #FFFF00;" + "text-align: left;"
				+ "font-size: 12px;" + "line-height: 20px;" + "color: #000000;"
				+ "}" +

				".stable {" + "font-family: Arial, Helvetica, sans-serif;"
				+ "text-align: center;" + "border: 1px #605151 solid;"
				+ "background-color: #ffffff;" + "text-align: left;"
				+ "font-weight:bold;" + "font-size: 12px;"
				+ "line-height: 20px;" + "color: #ffffff;"
				+ "margin-bottom: 20px;" + "}" +

				".stable tr th {"
				+ "font-family: Arial, Helvetica, sans-serif;"
				+ "width: 180px;" + "line-height: 20px;" + "font-size: 13px;"
				+ "text-align: left;" + "}" +

				"stable tr td {" + "font-family: Arial, Helvetica, sans-serif;"
				+ "width: 180px;" + "line-height: 20px;" + "}" +

				".tbheader {" + "font-family: Arial, Helvetica, sans-serif;"
				+ "text-align: center;" + "border: 1px #605151 solid;"
				+ "background-color: #ffffff;" + "font-size: 12px;"
				+ "line-height: 20px;" + "color: #000000;" + "}" +

				".subhead {" + "font-family: Arial, Helvetica, sans-serif;"
				+ "text-align: center;" + "border: 1px #605151 solid;"
				+ "background-color: #FFFFFF;" + "text-align: left;"
				+ "font-size: 12px;" + "line-height: 20px;" + "color: #000000;"
				+ "}" + "</style>");

	}

	protected void createTitle(String title) {
		out.append("<h3 class=\"subhead\">" + title + "</h3>");
	}

	public void startTable() {
		out.append("<table class='stable' width='100%' cellspacing='1' cellpadding='0' align='center'>");
	}

	public void createJavaScript() {

		out.append("<script type=\"text/javascript\">"
				+ " <!--"
				+ "function flip(e) {"
				+ "current = e.style.display;"
				+ "if (current == 'block') {"
				+ " e.style.display = 'none';"
				+ " return 0;"
				+ " }"
				+ " else {"
				+ "  e.style.display = 'block';"
				+ " return 1;"
				+ " }"
				+ "}"
				+

				"function toggleBox(szDivId, elem, msg1, msg2)"
				+ "{"
				+ "var res = -1;  if (document.getElementById) {"
				+ "  res = flip(document.getElementById(szDivId));"
				+ " }"
				+ " else if (document.all) {"
				+ "  res = flip(document.all[szDivId]);"
				+ " }"
				+ "if(elem) {"
				+ "  if(res == 0) elem.innerHTML = msg1; else elem.innerHTML = msg2;"
				+ " }" +

				"} " + "</script>" + "</head>");
	}

	protected void createTableHeader() {

		out.append("<tr class='summary'>" + "<th>Date</th>"
				+ "<th>TestCaseName</th>"
				+ "<th style=\"width: 300px\">Message</th>"
				+ "<th>Execution Time</th>" + "<th>StackTrace</th>" + "</tr>");
	}

	protected void createTableRow(String cssCase, String[] data) {

		out.append("<tr class=" + cssCase + ">" + "<td>" + data[0] + "</td>"
				+ "<td>" + data[1] + "</td>" + "<td>" + data[2] +

				"</td>" + "<td>" + data[3] + "</td>" + "<td>" +

				"<a href='#' title='" + data[4]
				+ "'>Hover to View StackTrace</a>"

				+ "</td>" + "</tr>");
	}

	public void endTable() {
		out.append("</table>");
	}

	protected void startHTML() {
		createCssContent();
		createJavaScript();
	}

	protected void endHTML() {
		out.append("</html>");
	}

	protected void createSummary(String suiteName, int[] results) {

		out.append("	<table class=\"stable\" width='400px' cellspacing=\"1\" cellpadding=\"0\" align=\"center\">"
				+ "<tr>"
				+ "<th colspan=\"2\" class=\"tbheader\">Test Report Summary</th>"
				+ "</tr>"
				+ "<tr class=\"subhead\">"
				+ "<th>Suite Name</th>"
				+ "	<td>"
				+ suiteName
				+ "</td>"
				+ "	</tr>"
				+

				"<tr class='success'>"
				+ "	<th>Success Tests</th>"
				+ "<td>"
				+ results[0]
				+ "</td>"
				+ "</tr>"
				+ "<tr class='failed'>"
				+ "<th>Failed Tests</th>"
				+ "<td>"
				+ results[1]
				+ "</td>"
				+ "</tr>"
				+

				"<tr class='skipped'>"
				+ "<th>Skipped Tests</th>"
				+ "<td>"
				+ results[2]
				+ "</td>"
				+ "	</tr>"
				+ "	<tr class='success'>"
				+ "<th>Total Tests</th>"
				+ "<td>"
				+ results[3]
				+ "</td>"
				+ "</tr>" + "</table>");

	}

	protected PrintWriter createWriter(String outdir) throws IOException {
		return new PrintWriter(new BufferedWriter(new FileWriter(new File(
				outdir, "TestSuiteSummary.html"))));
	}

	public String getDate(long time) {
		SimpleDateFormat sdfDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// dd/MM/yyyy
		Date now = new Date(time);

		return sdfDate.format(now);

	}

}
