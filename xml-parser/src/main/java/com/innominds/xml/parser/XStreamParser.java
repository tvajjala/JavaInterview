package com.innominds.xml.parser;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

import com.innominds.response.vo.AuthenticationToken;
import com.innominds.response.vo.ClientLoginResponse;
import com.innominds.response.vo.Data;
import com.innominds.response.vo.DataSet;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.converters.basic.DateConverter;
import com.thoughtworks.xstream.io.xml.DomDriver;

public class XStreamParser {

	public static void main(String[] args) throws Exception {

		
		/*
		 * clientLoginResponse Parsing
		 */
		String responseone = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><clientLoginResponse><authToken href=\"https://lhq.dev.corp.lyris.com/oasis/accounts/tokenInfo?token=e76b797f-4d7b-4a52-beaa-ee30d4983c81\"><id pk=\"21314\">e76b797f-4d7b-4a52-beaa-ee30d4983c81</id><expiration>1397817319327</expiration><uid>e76b797f-4d7b-4a52-beaa-ee30d4983c81</uid><created>2014-04-18T03:30:19-07:00</created><updated>2014-04-18T03:30:19-07:00</updated><canHasGui href=\"https://lhq.dev.corp.lyris.com/oasis/feeds/auth/e76b797f-4d7b-4a52-beaa-ee30d4983c81/canHasGui.xml\">true</canHasGui><user href=\"https://lhq.dev.corp.lyris.com/oasis/feeds/user/devuser1234\"><id pk=\"458\">634b21cb-4148-4d60-9bb1-6bb11221010b</id><uid>634b21cb-4148-4d60-9bb1-6bb11221010b</uid><name>User1 User2</name><login>devuser1234</login><email>hvalakati-111@im.corp.lyris.com</email><firstName>User1</firstName><lastName>User2</lastName><isCompany>false</isCompany><isStaff>false</isStaff><isSystemStaff>false</isSystemStaff><isSystemAdmin>false</isSystemAdmin><parentOrganization><organizationRef cn=\"Top 5 Flicks\" handle=\"top5flicks\" uid=\"cd15ccdb-4cca-43a9-ba28-c29a7348bba4\" href=\"https://lhq.dev.corp.lyris.com/oasis/feeds/company/2\" /></parentOrganization><organizationAccount isAdmin=\"true\"><organizationRef cn=\"Top 5 Flicks\" handle=\"top5flicks\" uid=\"cd15ccdb-4cca-43a9-ba28-c29a7348bba4\" href=\"https://lhq.dev.corp.lyris.com/oasis/feeds/company/2\" /></organizationAccount><workgroup><uid>c49190c8-84ce-4298-af88-b6c762facf72</uid><name>Default</name><description>Default Workgroup</description><organization-ref handle=\"top5flicks\" uid=\"cd15ccdb-4cca-43a9-ba28-c29a7348bba4\" /><id>1</id></workgroup></user><agent login=\"devuser1234\" uid=\"634b21cb-4148-4d60-9bb1-6bb11221010b\" href=\"https://lhq.dev.corp.lyris.com/oasis/feeds/user/devuser1234\" /><defaultOrganization><organizationRef cn=\"Top 5 Flicks\" handle=\"top5flicks\" uid=\"cd15ccdb-4cca-43a9-ba28-c29a7348bba4\" href=\"https://lhq.dev.corp.lyris.com/oasis/feeds/company/2\" /></defaultOrganization></authToken><x-oasis-meta><x-oasis-status>200 OK</x-oasis-status><x-oasis-render-duration-millis>47</x-oasis-render-duration-millis><x-oasis-render-datetime>2014-04-18T03:30:19-07:00</x-oasis-render-datetime><x-oasis-render-start-time-millis>1397817019295</x-oasis-render-start-time-millis><x-oasis-render-end-time-milis>1397817019342</x-oasis-render-end-time-milis></x-oasis-meta></clientLoginResponse>";

		ClientLoginResponse c = getClientLoginResponse(responseone);

		System.out.println(c.getAuthToken().getCreated());

		System.out.println(c.getMetadata().getStatus());
		
		
		/**
		 * authToken Parsing
		 */

		System.out
				.println(" -----------------------------------------------  ");
		String responsetwo = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><authToken href=\"https://lhq.dev.corp.lyris.com/oasis/accounts/tokenInfo?token=e76b797f-4d7b-4a52-beaa-ee30d4983c81\"><id pk=\"21314\">e76b797f-4d7b-4a52-beaa-ee30d4983c81</id><expiration>1397817319327</expiration><uid>e76b797f-4d7b-4a52-beaa-ee30d4983c81</uid><created>2014-04-18T03:30:19-07:00</created><updated>2014-04-18T03:30:19-07:00</updated><canHasGui href=\"https://lhq.dev.corp.lyris.com/oasis/feeds/auth/e76b797f-4d7b-4a52-beaa-ee30d4983c81/canHasGui.xml\">true</canHasGui><user href=\"https://lhq.dev.corp.lyris.com/oasis/feeds/user/devuser1234\"><id pk=\"458\">634b21cb-4148-4d60-9bb1-6bb11221010b</id><uid>634b21cb-4148-4d60-9bb1-6bb11221010b</uid><name>User1 User2</name><login>devuser1234</login><email>hvalakati-111@im.corp.lyris.com</email><firstName>User1</firstName><lastName>User2</lastName><isCompany>false</isCompany><isStaff>false</isStaff><isSystemStaff>false</isSystemStaff><isSystemAdmin>false</isSystemAdmin><parentOrganization><organizationRef cn=\"Top 5 Flicks\" handle=\"top5flicks\" uid=\"cd15ccdb-4cca-43a9-ba28-c29a7348bba4\" href=\"https://lhq.dev.corp.lyris.com/oasis/feeds/company/2\" /></parentOrganization><organizationAccount isAdmin=\"true\"><organizationRef cn=\"Top 5 Flicks\" handle=\"top5flicks\" uid=\"cd15ccdb-4cca-43a9-ba28-c29a7348bba4\" href=\"https://lhq.dev.corp.lyris.com/oasis/feeds/company/2\" /></organizationAccount><workgroup><uid>c49190c8-84ce-4298-af88-b6c762facf72</uid><name>Default</name><description>Default Workgroup</description><organization-ref handle=\"top5flicks\" uid=\"cd15ccdb-4cca-43a9-ba28-c29a7348bba4\" /><id>1</id></workgroup></user><agent login=\"devuser1234\" uid=\"634b21cb-4148-4d60-9bb1-6bb11221010b\" href=\"https://lhq.dev.corp.lyris.com/oasis/feeds/user/devuser1234\" /><defaultOrganization><organizationRef cn=\"Top 5 Flicks\" handle=\"top5flicks\" uid=\"cd15ccdb-4cca-43a9-ba28-c29a7348bba4\" href=\"https://lhq.dev.corp.lyris.com/oasis/feeds/company/2\" /></defaultOrganization></authToken>";

		AuthenticationToken token = getAuthenticationToken(responsetwo);

		System.out.println(token.getUser().getId().getPk());

		System.out.println(token.getCanHasGui());

		System.out.println(token.getAgent().getHref());

		System.out.println(token.getDefaultOrganization().getOrganizationRef()
				.getHref());

		System.out
				.println(" -----------------------------------------------  ");

		/**
		 * DataSet Parsing
		 */
		
		String dataString="<?xml version=\"1.0\" encoding=\"utf-8\"?><DATASET><TYPE>success</TYPE><RECORD><DATA type=\"name\" id=\"812\">12003</DATA><DATA type=\"messages\">10</DATA><DATA type=\"last-sent\">Mar. 4, 2014</DATA><DATA type=\"last-sent_tz\">Mar. 4, 2014</DATA><DATA type=\"members\">2,000,002</DATA><DATA type=\"status\">active</DATA><DATA type=\"cache-time\">2014-04-21T10:45:31+00:00</DATA></RECORD><RECORD><DATA type=\"name\" id=\"749\">16jan</DATA><DATA type=\"messages\">1</DATA><DATA type=\"last-sent\"></DATA><DATA type=\"last-sent_tz\"></DATA><DATA type=\"members\">0</DATA><DATA type=\"status\">active</DATA><DATA type=\"cache-time\">2014-04-21T10:56:10+00:00</DATA></RECORD><RECORD><DATA type=\"name\" id=\"406\">Attribute Test List 84c676de-c029-4255-84e6-435934</DATA><DATA type=\"messages\">1</DATA><DATA type=\"last-sent\"></DATA><DATA type=\"last-sent_tz\"></DATA><DATA type=\"members\">0</DATA><DATA type=\"status\">active</DATA><DATA type=\"cache-time\">2014-04-21T10:56:10+00:00</DATA></RECORD><RECORD><DATA type=\"name\" id=\"455\">B</DATA><DATA type=\"messages\">2</DATA><DATA type=\"last-sent\"></DATA><DATA type=\"last-sent_tz\"></DATA><DATA type=\"members\">0</DATA><DATA type=\"status\">active</DATA><DATA type=\"cache-time\">2014-04-21T10:56:10+00:00</DATA></RECORD><RECORD><DATA type=\"name\" id=\"471\">Clinton Test - 59465209-2c3b-11e3-9408-59e7408d230</DATA><DATA type=\"messages\">1</DATA><DATA type=\"last-sent\"></DATA><DATA type=\"last-sent_tz\"></DATA><DATA type=\"members\">0</DATA><DATA type=\"status\">active</DATA><DATA type=\"cache-time\">2014-04-21T10:56:10+00:00</DATA></RECORD><RECORD><DATA type=\"name\" id=\"479\">Clinton Test - b6326865-2c41-11e3-92e6-51f8a16f30e</DATA><DATA type=\"messages\">1</DATA><DATA type=\"last-sent\"></DATA><DATA type=\"last-sent_tz\"></DATA><DATA type=\"members\">0</DATA><DATA type=\"status\">active</DATA><DATA type=\"cache-time\">2014-04-21T10:56:10+00:00</DATA></RECORD><RECORD><DATA type=\"name\" id=\"385\">Clinton_07012013</DATA><DATA type=\"messages\">8</DATA><DATA type=\"last-sent\">Sep. 11, 2013</DATA><DATA type=\"last-sent_tz\">Sep. 11, 2013</DATA><DATA type=\"members\">2</DATA><DATA type=\"status\">active</DATA><DATA type=\"cache-time\">2014-04-21T10:45:31+00:00</DATA></RECORD><RECORD><DATA type=\"name\" id=\"391\">DEV-11865</DATA><DATA type=\"messages\">2</DATA><DATA type=\"last-sent\">Nov. 10, 2013</DATA><DATA type=\"last-sent_tz\">Nov. 10, 2013</DATA><DATA type=\"members\">100</DATA><DATA type=\"status\">active</DATA><DATA type=\"cache-time\">2014-04-21T10:45:31+00:00</DATA></RECORD><RECORD><DATA type=\"name\" id=\"392\">DEV-11865-01</DATA><DATA type=\"messages\">40</DATA><DATA type=\"last-sent\"></DATA><DATA type=\"last-sent_tz\"></DATA><DATA type=\"members\">12</DATA><DATA type=\"status\">active</DATA><DATA type=\"cache-time\">2014-04-21T10:45:31+00:00</DATA></RECORD><RECORD><DATA type=\"name\" id=\"384\">DEV-26062013349</DATA><DATA type=\"messages\">55</DATA><DATA type=\"last-sent\">Apr. 16, 2014</DATA><DATA type=\"last-sent_tz\">Apr. 16, 2014</DATA><DATA type=\"members\">5</DATA><DATA type=\"status\">active</DATA><DATA type=\"cache-time\">2014-04-21T10:45:31+00:00</DATA></RECORD><RECORD><DATA type=\"name\" id=\"470\">efec68f9-2c3a-11e3-9408-59e7408d230b</DATA><DATA type=\"messages\">1</DATA><DATA type=\"last-sent\"></DATA><DATA type=\"last-sent_tz\"></DATA><DATA type=\"members\">0</DATA><DATA type=\"status\">active</DATA><DATA type=\"cache-time\">2014-04-21T10:56:10+00:00</DATA></RECORD><RECORD><DATA type=\"name\" id=\"387\">extended-list</DATA><DATA type=\"messages\">69</DATA><DATA type=\"last-sent\">Oct. 23, 2013</DATA><DATA type=\"last-sent_tz\">Oct. 23, 2013</DATA><DATA type=\"members\">8</DATA><DATA type=\"status\">active</DATA><DATA type=\"cache-time\">2014-04-21T10:45:31+00:00</DATA><DATA type=\"extended_addressing\">on</DATA></RECORD><RECORD><DATA type=\"name\" id=\"814\">fablist-two</DATA><DATA type=\"messages\">1</DATA><DATA type=\"last-sent\"></DATA><DATA type=\"last-sent_tz\"></DATA><DATA type=\"members\">0</DATA><DATA type=\"status\">active</DATA><DATA type=\"cache-time\">2014-04-21T10:56:10+00:00</DATA></RECORD><RECORD><DATA type=\"name\" id=\"319\">gmuff</DATA><DATA type=\"messages\">133</DATA><DATA type=\"last-sent\">Feb. 18, 2014</DATA><DATA type=\"last-sent_tz\">Feb. 18, 2014</DATA><DATA type=\"members\">1,523,902</DATA><DATA type=\"status\">active</DATA><DATA type=\"cache-time\">2014-04-21T10:45:31+00:00</DATA></RECORD><RECORD><DATA type=\"name\" id=\"337\">gmuffShortList</DATA><DATA type=\"messages\">25</DATA><DATA type=\"last-sent\">Feb. 19, 2014</DATA><DATA type=\"last-sent_tz\">Feb. 19, 2014</DATA><DATA type=\"members\">2</DATA><DATA type=\"status\">active</DATA><DATA type=\"cache-time\">2014-04-21T10:45:31+00:00</DATA></RECORD><RECORD><DATA type=\"name\" id=\"733\">list-sample-sam</DATA><DATA type=\"messages\">1</DATA><DATA type=\"last-sent\"></DATA><DATA type=\"last-sent_tz\"></DATA><DATA type=\"members\">0</DATA><DATA type=\"status\">active</DATA><DATA type=\"cache-time\">2014-04-21T10:56:10+00:00</DATA></RECORD><RECORD><DATA type=\"name\" id=\"394\">list1</DATA><DATA type=\"messages\">1</DATA><DATA type=\"last-sent\"></DATA><DATA type=\"last-sent_tz\"></DATA><DATA type=\"members\">0</DATA><DATA type=\"status\">active</DATA><DATA type=\"cache-time\">2014-04-21T10:56:10+00:00</DATA></RECORD><RECORD><DATA type=\"name\" id=\"395\">Mailing List Test</DATA><DATA type=\"messages\">1</DATA><DATA type=\"last-sent\"></DATA><DATA type=\"last-sent_tz\"></DATA><DATA type=\"members\">0</DATA><DATA type=\"status\">active</DATA><DATA type=\"cache-time\">2014-04-21T10:56:10+00:00</DATA></RECORD><RECORD><DATA type=\"name\" id=\"389\">Marketing</DATA><DATA type=\"messages\">3</DATA><DATA type=\"last-sent\"></DATA><DATA type=\"last-sent_tz\"></DATA><DATA type=\"members\">0</DATA><DATA type=\"status\">active</DATA><DATA type=\"cache-time\">2014-04-21T10:56:10+00:00</DATA></RECORD><RECORD><DATA type=\"name\" id=\"815\">mfab-list1</DATA><DATA type=\"messages\">1</DATA><DATA type=\"last-sent\"></DATA><DATA type=\"last-sent_tz\"></DATA><DATA type=\"members\">0</DATA><DATA type=\"status\">active</DATA><DATA type=\"cache-time\">2014-04-21T10:56:10+00:00</DATA></RECORD><RECORD><DATA type=\"name\" id=\"673\">Pradeep</DATA><DATA type=\"messages\">11</DATA><DATA type=\"last-sent\">Jan. 27, 2014</DATA><DATA type=\"last-sent_tz\">Jan. 27, 2014</DATA><DATA type=\"members\">4</DATA><DATA type=\"status\">active</DATA><DATA type=\"cache-time\">2014-04-21T10:45:31+00:00</DATA></RECORD><RECORD><DATA type=\"name\" id=\"684\">Pradeep - Supression</DATA><DATA type=\"messages\">1</DATA><DATA type=\"last-sent\"></DATA><DATA type=\"last-sent_tz\"></DATA><DATA type=\"members\">1</DATA><DATA type=\"status\">active</DATA><DATA type=\"cache-time\">2014-04-21T10:45:31+00:00</DATA></RECORD><RECORD><DATA type=\"name\" id=\"316\">pras-test's</DATA><DATA type=\"messages\">531</DATA><DATA type=\"last-sent\">Mar. 4, 2014</DATA><DATA type=\"last-sent_tz\">Mar. 4, 2014</DATA><DATA type=\"members\">6</DATA><DATA type=\"status\">active</DATA><DATA type=\"cache-time\">2014-04-21T10:45:31+00:00</DATA></RECORD><RECORD><DATA type=\"name\" id=\"309\">prasad-test's</DATA><DATA type=\"messages\">552</DATA><DATA type=\"last-sent\">Nov. 13, 2013</DATA><DATA type=\"last-sent_tz\">Nov. 13, 2013</DATA><DATA type=\"members\">22</DATA><DATA type=\"status\">active</DATA><DATA type=\"cache-time\">2014-04-21T10:45:31+00:00</DATA></RECORD><RECORD><DATA type=\"name\" id=\"532\">Prasad_Test</DATA><DATA type=\"messages\">1</DATA><DATA type=\"last-sent\"></DATA><DATA type=\"last-sent_tz\"></DATA><DATA type=\"members\">0</DATA><DATA type=\"status\">active</DATA><DATA type=\"cache-time\">2014-04-21T10:56:10+00:00</DATA></RECORD><RECORD><DATA type=\"name\" id=\"390\">Richards List</DATA><DATA type=\"messages\">53</DATA><DATA type=\"last-sent\">Nov. 26, 2013</DATA><DATA type=\"last-sent_tz\">Nov. 26, 2013</DATA><DATA type=\"members\">492</DATA><DATA type=\"status\">active</DATA><DATA type=\"cache-time\">2014-04-21T10:45:31+00:00</DATA></RECORD><RECORD><DATA type=\"name\" id=\"700\">SalesForceContactsTest</DATA><DATA type=\"messages\">1</DATA><DATA type=\"last-sent\"></DATA><DATA type=\"last-sent_tz\"></DATA><DATA type=\"members\">624</DATA><DATA type=\"status\">active</DATA><DATA type=\"cache-time\">2014-04-21T10:45:31+00:00</DATA></RECORD><RECORD><DATA type=\"name\" id=\"453\">sam-list</DATA><DATA type=\"messages\">7</DATA><DATA type=\"last-sent\">Nov. 13, 2013</DATA><DATA type=\"last-sent_tz\">Nov. 13, 2013</DATA><DATA type=\"members\">4,998</DATA><DATA type=\"status\">active</DATA><DATA type=\"cache-time\">2014-04-21T10:45:31+00:00</DATA></RECORD><RECORD><DATA type=\"name\" id=\"454\">sam-list2</DATA><DATA type=\"messages\">217</DATA><DATA type=\"last-sent\">Feb. 7, 2014</DATA><DATA type=\"last-sent_tz\">Feb. 7, 2014</DATA><DATA type=\"members\">104</DATA><DATA type=\"status\">active</DATA><DATA type=\"cache-time\">2014-04-21T10:45:31+00:00</DATA></RECORD><RECORD><DATA type=\"name\" id=\"468\">sam-list3</DATA><DATA type=\"messages\">1</DATA><DATA type=\"last-sent\"></DATA><DATA type=\"last-sent_tz\"></DATA><DATA type=\"members\">0</DATA><DATA type=\"status\">active</DATA><DATA type=\"cache-time\">2014-04-21T10:56:10+00:00</DATA></RECORD><RECORD><DATA type=\"name\" id=\"469\">sam-list4</DATA><DATA type=\"messages\">1</DATA><DATA type=\"last-sent\"></DATA><DATA type=\"last-sent_tz\"></DATA><DATA type=\"members\">0</DATA><DATA type=\"status\">active</DATA><DATA type=\"cache-time\">2014-04-21T10:56:10+00:00</DATA></RECORD><RECORD><DATA type=\"name\" id=\"393\">sameer-list</DATA><DATA type=\"messages\">33</DATA><DATA type=\"last-sent\">Oct. 2, 2013</DATA><DATA type=\"last-sent_tz\">Oct. 2, 2013</DATA><DATA type=\"members\">3</DATA><DATA type=\"status\">active</DATA><DATA type=\"cache-time\">2014-04-21T10:45:31+00:00</DATA></RECORD><RECORD><DATA type=\"name\" id=\"800\">sameermlist1</DATA><DATA type=\"messages\">4</DATA><DATA type=\"last-sent\">Feb. 5, 2014</DATA><DATA type=\"last-sent_tz\">Feb. 5, 2014</DATA><DATA type=\"members\">1</DATA><DATA type=\"status\">active</DATA><DATA type=\"cache-time\">2014-04-21T10:45:31+00:00</DATA></RECORD><RECORD><DATA type=\"name\" id=\"720\">SegmentConnectorTestList</DATA><DATA type=\"messages\">1</DATA><DATA type=\"last-sent\"></DATA><DATA type=\"last-sent_tz\"></DATA><DATA type=\"members\">1</DATA><DATA type=\"status\">active</DATA><DATA type=\"cache-time\">2014-04-21T10:45:31+00:00</DATA></RECORD><RECORD><DATA type=\"name\" id=\"489\">test</DATA><DATA type=\"messages\">1</DATA><DATA type=\"last-sent\"></DATA><DATA type=\"last-sent_tz\"></DATA><DATA type=\"members\">0</DATA><DATA type=\"status\">active</DATA><DATA type=\"cache-time\">2014-04-21T10:56:10+00:00</DATA></RECORD><RECORD><DATA type=\"name\" id=\"397\">Test List - 4774b611-5c45-4f06-8e78-d91a53f7f44b</DATA><DATA type=\"messages\">1</DATA><DATA type=\"last-sent\"></DATA><DATA type=\"last-sent_tz\"></DATA><DATA type=\"members\">0</DATA><DATA type=\"status\">active</DATA><DATA type=\"cache-time\">2014-04-21T10:56:10+00:00</DATA></RECORD><RECORD><DATA type=\"name\" id=\"401\">Test List - 5cfb27e0-3696-4da1-aee2-f2913ef2e5d3</DATA><DATA type=\"messages\">1</DATA><DATA type=\"last-sent\"></DATA><DATA type=\"last-sent_tz\"></DATA><DATA type=\"members\">0</DATA><DATA type=\"status\">active</DATA><DATA type=\"cache-time\">2014-04-21T10:56:10+00:00</DATA></RECORD><RECORD><DATA type=\"name\" id=\"398\">Test List - 65e34f3e-3ac7-4c60-a19d-f13237300d98</DATA><DATA type=\"messages\">1</DATA><DATA type=\"last-sent\"></DATA><DATA type=\"last-sent_tz\"></DATA><DATA type=\"members\">0</DATA><DATA type=\"status\">active</DATA><DATA type=\"cache-time\">2014-04-21T10:56:10+00:00</DATA></RECORD><RECORD><DATA type=\"name\" id=\"400\">Test List - 8f564e51-a3da-404e-b2b8-fd95991c1848</DATA><DATA type=\"messages\">1</DATA><DATA type=\"last-sent\"></DATA><DATA type=\"last-sent_tz\"></DATA><DATA type=\"members\">0</DATA><DATA type=\"status\">active</DATA><DATA type=\"cache-time\">2014-04-21T10:56:10+00:00</DATA></RECORD><RECORD><DATA type=\"name\" id=\"403\">Test List - 9aa6eafb-3f28-47f2-afa3-c42489d350d3</DATA><DATA type=\"messages\">1</DATA><DATA type=\"last-sent\"></DATA><DATA type=\"last-sent_tz\"></DATA><DATA type=\"members\">0</DATA><DATA type=\"status\">active</DATA><DATA type=\"cache-time\">2014-04-21T10:56:10+00:00</DATA></RECORD><RECORD><DATA type=\"name\" id=\"399\">Test List - a60aab45-01ee-41ac-b7e8-22e7a4fe9a9a</DATA><DATA type=\"messages\">1</DATA><DATA type=\"last-sent\"></DATA><DATA type=\"last-sent_tz\"></DATA><DATA type=\"members\">0</DATA><DATA type=\"status\">active</DATA><DATA type=\"cache-time\">2014-04-21T10:56:10+00:00</DATA></RECORD><RECORD><DATA type=\"name\" id=\"386\">Test List Modified - b8e04eb6-bd16-47b9-afac-190cb</DATA><DATA type=\"messages\">1542</DATA><DATA type=\"last-sent\">Mar. 18, 2014</DATA><DATA type=\"last-sent_tz\">Mar. 18, 2014</DATA><DATA type=\"members\">13,038</DATA><DATA type=\"status\">active</DATA><DATA type=\"cache-time\">2014-04-21T10:45:31+00:00</DATA></RECORD><RECORD><DATA type=\"name\" id=\"490\">test1</DATA><DATA type=\"messages\">1</DATA><DATA type=\"last-sent\"></DATA><DATA type=\"last-sent_tz\"></DATA><DATA type=\"members\">0</DATA><DATA type=\"status\">active</DATA><DATA type=\"cache-time\">2014-04-21T10:56:10+00:00</DATA></RECORD></DATASET>";

		
		DataSet dataSet = getDataSet(dataString);
		

		System.out.println(dataSet.getType());

		for (Data data : dataSet.getRecords()) {
			System.out.println(data);
		}

		System.out.println("Total Records ::: " + dataSet.getRecords().size());

	}

	/**
	 * 
	 * @param xmlAsString
	 *            inputAsXMLString
	 * @return DataSet
	 * @throws Exception
	 */
	public static DataSet getDataSet(String xmlAsString) throws Exception {

		return getDataSet(new ByteArrayInputStream(xmlAsString.getBytes("UTF-8")));
	}

	/**
	 * 
	 * @param inputStream
	 *            input As Stream
	 * @return
	 * @throws Exception
	 */
	public static DataSet getDataSet(InputStream inputStream) throws Exception {

		return parseDataSet(getDocumentBuilder().parse(inputStream));

	}

	/**
	 * 
	 * @param xmlDocument
	 * @return DataSet
	 * @throws Exception
	 */
	private static DataSet parseDataSet(Document xmlDocument) throws Exception {

		XPath xPath = XPathFactory.newInstance().newXPath();
		DataSet dataSet = new DataSet();
		dataSet.setType(xPath.compile("/DATASET/TYPE").evaluate(xmlDocument));

		NodeList nodeList = (NodeList) xPath.compile("/DATASET/RECORD")
				.evaluate(xmlDocument, XPathConstants.NODESET);

		int totalRecords = nodeList.getLength();
		for (int i = 1; i <= totalRecords; i++) {
			dataSet.getRecords().add(getData(xmlDocument, xPath, i));
		}

		return dataSet;

	}

	/**
	 * 
	 * @param xmlDocument
	 * @param xPath
	 * @param recordNumber
	 * @return Data
	 * @throws Exception
	 */
	private static Data getData(Document xmlDocument, XPath xPath,
			int recordNumber) throws Exception {
		Data data = new Data();

		data.setId((String) xPath.compile(
				"/DATASET/RECORD[" + recordNumber + "]/DATA/@id").evaluate(
				xmlDocument, XPathConstants.STRING));

		data.setName((String) xPath.compile(
				"/DATASET/RECORD[" + recordNumber
						+ "]/DATA[@type='name']/text()").evaluate(xmlDocument,
				XPathConstants.STRING));

		data.setMessages((String) xPath.compile(
				"/DATASET/RECORD[" + recordNumber
						+ "]/DATA[@type='messages']/text()").evaluate(
				xmlDocument, XPathConstants.STRING));

		data.setLastsent((String) xPath.compile(
				"/DATASET/RECORD[" + recordNumber
						+ "]/DATA[@type='last-sent']/text()").evaluate(
				xmlDocument, XPathConstants.STRING));

		data.setLastsentTZ((String) xPath.compile(
				"/DATASET/RECORD[" + recordNumber
						+ "]/DATA[@type='last-sent_tz']/text()").evaluate(
				xmlDocument, XPathConstants.STRING));

		data.setMembers((String) xPath.compile(
				"/DATASET/RECORD[" + recordNumber
						+ "]/DATA[@type='members']/text()").evaluate(
				xmlDocument, XPathConstants.STRING));

		data.setStatus((String) xPath.compile(
				"/DATASET/RECORD[" + recordNumber
						+ "]/DATA[@type='status']/text()").evaluate(
				xmlDocument, XPathConstants.STRING));

		data.setCacheTime((String) xPath.compile(
				"/DATASET/RECORD[" + recordNumber
						+ "]/DATA[@type='cache-time']/text()").evaluate(
				xmlDocument, XPathConstants.STRING));

		data.setExtendedAddressing((String) xPath.compile(
				"/DATASET/RECORD[" + recordNumber
						+ "]/DATA[@type='extended_addressing']/text()").evaluate(
				xmlDocument, XPathConstants.STRING));

		return data;
	}

	/**
	 * 
	 * @return DocumentBuilder
	 */
	private static DocumentBuilder getDocumentBuilder() {

		DocumentBuilderFactory builderFactory = DocumentBuilderFactory
				.newInstance();
		DocumentBuilder builder = null;
		try {
			builder = builderFactory.newDocumentBuilder();
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		}

		return builder;
	}

	/**
	 * 
	 * @param inputAsString
	 * @return ClientLoginResponse
	 * @throws Exception
	 */
	public static ClientLoginResponse getClientLoginResponse(
			String inputAsString) throws Exception {

		XStream stream = initializeDriver();

		return (ClientLoginResponse) stream.fromXML(getAsStream(inputAsString));

	}

	/**
	 * 
	 * @param inputAsString
	 * @return AuthenticationToken
	 * @throws Exception
	 */
	public static AuthenticationToken getAuthenticationToken(
			String inputAsString) throws Exception {

		XStream stream = initializeDriver();

		return (AuthenticationToken) stream.fromXML(getAsStream(inputAsString));

	}

	/**
	 * 
	 * @param stringInput
	 * @return xmlAsStream
	 * @throws UnsupportedEncodingException
	 */
	private static InputStream getAsStream(String stringInput)
			throws UnsupportedEncodingException {

		return new ByteArrayInputStream(stringInput.getBytes("UTF-8"));

	}

	/**
	 * 
	 * @return xStream Driver with Customization
	 */
	private static XStream initializeDriver() {

		XStream stream = new XStream(new DomDriver());
		stream.autodetectAnnotations(true);
		stream.alias("clientLoginResponse", ClientLoginResponse.class);
		stream.alias("authToken", AuthenticationToken.class);
		stream.alias("DATASET", DataSet.class);
		// stream.ignoreUnknownElements();

		stream.registerConverter(new DateConverter("yyyy-MM-dd",
				new String[] {}));

		return stream;
	}

}
