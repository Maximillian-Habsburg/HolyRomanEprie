package phone;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.Scanner;

import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

public class UserOrderdelete {
	public void userOrderdelete() {
		Scanner userInput = new Scanner(System.in);
		Order order = new Order();
		System.out.println("��ӭ���붩��ɾ��ҳ�棡");
		System.out.println("�����붩���ţ�");
		order.setId(userInput.nextLine().trim());
		while(order.getId().equals("")){
			System.err.println("���������ϢΪ�����������룡");
			order.setId(userInput.nextLine().trim());
		}
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/order","root","123456");
			String sql="DELETE FROM BILL WHERE id=?";
			PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);
			ps.setString(1,order.getId());
			int res = ps.executeUpdate();
			if(res != 0){
				System.out.println("ɾ���ɹ�����ת����¼ҳ��");
			}else{
				System.out.println("���޴˶�����ɾ��ʧ�ܣ�������һ��");
				Useroption useroption = new Useroption();
				useroption.useroption();
			}
		}catch (Exception e){
			e.printStackTrace();
		}
	}
}
