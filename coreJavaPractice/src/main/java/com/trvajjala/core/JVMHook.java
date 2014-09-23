package com.trvajjala.core;

public class JVMHook {
public int NUM=20;
	public static void main(String[] args) {

		Runtime.getRuntime().addShutdownHook(new MyThread());
		Runtime.getRuntime().addShutdownHook(new MyThread());
		Runtime.getRuntime().addShutdownHook(new MyThread());
		Runtime.getRuntime().addShutdownHook(new MyThread());
		System.out.println(" Pre exit.");// when you have System.exit() next
											// operation won't execute
		// but shutdownHook operations will be executed
		// Runtime.getRuntime().halt(0); this will not invoke thread.it will
		// abruptly shutdown all the threads
		System.exit(0);
		System.out.println(" Post exit. ");
	}
}

class MyThread extends Thread {
	@Override
	public void run() {
		super.run();
		
		for(int i=0;i<100;i++){
			System.out.println(" shutdown hook executed	"+ i + " "+Thread.currentThread().getName());
		}
	}
}
