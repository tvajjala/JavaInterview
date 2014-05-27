package com.trvajjala.unit.testing;

import junit.framework.Assert;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.trvajjala.junit.UnitTestExample;
import com.trvajjala.regex.RegularExpression;

public class JunitAnnotations {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test(timeout = 100, expected = NullPointerException.class)
	public void nullPointerCheck() {

		UnitTestExample.checkException();

	}

}
