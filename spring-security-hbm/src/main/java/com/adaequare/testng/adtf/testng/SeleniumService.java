package com.adaequare.testng.adtf.testng;

import java.io.File;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.adaequare.testng.adtf.testng.beans.Configuration;
import com.adaequare.testng.adtf.testng.beans.TestSteps;
import com.adaequare.testng.adtf.testng.beans.TestSuite;

public abstract class SeleniumService {

	
	private String path;

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public int createCategory(String project, String categoryName) {
		// TODO Auto-generated method stub
		return 0;
	}

	public void createProjectFolder(String projectName) {
		// TODO Auto-generated method stub
		
	}

	public void createModuleFolder(String project, String moduleName) {
		// TODO Auto-generated method stub
		
	}

	public void createObjectReferencesFile(String xmlFilePath) throws Exception {
		// TODO Auto-generated method stub
		
	}

	public boolean deleteObjectReferencesFile(String xmlFilePath)
			throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	public int updateObjectReferecesFile(String projectName,
			Map<String, String> objmap) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int updateTestConfiguration(String projectName, String configName,
			String host, String port, String browser, String bVersion) {
		// TODO Auto-generated method stub
		return 0;
	}

	public Map<String, String> getObjectReferences(String projectName) {
		// TODO Auto-generated method stub
		return null;
	}

	public Map<String, String> getMessageInfo(String projectName) {
		// TODO Auto-generated method stub
		return null;
	}

	public Map<String, TestSuite> getTestSuites(String projectName) {
		// TODO Auto-generated method stub
		return null;
	}

	public Map<String, Configuration> getConfigurations(String projectName) {
		// TODO Auto-generated method stub
		return null;
	}

	public int updateTestSteps(String projectName, List<TestSteps> steps,
			String stepName, String repeatCount) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int updateMessageReferenceFile(String projectName,
			Map<String, String> msgMap) {
		// TODO Auto-generated method stub
		return 0;
	}

	public void createMessagesFile(String path) throws Exception {
		// TODO Auto-generated method stub
		
	}

	public boolean deleteMessagesFile(String path) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	public void createTestDetails(String path) throws Exception {
		// TODO Auto-generated method stub
		
	}

	public void createTestSteps(String path) throws Exception {
		// TODO Auto-generated method stub
		
	}

	public void createTestsToLoad(String path, String moduleName)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

	public int createProjects(String projectName) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int updateTestCasesFiles(String path, String projectName,
			String moduleName, List<String> testSteps, String testcase_name) {
		// TODO Auto-generated method stub
		return 0;
	}

	public Set<String> getCategories(String path, String project) {
		// TODO Auto-generated method stub
		return null;
	}

	public Map<String, Set<String>> getCategoriesTestList(String project) {
		// TODO Auto-generated method stub
		return null;
	}

	public void addTestToLoad(String project, String category,
			Set<String> testSet) {
		// TODO Auto-generated method stub
		
	}

	public int updateTestSuiteInfo(String projectName, String suiteName,
			List<TestSuite> testSuites) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int createSuiteFolder(String projectName, String suiteName,
			List<TestSuite> testSuites) {
		// TODO Auto-generated method stub
		return 0;
	}

	public List<String> getTestSteps(String projectName) {
		// TODO Auto-generated method stub
		return null;
	}

	public Set<String> getTestCases(String project, String module) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<String> getSelCaseSteps(String project, String module,
			String testCase) {
		// TODO Auto-generated method stub
		return null;
	}

	public Map<String, Object> getTestSteps(String projectName,
			String moduleName, String stepName) {
		// TODO Auto-generated method stub
		return null;
	}

	public Set<String> getProjects() {
		// TODO Auto-generated method stub
		return null;
	}

	public Set<String> getActionList() {
		// TODO Auto-generated method stub
		return null;
	}

	public Set<String> getComponentList() {
		// TODO Auto-generated method stub
		return null;
	}

	public void removeTestStepNode( String project,
			String moduleName, String value) {
		// TODO Auto-generated method stub
		
	}

	public void prepareTestNGSuite(String projectName, TestSuite testSuite,
			Configuration configuration, String suiteName, String configName,
			List<String> suiteFilesList, List<String> reportList) {
		// TODO Auto-generated method stub
		
	}

	public int updateTestsToLoad(String Testcase, File file) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	public int updateTestDetails(String Name, List<String> Steps, File file)
			throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	public List<String> getProjectFiles(String project, String moduleName) {
		// TODO Auto-generated method stub
		return null;
	}

	public int setFileData(String project, String moduleName, String fname,
			String data, String dir) {
		// TODO Auto-generated method stub
		return 0;
	}

	public String getFileData(String project, String moduleName, String fname,
			String dir) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<String> getModuleFiles(String project, String moduleName) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
