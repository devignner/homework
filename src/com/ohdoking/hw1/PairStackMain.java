package com.ohdoking.hw1;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;
import java.util.Stack;

public class PairStackMain {

	public static void main(String[] args) {

		try {

			Pair p = new Pair();
			byte[] b = new byte[1024];
			FileInputStream input = new FileInputStream("io\\hw1.inp");
			int result; 
						
			input.read(b);
			
			
			String[] deviceString = new String(b).split("\\r?\\n");
			
			for (String string : deviceString) {
				System.out.println(string + "의 결과");
				result = p.checkPair(string);
				
				if(result == 0)
				{
					System.out.println("올바름");
				}
				else if(result == 1)
				{
					System.out.println("닫히지 않고 끝났습니다");
					
				}
				else
				{
					System.out.println(result + "번째 열의 괄호가 맞지 않습니다");
				}
			}

			input.close();

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	

}
