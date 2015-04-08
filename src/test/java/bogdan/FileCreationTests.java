package bogdan;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.junit.Test;
import org.junit.Assert;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

import com.tngtech.java.junit.dataprovider.DataProvider;
import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;

@RunWith(DataProviderRunner.class)
public class FileCreationTests extends FileCreationBase implements MyCategories {
	
	@DataProvider
	public static Object[] files() {
		return new Object[] {"fileTempTest"};
	}
	
	@Test 
	@Category(PositiveTests.class)
	@UseDataProvider("files")
	public void test0(String file) {
		String path = basedir + tmp_dir_prefix + "/" + file;
		File file1 = new File(path);
		
		try {
			if (file1.createNewFile()) {
				System.out.println("File " + file1 + " is created");
			}
		} catch (IOException e) {e.printStackTrace();}
		
		Assert.assertTrue(file1.exists());
	} 
	
	//@DataProvider
	public static Iterator<Object[]> FileNamesGenerator() throws IOException {
		return loadContactsFromCsvFile(new File("fileNames1.txt")).iterator();
	}
	
	//@DataProvider
	public static Iterator<Object[]> FileNamesGenerator2() {
		List<Object[]> fileNames = new ArrayList<Object[]>();
		fileNames.add(new Object[]{"adminFile1.txt"});
		fileNames.add(new Object[]{"adminFile2.txt"});
		return fileNames.iterator();
	}
			
	//@Test (dataProvider = "FileNamesGenerator")
	public void test1(String fileName) {
		String path = basedir + tmp_dir_prefix + "/" + fileName;
		File file1 = new File(path);
		
		try {
			if (file1.createNewFile()) {
				System.out.println("File " + file1 + " is created");
			}
		} catch (IOException e) {e.printStackTrace();}
		
		//Assert.assertTrue(file1.exists(), "file1 exists");
	}
	
	@Test 
	@Category(PositiveTests.class)
	public void test2() {
		String path = basedir + tmp_dir_prefix + "/" + "fileTempTest2.txt";
		File file1 = new File(path);
		
		try {
			if (file1.createNewFile()) {
				System.out.println("File " + file1 + " is created");
			}
		} catch (IOException e) {e.printStackTrace();}
		
		Assert.assertTrue(file1.exists());
	} 
	
	@Test 
	@Category(PositiveTests.class)
	public void test3() {
		String path = basedir + tmp_dir_prefix + "/" + "fileTempTest3.txt";
		File file1 = new File(path);
		
		try {
			if (file1.createNewFile()) {
				System.out.println("File " + file1 + " is created");
			}
		} catch (IOException e) {e.printStackTrace();}
		
		Assert.assertTrue(file1.exists());
	} 
	
	@Test 
	@Category(NegativeTests.class)
	public void test4() {
		String path = basedir + tmp_dir_prefix + "/" + "fileTempTest777.txt";
		File file1 = new File(path);
		
		Assert.assertFalse(file1.exists());
	} 
	
	@Test 
	@Category(BrokenTests.class)
	public void test5() {
		String path = basedir + tmp_dir_prefix + "/" + "fileTempTest888.txt";
		File file1 = new File(path);
		
		Assert.assertFalse(file1.exists());
	} 

}
