package text_thread;

import javax.naming.NameAlreadyBoundException;

public class BaoZiPu {
	private int currentNum=100;
	public BaoZiPu(int num) {
		// TODO Auto-generated constructor stub
		currentNum=num;
	}
	public int  getNum() {
		return currentNum;
	}
	public synchronized void product() {
		try {
			String name =Thread.currentThread().getName();
			System.out.println(name+"正在蒸包子....");
			currentNum+=20;
			if(currentNum>=20){
				System.out.println("包子刚出锅，可以过来买了");
				this.notifyAll();
			}
			Thread.sleep(200);
			System.out.println("包子剩余:"+currentNum+"...");
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	public synchronized void  consum() {
		try {
			String name=Thread.currentThread().getName();
			System.out.println(name+"过来买包子...");
			if(currentNum<20){
				System.out.println(name+"正在等待...");
				this.wait();
			}
			currentNum-=20;
			Thread.sleep(1000);
			System.out.println(name+"过来买包子..."+"包子还剩:"+currentNum+"...");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}