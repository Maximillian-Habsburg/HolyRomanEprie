package phone;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Scanner;

import com.mysql.jdbc.PreparedStatement;

public class UserOrderadd {
	public void userOrderadd() {
		Scanner userInput = new Scanner(System.in);
		Order order = new Order();
		System.out.println("��ӭ���붩�����ҳ�棡");
		System.out.println("�������ֻ�����");
		order.setPhonename(userInput.nextLine().trim());
		while(order.getPhonename().equals("")){
			System.err.println("��������û���Ϊ�����������룡");
			order.setPhonename(userInput.nextLine().trim());
		}
		System.out.println("�����������");
		order.setNumber(userInput.nextLine().trim());
		VerifyNumber verifyNumber = new VerifyNumber();
		int verifyNumberNum = verifyNumber.verifyNumber(order.getNumber());
		while(verifyNumberNum == 0 || verifyNumberNum == 1){
			if(verifyNumberNum == 0){
				System.err.println("���������Ϊ�����������룡");
				order.setNumber(userInput.nextLine().trim());
				verifyNumberNum = verifyNumber.verifyNumber(order.getNumber());
			}
			if(verifyNumberNum == 1){
				System.err.println("������������࣡��0-99��");
				order.setNumber(userInput.nextLine().trim());
				verifyNumberNum = verifyNumber.verifyNumber(order.getNumber());
			}
		}
		System.out.println("������۸���Ϣ��");
		order.setPrice(userInput.nextLine().trim());
		VerifyPrice verifyPrice = new VerifyPrice();
		int verifyPriceNum = verifyPrice.verifyPrice(order.getPrice());
		while(verifyPriceNum == 0 || verifyPriceNum == 1){
			if(verifyPriceNum == 0){
				System.err.println("������۸�Ϊ�����������룡");
				order.setPrice(userInput.nextLine().trim());
				verifyPriceNum = verifyPrice.verifyPrice(order.getPrice());
			}
			if(verifyPriceNum == 1){
				System.err.println("������۸񲻷��Ϲ��򣡣�100-99999��");
				order.setPrice(userInput.nextLine().trim());
				verifyPriceNum = verifyPrice.verifyPrice(order.getPrice());
			}
		}
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/phone","root","123456");
			String sql = "INSERT INTO BILL(phonename,number,price) VALUE( ?, ?, ?)";
			PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);
			ps.setString(1,order.getPhonename());
			ps.setString(2,order.getNumber());
			ps.setString(3,order.getPrice());
			int res = ps.executeUpdate();
			if(res != 0){
				System.out.println("������ӳɹ�����ת����¼ҳ��");
			}else{
				System.out.println("�������ʧ�ܣ�������һ��");
				Useroption useroption = new Useroption();
				useroption.useroption();
			}
			con.close();
		}catch (Exception e){
			e.printStackTrace();
		}
		
	}
}
