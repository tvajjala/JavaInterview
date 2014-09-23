package automation.scripts;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.apache.log4j.Logger;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;


public class SAXXMLTransformation {

	static public Logger logger = Logger.getRootLogger();

   static ArrayList<String> Testlist = new ArrayList<String>();
	static ArrayList<String> testdetails = new ArrayList<String>();
	static ArrayList<String> steplist = new ArrayList<String>();
	 
     static String[][] sortedArray = new String[3000][3000];
	 private static String[] sortedarray2 = new String[2000];
	 private static String[][] sortedarray3 = new String[2000][2000];
	 
	static String testcasename = "";


   static String teststepname = "";
	
	    public static String Testcase = "";
		public static String[] parseTestDetails(String TestDetails, String testcase)
        throws SAXException, IOException, ParserConfigurationException {


		
		File file = new File(TestDetails);
		Testcase = testcase;
		try {
		//	System.out.println("inside SAX test detail TRY");
		
			SAXParserFactory factory = SAXParserFactory.newInstance();
			SAXParser saxParser = factory.newSAXParser();
			testdetails.removeAll(testdetails);
			DefaultHandler handler = new DefaultHandler() {
			
			    
				boolean step = false;
				public void startElement(String uri, String localName,String qName, 
		                Attributes attributes) throws SAXException {
					logger.info("inside SAX test detail - default handler class.."+qName);				

				if(qName.equals("Test")){
						testcasename = "";
					}
					
					for(int i=0;i<attributes.getLength();i++){
						String attr = attributes.getValue(i);
						
						if(attr.equalsIgnoreCase(Testcase)){       //hardcode the testcase name
							testcasename=attr;
						}
					}
					
					if(testcasename.equals(Testcase)){                 //hardcode the testcase name
						if(qName.equals("Step")){
							step = true;
						}
					}
				}
				public void endElement(String uri, String localName,
						String qName) throws SAXException {
				  
					}
				public void characters(char ch[], int start, int length) throws SAXException {
					if(step){
						String steps = new String(ch, start, length);
						testdetails.add(steps);
						logger.info("Step Name : " + new String(ch, start, length));
						step = false;
					}
						
				}
			};
			//*****************hardcode the filename
			saxParser
					.parse(file,
							handler);
			
			logger.info("test details from SAX parser: "+testdetails);
            for(int i=0;i<testdetails.size();i++){
				sortedarray2[i] = testdetails.get(i);
				
				logger.info("TEST STEP:  "+sortedarray2[i]);

				
		}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sortedarray2;
		}


		public static String StepName ="";
	
		//public static ThreadLocal<String> StepName = new ThreadLocal<String>();
		public static String[][] parseTestSteps(String TestSteps,String stepname)
        throws SAXException, IOException, ParserConfigurationException {
		steplist.removeAll(steplist);
		File file = new File(TestSteps);
		StepName = stepname;
		try {

			SAXParserFactory factory = SAXParserFactory.newInstance();
			SAXParser saxParser = factory.newSAXParser();
			DefaultHandler handler = new DefaultHandler() {
				boolean step = false;
				public void startElement(String uri, String localName,String qName, 
		                Attributes attributes) throws SAXException {
					
					if(qName.equals("StepName")){
						teststepname="";
						for(int i=0;i<attributes.getLength();i++){
							String attr = attributes.getValue(i);
							
							if(attr.equalsIgnoreCase(StepName)){           //hardcode the testcase name
								teststepname=attr;
							}
						}
					}
					if(qName.equals("step")){
						if(teststepname.equals(StepName)){                  //hardcode the testcase name
							for(int i=0;i<attributes.getLength();i++){
								String attr = attributes.getValue(i);
								steplist.add(attr);
							}
								
						}
					}
					
				}
					
				};
				//*****************hardcode the filename
				saxParser
				.parse(file,
						handler);
				logger.info("steplist..................."+steplist.size());
				List<List<String>> parts = new ArrayList<List<String>>();  
				final int itemCount = steplist.size();
					int arrno;
					arrno=itemCount/3;
					for (int i = 0; i <itemCount ; i += 3) {      
						parts.add(new ArrayList<String>(        
								steplist.subList(i, Math.min(itemCount, i + 3))));
					}
					int der = parts.size();
					//System.out.println(der);
					//System.out.println(parts);
					int i=0;
					//String[][] S3 = new String[1000][1000];
					for(List<String> p : parts){
						
						for(int j=0;j<p.size();j++){
						//	S3 = sortedarray3.get();
							sortedarray3[i][j]= p.get(j);
							
							}
						i++;
					}	
					//sortedarray3.set(S3);
					//System.out.println(sortedarray3[1][1]);
		}catch(Exception e){
			e.printStackTrace();
		}
		return sortedarray3;
	}
	
/*	public static ThreadLocal<String> firstatt = new ThreadLocal<String>();
	public static ThreadLocal<String> secatt = new ThreadLocal<String>();
	public static ThreadLocal<String> count = new ThreadLocal<String>();
	public static ThreadLocal<String[]> attr = new ThreadLocal<String[]>();
	public static ThreadLocal<String> Step = new ThreadLocal<String>();*/
	
	public static String firstatt = "";
	public static String secatt = "";
	public static String count = "";
	public static String[] attr = new String[1000];
	public static String Step = "";
	
	//static String[] atr = new String[1000];	
	public static String getStepsCount(String TestStepsFile ,String step)throws SAXException{

	File file = new File(TestStepsFile);
	Step=step;
	try {

		SAXParserFactory factory = SAXParserFactory.newInstance();
		SAXParser saxParser = factory.newSAXParser();
		DefaultHandler handler = new DefaultHandler() {

		public void startElement(String uri, String localName,String qName, Attributes attributes) throws SAXException {
		//atr = attr.get();
		if (qName.equals("StepName")) {
		for (int i = 0; i < attributes.getLength(); i++) {
		attr[i]=attributes.getValue(i);
		
		}
		//attr.set(atr);
		firstatt=attr[0];
		secatt=attr[1];
		if (firstatt.equals(Step)) {
		
			count=attr[1];
		}
		else if(secatt.equals(Step)) {
			count=attr[0];
		}
		}	
		}
		};
		saxParser.parse(file,handler);
		//System.out.println(count.get());	
		
	} catch (Exception e) {
		e.printStackTrace();		
	}
			//System.out.println("count is **********************************************************************: "+count);

		return (count);

	}
	

	public static ThreadLocal<String> Message = new ThreadLocal<String>();
	public static ThreadLocal<String> Msg = new ThreadLocal<String>();
	public static ThreadLocal<String> parseMessages(String MessageFile,String msgname)
     throws SAXException, IOException, ParserConfigurationException {

	File file = new File(MessageFile);
	Message.set(msgname);

		SAXParserFactory factory = SAXParserFactory.newInstance();
		SAXParser saxParser = factory.newSAXParser();
		DefaultHandler handler = new DefaultHandler() {
			boolean testmsgname = false;
			public void startElement(String uri, String localName,String qName, 
	                Attributes attributes) throws SAXException {
				
				if(qName.equals("Msg")){
					//testmsgname = false;
					for(int i=0;i<attributes.getLength();i++){
						String attr = attributes.getValue(i);
						
						if(attr.equalsIgnoreCase(Message.get())){           //hardcode the testcase name
							testmsgname=true;
						}
					}
				}
			}
				/*if(qName.equals("Msg")){
					if(testmsgname.equals(Message)){
						//hardcode the testcase name
						for(int i=0;i<attributes.getLength();i++){
							String attr = attributes.getValue(i);
							steplist.add(attr);
						}
							
					}
				}*/
				
				public void characters(char ch[], int start, int length) throws SAXException {
					 
					if (testmsgname) {
				//		System.out.println("qName Name : " + new String(ch, start, length));
						testmsgname = false;
						Msg.set(new String(ch, start, length));
					}
				}
				
			};
			//*****************hardcode the filename
			saxParser
			.parse(file,
					handler);

	//System.out.println("Msg inside SAX is &&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&& "+Msg);
	return (Msg);
}


	//public static ThreadLocal<String> firstatt1 = new ThreadLocal<String>();
	//public static ThreadLocal<String> secatt1 = new ThreadLocal<String>();
	//public static ThreadLocal<String[]> attr1 = new ThreadLocal<String[]>();
	
	public static String firstatt1 = "";
	public static String secatt1 = "";
	public static String[] attr1 = new String[1000];
	
	//static String[] atr1 = new String[1000];
	public static ThreadLocal<String> Component = new ThreadLocal<String>();
	public static String getObj(String ObjectReferenceFile, String component){
	
		File file = new File(ObjectReferenceFile);
		Component.set(component);
		try {

			SAXParserFactory factory = SAXParserFactory.newInstance();
			SAXParser saxParser = factory.newSAXParser();
			//atr1 = attr1.get();
			DefaultHandler handler = new DefaultHandler() {
				public void startElement(String uri, String localName,String qName, 
		                Attributes attributes) throws SAXException {
					if(qName.equals("RefValues")){
						for (int i = 0; i < attributes.getLength(); i++) {
							attr1[i] = attributes.getValue(i);
						}
						firstatt1=attr1[0];
						if (firstatt1.equals(Component.get())) {
							secatt1=attr1[1];
						}
					}
				}
					
				};
				saxParser
				.parse(file,
						handler);
				//System.out.println(secatt1);
		}catch(Exception e){
			e.printStackTrace();
		}
	
	return secatt1;
	
	}

   public static ThreadLocal<String[][]> NewnodeListFinal = new ThreadLocal<String[][]>();
   public static ThreadLocal<String[][]> parseTestsToExecute(String TestsToExecute)
   throws SAXException, IOException, ParserConfigurationException {
   File file = new File(TestsToExecute);
   DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
   DocumentBuilder db = dbf.newDocumentBuilder();
   Document doc = db.parse(file);
   doc.getDocumentElement().normalize();

   NodeList nodeLst = doc.getElementsByTagName("Test");
   String[][] NewnodeList = new String[nodeLst.getLength()][];

   for (int s = 0; s < nodeLst.getLength(); s++) {
       NewnodeList[s] = new String[1];
  //     NewnodeList[s][0] = ((Node) nodeLst.item(s)).getTextContent();
   }
	NewnodeListFinal.set(NewnodeList);
   return NewnodeListFinal;
}

  public static ThreadLocal<String> parseReportsFile(String ReportsFile)
   throws SAXException, IOException, ParserConfigurationException {
   
   File file = new File(ReportsFile);
   DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
   DocumentBuilder db = dbf.newDocumentBuilder();
   Document doc = db.parse(file);
   doc.getDocumentElement().normalize();

   NodeList nodeLst = doc.getElementsByTagName("rep");
   String[][] NewnodeList = new String[nodeLst.getLength()][];
   logger.info("***************nodeLst.getLength()*****************" + nodeLst.getLength());

  /* for (int s = 0; s < nodeLst.getLength(); s++) {
       NewnodeList[s] = new String[1];
       NewnodeList[s][0] = ((Node) nodeLst.item(s)).getTextContent();
   }*/
    ThreadLocal<String> reportfilename = new ThreadLocal<String>();
	
/*    logger.info("***************nodeLst.getLength()*****************" + 	((Node) nodeLst.item(nodeLst.getLength()-1)).getTextContent());

	reportfilename.set(((Node) nodeLst.item(nodeLst.getLength()-1)).getTextContent());
	logger.info("***************ReportFolderName.get*****************" + reportfilename.get());*/

   return reportfilename;
}

}