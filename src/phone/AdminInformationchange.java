package phone;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Scanner;

import com.mysql.jdbc.PreparedStatement;

public class AdminInformationchange {

	public void adminInformationchange() {
		Scanner adminInput = new Scanner(System.in);
		Information information = new Information();
		System.out.println("��ӭ�������ҳ�棡");
		System.out.println("������Ҫ������Ϣ���ֻ�����");
		information.setPhonename(adminInput.nextLine().trim());
		while(information.getPhonename().equals("")){
			System.err.println("���������ϢΪ�����������룡");
			information.setPhonename(adminInput.nextLine().trim());
		}
		System.out.println("������Ҫ����������Ϣ��");
		information.setConfigure(adminInput.nextLine().trim());
		while(information.getConfigure().equals("")){
			System.err.println("���������ϢΪ�����������룡");
			information.setPhonename(adminInput.nextLine().trim());
		}
		System.out.println("������Ҫ���ĵļ۸���Ϣ��");
		information.setPrice(adminInput.nextLine().trim());
		while(information.getPhonename().equals("")){
			System.err.println("���������ϢΪ�����������룡");
			information.setPrice(adminInput.nextLine().trim());
		}
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/phone","root","123456");
			String sql="UPDATE INFORMATION SET configure=? , price=? WHERE phonename=?";
			PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);
			ps.setString(1,information.getConfigure());
			ps.setString(2,information.getPrice());
			ps.setString(3,information.getPhonename());
			int res = ps.executeUpdate();
			if(res != 0){
				System.out.println("���ĳɹ�����ת����¼ҳ��");
			}else{
				System.out.println("�޴��豸������ʧ�ܣ�������һ��");
				AdminInformationchange adminInformationchange = new AdminInformationchange();
				adminInformationchange.adminInformationchange();
			}
		}catch (Exception e){
			e.printStackTrace();
		}
	}

}
