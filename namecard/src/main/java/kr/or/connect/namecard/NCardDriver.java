package kr.or.connect.namecard;

import java.util.Scanner;

import kr.or.connect.namecard.dao.NCardDao;
import kr.or.connect.namecard.dao.NCardDao2;
import kr.or.connect.namecard.dto.NCard;

public class NCardDriver {

	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		NCardDao nd=new NCardDao();
		NCardDao2 nd2=new NCardDao2();
		NCard nc=null;
		int menu;
		String name;
		String phone;
		String companyName;
		
		while(true) {
			System.out.println("-----------------------");
			System.out.println("1. 명함 입력");
			System.out.println("2. 명함 검색");
			System.out.println("3. 종료");
			System.out.println("-----------------------");
			System.out.print("메뉴를 입력하세요 : ");
			menu=scan.nextInt();
			if(menu==1) {
				System.out.print("이름을 입력하세요 : ");
				name=scan.next();
				System.out.print("전화번호를 입력하세요 : ");
				phone=scan.next();
				System.out.print("회사 이름을 입력하세요 : ");
				companyName=scan.next();
				nd2.setCard(name, phone, companyName);
			}
			else if(menu==2) {
				System.out.print("검색할 이름을 입력하세요. (like검색) : ");
				name=scan.next();
				nc=nd.getNCard(name);
				System.out.println(nc);
			}
			else if(menu==3) {
				System.out.println("프로그램을 종료합니다. :-)");
				break;
			}
			else {
				System.out.println("잘못된 입력입니다.");
				continue;
			}
		}
	}

}
