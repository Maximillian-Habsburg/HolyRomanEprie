package phone;

import java.util.Scanner;

public class AdminShipment {
	public void adminShipment() {
		Scanner adminInput = new Scanner(System.in);
		System.out.println("����鿴������Ϣҳ��������1");
		System.out.println("������ӳ�����Ϣҳ��������2");
		System.out.println("������һ��������quit");
		String adminChange = adminInput.nextLine();
		System.out.println(adminChange);
		if(adminChange.equals("1")){
			AdminShipmentquery adminShipmentquery = new AdminShipmentquery();
			adminShipmentquery.adminShipmentquery();
		}else if(adminChange.equals("2")){
			AdminShipmentadd adminShipmentadd = new AdminShipmentadd();
			adminShipmentadd.adminShipmentadd();
		}else if(adminChange.equals("quit")){
			//�����ʼ����
			AdminIstraion adminIstraion = new AdminIstraion();
			adminIstraion.adminIstraion();
		}else{
			System.err.println("��������ȷ�����룡");
			adminShipment();
		}
	}	
	
}
