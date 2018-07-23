package test;

/*
	这个应该是利用管道实现Java线程间通信
 */
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

class Send implements Runnable{

	private PipedOutputStream pos = null;

	public Send(){
		this.pos = new PipedOutputStream();
	}

	@Override
	public void run(){

		String str = "hello world";
		try{
			pos.write(str.getBytes());
		}catch (Exception e){
			e.printStackTrace();
		}

		try{
			pos.close();
		}catch (Exception e){
			e.printStackTrace();
		}
	}

	public PipedOutputStream getPos() {
		return pos;
	}
}

class Receive implements Runnable{

	private PipedInputStream pis = null;

	public Receive(){
		pis = new PipedInputStream();
	}

	@Override
	public void run(){

		byte[] b = new byte[1024];
		int len = 0;

		try{
			len = pis.read(b);
		}catch (Exception e){
			e.printStackTrace();
		}

		try{
			pis.close();
		}catch (Exception e){
			e.printStackTrace();
		}

		System.out.println("接受内容 : " + new String(b));
	}

	public PipedInputStream getPis() {
		return pis;
	}
}

public class PipeTest {

	public static void main(String[] args) {

		Send s = new Send();
		Receive r = new Receive();

		try{
			s.getPos().connect(r.getPis());
		}catch (Exception e){
			e.printStackTrace();
		}

		new Thread(s).start();
		new Thread(r).start();
	}
}
