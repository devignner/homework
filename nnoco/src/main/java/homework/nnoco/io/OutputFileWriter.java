package homework.nnoco.io;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class OutputFileWriter {
	/**
	 * List<String>을 파일로 출력한다. 리스트의 각 항목은 텍스트 파일의 한 줄이다.
	 * @param lines 출력할 String List
	 * @param filePath 출력할 파일 경로
	 * @return 정상적으로 저장한 경우 true, 예외가 발생한 경우 false
	 */
	public static boolean writeLines(List<String> lines, String filePath) {
		try {
			Path path = FileSystems.getDefault().getPath(filePath);
			Files.write(path, lines);
			
			return true;
		} catch (IOException e) {
			e.printStackTrace();
			
			return false;
		}
	}
}
