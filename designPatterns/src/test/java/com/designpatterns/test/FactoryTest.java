package com.designpatterns.test;

import org.junit.Assert;
import org.junit.Test;

import com.designpatterns.factory.Currency;
import com.designpatterns.factory.CurrencyFactory;

public class FactoryTest {

	@Test
	public void currencySymbolTest() {

		Currency currency = CurrencyFactory.getCurrency("IN");

		Assert.assertEquals("INR", currency.getSymbol());

		currency = CurrencyFactory.getCurrency("US");

		Assert.assertEquals("$", currency.getSymbol());

		currency = CurrencyFactory.getCurrency("JP");

		Assert.assertNull(currency);
	}
}
