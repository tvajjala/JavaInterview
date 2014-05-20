package com.lyris.proto.test;

import java.util.HashSet;
import java.util.Set;

import org.junit.After;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.hazelcast.core.IMap;
import com.lyris.proto.model.Organization;
import static org.junit.Assert.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class HazelMongoPersitenceTest {

	ApplicationContext applicationContext;

	@Before
	public void setUp() throws Exception {
		applicationContext = new GenericXmlApplicationContext(
				"applicationContext.xml");
	}

	@After
	public void tearDown() throws Exception {
		applicationContext = null;
	}

	@Test
	public void b_storeTest() {

		Organization organization = new Organization();
		organization.setOrgId("ONE");
		organization.setOrgName("Lyris");
		organization.setContactPersonEmailAddress("kkumar@lyris.com");
		organization.setContactPersonName("kranthi");
		organization.setOrgDbName("myorg");
		organization.setParentOrgId("myParentOrgId");
		IMap<String, Object> map = (IMap) applicationContext.getBean("orgmap");

		assertNull(map.put("ONE", organization));// success if new entry

	}

	@Test
	public void c_deleteTest() {
		IMap<String, Object> map = (IMap) applicationContext.getBean("orgmap");
		assertNotNull(map.remove("ONE")); // success if entry exists and removed
											// from DB
	}

	@Test
	public void d_storeAllTest() {

		Organization organization = new Organization();
		organization.setOrgId("ONE");
		organization.setOrgName("Lyris");
		organization.setContactPersonEmailAddress("kkumar@lyris.com");
		organization.setContactPersonName("kranthi");
		organization.setOrgDbName("myorg");
		organization.setParentOrgId("myParentOrgId");
		IMap<String, Object> map = (IMap) applicationContext.getBean("orgmap");

		assertNull(map.put("ONE", organization));
		assertNull(map.put("TWO", organization));
		assertNull(map.put("THREE", organization));
		assertNull(map.put("FOUR", organization));

	}

	@Test
	public void e_loadTest() {
		IMap<String, Object> map = (IMap) applicationContext.getBean("orgmap");

		Set<String> set = new HashSet<String>();

		set.add("TWO");
		set.add("ONE");
		set.add("THREE");
		set.add("FOUR");

		int size = map.getAll(set).size();

		assertTrue(4 == size);// success if all entry available and loaded

	}

	@Test
	public void a_deleteAllTest() {

		IMap<String, Object> map = (IMap) applicationContext.getBean("orgmap");

		map.clear();

		assertTrue(map.isEmpty());// clean db

	}

}
