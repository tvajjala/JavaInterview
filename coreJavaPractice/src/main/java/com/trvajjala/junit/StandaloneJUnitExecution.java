package com.trvajjala.junit;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import com.trvajjala.unit.testing.JunitAnnotations;

public class StandaloneJUnitExecution {

	public static void main(String[] args) {
		// this will run jUnit test cases but need to have all testCase classes
		// in the ClassPath
		Result result = JUnitCore.runClasses(JunitAnnotations.class);
		for (Failure failure : result.getFailures()) {
			System.out.println(failure.toString());
		}
	}
}
