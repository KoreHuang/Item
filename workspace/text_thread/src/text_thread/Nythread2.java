package text_thread;


public class Nythread2 extends Thread{
	Account account;
	public Nythread2(String name,Account account) {
	// TODO Auto-generated constructor stub
		super(name);
		this.account=account;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		account.TakeMoney();
	}
}