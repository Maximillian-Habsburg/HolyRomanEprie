package phone;

import java.util.Scanner;

public class AdminPurchase {
	public void adminPurchase() {
		Scanner adminInput = new Scanner(System.in);
		System.out.println("����鿴������Ϣҳ��������1");
		System.out.println("������ӽ�����Ϣҳ��������2");
		System.out.println("������һ��������quit");
		String adminChange = adminInput.nextLine();
		System.out.println(adminChange);
		if(adminChange.equals("1")){
			AdminPurchasequery adminPurchasequery = new AdminPurchasequery();
			adminPurchasequery.adminPurchasequery();
		}else if(adminChange.equals("2")){
			AdminPurchaseadd adminPurchaseadd = new AdminPurchaseadd();
			adminPurchaseadd.adminPurchaseadd();
		}else if(adminChange.equals("quit")){
			//�����ʼ����
			AdminIstraion adminIstraion = new AdminIstraion();
			adminIstraion.adminIstraion();
		}else{
			System.err.println("��������ȷ�����룡");
			adminPurchase();
		}
	}	
}
