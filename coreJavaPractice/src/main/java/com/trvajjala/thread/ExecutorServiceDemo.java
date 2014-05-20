package com.trvajjala.thread;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ExecutorServiceDemo {

	public static void main(String[] args) throws Exception {

		long start = System.nanoTime();
		ExecutorService executorService = Executors.newCachedThreadPool();

		List<Future<String>> list = new ArrayList<>();

		for (int i = 0; i < 5; i++) {
			list.add(executorService.submit(new MyReturnTask("")));
		}


		for (Future<String> f : list) {

			try {
				String result = f.get();

				System.out.println(result);

			} catch (InterruptedException | ExecutionException e) {

				e.printStackTrace();
			}
		}
		executorService.shutdown();
		long difference = System.nanoTime() - start;

		System.out.println("  DIFF " + (difference) / 1000000);

		System.out.println("SHUTDOWN *********");
	}

}

class MyTask implements Runnable {

	public void run() {
		System.out.println(" Running ");

	}
}

class MyReturnTask implements Callable<String> {

	String task;

	public MyReturnTask(String task) {
		this.task = task;
	}

	public String call() throws Exception {

		StringBuffer buffer = new StringBuffer();
		try {

			URL url = new URL("http://localhost:8081/parse");
			HttpURLConnection connection = (HttpURLConnection) url
					.openConnection();
			connection.setDoOutput(true);
			connection.setRequestMethod("POST");

			DataOutputStream outputStream = new DataOutputStream(
					connection.getOutputStream());
			outputStream.writeBytes("<?xml version=\"1.0\" encoding=\"UTF-8\"?><clientLoginResponse><authToken href=\"https://lhq.dev.corp.lyris.com/oasis/accounts/tokenInfo?token=e76b797f-4d7b-4a52-beaa-ee30d4983c81\"><id pk=\"21314\">e76b797f-4d7b-4a52-beaa-ee30d4983c81</id><expiration>1397817319327</expiration><uid>e76b797f-4d7b-4a52-beaa-ee30d4983c81</uid><created>2014-04-18T03:30:19-07:00</created><updated>2014-04-18T03:30:19-07:00</updated><canHasGui href=\"https://lhq.dev.corp.lyris.com/oasis/feeds/auth/e76b797f-4d7b-4a52-beaa-ee30d4983c81/canHasGui.xml\">true</canHasGui><user href=\"https://lhq.dev.corp.lyris.com/oasis/feeds/user/devuser1234\"><id pk=\"458\">634b21cb-4148-4d60-9bb1-6bb11221010b</id><uid>634b21cb-4148-4d60-9bb1-6bb11221010b</uid><name>User1 User2</name><login>devuser1234</login><email>hvalakati-111@im.corp.lyris.com</email><firstName>User1</firstName><lastName>User2</lastName><isCompany>false</isCompany><isStaff>false</isStaff><isSystemStaff>false</isSystemStaff><isSystemAdmin>false</isSystemAdmin><parentOrganization><organizationRef cn=\"Top 5 Flicks\" handle=\"top5flicks\" uid=\"cd15ccdb-4cca-43a9-ba28-c29a7348bba4\" href=\"https://lhq.dev.corp.lyris.com/oasis/feeds/company/2\" /></parentOrganization><organizationAccount isAdmin=\"true\"><organizationRef cn=\"Top 5 Flicks\" handle=\"top5flicks\" uid=\"cd15ccdb-4cca-43a9-ba28-c29a7348bba4\" href=\"https://lhq.dev.corp.lyris.com/oasis/feeds/company/2\" /></organizationAccount><workgroup><uid>c49190c8-84ce-4298-af88-b6c762facf72</uid><name>Default</name><description>Default Workgroup</description><organization-ref handle=\"top5flicks\" uid=\"cd15ccdb-4cca-43a9-ba28-c29a7348bba4\" /><id>1</id></workgroup></user><agent login=\"devuser1234\" uid=\"634b21cb-4148-4d60-9bb1-6bb11221010b\" href=\"https://lhq.dev.corp.lyris.com/oasis/feeds/user/devuser1234\" /><defaultOrganization><organizationRef cn=\"Top 5 Flicks\" handle=\"top5flicks\" uid=\"cd15ccdb-4cca-43a9-ba28-c29a7348bba4\" href=\"https://lhq.dev.corp.lyris.com/oasis/feeds/company/2\" /></defaultOrganization></authToken><x-oasis-meta><x-oasis-status>200 OK</x-oasis-status><x-oasis-render-duration-millis>47</x-oasis-render-duration-millis><x-oasis-render-datetime>2014-04-18T03:30:19-07:00</x-oasis-render-datetime><x-oasis-render-start-time-millis>1397817019295</x-oasis-render-start-time-millis><x-oasis-render-end-time-milis>1397817019342</x-oasis-render-end-time-milis></x-oasis-meta></clientLoginResponse>");
			outputStream.close();

			BufferedReader in = new BufferedReader(new InputStreamReader(
					connection.getInputStream()));
			String inputLine;
			buffer.append("TASK: " + task);
			while ((inputLine = in.readLine()) != null) {
				 System.out.println(inputLine);
			//	buffer.append("*");
			}
			in.close();
			System.out.println();
		} catch (Exception e) {
			return "TASK " + task + " Failed. REASON :: " + e.getMessage();
		} finally {
			System.out.println(task + "--------------");
		}
		return buffer.toString();
	}
}
