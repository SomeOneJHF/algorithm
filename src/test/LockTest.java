package test;

/*
	Lock在多线程中的应用，实现线程间通信
 */
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class AccountLock{

	private final Lock lock = new ReentrantLock();

	private final Condition condition = lock.newCondition();

	private String accountNo;
	private double balance;
	private boolean flag = false;

	public AccountLock(){}

	public AccountLock(String accountNo, double balance){

		this.accountNo = accountNo;
		this.balance = balance;
	}

	public void draw(double drawAmount){

		try{
			lock.lock();
			if(!flag){
				condition.await();
			}else{
				System.out.println(Thread.currentThread().getName() + " 取钱: " + drawAmount);
				balance = balance = drawAmount;
				System.out.println("余额 ：" + balance);

				flag = false;

				condition.signalAll();
			}
		}catch (Exception e){
			e.printStackTrace();
		}finally {
			lock.unlock();
		}
	}

	public void deposit(double depositAmount){

		try{
			lock.lock();
			if(flag){
				condition.await();
			}else{
				System.out.println(Thread.currentThread().getName() + "存钱 ： " + depositAmount);
				balance = balance + depositAmount;
				System.out.println("余额 ：" + balance);

				flag = true;
				condition.signalAll();
			}
		}catch (Exception e){
			e.printStackTrace();
		}finally {
			lock.unlock();
		}
	}
}

class DrawThreadLock implements Runnable{

	private AccountLock account;
	private double drawAccount;

	public DrawThreadLock(AccountLock account, double drawAccount){

		this.account = account;
		this.drawAccount = drawAccount;
	}

	public void run(){

		for(int i = 0; i < 100; i++){
			account.draw(drawAccount);
		}
	}
}

class DespoitThreadLock implements Runnable{

	private AccountLock account;
	private double despoitAccount;

	public DespoitThreadLock(AccountLock account, double despoitAccount){

		this.account = account;
		this.despoitAccount = despoitAccount;
	}

	public void run(){

		for(int i = 0; i < 100; i++){
			account.deposit(despoitAccount);
		}
	}
}

public class LockTest {

	public static void main(String[] args) {

		AccountLock account = new AccountLock();

		new Thread(new DrawThreadLock(account, 800), "取钱者").start();
		new Thread(new DespoitThreadLock(account, 800), "存钱者甲").start();
		new Thread(new DespoitThreadLock(account, 800), "存钱者乙").start();
		new Thread(new DespoitThreadLock(account, 800), "存钱者丙").start();
	}
}

