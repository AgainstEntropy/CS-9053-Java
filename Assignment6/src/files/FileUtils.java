package files;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileUtils {

	public static String readFile(String fileName) {
		String output = "";
		try (FileReader f = new FileReader(fileName)) {
			BufferedReader in = new BufferedReader(f);
			String line = null;
			while ((line = in.readLine()) != null) {
				output += line + "\n";
			}
		} catch (FileNotFoundException e) {
			System.out.println("File not found: " + fileName);
		} catch (IOException e) {
			System.out.println("Error reading file: " + fileName);
		}

		return output;
	}

	public static void saveFile(String fileName, String data) {
		try (FileWriter f = new FileWriter(fileName)) {
			f.write(data);
		} catch (IOException e) {
			System.out.println("Error writing file: " + fileName);
		}

	}
}
