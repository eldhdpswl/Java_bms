package presentation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

import domain.Code;

public class Console extends MenuImpl implements Code {
	private static BufferedReader reader;
	
	//input�������
	public Console() {
		
		//�α���(common���� ȣ��)
		commonMenu(SHOP_LOGIN);
		//loginMenu();
		
	}
	
	//��ǲ��Ʈ��
	public static String input() {
		reader = new BufferedReader(new InputStreamReader(System.in));
		String str="";
		try {
			str = reader.readLine();
		} catch(IOException e) {
			e.printStackTrace();
			System.out.println("Ű���� �Է¿���!!");
		}
		
		return str;
		
	}
}
