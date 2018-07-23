package test;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class ProcessBuilderTest {

	public static void main(String[] args) {

		try{
			List<String> list = new ArrayList<String>();
			ProcessBuilder processBuilder = null;
			Process process = null;
			String line = null;
			BufferedReader stdout = null;

			list.add("CMD.EXE");
			list.add("/C");
			list.add("dir");
			processBuilder = new ProcessBuilder(list);
			processBuilder.directory(new File("C:\\"));
			process = processBuilder.start();

			stdout = new BufferedReader(new InputStreamReader(process.getInputStream()));

			while ((line = stdout.readLine()) != null){
				System.out.println(line);
			}
		}catch (IOException e){
			e.printStackTrace();
		}
	}
}
