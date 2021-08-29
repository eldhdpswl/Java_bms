package presentation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

import domain.Code;

public class Console extends MenuImpl implements Code {
	private static BufferedReader reader;
	
	//input받으면됨
	public Console() {
		
		//로그인(common으로 호출)
		commonMenu(SHOP_LOGIN);
		//loginMenu();
		
	}
	
	//인풋스트림
	public static String input() {
		reader = new BufferedReader(new InputStreamReader(System.in));
		String str="";
		try {
			str = reader.readLine();
		} catch(IOException e) {
			e.printStackTrace();
			System.out.println("키보드 입력에러!!");
		}
		
		return str;
		
	}
}
