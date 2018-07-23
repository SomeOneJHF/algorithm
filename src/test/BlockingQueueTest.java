package test;


import java.util.Random;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;


public class BlockingQueueTest {

	public static void main(String[] args) throws InterruptedException{

		BlockingDeque<String> queue = new LinkedBlockingDeque<>(10);

		Producer producer1 = new Producer(queue);
		Producer producer2 = new Producer(queue);
		Producer producer3 = new Producer(queue);
		Consumer consumer = new Consumer(queue);

		ExecutorService service = Executors.newCachedThreadPool();
		service.execute(producer1);
		service.execute(producer2);
		service.execute(producer3);
		service.execute(consumer);

		Thread.sleep(10 * 1000);

		producer1.stop();
		producer2.stop();
		producer3.stop();

		Thread.sleep(2000);

		service.shutdown();

	}
}

class Producer implements Runnable{

	private BlockingQueue queue;
	private volatile boolean isRunning = true;
	private static AtomicInteger count = new AtomicInteger();
	private static final int DEFAULT_RANGE_FOR_SLEEP = 1000;

	public Producer(BlockingQueue queue){

		this.queue = queue;
	}

	public void run(){

		String data = null;
		Random r = new Random();

		System.out.println("启动生产者线程");
		try{
			while (isRunning){
				System.out.println("正在生产数据");
				Thread.sleep(DEFAULT_RANGE_FOR_SLEEP);

				data = "data : " + count.incrementAndGet();
				System.out.println("将数据 " + data + " 放入队列中");
				if(!queue.offer(data, 2, TimeUnit.SECONDS)){
					System.out.println("放入数据失败 : " + data);
				}
			}
		}catch (InterruptedException e){
			e.printStackTrace();
			Thread.currentThread().interrupt();
		}finally {
			System.out.println("退出生产者线程");
		}
	}

	public void stop(){

		isRunning = false;
	}
}

class Consumer implements Runnable{

	private BlockingQueue queue = null;
	private static final int DEFAULT_RANGE_FOR_SLEEP = 1000;

	public Consumer(BlockingQueue queue){

		this.queue = queue;
	}

	public void run(){

		System.out.println("启动消费者线程");
		Random r = new Random();
		boolean isRunning = true;
		try{
			while (isRunning){
				System.out.println("正从队列中获取数据");
				String data = (String) queue.poll(2, TimeUnit.SECONDS);
				if(null != data){
					System.out.println("拿到数据：" + data);
					System.out.println("正在消费数据：" + data);
					Thread.sleep(r.nextInt(DEFAULT_RANGE_FOR_SLEEP));
				}else{
					isRunning = false;
				}
			}
		}catch (InterruptedException e){
			e.printStackTrace();
			Thread.currentThread().interrupt();
		}
	}
}