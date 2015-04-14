package homework.nnoco.io;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;


public class InputFileReader {
	/**
	 * 텍스트파일의 내용을 줄단위로 읽는 메서드.
	 * @param filePath 텍스트를 읽을 파일의 위치
	 * @return 읽은 파일 내용을 List<String>으로 읽음, 예외가 발생한 경우 null 리턴
	 */
	public static List<String> getLines(String filePath) {
		List<String> lines = null;
		
		try {
			Path path = FileSystems.getDefault().getPath(filePath);
			lines = Files.readAllLines(path);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return lines;
	}
}