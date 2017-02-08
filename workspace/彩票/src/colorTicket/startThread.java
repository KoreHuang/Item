package colorTicket;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class startThread extends Thread{
	private JButton jb[];
	private JPanel jp;
	private JTextArea jTextArea;
	public startThread(JButton jb[],JPanel jPanel,JTextArea jTextArea) {
		// TODO Auto-generated constructor stub
		this.jb=jb;
		jp=jPanel;
		this.jTextArea=jTextArea;
	}
	@Override
	public void run() {
		synchronized (this) {
			int cnt=60;
			String mString="距离结束还有";
			jTextArea.setText(mString+cnt+"秒");
			closeAll();
			try {
				while(cnt>0){
					if(!this.isInterrupted()){
						for (int i = 0; i < jb.length; i++) {
							jb[i].setEnabled(true);
							jp.repaint();
							Thread.sleep(30);
							jb[i].setEnabled(false);
							jp.repaint();
						}
					}
					cnt--;
					jTextArea.setText(mString+cnt+"秒");
				}
			} catch (Exception e) {
				this.interrupt();
			}
		}
	}
	public synchronized void closeAll() {
		for (int i = 0; i < jb.length; i++) {
			jb[i].setEnabled(false);
		}
	}

}
