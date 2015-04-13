package homework;

import homework.nnoco.io.InputFileReader;
import java.io.IOException;
import java.util.List;
/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println(args);

        try {
        	List<String> lines = InputFileReader.getLines(args[0]);
        	for(String line : lines) {
        		System.out.println(line);
        	}
        } catch (IOException e) {
        	e.printStackTrace();
        }
    }
}
