package test;


import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

public class RunTimeTest {

	public static void main(String[] args) {

		try{
			Process process = null;
			String line = null;
			BufferedReader stdout = null;

			process = Runtime.getRuntime().exec("CMD.exe /C dir", null, new File("C:\\"));
			stdout = new BufferedReader(new InputStreamReader(process.getInputStream()));
			while((line = stdout.readLine()) != null){
				System.out.println(line);
			}
			System.out.println();
			stdout.close();
		}catch (IOException e){
			e.printStackTrace();
		}
	}
}
