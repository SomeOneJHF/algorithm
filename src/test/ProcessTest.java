package test;

import java.lang.management.ManagementFactory;
import java.lang.management.RuntimeMXBean;

import java.util.HashSet;
import java.util.Set;

public class ProcessTest {

	public static void main(String[] args) {


		/*
		try {
			System.out.println(getProcessID());
			while (true) {
				Thread.sleep(1000);
			}
		}catch (InterruptedException e){
			e.printStackTrace();
		}*/
	}

	public static final int getProcessID(){

		RuntimeMXBean runtimeMXBean = ManagementFactory.getRuntimeMXBean();
		System.out.println(runtimeMXBean.getName());

		return Integer.valueOf(runtimeMXBean.getName().split("@")[0]).intValue();
	}
}
