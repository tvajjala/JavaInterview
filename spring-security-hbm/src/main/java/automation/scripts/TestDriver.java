/*******************************************************************
 * A user specified class, where the test cases are executed
 * by performing mapping to the tables like Object Reference, 
 * Component Reference and Hash-Map Tables from Test-case tables
 *******************************************************************/

package automation.scripts;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.SQLException;

import javax.xml.parsers.ParserConfigurationException;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriverException;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.xml.sax.SAXException;

import com.thoughtworks.selenium.SeleniumException;

public class TestDriver extends Components {

	private static final int ARRAY_SIZE = 4000;

	public Logger logger = Logger.getRootLogger();
	public String TestsToExecuteFile = "";
	public String TestDetailsFile = "";
	public String TestStepsFile = "";
	public String MessagesFile = "";
	public String ObjectReferenceFile = "";

	@Parameters({ "path", "project", "module", "Suitename" })
	@BeforeSuite
	public void initializeDataFiles(String path, String project, String module,
			String Suitename) throws IOException, Exception, SeleniumException {

		logger.info("initializing data files ");
		String mainPath = path + File.separator + "data" + File.separator
				+ "projects" + File.separator + project + File.separator;

		String xmlFilesPath = mainPath + "test-input" + File.separator;

		TestsToExecuteFile = mainPath + "configs" + File.separator + Suitename
				+ File.separator + Suitename + "_" + module + ".xml";

		TestDetailsFile = xmlFilesPath + File.separator + "TestDetails.xml";

		TestStepsFile = xmlFilesPath + File.separator + "TestSteps.xml";

		MessagesFile = xmlFilesPath + File.separator + "Messages.xml";

		ObjectReferenceFile = xmlFilesPath + File.separator
				+ "ObjectReference.xml";

	}

	/**
	 * 
	 * @testData method uses the DataProvider annotation which repeats the test
	 *           for every set of data that is read from the given excel file
	 */

	@DataProvider(name = "TestCases")
	public Object[][] testData() throws Exception {
		Object[][] retObjArr1 = SAXXMLTransformation.parseTestsToExecute(
				TestsToExecuteFile).get();

		logger.info("reading test data");
		return (retObjArr1);
	}

	/**
	 * @throws Exception
	 * @executeTest method executes the specified tests by getting data from the
	 *              test cases and mapping data to Object Reference, Component
	 *              Reference and Hash-Map Tables
	 * 
	 * @Exception throws an exception after the sleep interval is Completed
	 */
	@Test(dataProvider = "TestCases", groups = { "Tests to be executed" }, description = "The test cases to be executed are handled using this function...")
	public void executeTest(String Test) throws SAXException, IOException,
			ParserConfigurationException, SQLException, InterruptedException {
		if (Test != null) {

			ThreadLocal<String[]> TD = new ThreadLocal<String[]>();
			TD.set(SAXXMLTransformation.parseTestDetails(TestDetailsFile, Test));

			for (int s = 0; s < TD.get().length; s++) {

				String[] TestDetails = TD.get();

				try {
					if (TestDetails[s] != null) {

						ThreadLocal<String> Stps = new ThreadLocal<String>();
						String Steps = Stps.get();
						Steps = TestDetails[s];

						ThreadLocal<String[][]> TDF = new ThreadLocal<String[][]>();

						TDF.set(SAXXMLTransformation.parseTestSteps(
								TestStepsFile, Steps));
						String stepscount = SAXXMLTransformation.getStepsCount(
								TestStepsFile, Steps);

						String[][] TestDataFinal = TDF.get();

						try {

							if (stepscount != null) {

								for (int cnt = 0; cnt < Integer
										.parseInt(stepscount); cnt++) {

									// System.out.println("inside cnt for loop: "+cnt);

									for (int k = 0; k < TDF.get().length; k++) {

										String Component = TestDataFinal[k][0];
										String Action = TestDataFinal[k][1];
										String Expected = TestDataFinal[k][2];

										if ((Component != null)
												&& (Action != null)
												&& (Expected != null)) {
											try {

												logger.info("################################## THE STEP details ARE:"
														+ SAXXMLTransformation
																.getObj(ObjectReferenceFile,
																		Component)
														+ ","
														+ Action
														+ ","
														+ Expected);

												Object obj = Class
														.forName(
																"automation.scripts.Components")
														.newInstance();
												Method[] methods = obj
														.getClass()
														.getMethods();
												for (int i = 0; i < methods.length; ++i) {
													if (methods[i].getName()
															.equalsIgnoreCase(
																	Action)) {

														if (Component
																.equalsIgnoreCase("NA")) {
															methods[i]
																	.invoke(obj,
																			SAXXMLTransformation
																					.parseMessages(
																							MessagesFile,
																							Expected)
																					.get());
														} else if (Expected
																.equalsIgnoreCase("NA")) {
															methods[i]
																	.invoke(obj,
																			SAXXMLTransformation
																					.getObj(ObjectReferenceFile,
																							Component));
														} else {
															methods[i]
																	.invoke(obj,
																			SAXXMLTransformation
																					.getObj(ObjectReferenceFile,
																							Component),
																			SAXXMLTransformation
																					.parseMessages(
																							MessagesFile,
																							Expected)
																					.get());
														}
													}
												}
											} catch (AssertionError e) {
												click("//div[@id='links']/a[2]");
												pauseExecution("2000");
												logger.error("AssertionError EXCEPTION CAUGHT");
												logger.error("################################## THE STEP details when AssertionError:"
																+ SAXXMLTransformation
																		.getObj(ObjectReferenceFile,
																				Component)
																+ ","
																+ Action
																+ ","
																+ Expected);
												Assert.fail("SeleniumException");
												// e.printStackTrace("AssertionError");
											} catch (SeleniumException e) {
												click("//div[@id='links']/a[2]");
												pauseExecution("2000");
												logger.error("SeleniumException CAUGHT");
												logger.error("################################## THE STEP details when SeleniumException:"
																+ SAXXMLTransformation
																		.getObj(ObjectReferenceFile,
																				Component)
																+ ","
																+ Action
																+ ","
																+ Expected);
												Assert.fail("SeleniumException");
												// e.printStackTrace("SeleniumException");
											} catch (InstantiationException e) {
												click("//div[@id='links']/a[2]");
												pauseExecution("2000");
												logger.error("InstantiationException CAUGHT");
												logger.error("################################## THE STEP details when InstantiationException:"
																+ SAXXMLTransformation
																		.getObj(ObjectReferenceFile,
																				Component)
																+ ","
																+ Action
																+ ","
																+ Expected);
												Assert.fail("InstantiationException");
												// e.printStackTrace("InstantiationException");
											} catch (IllegalAccessException e) {
												click("//div[@id='links']/a[2]");
												pauseExecution("2000");
												logger.error("IllegalAccessException CAUGHT");
												logger.error("################################## THE STEP details when IllegalAccessException:"
																+ SAXXMLTransformation
																		.getObj(ObjectReferenceFile,
																				Component)
																+ ","
																+ Action
																+ ","
																+ Expected);
												Assert.fail("IllegalAccessException");
												// e.printStackTrace("IllegalAccessException");
											} catch (ClassNotFoundException e) {
												click("//div[@id='links']/a[2]");
												pauseExecution("2000");
												logger.error("ClassNotFoundException CAUGHT");
												logger.error("################################## THE STEP details when ClassNotFoundException:"
																+ SAXXMLTransformation
																		.getObj(ObjectReferenceFile,
																				Component)
																+ ","
																+ Action
																+ ","
																+ Expected);
												Assert.fail("ClassNotFoundException");
												// e.printStackTrace("ClassNotFoundException");
											} catch (IllegalArgumentException e) {
												click("//div[@id='links']/a[2]");
												pauseExecution("2000");
												logger.error("IllegalArgumentException CAUGHT");
												logger.error("################################## THE STEP details when IllegalArgumentException:"
																+ SAXXMLTransformation
																		.getObj(ObjectReferenceFile,
																				Component)
																+ ","
																+ Action
																+ ","
																+ Expected);
												Assert.fail("IllegalArgumentException");
												// e.printStackTrace("IllegalArgumentException");
											} catch (InvocationTargetException e) {
												click("//div[@id='links']/a[2]");
												pauseExecution("2000");
												logger.error("InvocationTargetException CAUGHT");
												logger.error("################################## THE STEP details when InvocationTargetException:"
																+ SAXXMLTransformation
																		.getObj(ObjectReferenceFile,
																				Component)
																+ ","
																+ Action
																+ ","
																+ Expected);
												Assert.fail("InvocationTargetException");
												// e.printStackTrace("InvocationTargetException");
											} catch (NullPointerException e) {
												click("//div[@id='links']/a[2]");
												pauseExecution("2000");
												logger.error("NullPointerException CAUGHT");
												logger.error("################################## THE STEP details when NullPointerException:"
																+ SAXXMLTransformation
																		.getObj(ObjectReferenceFile,
																				Component)
																+ ","
																+ Action
																+ ","
																+ Expected);
												Assert.fail("NullPointerException");
												// e.printStackTrace("NullPointerException");
											} catch (WebDriverException e) {
												click("//div[@id='links']/a[2]");
												pauseExecution("2000");
												logger.error("WebDriverException CAUGHT");
												logger.error("################################## THE STEP details when WebDriverException:"
																+ SAXXMLTransformation
																		.getObj(ObjectReferenceFile,
																				Component)
																+ ","
																+ Action
																+ ","
																+ Expected);
												Assert.fail("WebDriverException");
												// e.printStackTrace("WebDriverException");
											} catch (RuntimeException e) {
												click("//div[@id='links']/a[2]");
												pauseExecution("2000");
												logger.error("RuntimeException CAUGHT");
												logger.error("################################## THE STEP details when RuntimeException:"
																+ SAXXMLTransformation
																		.getObj(ObjectReferenceFile,
																				Component)
																+ ","
																+ Action
																+ ","
																+ Expected);
												Assert.fail("RuntimeException");
												// e.printStackTrace("RuntimeException");
											} finally {

												logger.info("End of for loop: "
																+ k);
											}
										}
									}
								}
							}

						}

						catch (Exception e) {
							click("//div[@id='links']/a[2]");
							pauseExecution("2000");
							logger.error(e.getMessage());
						} finally {
							// TDF.remove();
							for (int cln = 0; cln < TestDataFinal.length; cln++) {

								TestDataFinal[cln][0] = null;
								TestDataFinal[cln][1] = null;
								TestDataFinal[cln][2] = null;
							}
						}
					}
				} catch (Exception e) {
					click("//div[@id='links']/a[2]");
					pauseExecution("2000");
					logger.error(e.getMessage());
				} finally {
					// TD.remove();
					TestDetails[s] = null;
				}
			}
		}
	}
}