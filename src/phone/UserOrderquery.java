package phone;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.Scanner;
import java.sql.Connection;

import com.mysql.jdbc.Statement;

public class UserOrderquery {
	public void userOrderquery() {
		Scanner userInput = new Scanner(System.in);
		Order order = new Order();
		System.out.println("��ӭ���붩����ѯҳ�棡");
		System.out.println("�����������ַ����в鿴");
		order.setPhonename(userInput.nextLine().trim());
		while(order.getPhonename().equals("")){
			System.err.println("���������ϢΪ�����������룡");
			order.setPhonename(userInput.nextLine().trim());
		}
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/phone","root","123456");
			Statement ps = (Statement) con.createStatement();
			ResultSet res = ps.executeQuery("SELECT * FROM BILL");
			if(res.next()){
				System.out.println("��ѯ�ɹ���������Ϣ����");
				System.out.println("������ţ�"+res.getInt("id")+"\t�ֻ����ƣ�"+res.getString("phonename")+"\t�ֻ�������"+res.getString("number")+"\t�۸���Ϣ��"+res.getString("price")+"\t����ʱ�䣺"+res.getString("ts"));
			}else{
				System.out.println("��ѯʧ�ܣ�������һ��");
				Useroption useroption = new Useroption();
				useroption.useroption();
			}
		}catch (Exception e){

			e.printStackTrace();
		}
}
}
