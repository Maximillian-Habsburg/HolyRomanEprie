package phone;

import java.util.Scanner;

public class AdminStock {
	public void adminStock() {
		Scanner adminInput = new Scanner(System.in);
		System.out.println("����鿴�����Ϣҳ��������1");
		System.out.println("������ӿ����Ϣҳ��������2");
		System.out.println("������Ŀ����Ϣҳ��������3");
		System.out.println("����ɾ�������Ϣҳ��������4");
		System.out.println("������һ��������quit");
		String adminChange = adminInput.nextLine();
		System.out.println(adminChange);
		if(adminChange.equals("1")){
			AdminStockquery adminStockquery = new AdminStockquery();
			adminStockquery.adminStockquery();
		}else if(adminChange.equals("2")){
			AdminStockadd adminStockadd = new AdminStockadd();
			adminStockadd.adminStockadd();
		}else if(adminChange.equals("3")){
			AdminStockchange adminStockchange = new AdminStockchange();
			adminStockchange.adminStockchange();
		}else if(adminChange.equals("4")){
			AdminStockdelete adminStockdelete = new AdminStockdelete();
			adminStockdelete.adminStockdelete();
		}else if(adminChange.equals("quit")){
			AdminIstraion adminIstraion = new AdminIstraion();
			adminIstraion.adminIstraion();
		}else{
			System.err.println("��������ȷ�����룡");
			adminStock();
		}
	}	
}
