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
		System.out.println("�������豸�ţ�");
		information.setId(adminInput.nextLine().trim());
		while(information.getId().equals("")){
			System.err.println("���������ϢΪ�����������룡");
			information.setId(adminInput.nextLine().trim());
		}
		System.out.println("������Ҫ���ĵ��ֻ�����");
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
			String sql="UPDATE INFORMATION SET phonename=? , configure=? , price=? WHERE id=?";
			PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);
			ps.setString(1,information.getPhonename());
			ps.setString(2,information.getConfigure());
			ps.setString(3,information.getPrice());
			ps.setString(4,information.getId());
			int res = ps.executeUpdate();
			if(res != 0){
				System.out.println("���ĳɹ�!");
			}else{
				System.out.println("�޴��豸������ʧ�ܣ�������һ��");
				AdminInformation adminInformation = new AdminInformation();
				adminInformation.adminInformation();
			}
		}catch (Exception e){
			e.printStackTrace();
		}
	}

}
