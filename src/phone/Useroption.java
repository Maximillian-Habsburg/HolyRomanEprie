package phone;

import java.util.Scanner;

public class Useroption {
	public void useroption(){
		Scanner userInput = new Scanner(System.in);
		System.out.println("�鿴��Ʒ������1");
		System.out.println("�鿴����������2");
		System.out.println("��Ӷ���������3");
		System.out.println("���Ķ���������4");
		System.out.println("ɾ������������5");
		System.out.println("������һ��������quit");
		String userChange = userInput.nextLine();
		System.out.println(userChange);
		if(userChange.equals("1")){
			UserCommodity userCommodity = new UserCommodity();
			userCommodity.userCommodity();
		}else if(userChange.equals("2")){
			UserOrderquery userOrderquery = new UserOrderquery();
			userOrderquery.userOrderquery();
		}else if(userChange.equals("3")){
			UserOrderadd userOrderadd = new UserOrderadd();
			userOrderadd.userOrderadd();
		}else if(userChange.equals("4")){
			UserOrderchange userOrderchange = new UserOrderchange();
			userOrderchange.userOrderchange();
		}else if(userChange.equals("5")){
			UserOrderdelete userOrderdelete = new UserOrderdelete();
			userOrderdelete.userOrderdelete();
		}else if(userChange.equals("quit")){
			UserLogin userLogin = new UserLogin();
			userLogin.userLogin();
		}else{
			System.err.println("��������ȷ�����룡");
			useroption();
		}
	}
}
