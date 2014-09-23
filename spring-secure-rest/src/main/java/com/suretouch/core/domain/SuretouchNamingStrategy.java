package com.suretouch.core.domain;

import org.hibernate.annotations.common.util.StringHelper;
import org.hibernate.cfg.ImprovedNamingStrategy;

public class SuretouchNamingStrategy extends ImprovedNamingStrategy {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5118322121741445924L;
	
	/**
     * Transforms class names to table names by using the described naming conventions.
     * @param className
     * @return  The constructed table name.
     */
    @Override
    public String classToTableName(String className) {
	   	return addUnderscoredAndCovertToUppercase("ST_" +StringHelper.unqualify(className));
    }
 
    @Override
    public String tableName(String tableName) {
    	
    	return addUnderscoredAndCovertToUppercase(tableName);
    	
    }

	protected String addUnderscoredAndCovertToUppercase(String name) {
		
		return addUnderscores(name).toLowerCase();
	}
}
