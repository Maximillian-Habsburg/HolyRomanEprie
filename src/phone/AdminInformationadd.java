package phone;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Scanner;

import com.mysql.jdbc.PreparedStatement;

public class AdminInformationadd {

	public void adminInformationadd() {
		Scanner adminInput = new Scanner(System.in);
		Information information = new Information();
		System.out.println("欢迎进入添加页面！");
		System.out.println("请输入手机名：");
		information.setPhonename(adminInput.nextLine().trim());
		while(information.getPhonename().equals("")){
			System.err.println("您输入的用户名为空请重新输入！");
			information.setPhonename(adminInput.nextLine().trim());
		}
		System.out.println("请输入配置信息：");
		information.setConfigure(adminInput.nextLine().trim());
		while(information.getConfigure().equals("")){
			System.err.println("您输入的配置信息为空请重新输入！");
			information.setConfigure(adminInput.nextLine().trim());
		}
		System.out.println("请输入价格信息：");
		information.setPrice(adminInput.nextLine().trim());
		while(information.getPrice().equals("")){
			System.err.println("您输入的价格信息为空请重新输入！");
			information.setPrice(adminInput.nextLine().trim());
		}	
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/phone","root","123456");
			String sql = "INSERT INTO INFORMATION(phonename,configure,price) VALUE( ?, ?, ?)";
			PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);
			ps.setString(1,information.getPhonename());
			ps.setString(2,information.getConfigure());
			ps.setString(3,information.getPrice());
			int res = ps.executeUpdate();
			if(res != 0){
				System.out.println("添加成功，跳转到登录页面");
			}else{
				System.out.println("添加失败，返回上一级");
				AdminInformationadd adminInformationadd = new AdminInformationadd();
				adminInformationadd.adminInformationadd();
			}
			con.close();
		}catch (Exception e){
			e.printStackTrace();
		}
		
	}

}
