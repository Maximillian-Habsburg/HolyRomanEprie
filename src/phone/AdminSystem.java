package phone;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.Scanner;

import com.mysql.jdbc.PreparedStatement;

public class AdminSystem {
	public void adminSystem(){
		Scanner adminInput = new Scanner(System.in);
		Admin admin = new Admin();
		System.out.println("��ӭ����Ա��");
		System.out.println("�������û�����");
		admin.setAdminname(adminInput.nextLine().trim());
		int num = 0;
		while(admin.getAdminname().equals("")){
			if(num >=3){
				//��ת����ҳ
				System.err.println("�û�������������࣬���������û�ϵͳ��ҳ��");
				UserSystem userSystem = new UserSystem();
				userSystem.userSystem();
			}
			System.err.println("��������û���Ϊ�����������룡");
			admin.setAdminname(adminInput.nextLine().trim());
			num++;
		}
		System.out.println("���������룺��6-16λ��");
		admin.setPassword(adminInput.nextLine().trim());
		VerifyPassword verifyPassword = new VerifyPassword();
		int verifyPasswordNum = verifyPassword.verifyPassword(admin.getPassword());
		while(verifyPasswordNum == 0 || verifyPasswordNum == 1){
			if(verifyPasswordNum == 0){
				System.err.println("�����������Ϊ�����������룡");
				admin.setPassword(adminInput.nextLine().trim());
				verifyPasswordNum = verifyPassword.verifyPassword(admin.getPassword());
			}
			if(verifyPasswordNum == 1){
				System.err.println("����������볤�Ȳ�����6-16λ��");
				admin.setPassword(adminInput.nextLine().trim());
				verifyPasswordNum = verifyPassword.verifyPassword(admin.getPassword());
			}
		}
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/phone","root","123456");
			String sql = "SELECT * FROM ADMINISTRATORS WHERE adminname=? and password=?";
			PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);
			ps.setString(1,admin.getAdminname());
			ps.setString(2,admin.getPassword());
			ResultSet res = ps.executeQuery();
			if(res.next()){
				System.out.println("��¼�ɹ�����ת������ҳ��");
				AdminIstraion adminIstraion = new AdminIstraion();
				adminIstraion.adminIstraion();
			}else{
				System.out.println("��¼ʧ�ܣ�������һ��");
				Login login = new Login();
				login.Login();
			}
		}catch (Exception e){
			e.printStackTrace();
		}
	}
}

