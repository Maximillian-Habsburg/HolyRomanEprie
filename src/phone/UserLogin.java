package phone;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.Scanner;

import com.mysql.jdbc.PreparedStatement;

public class UserLogin {
	public void userLogin(){
		Scanner userInput = new Scanner(System.in);
		User user = new User();
		System.out.println("��ӭ�����¼");
		System.out.println("�������û�����");
		//nextLine(),���û����ַ�����ʽ����
		user.setUsername(userInput.nextLine().trim());
		int num = 0;
		while(user.getUsername().equals("")){
			if(num >=3){
				//��ת����ҳ
				System.err.println("�û�������������࣬���������û�ϵͳ��ҳ��");
				UserSystem userSystem = new UserSystem();
				userSystem.userSystem();
			}
			System.err.println("��������û���Ϊ�����������룡");
			user.setUsername(userInput.nextLine().trim());
			num++;
		}
		System.out.println("���������룺��6-16λ��");
		user.setPassword(userInput.nextLine().trim());
		VerifyPassword verifyPassword = new VerifyPassword();
		int verifyPasswordNum = verifyPassword.verifyPassword(user.getPassword());
		while(verifyPasswordNum == 0 || verifyPasswordNum == 1){
			if(verifyPasswordNum == 0){
				System.err.println("�����������Ϊ�����������룡");
				user.setPassword(userInput.nextLine().trim());
				verifyPasswordNum = verifyPassword.verifyPassword(user.getPassword());
			}
			if(verifyPasswordNum == 1){
				System.err.println("����������볤�Ȳ�����6-16λ��");
				user.setPassword(userInput.nextLine().trim());
				verifyPasswordNum = verifyPassword.verifyPassword(user.getPassword());
			}
		}
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/phone","root","123456");
			String sql = "SELECT * FROM USER WHERE username=? and password=?";
			PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);
			ps.setString(1,user.getUsername());
			ps.setString(2,user.getPassword());
			ResultSet res = ps.executeQuery();
			if(res.next()){
				System.out.println("��¼�ɹ�����ת���̵�ҳ��");
			}else{
				System.out.println("��¼ʧ�ܣ�������һ��");
				UserSystem userSystem = new UserSystem();
				userSystem.userSystem();
			}
		}catch (Exception e){
			e.printStackTrace();
		}
	}
}

	
	

