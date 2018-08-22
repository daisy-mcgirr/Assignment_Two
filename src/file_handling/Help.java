package file_handling;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

public class Help {
	/**
	 * Method to read in "help.txt" file
	 */
	public void readHelpFile() {
		try {
			File file = new File("help.txt");
			FileInputStream fileInput = new FileInputStream(file);
			byte[] data = new byte[(int) file.length()];
			fileInput.read(data);
			fileInput.close();

			String str = new String(data, "UTF-8");
			System.out.println(str);

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}