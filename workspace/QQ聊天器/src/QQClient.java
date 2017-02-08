import java.awt.BorderLayout;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class QQClient extends JFrame {
	public QQClient() {
		// TODO Auto-generated constructor stub
		// TODO Auto-generated constructor stub
				JTextArea jTextArea=new JTextArea();
				JPanel jPanel=new JPanel();
				String title="小黄";
				JButton send=new JButton("发送");
				JTextField jTextField=new JTextField(30);
				JScrollPane jpPane=new JScrollPane(jTextArea);
				jPanel.add(jTextField);
				jPanel.add(send);
				jTextArea.setEnabled(false);
				
				this.setTitle(title);
				this.add(jPanel,BorderLayout.SOUTH);
				this.add(jpPane);
				this.setVisible(true);
				this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				this.setSize(550, 800);
				
				try {
					
					Socket socket=new Socket("192.168.137.233", 8989);			//建立链接
					
					send.addActionListener(new SendClientListener(jTextArea,jTextField,socket.getOutputStream()));	
					//将文本框 输入框 输出流添加到点击事件	
					
					InputStream iStream=socket.getInputStream();  //建立输入流的链接
					
					InputStreamReader inputStreamReader=new InputStreamReader(iStream);
					BufferedReader bufferedReader=new BufferedReader(inputStreamReader);
					String string=null;
					while ((string=bufferedReader.readLine())!=null) {
						jTextArea.append("小黄说:"+string+"\r\n");
						
					}
					
				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				}
	}
	public static void main(String[] args) {
		QQClient qClient=new QQClient();
	}
}
