package phone;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Scanner;

import com.mysql.jdbc.PreparedStatement;

public class AdminInformationadd {

	public void adminInformationadd() {
		Scanner adminInput = new Scanner(System.in);
		Information information = new Information();
		System.out.println("��ӭ�������ҳ�棡");
		System.out.println("�������ֻ�����");
		information.setPhonename(adminInput.nextLine().trim());
		while(information.getPhonename().equals("")){
			System.err.println("��������û���Ϊ�����������룡");
			information.setPhonename(adminInput.nextLine().trim());
		}
		System.out.println("������������Ϣ��");
		information.setConfigure(adminInput.nextLine().trim());
		while(information.getConfigure().equals("")){
			System.err.println("�������������ϢΪ�����������룡");
			information.setConfigure(adminInput.nextLine().trim());
		}
		System.out.println("������۸���Ϣ��");
		information.setPrice(adminInput.nextLine().trim());
		VerifyPrice verifyPrice = new VerifyPrice();
		int verifyPriceNum = verifyPrice.verifyPrice(information.getPrice());
		while(verifyPriceNum == 0 || verifyPriceNum == 1){
			if(verifyPriceNum == 0){
				System.err.println("������۸�Ϊ�����������룡");
				information.setPrice(adminInput.nextLine().trim());
				verifyPriceNum = verifyPrice.verifyPrice(information.getPrice());
			}
			if(verifyPriceNum == 1){
				System.err.println("������۸񲻷��Ϲ��򣡣�100-99999��");
				information.setPrice(adminInput.nextLine().trim());
				verifyPriceNum = verifyPrice.verifyPrice(information.getPrice());
			}
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
				System.out.println("��ӳɹ�");
			}else{
				System.out.println("���ʧ�ܣ�������һ��");
				AdminInformation adminInformation = new AdminInformation();
				adminInformation.adminInformation();
			}
			con.close();
		}catch (Exception e){
			e.printStackTrace();
		}
		
	}

}
