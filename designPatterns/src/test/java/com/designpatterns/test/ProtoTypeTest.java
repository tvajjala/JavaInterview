package com.designpatterns.test;

import org.junit.Assert;
import org.junit.Test;

import com.designpatterns.prototype.Bike;
import com.designpatterns.prototype.NoBikeAvailableException;
import com.designpatterns.prototype.WorkShop;

public class ProtoTypeTest {

	@Test
	public void basicModelTest() {
		WorkShop workShop=new WorkShop(new Bike());
		
		Bike bike=  workShop.getBasicModel();
		
		Assert.assertEquals("basic model type not correct", "SZ", bike.getBikeType()); 
		Assert.assertEquals("basic model price wrong", "60,000", bike.getPrice());
		
	}

	@Test
	public void advanceModelTest() throws NoBikeAvailableException{

		WorkShop workShop=new WorkShop(new Bike());
		Bike bike=  workShop.getAdvancedModel();
		
		Assert.assertEquals("advanced model type not correct", "SZ-R", bike.getBikeType()); 
		Assert.assertEquals("advanced model price wrong", "63,000", bike.getPrice());
		
	}
}
