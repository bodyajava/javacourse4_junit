package bogdan;

import java.io.File;
import java.io.IOException;
import java.util.Collection;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import com.tngtech.java.junit.dataprovider.UseDataProvider;

@RunWith(Parameterized.class)
public class FileCreationTests3 extends FileCreationBase3 {
	
	@Parameters(name = "file1:{0}")
	public static Collection<Object[]> files() throws IOException {
		return (Collection<Object[]>) loadContactsFromCsvFile(new File("fileNames1.txt"));
	}
		
	private String file1;
	
	public FileCreationTests3(String file1) {
		this.file1 = file1;
	}
	
	@Test 
	@UseDataProvider("files")
	public void test0() throws IOException {
		File tempFile = tmpdir.newFile(file1);
		System.out.println("File " + tempFile + " created.");
		Assert.assertTrue(tempFile.exists());
	} 
	
}
