package com.adaequare.testng.adtf.testng.beans;

import java.io.Serializable;

public class TestSteps implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -337322855309623042L;
	private String componentName;
	private String actionName;
	private String messageName;

	public String getComponentName() {
		return componentName;
	}

	public void setComponentName(String componentName) {
		this.componentName = componentName;
	}

	public String getActionName() {
		return actionName;
	}

	public void setActionName(String actionName) {
		this.actionName = actionName;
	}

	public String getMessageName() {
		return messageName;
	}

	public void setMessageName(String messageName) {
		this.messageName = messageName;
	}

}
