package phone;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.Scanner;

import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

public class AdminInformationdelete {

	public void adminInformationdelete() {
		Scanner adminInput = new Scanner(System.in);
		Information information = new Information();
		System.out.println("��ӭ����ɾ��ҳ�棡");
		System.out.println("������Ҫɾ����Ϣ���ֻ�����");
		information.setPhonename(adminInput.nextLine().trim());
		while(information.getPhonename().equals("")){
			System.err.println("���������ϢΪ�����������룡");
			information.setPhonename(adminInput.nextLine().trim());
		}
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/phone","root","123456");
			String sql="DELETE FROM INFORMATION WHERE phonename=?";
			PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);
			ps.setString(1,information.getPhonename());
			int res = ps.executeUpdate();
			if(res != 0){
				System.out.println("ɾ���ɹ�����ת����¼ҳ��");
			}else{
				System.out.println("���޴��豸��ɾ��ʧ�ܣ�������һ��");
				AdminInformationdelete adminInformationdelete = new AdminInformationdelete();
				adminInformationdelete.adminInformationdelete();
			}
		}catch (Exception e){
			e.printStackTrace();
		}
	}

}
