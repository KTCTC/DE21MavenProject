package assertion;

import org.testng.Assert;
import org.testng.annotations.Test;

import annotation.Annotation2;

public class HardAssertions {
	
	String str ;
	
	Annotation2 obj;
	
	@Test
	public void B() {
		System.out.println("This is B Method");
		
		boolean flag = true;
		boolean flag1 = false;
		
		Assert.assertTrue(flag);
		Assert.assertFalse(flag1, "sample message");
		
		Assert.assertTrue(flag1, "Email id of mwntioned user is not displayed");
		
		
		System.out.println("After boolean assertion");
	}

	@Test
	public void A() {
		System.out.println("This is A Method");
		boolean flag = true;
		String currentSharePrice = "450.55";
		Assert.assertNotEquals(currentSharePrice, "456");
		
		Assert.assertEquals(currentSharePrice, "450.55", "Share price is not matching");		
		
		Assert.assertEquals(flag, true, "expected value and value displayed on UI is not same");
		String msg = "1 file has been uploaded successfully";
		Assert.assertEquals(msg, "1 file has been uploaded successfully.", "Actual message displayed on UI for file upload and expected message are not same");
		
		
		System.out.println("After equal assert");
		
	}

	@Test
	public void verifyUserCanUploadFile() {
		System.out.println("verifyUserCanUploadFile");
		
		Assert.assertNotNull(obj, "Annotation class object is not initialized");
		
	}
	@Test
	public void sampleTestCaseForAllTypesOFAsssertion()
	{
		String currentSharePrice = "450.55";
		Assert.assertNotEquals(currentSharePrice, "456");
		Assert.assertNotNull(obj, "Annotation class object is not initialized");
		boolean flag = true;
		boolean flag1 = false;
		
		Assert.assertTrue(flag);
		Assert.assertFalse(flag1, "sample message");
		
		System.out.println("After all types of assertion");
	}

}
