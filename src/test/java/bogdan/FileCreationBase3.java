package bogdan;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.junit.Rule;
import org.junit.rules.TemporaryFolder;

public class FileCreationBase3 {
	
	@Rule
	public TemporaryFolder tmpdir = new TemporaryFolder();
	
	public static List<Object[]> loadContactsFromCsvFile(File file) throws IOException {
		List<Object[]> list = new ArrayList<Object[]>();
		FileReader reader = new FileReader(file);
		BufferedReader bufferedReader = new BufferedReader(reader);
		String line = bufferedReader.readLine();
		while (line != null) {
			//String part = line;
			list.add(new Object[] {line});
			line = bufferedReader.readLine();
		}
		bufferedReader.close();
		return list;
	}
	
}
