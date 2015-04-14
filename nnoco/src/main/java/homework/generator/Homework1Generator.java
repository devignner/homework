package homework.generator;

import homework.nnoco.hw1.BracketPair;
import homework.nnoco.io.OutputFileWriter;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Stack;

public class Homework1Generator {
	public static final String DEFAULT_FILE_PATH = "hw1";
	private static final String alphabets = "abcdefghijklmnopqrstuvwxyz";
	private static final char[] lowerCaseTokens = alphabets.toCharArray();
	private static final char[] upperCaseTokens = alphabets.toUpperCase().toCharArray();
	private static final char[] operators = "!%^&**-+/?~".toCharArray();
	private static final BracketPair[] brackets = {
		BracketPair.create('(', ')'),
		BracketPair.create('[',']'),
		BracketPair.create('{','}'),
		BracketPair.create('<','>'),
	};
	private static final int MAX_COUNT = 10000;
	
	private static Random random = new Random(System.currentTimeMillis());
	private List<String> generatedLines = new ArrayList<String>();
	private List<String> output = new ArrayList<String>();
	
	public void generate(int count) {
		generate(DEFAULT_FILE_PATH, count);
	}
	
	public void generate(String fileName, int count) {
		for(int i=0; i<count; i++) {
			createEquation();
		}
		
		writeToFile(generatedLines, fileName + ".inp");
		writeToFile(output, fileName + ".out");
	}
	
	private void createEquation() {
		Stack<BracketPair> bracketStack = new Stack<BracketPair>();
		int count = random.nextInt(MAX_COUNT) + 20;
		StringBuilder result = new StringBuilder();
		
		while(count > 0) {
			// 괄호 랜덤 생성
			if(trueOrFalse()) {
				BracketPair pair = getRandomItem(brackets);
				bracketStack.push(pair);
				result.append(pair.open);
			}

			// 공백 임의 삽입
			if(trueOrFalse()) result.append(' ');
			// 토큰 랜덤 생성
			if(trueOrFalse()) result.append(genRandomToken());
			// 공백 임의 삽입
			if(trueOrFalse()) result.append(' ');
			
			// 괄호 닫을까 말까
			if(trueOrFalse() && bracketStack.size() > 0) {
				BracketPair pair = bracketStack.pop();
				result.append(pair.close);
				count--;
			}
		}

		// 4분의 1확률로 올바르지 않은 식을 만듬
		boolean isWrong = random.nextBoolean() && random.nextBoolean();
		if(isWrong) {
			int wrongColNumber = random.nextInt(result.length());
			char randomBracket = getRandomBracket();
			
			result.insert(wrongColNumber, randomBracket);
			
			output.add(wrongColNumber +" 번째 열에 올바르지 않은 괄호입니다. - " + randomBracket);
		} else {
			output.add("올바름");
		}
		
		generatedLines.add(result.toString());
	}
	
	private char getRandomBracket() {
		BracketPair bracket = getRandomItem(brackets);
		return random.nextBoolean() ?
				bracket.open : bracket.close;
	}

	private boolean trueOrFalse() {
		return random.nextBoolean();
	}

	public static void main(String[] args) {
		new Homework1Generator().generate(500);
	}
	
	private String genRandomToken() {
		return random.nextBoolean() ?
				genMonomial() : genBinomial();
	}
	
	private String genMonomial() {
		BracketPair bracketPair = getRandomItem(brackets);
		
		return new StringBuilder()
			.append(getRandomCharacter(lowerCaseTokens, upperCaseTokens))
			.append(bracketPair.open)
			.append(getRandomCharacter(lowerCaseTokens, upperCaseTokens))
			.append(bracketPair.close)
			.toString();
	}
	
	private String genBinomial() {
		return new StringBuilder()
			.append(getRandomCharacter(lowerCaseTokens, upperCaseTokens))
			.append(getRandomCharacter(operators))
			.append(getRandomCharacter(lowerCaseTokens, upperCaseTokens))
			.toString();
	}
	
	private char getRandomCharacter(char[] charArray1, char[] charArray2) {
		return random.nextBoolean() ? 
				getRandomCharacter(charArray1): getRandomCharacter(charArray2);
	}

	private char getRandomCharacter(char[] charArray) {
		return charArray[random.nextInt(charArray.length)];
	}
	
	// Reference 타입만 가능..
	private <T> T getRandomItem(T[] array) {
		return array[random.nextInt(array.length)];
	}
	
	private void writeToFile(List<String> lines, String filePath) {
		OutputFileWriter.writeLines(lines, filePath);
	}
}
