<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="auth" uri="spring.security.taglib.tld"%>

<div class="securemainbody">

	<ul class="unorderlist">

		<li>Create
			 <ol class="sublist">
				<li><a href="<%=request.getContextPath()%>/tester/createObjectIdsPage.htm"> Object IDs</a></li>
				<li><a href="<%=request.getContextPath()%>/tester/createMessages.htm"> Messages</a></li>
				<li><a href="<%=request.getContextPath()%>/tester/createTestSteps.htm"> Test Steps</a></li>
				<li><a href="<%=request.getContextPath()%>/tester/createTestCases.htm"> Test Cases</a></li>
			</ol>
		</li>

<%-- 
		<li>Manage
		        <ol class="sublist">
				<li><a href="<%=request.getContextPath()%>/tester/viewObjectIds.htm"> Object IDs</a></li>
				<li><a href="<%=request.getContextPath()%>/tester/viewMessages.htm"> Messages</a></li>
				<li><a href="<%=request.getContextPath()%>/tester/viewTestSteps.htm"> Test Steps</a></li>
				<li><a href="<%=request.getContextPath()%>/tester/viewTestCases.htm"> Test Cases</a></li>
				</ol>
		</li> --%>

		<li><a href="<%=request.getContextPath()%>/tester/viewXMLs.htm">View XMLs</a>
			 <!-- <ol class="sublist">
				<li><a href="#"> Create Object IDs</a></li>
				<li><a href="#"> Create Messages</a></li>
				<li><a href="#"> Create Test Steps</a></li>
				<li><a href="#"> Create Test Cases</a></li>
			</ol> --> 
		</li>

		<li>Test Automation
			<ol class="sublist">
				<li><a
					href="<%=request.getContextPath()%>/tester/createConfiguration.htm">
						Create Configuration</a>
				</li>
				
				
				<li><a
					href="<%=request.getContextPath()%>/tester/createTestSuite.htm">
						Create Test Suite</a>
				</li>
				
				<li><a
					href="<%=request.getContextPath()%>/tester/executeTestCases.htm">
						Execute</a>
				</li>

			</ol></li>


		<li><a href="<%=request.getContextPath()%>/tester/viewReports.htm">
    		View Reports</a>
		</li>


<!-- 		<li>Utilities

			<ol class="sublist">
				<li><a href="#"> Migrate Message Files</a></li>
			</ol>
		</li>

 -->


	</ul>
</div>