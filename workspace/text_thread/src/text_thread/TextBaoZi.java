package text_thread;

import org.omg.CORBA.CTX_RESTRICT_SCOPE;

public class TextBaoZi {
	public static void main(String[] args) {
		BaoZiPu qingFeng =new BaoZiPu(0);
		productThread pt1=new productThread("翠花",qingFeng);
		consumThread ct1=new consumThread("小雨",qingFeng);
		consumThread ct2=new consumThread("小象",qingFeng);
		consumThread ct3=new consumThread("柱子",qingFeng);
		ct1.start();
		ct2.start();
		ct3.start();
		pt1.start();
	}
}
