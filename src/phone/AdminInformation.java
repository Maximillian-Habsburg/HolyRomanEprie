package phone;

import java.util.Scanner;

public class AdminInformation {

	public void adminInformation() {
		Scanner adminInput = new Scanner(System.in);
		System.out.println("��ѯ����������1");
		System.out.println("��Ӳ���������2");
		System.out.println("���Ĳ���������3");
		System.out.println("ɾ������������4");
		System.out.println("������һ��������quit");
		String adminChange = adminInput.nextLine();
		System.out.println(adminChange);
		if(adminChange.equals("1")){
			AdminInformationquery adminInformationquery = new AdminInformationquery();
			adminInformationquery.adminInformationquery();
		}else if(adminChange.equals("2")){
			AdminInformationadd adminInformationadd = new AdminInformationadd();
			adminInformationadd.adminInformationadd();
		}else if(adminChange.equals("3")){
			AdminInformationchange adminInformationchange = new AdminInformationchange();
			adminInformationchange.adminInformationchange();
		}else if(adminChange.equals("4")){
			AdminInformationdelete adminInformationdelete = new AdminInformationdelete();
			adminInformationdelete.adminInformationdelete();
		}else if(adminChange.equals("quit")){
			//�����ʼ����
			AdminIstraion adminIstraion = new AdminIstraion();
			adminIstraion.adminIstraion();
		}else{
			System.err.println("��������ȷ�����룡");
			adminInformation();
		}
		
	}

}
