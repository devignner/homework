package homework.nnoco.io;

import java.io.IOException;
import java.io.File;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;


public class InputFileReader {
	public static List<String> getLines(String filePath) throws IOException {
		File file = new File(filePath);

		Scanner scanner = new Scanner(file);

		List<String> lines = new ArrayList<String>();
		while(scanner.hasNextLine()) {
			lines.add(scanner.nextLine());
		}

		scanner.close();

		return lines;
	}
}