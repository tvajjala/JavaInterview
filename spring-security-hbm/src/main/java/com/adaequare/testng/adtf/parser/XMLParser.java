package com.adaequare.testng.adtf.parser;

import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.springframework.beans.factory.annotation.Autowired;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.adaequare.testng.adtf.testng.beans.Configuration;
import com.adaequare.testng.adtf.testng.beans.TestSteps;
import com.adaequare.testng.adtf.testng.beans.TestSuite;

public class XMLParser {/*

	@Autowired
	private DocumentBuilderFactory documentBuilderFactory;

	@Autowired
	private TransformerFactory transformerFactory;

	DocumentBuilder builder;
	Document document;
	Transformer transformer;

	public void setTransformerFactory(TransformerFactory transformerFactory) {
		this.transformerFactory = transformerFactory;
	}

	public TransformerFactory getTransformerFactory() {
		return transformerFactory;
	}

	public void setDocumentBuilderFactory(
			DocumentBuilderFactory documentBuilderFactory) {
		this.documentBuilderFactory = documentBuilderFactory;
	}

	public DocumentBuilderFactory getDocumentBuilderFactory() {
		return documentBuilderFactory;
	}

	public int createCategory(String path, String project, String moduleName) {
		try {
			// System.out.println(" moduleName" + moduleName);
			builder = documentBuilderFactory.newDocumentBuilder();
			document = builder.newDocument();

			File file = new File(path + File.separator + "data"
					+ File.separator + "projects" + File.separator + project
					+ File.separator + "test-input" + File.separator
					+ "Categories.xml");

			if (!file.exists()) {
				Element rootElement = document.createElement("Categories");
				document.appendChild(rootElement);
				Element cat = document.createElement("cat");
				cat.setTextContent(moduleName);
				rootElement.appendChild(cat);
			} else {

				if (getCategories(path, project).contains(moduleName)) {
					return 1;// duplicate
				}

				document = builder.parse(file);
				document.getDocumentElement().normalize();

				Element cat = document.createElement("cat");
				cat.setTextContent(moduleName);
				// System.out.println(cat);
				document.getDocumentElement().appendChild(cat);
				// System.out.println(document);
			}

			transformer = transformerFactory.newTransformer();
			DOMSource source = new DOMSource(document);
			StreamResult result = new StreamResult(file);
			transformer.transform(source, result);

			// creating required folder and xml files
			createModuleFolder(path, project, moduleName);

		} catch (Exception e) {

			e.printStackTrace();
			return -1;
		}
		return 0;
	}

	public void createProjectFolder(String path, String projectName) {

		File projectDir = new File(path + File.separator + "data"
				+ File.separator + "projects" + File.separator + projectName);

		if (!projectDir.exists()) {
			projectDir.mkdir();

			File configDir = new File(path + File.separator + "data"
					+ File.separator + "projects" + File.separator
					+ projectName + File.separator + "configs");
			if (!configDir.exists()) {
				configDir.mkdir();
			}

			File testInput = new File(path + File.separator + "data"
					+ File.separator + "projects" + File.separator
					+ projectName + File.separator + "test-input");
			if (!testInput.exists()) {
				testInput.mkdir();
			}

			File testOutput = new File(path + File.separator + "data"
					+ File.separator + "projects" + File.separator
					+ projectName + File.separator + "test-output");
			if (!testOutput.exists()) {
				testOutput.mkdir();
			}

		}

	}

	public void createModuleFolder(String path, String project,
			String moduleName) {

		File moduleDir = new File(path + File.separator + "data"
				+ File.separator + "projects" + File.separator + project
				+ File.separator + "test-input" + File.separator + moduleName);

		if (!moduleDir.exists()) {
			moduleDir.mkdir();
		}

		try {

			String xmlFilesPath = path + File.separator + "data"
					+ File.separator + "projects" + File.separator + project
					+ File.separator + "test-input";
			createObjectReferencesFile(xmlFilesPath);
			createMessagesFile(xmlFilesPath);
			createTestDetails(xmlFilesPath);
			createTestSteps(xmlFilesPath);
			createTestsToLoad(xmlFilesPath, moduleName);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void createObjectReferencesFile(String path) throws Exception {

		File objFile = new File(path + File.separator + "ObjectReference.xml");
		if (!objFile.exists()) {
			builder = documentBuilderFactory.newDocumentBuilder();
			document = builder.newDocument();
			Element rootElement = document.createElement("Reference");
			document.appendChild(rootElement);
			transformer = transformerFactory.newTransformer();
			DOMSource source = new DOMSource(document);
			StreamResult result = new StreamResult(objFile);
			transformer.transform(source, result);
		}
	}

	public boolean deleteObjectReferencesFile(String path) throws Exception {
		File objFile = new File(path + File.separator + "ObjectReference.xml");
		if (objFile.exists())
			return objFile.delete();
		return false;
	}

	public int updateObjectReferecesFile(String path, String projectName,
			 Map<String, String> objmap) {

		try {

			String file = path + File.separator + "data" + File.separator
					+ "projects" + File.separator + projectName
					+ File.separator + "test-input";
			File objFile = new File(file + File.separator
					+ "ObjectReference.xml");

			// System.out.println(objFile.getAbsolutePath());

			builder = documentBuilderFactory.newDocumentBuilder();

			if (objFile.exists()) {
				document = builder.parse(objFile);
				document.getDocumentElement().normalize();
			} else {
				document = builder.newDocument();
			}

			Element rootElement = document.getDocumentElement();

			Set<Map.Entry<String, String>> objSet = objmap.entrySet();

			for (Entry<String, String> entry : objSet) {
				Element element = document.createElement("RefValues");
				element.setAttribute("aName", entry.getKey());
				element.setAttribute("bObjRef", entry.getValue());

				rootElement.appendChild(element);
			}

			transformer = transformerFactory.newTransformer();
			transformer.setOutputProperty(OutputKeys.INDENT, "yes");
			DOMSource source = new DOMSource(document);
			StreamResult result = new StreamResult(objFile);

			transformer.transform(source, result);

			return 0;
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		}

	}

	public int updateTestConfiguration(String path, String projectName,
			String configName, String hostName, String browser, String bVersion) {

		try {
			String file = path + File.separator + "data" + File.separator
					+ "projects" + File.separator + projectName
					+ File.separator + "configs";

			File configsFolder = new File(file);
			if (!configsFolder.exists()) {
				configsFolder.mkdir();
			}

			File configFile = new File(file + File.separator
					+ "TestConfiguration.xml");

			builder = documentBuilderFactory.newDocumentBuilder();
			Element rootElement = null;
			if (configFile.exists()) {
				document = builder.parse(configFile);
				document.getDocumentElement().normalize();
				rootElement = document.getDocumentElement();
			} else {
				document = builder.newDocument();
				rootElement = document.createElement("TestConfiguration");
				document.appendChild(rootElement);
			}

			Element TestConfig1 = document.createElement("TestConfig");
			TestConfig1.setAttribute("name", configName);
			// rootElement.appendChild(TestConfig);

			Element hostname1 = document.createElement("hostname");
			hostname1.setTextContent(hostName);
			TestConfig1.appendChild(hostname1);

			Element browsertype1 = document.createElement("browsertype");
			browsertype1.setTextContent(browser);
			TestConfig1.appendChild(browsertype1);

			Element browserversion1 = document.createElement("browserversion");
			browserversion1.setTextContent(bVersion);
			TestConfig1.appendChild(browserversion1);

			rootElement.appendChild(TestConfig1);

			transformer = transformerFactory.newTransformer();
			transformer.setOutputProperty(OutputKeys.INDENT, "yes");
			DOMSource source = new DOMSource(document);
			StreamResult result = new StreamResult(configFile);

			transformer.transform(source, result);
			return 0;
		} catch (Exception e) {
			// TODO: handle exception
			return -1;
		}

	}

	public Map<String, String> getObjectReferences(String path,
			String projectName) {
		Map<String, String> objMap = new HashMap<String, String>();
		String objName = "";
		try {
			String file = path + File.separator + "data" + File.separator
					+ "projects" + File.separator + projectName
					+ File.separator + "test-input";
			File objFile = new File(file + File.separator
					+ "ObjectReference.xml");
			
			String objVal = "";
			builder = documentBuilderFactory.newDocumentBuilder();
			document = builder.parse(objFile);
			document.getDocumentElement().normalize();
			NodeList nodeList = document.getElementsByTagName("RefValues");
			for (int i = 0; i < nodeList.getLength(); i++) {
				objName = nodeList.item(i).getAttributes().getNamedItem("aName").getNodeValue();
				objVal = nodeList.item(i).getAttributes().getNamedItem("bObjRef").getNodeValue();
				objMap.put(objName, objVal);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return objMap;
	}

	public Map<String, String> getMessageInfo(String path, String projectName) {
		Map<String, String> msgMap = new HashMap<String, String>();

		try {
			String file = path + File.separator + "data" + File.separator
					+ "projects" + File.separator + projectName
					+ File.separator + "test-input";
			File objFile = new File(file + File.separator + "Messages.xml");

			String msgName = "";
			String msgVal = "";
			builder = documentBuilderFactory.newDocumentBuilder();
			document = builder.parse(objFile);
			document.getDocumentElement().normalize();
			NodeList nodeList = document.getElementsByTagName("Msg");
			for (int i = 0; i < nodeList.getLength(); i++) {

				msgName = nodeList.item(i).getAttributes().getNamedItem("name")
						.getNodeValue();
				msgVal = nodeList.item(i).getTextContent();

				msgMap.put(msgName, msgVal);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return msgMap;
	}

	public Map<String, TestSuite> getTestSuites(String path, String projectName) {
		Map<String, TestSuite> suiteSet = new HashMap<String, TestSuite>();

		try {
			String file = path + File.separator + "data" + File.separator
					+ "projects" + File.separator + projectName
					+ File.separator + "configs";
			File objFile = new File(file + File.separator + "Suite.xml");
			if (objFile.exists()) {
				builder = documentBuilderFactory.newDocumentBuilder();
				document = builder.parse(objFile);
				document.getDocumentElement().normalize();
				NodeList nodeList = document.getElementsByTagName("Suite");
				TestSuite testSuite = null;
				for (int i = 0; i < nodeList.getLength(); i++) {
					testSuite = new TestSuite();

					NodeList childNode = nodeList.item(i).getChildNodes();
					for (int a = 0; a < childNode.getLength(); a++) {

						if ("urls".equalsIgnoreCase(childNode.item(a)
								.getNodeName())) {
							testSuite
									.setUrl(childNode.item(a).getTextContent());

						} else if ("cats".equalsIgnoreCase(childNode.item(a)
								.getNodeName())) {
							testSuite.setModule(childNode.item(a)
									.getTextContent());
						}
					}
					suiteSet.put(
							nodeList.item(i).getAttributes()
									.getNamedItem("name").getNodeValue(),
							testSuite);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return suiteSet;
	}

	public Map<String, Configuration> getConfigurations(String path,
			String projectName) {
		Map<String, Configuration> suiteSet = new HashMap<String, Configuration>();

		try {
			String file = path + File.separator + "data" + File.separator
					+ "projects" + File.separator + projectName
					+ File.separator + "configs";
			File objFile = new File(file + File.separator
					+ "TestConfiguration.xml");
			if (objFile.exists()) {
				builder = documentBuilderFactory.newDocumentBuilder();
				document = builder.parse(objFile);
				document.getDocumentElement().normalize();
				NodeList nodeList = document.getElementsByTagName("TestConfig");
				Configuration configuration = null;
				for (int i = 0; i < nodeList.getLength(); i++) {

					configuration = new Configuration();

					NodeList childNode = nodeList.item(i).getChildNodes();

					for (int a = 0; a < childNode.getLength(); a++) {
						if ("hostname".equalsIgnoreCase(childNode.item(a)
								.getNodeName())) {
							configuration.setHost(childNode.item(a)
									.getTextContent());

						} else if ("browsertype".equalsIgnoreCase(childNode
								.item(a).getNodeName())) {
							configuration.setBrowserType(childNode.item(a)
									.getTextContent());

						} else if ("browserversion".equalsIgnoreCase(childNode
								.item(a).getNodeName())) {
							configuration.setBrowserVersion(childNode.item(a)
									.getTextContent());
						}

					}

					suiteSet.put(
							nodeList.item(i).getAttributes()
									.getNamedItem("name").getNodeValue(),
							configuration);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return suiteSet;
	}

	public int updateTestSteps(String path, String projectName,
			List<TestSteps> steps, String stepName,
			String repeatCount) {
		try {
			String file = path + File.separator + "data" + File.separator
					+ "projects" + File.separator + projectName
					+ File.separator + "test-input" + File.separator
					+ "TestSteps.xml";
			File testStepsFile = new File(file);

			builder = documentBuilderFactory.newDocumentBuilder();

			if (testStepsFile.exists()) {
				document = builder.parse(testStepsFile);
				document.getDocumentElement().normalize();
			} else {
				document = builder.newDocument();
			}
			Element rootElement = document.getDocumentElement();

			Element stepNameElement = document.createElement("StepName");
			stepNameElement.setAttribute("count", repeatCount);
			stepNameElement.setAttribute("name", stepName);

			for (TestSteps testSteps : steps) {
				Element stepElement = document.createElement("step");
				stepElement.setAttribute("aComponent",
						testSteps.getComponentName());
				stepElement.setAttribute("bAction", testSteps.getActionName());
				stepElement.setAttribute("cExpectedValue",
						testSteps.getMessageName());
				stepNameElement.appendChild(stepElement);
			}

			rootElement.appendChild(stepNameElement);

			transformer = transformerFactory.newTransformer();
			transformer.setOutputProperty(OutputKeys.INDENT, "yes");
			DOMSource source = new DOMSource(document);
			StreamResult result = new StreamResult(testStepsFile);
			transformer.transform(source, result);

			return 0;
		} catch (Exception e) {
			e.printStackTrace();
			return 1;
		}

	}

	public int updateMessageReferenceFile(String path, String projectName,
			 Map<String, String> msgMap) {

		try {

			String file = path + File.separator + "data" + File.separator
					+ "projects" + File.separator + projectName
					+ File.separator + "test-input";
			File objFile = new File(file + File.separator + "Messages.xml");

			// System.out.println(objFile.getAbsolutePath());

			builder = documentBuilderFactory.newDocumentBuilder();

			if (objFile.exists()) {
				document = builder.parse(objFile);
				document.getDocumentElement().normalize();
			} else {
				document = builder.newDocument();
			}

			Element rootElement = document.getDocumentElement();

			Set<Map.Entry<String, String>> msgSet = msgMap.entrySet();

			for (Entry<String, String> entry : msgSet) {
				Element element = document.createElement("Msg");
				element.setAttribute("name", entry.getKey());
				element.setTextContent(entry.getValue());

				rootElement.appendChild(element);
			}

			transformer = transformerFactory.newTransformer();
			transformer.setOutputProperty(OutputKeys.INDENT, "yes");
			DOMSource source = new DOMSource(document);
			StreamResult result = new StreamResult(objFile);
			transformer.transform(source, result);

			return 0;
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		}

	}

	public void createMessagesFile(String path) throws Exception {

		File msgFile = new File(path + File.separator + "Messages.xml");
		if (!msgFile.exists()) {
			builder = documentBuilderFactory.newDocumentBuilder();
			document = builder.newDocument();
			Element rootElement = document.createElement("Messages");
			document.appendChild(rootElement);
			transformer = transformerFactory.newTransformer();
			DOMSource source = new DOMSource(document);
			StreamResult result = new StreamResult(msgFile);
			transformer.transform(source, result);
		}

	}

	public boolean deleteMessagesFile(String path) throws Exception {

		File msgFile = new File(path + File.separator + "Messages.xml");
		if (msgFile.exists())
			return msgFile.delete();
		return false;

	}

	public void createTestDetails(String path) throws Exception {

		File testDetailsFile = new File(path + File.separator
				+ "TestDetails.xml");
		if (!testDetailsFile.exists()) {
			builder = documentBuilderFactory.newDocumentBuilder();
			document = builder.newDocument();
			Element rootElement = document.createElement("TestDetails");
			document.appendChild(rootElement);
			transformer = transformerFactory.newTransformer();
			DOMSource source = new DOMSource(document);
			StreamResult result = new StreamResult(testDetailsFile);
			transformer.transform(source, result);
		}

	}

	public void createTestSteps(String path) throws Exception {

		File testDetailsFile = new File(path + File.separator + "TestSteps.xml");
		if (!testDetailsFile.exists()) {
			builder = documentBuilderFactory.newDocumentBuilder();
			document = builder.newDocument();
			Element rootElement = document.createElement("TestSteps");
			document.appendChild(rootElement);
			transformer = transformerFactory.newTransformer();
			DOMSource source = new DOMSource(document);
			StreamResult result = new StreamResult(testDetailsFile);
			transformer.transform(source, result);
		}

	}

	public void createTestsToLoad(String path, String moduleName)
			throws Exception {

		File testDetailsFile = new File(path + File.separator + moduleName
				+ File.separator + "TestsToLoad.xml");
		if (!testDetailsFile.exists()) {
			builder = documentBuilderFactory.newDocumentBuilder();
			document = builder.newDocument();
			Element rootElement = document.createElement("TestCases");
			document.appendChild(rootElement);
			transformer = transformerFactory.newTransformer();
			DOMSource source = new DOMSource(document);
			StreamResult result = new StreamResult(testDetailsFile);
			transformer.transform(source, result);
		}

	}

	public int createProjects(String path, String projectName) {
		try {
			File projectFile = new File(path + File.separator + "data"
					+ File.separator + "projects" + File.separator
					+ "projects.xml");

			builder = documentBuilderFactory.newDocumentBuilder();
			document = builder.newDocument();

			if (!projectFile.exists()) {
				Element rootElement = document.createElement("projects");
				document.appendChild(rootElement);
				Element cat = document.createElement("proj");
				cat.setTextContent(projectName);
				rootElement.appendChild(cat);
			} else {

				if (getProjects(path).contains(projectName)) {
					createProjectFolder(path, projectName);
					return 1;// duplicate
				}

				document = builder.parse(projectFile);
				document.getDocumentElement().normalize();

				Element cat = document.createElement("proj");
				cat.setTextContent(projectName);
				document.getDocumentElement().appendChild(cat);

			}

			transformer = transformerFactory.newTransformer();
			DOMSource source = new DOMSource(document);
			StreamResult result = new StreamResult(projectFile);
			transformer.transform(source, result);
			createProjectFolder(path, projectName);
			return 0;
		} catch (Exception e) {
			e.printStackTrace();
			return -1;

		}
	}

	public int updateTestCasesFiles(String path, String projectName,
			String moduleName, List<String> testSteps, String testcase_name) {

		try {

			String file = path + File.separator + "data" + File.separator
					+ "projects" + File.separator + projectName
					+ File.separator + "test-input";
			File detailsFile = new File(file + File.separator
					+ "TestDetails.xml");

			File testsToLoad = new File(file + File.separator + moduleName
					+ File.separator + "TestsToLoad.xml");

			// and updata TestsToLoad.xml file with Test Case name
			updateTestsToLoad(testcase_name, testsToLoad);

			// add testSteps to TestDetails.xml
			updateTestDetails(testcase_name, testSteps, detailsFile);
			return 0;
		} catch (Exception e) {
			return -1;
		}
	}

	public Set<String> getCategories(String path, String project) {
		Set<String> categories = new HashSet<String>();
		try {

			DocumentBuilder builder = documentBuilderFactory
					.newDocumentBuilder();
			Document document = builder.newDocument();

			File file = new File(path + File.separator + "data"
					+ File.separator + "projects" + File.separator + project
					+ File.separator + "test-input" + File.separator
					+ "Categories.xml");
			if (file.exists()) {
				document = builder.parse(file);
				document.getDocumentElement().normalize();
				NodeList nodeList = document.getElementsByTagName("cat");
				for (int i = 0; i < nodeList.getLength(); i++) {
					categories
							.add((((Node) nodeList.item(i)).getTextContent()));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return categories;
	}

	public Map<String, Set<String>> getCategoriesTestList(String path,
			String project) {
		Map<String, Set<String>> categories = new HashMap<String, Set<String>>();
		try {

			DocumentBuilder builder = documentBuilderFactory
					.newDocumentBuilder();
			Document document = builder.newDocument();

			File file = new File(path + File.separator + "data"
					+ File.separator + "projects" + File.separator + project
					+ File.separator + "test-input" + File.separator
					+ "Categories.xml");
			if (file.exists()) {
				document = builder.parse(file);
				document.getDocumentElement().normalize();
				NodeList nodeList = document.getElementsByTagName("cat");
				for (int i = 0; i < nodeList.getLength(); i++) {
					categories.put(
							(((Node) nodeList.item(i)).getTextContent()),
							new HashSet<String>());
				}
				Set<Entry<String, Set<String>>> s = categories.entrySet();

				for (Entry<String, Set<String>> entry : s) {

					addTestToLoad(path, project, entry.getKey(),
							entry.getValue());
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return categories;
	}

	public void addTestToLoad(String path, String project, String category,
			Set<String> testSet) {

		try {
			File testFile = new File(path + File.separator + "data"
					+ File.separator + "projects" + File.separator + project
					+ File.separator + "test-input" + File.separator + category
					+ File.separator + "TestsToLoad.xml");

			builder = documentBuilderFactory.newDocumentBuilder();
			document = builder.parse(testFile);
			document.getDocumentElement().normalize();
			NodeList nodeList = document.getElementsByTagName("Test");
			for (int i = 0; i < nodeList.getLength(); i++) {
				testSet.add((((Node) nodeList.item(i)).getTextContent()));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public int updateTestSuiteInfo(String path, String projectName,
			String suiteName, List<TestSuite> testSuites) {

		try {

			String file = path + File.separator + "data" + File.separator
					+ "projects" + File.separator + projectName
					+ File.separator + "configs";

			File suiteFolder = new File(file + File.separator + suiteName);
			if (!suiteFolder.exists()) {
				suiteFolder.mkdirs();
			}

			String urls = "";
			String cat = "";
			for (TestSuite testSuite : testSuites) {

				urls += "," + testSuite.getUrl();
				cat += "," + testSuite.getModule();
			}

			File suiteFile = new File(file + File.separator + "Suite.xml");

			builder = documentBuilderFactory.newDocumentBuilder();
			Element rootElement = null;
			if (suiteFile.exists()) {
				document = builder.parse(suiteFile);
				document.getDocumentElement().normalize();
				rootElement = document.getDocumentElement();
			} else {
				document = builder.newDocument();
				rootElement = document.createElement("Suites");
				document.appendChild(rootElement);
			}

			Element suite = document.createElement("Suite");
			suite.setAttribute("name", suiteName);
			rootElement.appendChild(suite);

			Element url = document.createElement("urls");
			url.setTextContent(urls.substring(1));
			suite.appendChild(url);

			Element cats = document.createElement("cats");
			cats.setTextContent(cat.substring(1));
			suite.appendChild(cats);

			rootElement.appendChild(suite);

			transformer = transformerFactory.newTransformer();
			transformer.setOutputProperty(OutputKeys.INDENT, "yes");
			DOMSource source = new DOMSource(document);
			StreamResult result = new StreamResult(suiteFile);
			transformer.transform(source, result);
			return createSuiteFolder(path, projectName, suiteName, testSuites);

		} catch (Exception e) {

			e.printStackTrace();
			return -1;
		}

	}

	public int createSuiteFolder(String path, String projectName,
			String suiteName, List<TestSuite> testSuites) {

		try {

			File suiteDir = new File(path + File.separator + "data"
					+ File.separator + "projects" + File.separator
					+ projectName + File.separator + "configs" + File.separator
					+ suiteName);

			if (!suiteDir.exists()) {
				suiteDir.mkdir();
			}

			for (TestSuite testSuite : testSuites) {

				File testSuiteXML = new File(path + File.separator + "data"
						+ File.separator + "projects" + File.separator
						+ projectName + File.separator + "configs"
						+ File.separator + suiteName + File.separator
						+ suiteName + "_" + testSuite.getModule() + ".xml");

				DocumentBuilder builder = documentBuilderFactory
						.newDocumentBuilder();
				Document document = builder.newDocument();

				Element rootElement = document.createElement("TestCases");
				document.appendChild(rootElement);

				String[] testCases = testSuite.getTestCases();

				for (String testCase : testCases) {
					Element testCaseElement = document.createElement("Test");

					testCaseElement.appendChild(document
							.createTextNode(testCase));
					rootElement.appendChild(testCaseElement);
				}

				transformer = transformerFactory.newTransformer();
				transformer.setOutputProperty(OutputKeys.INDENT, "yes");
				DOMSource source = new DOMSource(document);
				StreamResult result = new StreamResult(testSuiteXML);
				transformer.transform(source, result);
			}
			return 0;
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		}

	}

	public List<String> getTestSteps(String path, String projectName) {
		List<String> objMap = new ArrayList<String>();

		try {
			String file = path + File.separator + "data" + File.separator
					+ "projects" + File.separator + projectName
					+ File.separator + "test-input" + File.separator
					+ "TestSteps.xml";
			File objFile = new File(file);

			String objName = "";

			builder = documentBuilderFactory.newDocumentBuilder();
			document = builder.parse(objFile);
			document.getDocumentElement().normalize();
			NodeList nodeList = document.getElementsByTagName("StepName");
			for (int i = 0; i < nodeList.getLength(); i++) {

				objName = nodeList.item(i).getAttributes().getNamedItem("name")
						.getNodeValue();

				objMap.add(objName);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return objMap;
	}

	public Set<String> getTestCases(String path, String project, String module) {
		Set<String> testCases = new HashSet<String>();

		try {
			String file = path + File.separator + "data" + File.separator
					+ "projects" + File.separator + project + File.separator
					+ "test-input" + File.separator + module + File.separator
					+ "TestsToLoad.xml";
			File objFile = new File(file);

			builder = documentBuilderFactory.newDocumentBuilder();
			document = builder.parse(objFile);
			document.getDocumentElement().normalize();
			NodeList nodeList = document.getElementsByTagName("Test");
			for (int i = 0; i < nodeList.getLength(); i++) {
				testCases.add(nodeList.item(i).getTextContent());
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return testCases;
	}

	public List<String> getSelCaseSteps(String path, String project,
			String module, String testCase) {
		List<String> testCases = new ArrayList<String>();

		try {
			String file = path + File.separator + "data" + File.separator
					+ "projects" + File.separator + project + File.separator
					+ "test-input" + File.separator + "TestDetails.xml";
			File objFile = new File(file);

			builder = documentBuilderFactory.newDocumentBuilder();
			document = builder.parse(objFile);
			document.getDocumentElement().normalize();
			NodeList nodeList = document.getElementsByTagName("Test");
			for (int i = 0; i < nodeList.getLength(); i++) {
				String caseName = nodeList.item(i).getAttributes()
						.getNamedItem("name").getNodeValue();
				if (caseName.equals(testCase)) {

					Node node = nodeList.item(i);
					if (node.getNodeType() == Node.ELEMENT_NODE) {
						Element element = (Element) node;
						NodeList snodelist = element
								.getElementsByTagName("Step");
						for (int j = 0; j < snodelist.getLength(); j++) {
							testCases.add(snodelist.item(j).getTextContent());
						}
					}
					break;
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return testCases;
	}

	public Map<String, Object> getTestSteps(String path, String projectName,
			String moduleName, String stepName) {

		Map<String, Object> objMap = new HashMap<String, Object>();

		try {
			String file = path + File.separator + "data" + File.separator
					+ "projects" + File.separator + projectName
					+ File.separator + "test-input" + File.separator
					+ "TestSteps.xml";
			File objFile = new File(file);
			String objName = "";

			String stepcount = "";

			List<TestSteps> stepsData = new ArrayList<TestSteps>();

			builder = documentBuilderFactory.newDocumentBuilder();
			document = builder.parse(objFile);
			document.getDocumentElement().normalize();
			NodeList nodeList = document.getElementsByTagName("StepName");

			for (int i = 0; i < nodeList.getLength(); i++) {
				objName = nodeList.item(i).getAttributes().getNamedItem("name")
						.getNodeValue();

				if (objName.equals(stepName)) {
					stepcount = nodeList.item(i).getAttributes()
							.getNamedItem("count").getNodeValue();
					Node node = nodeList.item(i);
					if (node.getNodeType() == Node.ELEMENT_NODE) {
						Element element = (Element) node;
						NodeList snodelist = element
								.getElementsByTagName("step");
						for (int j = 0; j < snodelist.getLength(); j++) {
							TestSteps data = new TestSteps();
							data.setComponentName(snodelist.item(j)
									.getAttributes().getNamedItem("aComponent")
									.getNodeValue());
							data.setActionName(snodelist.item(j)
									.getAttributes().getNamedItem("bAction")
									.getNodeValue());
							data.setMessageName(snodelist.item(j)
									.getAttributes()
									.getNamedItem("cExpectedValue")
									.getNodeValue());
							stepsData.add(data);
						}
					}
					objMap.put("count", stepcount);
					break;
				}

			}

			objMap.put("name", stepName);
			objMap.put("data", stepsData);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return objMap;
	}

	public Set<String> getProjects(String path) {
		Set<String> projects = new HashSet<String>();
		try {

			DocumentBuilder builder = documentBuilderFactory
					.newDocumentBuilder();
			Document document = builder.newDocument();

			File projectFile = new File(path + File.separator + "data"
					+ File.separator + "projects" + File.separator
					+ "projects.xml");

			if (!projectFile.exists()) {
				return projects;
			}

			document = builder.parse(projectFile);
			document.getDocumentElement().normalize();
			NodeList nodeList = document.getElementsByTagName("proj");
			for (int i = 0; i < nodeList.getLength(); i++) {
				projects.add((((Node) nodeList.item(i)).getTextContent()));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return projects;
	}

	public Set<String> getActionList(String path) {
		Set<String> actionItems = new HashSet<String>();

		try {

			builder = documentBuilderFactory.newDocumentBuilder();

			File actionsFile = new File(path + File.separator + "data"
					+ File.separator + "projects" + File.separator
					+ "ActionList.xml");

			document = builder.parse(actionsFile);
			document.getDocumentElement().normalize();
			NodeList nodeList = document.getElementsByTagName("Action");
			for (int i = 0; i < nodeList.getLength(); i++) {
				actionItems.add(((Node) nodeList.item(i)).getTextContent());
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return actionItems;
	}

	public Set<String> getComponentList(String path) {
		Set<String> compList = new HashSet<String>();

		try {

			builder = documentBuilderFactory.newDocumentBuilder();

			File actionsFile = new File(path + File.separator + "data"
					+ File.separator + "projects" + File.separator
					+ "CompTypeList.xml");

			document = builder.parse(actionsFile);
			document.getDocumentElement().normalize();
			NodeList nodeList = document.getElementsByTagName("CompType");
			for (int i = 0; i < nodeList.getLength(); i++) {
				compList.add(((Node) nodeList.item(i)).getTextContent());
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return compList;
	}

	public void removeTestStepNode(String path, String project,
			String moduleName, String value) {
		String filepath = path + File.separator + "data" + File.separator
				+ "projects" + File.separator + project + File.separator
				+ "test-input" + File.separator + "TestSteps.xml";
		removeNode(filepath, "StepName", "name", value);

	}

	private void removeNode(String filepath, String tag, String attribute,
			String value) {
		try {

			DocumentBuilderFactory docFactory = DocumentBuilderFactory
					.newInstance();
			DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
			Document doc = docBuilder.parse(filepath);

			String objName;
			List<Node> lstnodes = new ArrayList<Node>();
			NodeList nodeList = doc.getElementsByTagName(tag);

			for (int i = 0; i < nodeList.getLength(); i++) {
				objName = nodeList.item(i).getAttributes()
						.getNamedItem(attribute).getNodeValue();
				Node node = nodeList.item(i);
				// System.out.println("StepName :" + objName);
				if (objName.equals(value)) {
					lstnodes.add(node);
					// break;
				}
			}
			for (Node node : lstnodes) {
				Node parent = node.getParentNode();
				parent.removeChild(node);
			}
			// write the content into xml file
			TransformerFactory transformerFactory = TransformerFactory
					.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			DOMSource source = new DOMSource(doc);
			StreamResult result = new StreamResult(new File(filepath));
			transformer.transform(source, result);
			// System.out.println("Done");
		} catch (ParserConfigurationException pce) {
			pce.printStackTrace();
		} catch (TransformerException tfe) {
			tfe.printStackTrace();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		} catch (SAXException sae) {
			sae.printStackTrace();
		}
	}

	public void prepareTestNGSuite(String realPath, String projectName,
			TestSuite testSuite, Configuration configuration, String suiteName,
			String configName, List<String> suiteFilesList,
			List<String> reportList) {

		try {
			String suiteFile = realPath + File.separator + "data"
					+ File.separator + "projects" + File.separator
					+ projectName + File.separator + "configs" + File.separator
					+ suiteName + File.separator + suiteName + "_" + configName
					+ "_" + configuration.getHost() + ".xml";

			reportList.add(suiteName + "_" + configName + "_"
					+ configuration.getHost());
			builder = documentBuilderFactory.newDocumentBuilder();
			document = builder.newDocument();
			Element rootElement = document.createElement("suite");
			rootElement.setAttribute("name", suiteName + "_" + configName + "_"
					+ configuration.getHost());
			rootElement.setAttribute("parallel", "false");

			document.appendChild(rootElement);

			Element projectPath = document.createElement("parameter");
			projectPath.setAttribute("name", "path");
			projectPath.setAttribute("value", realPath);
			rootElement.appendChild(projectPath);

			Element project = document.createElement("parameter");
			project.setAttribute("name", "project");
			project.setAttribute("value", projectName);
			rootElement.appendChild(project);

			Element hostname = document.createElement("parameter");
			hostname.setAttribute("name", "hostname");
			hostname.setAttribute("value", configuration.getHost());
			rootElement.appendChild(hostname);

			Element module = document.createElement("parameter");
			module.setAttribute("name", "module");
			module.setAttribute("value", testSuite.getModule());
			rootElement.appendChild(module);

			Element browser = document.createElement("parameter");
			browser.setAttribute("name", "Browser");
			browser.setAttribute("value", configuration.getBrowserType());
			rootElement.appendChild(browser);

			Element url = document.createElement("parameter");
			url.setAttribute("name", "URL");
			url.setAttribute("value", testSuite.getUrl());
			rootElement.appendChild(url);

			Element Suitename = document.createElement("parameter");
			Suitename.setAttribute("name", "Suitename");
			Suitename.setAttribute("value", suiteName);
			rootElement.appendChild(Suitename);

			
			 * Element listerners = document.createElement("listeners");
			 * rootElement.appendChild(listerners); Element listerner =
			 * document.createElement("listener");
			 * 
			 * listerner.setAttribute("class-name",
			 * "automation.scripts.ReportGenerator");
			 * listerners.appendChild(listerner);
			 

			Element test = document.createElement("test");

			test.setAttribute("name", suiteName + "_" + configName);
			rootElement.appendChild(test);

			Element classes = document.createElement("classes");
			test.appendChild(classes);

			Element class1 = document.createElement("class");
			class1.setAttribute("name", "automation.scripts.Components");
			classes.appendChild(class1);

			Element class2 = document.createElement("class");
			class2.setAttribute("name", "automation.scripts.TestDriver");
			classes.appendChild(class2);

			transformer = transformerFactory.newTransformer();
			DOMSource source = new DOMSource(document);
			transformer.setOutputProperty(OutputKeys.INDENT, "yes");
			StreamResult result = new StreamResult(suiteFile);
			transformer.transform(source, result);
			suiteFilesList.add(suiteFile);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public int updateTestsToLoad(String Testcase, File file) throws Exception {

		try {
			builder = documentBuilderFactory.newDocumentBuilder();
			if (file.exists()) {
				document = builder.parse(file);
				document.getDocumentElement().normalize();
			} else {
				document = builder.newDocument();
			}

			Element rootElement = document.getDocumentElement();

			NodeList tagsNodeList = document.getElementsByTagName("Test");

			for (int i = 0; i < tagsNodeList.getLength(); i++) {
				Node childNode = tagsNodeList.item(i);
				String str = childNode.getTextContent();
				if (str.compareToIgnoreCase(Testcase) == 0) {
					// remove node if exists
					Node parent = childNode.getParentNode();
					parent.removeChild(childNode);

				}
			}

			Element element = document.createElement("Test");
			element.setTextContent(Testcase);
			rootElement.appendChild(element);

			transformer = transformerFactory.newTransformer();
			transformer.setOutputProperty(OutputKeys.INDENT, "yes");
			DOMSource source = new DOMSource(document);
			StreamResult result = new StreamResult(file);
			transformer.transform(source, result);

			return 0;
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		}
	}

	public int updateTestDetails(String Name, List<String> Steps, File file)
			throws Exception {
		try {
			builder = documentBuilderFactory.newDocumentBuilder();
			if (file.exists()) {
				document = builder.parse(file);
				document.getDocumentElement().normalize();
			} else {
				document = builder.newDocument();
			}

			Element rootElement = document.getDocumentElement();

			NodeList tagsNodeList = document.getElementsByTagName("Test");
			for (int i = 0; i < tagsNodeList.getLength(); i++) {
				Node childNode = tagsNodeList.item(i);
				String str = tagsNodeList.item(i).getAttributes()
						.getNamedItem("name").getNodeValue();
				if (str.equalsIgnoreCase(Name)) {
					Node parent = childNode.getParentNode();
					parent.removeChild(childNode);
				}
			}

			Element Test = document.createElement("Test");
			Test.setAttribute("name", Name);

			for (String step : Steps) {
				Element Step1 = document.createElement("Step");
				Step1.setTextContent(step);
				Test.appendChild(Step1);
			}

			rootElement.appendChild(Test);

			transformer = transformerFactory.newTransformer();
			transformer.setOutputProperty(OutputKeys.INDENT, "yes");
			DOMSource source = new DOMSource(document);
			StreamResult result = new StreamResult(file);
			transformer.transform(source, result);

			return 0;
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		}
	}

	public List<String> getProjectFiles(String path, String project,
			String moduleName) {

		List<String> prjfiles = new ArrayList<String>();
		try {

			File moduleDir = new File(path + File.separator + "data"
					+ File.separator + "projects" + File.separator + project
					+ File.separator + "test-input");
			File tfiles[] = moduleDir.listFiles();
			for (File file : tfiles) {
				if (file.isFile())
					prjfiles.add(file.getName());
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return prjfiles;
	}

	public List<String> getModuleFiles(String path, String project,
			String moduleName) {
		List<String> datafiles = new ArrayList<String>();

		try {

			File moduleDir = new File(path + File.separator + "data"
					+ File.separator + "projects" + File.separator + project
					+ File.separator + "test-input" + File.separator
					+ moduleName);
			File tfiles[] = moduleDir.listFiles();
			for (File file : tfiles) {
				if (file.isFile())
					datafiles.add(file.getName());
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return datafiles;
	}

	

	public String getFileData(String path, String project, String moduleName,
			String fname, String dir) {

		String filedata = "";
		String mpath = "";
		if (dir.equals("mod")) {
			mpath = File.separator + moduleName;
		}

		File reqFile = new File(path + File.separator + "data" + File.separator
				+ "projects" + File.separator + project + File.separator
				+ "test-input" + mpath + File.separator + fname);

		try {
			ByteArrayOutputStream byteStream = new ByteArrayOutputStream();
			InputStream input = new FileInputStream(reqFile);

			byte[] dataBuffer = new byte[4096];
			int numberBytes = 0;
			while ((numberBytes = input.read(dataBuffer, 0, 4096)) != -1) {
				byteStream.write(dataBuffer, 0, numberBytes);
			}
			filedata = new String(byteStream.toByteArray());
			input.close();
		} catch (IOException e) {
			return null;
		}
		return filedata;
	}

	public int setFileData(String path, String project, String moduleName,
			String fname, String data, String dir) {
		String mpath = "";
		if (dir.equals("mod")) {
			mpath = File.separator + moduleName;
		}

		File reqFile = new File(path + File.separator + "data" + File.separator
				+ "projects" + File.separator + project + File.separator
				+ "test-input" + mpath + File.separator + fname);
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter(reqFile,
					false));
			bw.write(data);
			bw.newLine();
			bw.close();
			return 0;
		} catch (Exception e) {
			return -1;
		}
	}

*/}
