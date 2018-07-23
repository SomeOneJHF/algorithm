package test;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

class CallableThread implements Callable{

	private Integer i = 0;

	@Override
	public Integer call(){

		for(i = 0; i < 20; i++){
			System.out.println(Thread.currentThread().getName() + " " + i);
		}
		return i;
	}
}
public class CallableTest {

	public static void main(String[] args) {

		CallableThread callableThread = new CallableThread();
		FutureTask<Integer> futureTask = new FutureTask<Integer>(callableThread);

		Thread thread = new Thread(futureTask, "新线程");
		thread.start();

		try{
			System.out.println(futureTask.get());
		}catch (Exception e){
			e.printStackTrace();
		}
	}
}
