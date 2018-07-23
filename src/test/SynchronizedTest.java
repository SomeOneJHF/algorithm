package test;

/*
	synchronized在多线程中的应用，实现线程间通信
 */
public class SynchronizedTest {

	public static void main(String[] args) {

		Account account = new Account();

		new Thread(new DrawThread(account, 800), "取钱者").start();
		new Thread(new DespoitThread(account, 800), "存钱者甲").start();
		new Thread(new DespoitThread(account, 800), "存钱者乙").start();
		new Thread(new DespoitThread(account, 800), "存钱者丙").start();
	}
}

class Account{
	private String accontNo;
	private double balance;

	private boolean flag = false;

	public Account(){}

	public Account(String accontNo, double balance){

		this.accontNo = accontNo;
		this.balance = balance;
	}

	public synchronized void draw(double drawAmount){

		try{
			if(!flag){
				wait();
			}else{
				System.out.println(Thread.currentThread().getName() + " 取钱: " + drawAmount);
				balance = balance = drawAmount;
				System.out.println("余额 ：" + balance);

				flag = false;
				notifyAll();
			}
		}catch (Exception e){
			e.printStackTrace();
		}
	}

	public synchronized void deposit(double desositAmount){

		try{
			if(flag) {
				wait();
			}else{
				System.out.println(Thread.currentThread().getName() + "存钱 ： " + desositAmount);
				balance = balance + desositAmount;
				System.out.println("余额 ：" + balance);

				flag = true;
				notifyAll();
			}
		}catch (Exception e){
			e.printStackTrace();
		}
	}
}

class DrawThread implements Runnable{

	private Account account;
	private double drawAccount;

	public DrawThread(Account account, double drawAccount){

		this.account = account;
		this.drawAccount = drawAccount;
	}

	public void run(){

		for(int i = 0; i < 100; i++){
			account.draw(drawAccount);
		}
	}
}

class DespoitThread implements Runnable{

	private Account account;
	private double despoitAccount;

	public DespoitThread(Account account, double despoitAccount){

		this.account = account;
		this.despoitAccount = despoitAccount;
	}

	public void run(){

		for(int i = 0; i < 100; i++){
			account.deposit(despoitAccount);
		}
	}
}

