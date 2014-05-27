package com.jersey.test;

import org.glassfish.jersey.test.JerseyTest;
import org.glassfish.jersey.test.grizzly.GrizzlyWebTestContainerFactory;
import org.glassfish.jersey.test.spi.TestContainerFactory;
import org.junit.Test;

import com.sun.jersey.api.core.ClassNamesResourceConfig;
import com.sun.jersey.spi.container.servlet.WebComponent;


public class RestResourceTest extends JerseyTest{

	@Test
	public void test() {
		
	}
	
	@Override
    public TestContainerFactory getTestContainerFactory() {
        return new GrizzlyWebTestContainerFactory();
    }
	
/*	@Override
    public WebAppDescriptor configure() {
        return new WebAppDescriptor.Builder()
            	.initParam(WebComponent.RESOURCE_CONFIG_CLASS,
                      ClassNamesResourceConfig.class.getName())
                .initParam(
                      ClassNamesResourceConfig.PROPERTY_CLASSNAMES,
                      TodoResource.class.getName() + ";"
                              + MockTodoServiceProvider.class.getName() + ";"
                              + NotFoundMapper.class.getName()).build();
    }*/

}
