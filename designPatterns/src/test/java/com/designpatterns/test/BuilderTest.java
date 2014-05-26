package com.designpatterns.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.designpatterns.builder.Cake;

public class BuilderTest {

	@Test
	public void builderInstanceTest() {
		// PROS : more maintainable if number of fields required to create
		// object is more than 4 or 5.

		// CONS: verbose and code duplication as Builder needs to copy all
		// fields from Original or Item class.

		Cake cake = new Cake.Builder().sugar(12.4).butter(45.33).build();

		assertNotNull(cake);
	}

}
