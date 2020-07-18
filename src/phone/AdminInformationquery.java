package phone;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.Scanner;

import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

public class AdminInformationquery {

	public void adminInformationquery() {
		Scanner adminInput = new Scanner(System.in);
		Information information = new Information();
		System.out.println("欢迎进入查询页面！");
		System.out.println("请输入任意字符");
		information.setPhonename(adminInput.nextLine().trim());
		while(information.getPhonename().equals("")){
			System.err.println("您输入的信息为空请重新输入！");
			information.setPhonename(adminInput.nextLine().trim());
		}
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/phone","root","123456");
			Statement ps = (Statement) con.createStatement();
			ResultSet res = ps.executeQuery("SELECT * FROM INFORMATION");
			while(res.next()){
				System.out.println("查询成功，信息如下");
				System.out.println(res.getString("phonename"));
				System.out.println(res.getString("configure"));
				System.out.println(res.getString("price"));
				System.out.println(res.getString("ts"));
				System.out.println();
			}
		}catch (Exception e){
			e.printStackTrace();
		}

	}

}
