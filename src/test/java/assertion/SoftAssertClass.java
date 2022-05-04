package assertion;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import annotation.Annotation2;

public class SoftAssertClass {

	String str;

	Annotation2 obj;

	@Test
	public void B() {
		SoftAssert sAssert = new SoftAssert();
		System.out.println("This is B Method");

		boolean flag = true;
		boolean flag1 = false;

		sAssert.assertTrue(flag);
		sAssert.assertFalse(flag1, "sample message");

		sAssert.assertTrue(flag, "Email id of mwntioned user is not displayed");

		System.out.println("After boolean assertion");
		sAssert.assertAll();
	}

	@Test
	public void A() {
		SoftAssert sAssert = new SoftAssert();
		System.out.println("This is A Method");
		boolean flag = true;
		String currentSharePrice = "450.55";
		sAssert.assertNotEquals(currentSharePrice, "450.55");

		sAssert.assertEquals(currentSharePrice, "450", "Share price is not matching");

		sAssert.assertEquals(flag, false, "expected value and value displayed on UI is not same");
		String msg = "1 file has been uploaded successfully";
		sAssert.assertEquals(msg, "1 file has been uploaded successfully.",
				"Actual message displayed on UI for file upload and expected message are not same");

		System.out.println("After equal assert");
sAssert.assertAll();
	}

	@Test
	public void verifyUserCanUploadFile() {
		SoftAssert sAssert = new SoftAssert();
		System.out.println("verifyUserCanUploadFile");

		sAssert.assertNotNull(obj, "Annotation class object is not initialized");
sAssert.assertAll();
	}

	@Test
	public void sampleTestCaseForAllTypesOFAsssertion() {
		SoftAssert sAssert = new SoftAssert();
		String currentSharePrice = "450.55";
		sAssert.assertNotEquals(currentSharePrice, "456");
		sAssert.assertNotNull(obj, "Annotation class object is not initialized");
		boolean flag = true;
		boolean flag1 = false;

		sAssert.assertTrue(flag);
		sAssert.assertFalse(flag1, "sample message");

		System.out.println("After all types of assertion");
		sAssert.assertAll();
	}

}
