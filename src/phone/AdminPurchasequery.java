package phone;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.Scanner;

import com.mysql.jdbc.Statement;

public class AdminPurchasequery {
	public void adminPurchasequery() {
		Scanner adminInput = new Scanner(System.in);
		Order order = new Order();
		System.out.println("��ӭ���������ѯҳ�棡");
		System.out.println("�����������ַ����в鿴");
		order.setPhonename(adminInput.nextLine().trim());
		while(order.getPhonename().equals("")){
			System.err.println("���������ϢΪ�����������룡");
			order.setPhonename(adminInput.nextLine().trim());
		}
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/phone","root","123456");
			Statement ps = (Statement) con.createStatement();
			ResultSet res = ps.executeQuery("SELECT * FROM PURCHASE");
			if(res.next()){
				System.out.println("��ѯ�ɹ�����Ϣ����");
				System.out.println("�豸��ţ�"+res.getInt("id")+"\t�ֻ����ƣ�"+res.getString("phonename")+"\t������Ϣ��"+res.getString("number")+"\t�۸���Ϣ��"+res.getString("price")+"\t����ʱ�䣺"+res.getString("ts"));
			}else{
				System.out.println("��ѯʧ�ܣ�������һ��");
				AdminInformation adminInformation = new AdminInformation();
				adminInformation.adminInformation();
			}
		}catch (Exception e){
			e.printStackTrace();
		}

	}
}
