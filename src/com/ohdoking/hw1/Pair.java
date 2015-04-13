package com.ohdoking.hw1;

import java.util.Stack;

public class Pair {

	public Integer checkPair(String sValue) {
		byte[] stringByte = StringToByte(sValue);
		int correctResultNum = 0;
		boolean CheckSignOfInequality = false;
		Stack<Character> stack = new Stack<Character>();
		char[] charArr = (new String(stringByte)).toCharArray();

		for (int i = 0; i < charArr.length; i++) {

			if(charArr[i] == '#'){
				break;
			}
			
			if(charArr[i] == '<' || charArr[i] == '>' ){
				CheckSignOfInequality = isCheckSignOfInequality(charArr,i);
			}
			if(CheckSignOfInequality == true){
				
			}
			else{
				if (charArr[i] == '(' 
						|| charArr[i] == '[' 
						|| charArr[i] == '{'
						|| charArr[i] == '<' 
						) {
					stack.add(charArr[i]);
				}
				
				if(charArr[i] == '>'
						|| charArr[i] == '}' 
						|| charArr[i] == ']'
						|| charArr[i] == ')'){
					
					if(stack.isEmpty()){
						return i+1;
					}
					if(charArr[i] == pairKey(stack.lastElement())){
						stack.pop();
					}
					else{
						return i+1;
					}
				}
			}
			
		}

	
			
			return correctResultNum;


	}
	
	public char pairKey(char charValue){
		if(charValue == '{')
			return '}';
		if(charValue == '[')
			return ']';
		if(charValue == '(')
			return ')';
		if(charValue == '<')
			return '>';
		
		return 0;
	}

	public boolean isCheckSignOfInequality(char[] array, int index){
		
		if(index == 1){
			return false;
		}
		System.out.println(array[index - 2] + " : " + array[index + 2]);
		if(		 array[index - 2] == '['
				|| array[index - 2] == '{'
				|| array[index - 2] == '<'
				|| array[index - 2] == '>'
				|| array[index - 2] == '}'
				|| array[index - 2] == ']'
				|| array[index + 2] == '['
				|| array[index + 2] == '{'
				|| array[index + 2] == '<'
				|| array[index + 2] == '>'
				|| array[index + 2] == '}'
				|| array[index + 2] == ']')
		{
			if(array[index - 2] == '(' 
				|| array[index - 2] == ')'
				|| array[index + 2] == '('
				|| array[index + 2] == ')')
			{
				if(		 array[index - 2] == '['
						|| array[index - 2] == '{'
						|| array[index - 2] == '<'
						|| array[index - 2] == '>'
						|| array[index - 2] == '}'
						|| array[index - 2] == ']'
						|| array[index + 2] == '['
						|| array[index + 2] == '{'
						|| array[index + 2] == '<'
						|| array[index + 2] == '>'
						|| array[index + 2] == '}'
						|| array[index + 2] == ']')
				{
					return false;
				}
				return true;
			}
			return false;
			
		}
		
		return true;
		
	}

	public byte[] StringToByte(String sValue) {
		return sValue.getBytes();
	}
}
