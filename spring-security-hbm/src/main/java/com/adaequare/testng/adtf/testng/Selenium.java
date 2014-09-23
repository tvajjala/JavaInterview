package com.adaequare.testng.adtf.testng;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

public class Selenium {/*

    public SeleniumService seleniumService;
    WebApplicationContext context;

    public SeleniumService getService(String serviceType, HttpServletRequest request) {

        if (context == null) {
            context = WebApplicationContextUtils.getRequiredWebApplicationContext(request.getServletContext());
        }

        if (serviceType.equalsIgnoreCase("XML")) {

            seleniumService = (SeleniumService) context.getBean("xmlSeleniumService");
        } else {
            seleniumService = (SeleniumService) context.getBean("ormSeleniumService");
        }
        seleniumService.setPath(request.getSession().getServletContext().getRealPath(""));
        return seleniumService;
    }
*/}
