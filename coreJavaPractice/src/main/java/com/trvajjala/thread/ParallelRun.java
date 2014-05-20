package com.trvajjala.thread;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class ParallelRun implements Runnable {

	private String name;

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public ParallelRun(String name) {
		this.name = name;
	}

	public static void main(String[] args) {

		long start = System.currentTimeMillis();
		for (int i = 0; i < 100; i++) {
			Thread pr = new Thread(new ParallelRun("ThirupahtiReddy" + i));

			pr.start();
		}

		long delta = System.currentTimeMillis() - start;

		System.out.println("Difference " + (delta));
	}

	@Override
	public void run() {
		try {
			URL url = new URL("http://localhost:8080/quote");
			HttpURLConnection connection = (HttpURLConnection) url
					.openConnection();
			connection.setDoOutput(true);
			connection.setRequestMethod("POST");

			DataOutputStream outputStream = new DataOutputStream(
					connection.getOutputStream());
			outputStream.writeBytes("name=" + name
					+ "&phone=99&amount=4&terms=4");
			outputStream.close();

			BufferedReader in = new BufferedReader(new InputStreamReader(
					connection.getInputStream()));
			String inputLine;
			while ((inputLine = in.readLine()) != null){
			//	System.out.println(inputLine);
				System.out.print("*");
			}
			
			System.out.println("--------------");
			
			in.close();

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

}
