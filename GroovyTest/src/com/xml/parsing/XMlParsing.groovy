package com.xml.parsing

class XMlParsing {


	


	public Person tranform(){
		
		def  dataset=new XmlSlurper().parse(ClassLoader.getSystemResourceAsStream("dataset.xml"));
		
		
		
	}
}
