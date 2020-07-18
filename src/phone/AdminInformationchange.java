package phone;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Scanner;

import com.mysql.jdbc.PreparedStatement;

public class AdminInformationchange {

	public void adminInformationchange() {
		Scanner adminInput = new Scanner(System.in);
		Information information = new Information();
		System.out.println("欢迎进入更改页面！");
		System.out.println("请输入要更改信息的手机名：");
		information.setPhonename(adminInput.nextLine().trim());
		while(information.getPhonename().equals("")){
			System.err.println("您输入的信息为空请重新输入！");
			information.setPhonename(adminInput.nextLine().trim());
		}
		System.out.println("请输入要更改配置信息：");
		information.setConfigure(adminInput.nextLine().trim());
		while(information.getConfigure().equals("")){
			System.err.println("您输入的信息为空请重新输入！");
			information.setPhonename(adminInput.nextLine().trim());
		}
		System.out.println("请输入要更改的价格信息：");
		information.setPrice(adminInput.nextLine().trim());
		while(information.getPhonename().equals("")){
			System.err.println("您输入的信息为空请重新输入！");
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
				System.out.println("更改成功，跳转到登录页面");
			}else{
				System.out.println("无此设备，更改失败，返回上一级");
				AdminInformationchange adminInformationchange = new AdminInformationchange();
				adminInformationchange.adminInformationchange();
			}
		}catch (Exception e){
			e.printStackTrace();
		}
	}

}
