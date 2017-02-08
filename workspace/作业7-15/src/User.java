import java.util.List;
import java.util.Map;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;

import javax.jws.soap.SOAPBinding.Use;

public class User implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private String name;
	private String sex;
	//User 构造方法初始化 user对象的信息***************
	
	public User(int id,String name,String sex) {
		// TODO Auto-generated constructor stub
		this.id=id;
		this.name=name;
		this.sex=sex;
	}
	
	public User() {
		// TODO Auto-generated constructor stub
	}
	//*********************************************
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		
		return id;
	}
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		if(obj instanceof User){
			User tmp=(User) obj;
				if(tmp.name.equals(this.name))
					return true;
		}
		return false;
	}

	public void modify(int  nId,String nName,String nSex){
		id=nId;
		name=nName;
		sex=nSex;
	}
	//修改user对象的信息
	
	public void showInfo(){
		System.out.println("ID:"+id+" Name:"+name+" Sex:"+sex);
	}
	//展示user 对象的信息

	//********************************************
	public int getId(){
		return id;
	}
	//获取对象id

	//*******************************************************
	public static void readObjFrmFile( List<User> lst, String srcPath){
		FileInputStream fiss;
		ObjectInputStream oiss;
		User tmpUser=null;
		try {
			
			fiss=new FileInputStream(srcPath);
			oiss=new ObjectInputStream(fiss);
			
			oiss.readObject();
			
			oiss.close();
			fiss.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	//读取文件中的对象信息保存到一个list集合中
	
	//*******************************************************
	public static void SaveList(List<User> lst,String path){
		FileOutputStream foss;
		ObjectOutputStream oss;
		try {
			foss=new FileOutputStream(path);
			oss=new ObjectOutputStream(foss);
			//Iterator<User> itt=lst.iterator();
			
			
			oss.writeObject(lst);
			
			oss.flush();
			oss.close();
			foss.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	//保存list集合信息
	
	
	//*******************************************************
	public static User enterInfo(){
		Scanner scanner=new Scanner(System.in);
		User tmpUser=null;
		int id;
		String name=null;
		String sex=null;
		System.out.println("Input User's Information:");
		//scanner.next();
		id=scanner.nextInt();
		name=scanner.next();
		sex=scanner.next();
		tmpUser=new User(id,name,sex);
			//		list.add(new User(id, name, sex));
		return tmpUser;
	}
	//获取新User对象信息，并创建对象返回

	
	//******************************************************
	public static Map<Integer, User>covertToMap(List< User> lst){
		Map<Integer, User> tmpMap=new HashMap<Integer,User>();
		//Iterator< User> itl=lst.iterator();
		for (User user : lst) {
			tmpMap.put(user.getId(), user);
		}
		return tmpMap;
	}
	//将list中的对象元素按以id为key值存入map
	
	
	//******************************************************
	public static void chInfo(User preUser){
		Scanner scanner=new Scanner(System.in);
		int id;
		String name=null;
		String sex=null;
		System.out.println("Input User's Information:");
		scanner.next();
	
		
		id=scanner.nextInt();
		name=scanner.next();
		sex=scanner.next();
		preUser.modify(id, name, sex);
		
	}
	//更改一个user对象的信息

	
	//******************************************************
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		List<User> list=new ArrayList<User>();
		Map<Integer, User> cap=null;
		list.add(enterInfo());
		list.add(enterInfo());
		list.add(enterInfo());
		String savePath="";
		System.out.println("Input save path:");
		savePath=scanner.nextLine();
		SaveList(list, savePath);
		
		readObjFrmFile(list,savePath);
		for (User user : list) {
			user.showInfo();
		}
	}
	//主函数入口
	///Users/mac/Desktop/demo/data.txt
}
