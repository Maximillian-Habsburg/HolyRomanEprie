package phone;

import java.util.Scanner;

public class AdminIstraion {

	public void adminIstraion() {
		Scanner adminInput = new Scanner(System.in);
		System.out.println("�����豸����ҳ��������1");
		System.out.println("�����������ҳ��������2");
		System.out.println("�����������ҳ��������3");
		System.out.println("���������ҳ��������3");
		System.out.println("������һ��������quit");
		String adminChange = adminInput.nextLine();
		System.out.println(adminChange);
		if(adminChange.equals("1")){
			AdminInformation adminInformation = new AdminInformation();
			adminInformation.adminInformation();
		}else if(adminChange.equals("2")){
			AdminShipment adminShipment = new AdminShipment();
			adminShipment.adminShipment();
		}else if(adminChange.equals("3")){
			AdminPurchase adminPurchase = new AdminPurchase();
			adminPurchase.adminPurchase();
		}else if(adminChange.equals("4")){
			AdminStock adminStock = new AdminStock();
			adminStock.adminStock();
		}else if(adminChange.equals("quit")){
			//�����ʼ����
			Login login = new Login();
			login.Login();
		}else{
			System.err.println("��������ȷ�����룡");
			adminIstraion();
		}
	}	
}
