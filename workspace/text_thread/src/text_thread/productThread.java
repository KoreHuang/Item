package text_thread;

public class productThread extends Thread{
	BaoZiPu baoZiPu;
	public productThread(String name,BaoZiPu baoZiPu) {
		// TODO Auto-generated constructor stub
		super(name);
		this.baoZiPu=baoZiPu;
	}
	@Override
	public void run() {
		//int unWeak=10;
		while (true) {			
			baoZiPu.product();
			//unWeak--;
		}
	}
	
}