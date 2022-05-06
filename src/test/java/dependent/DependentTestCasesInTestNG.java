package dependent;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import annotation.Annotation2;

public class DependentTestCasesInTestNG {
	
	String str;

	Annotation2 obj;

	@Test 
	public void B() {
		SoftAssert sAssert = new SoftAssert();
		System.out.println("This is B Method");

		boolean flag = true;
		boolean flag1 = false;

		sAssert.assertTrue(flag);
		
		sAssert.assertAll();
	}

	@Test (dependsOnMethods = {"B"})
	public void A() {
		SoftAssert sAssert = new SoftAssert();
		System.out.println("This is A Method");
		boolean flag = true;
		String currentSharePrice = "450.55";
		sAssert.assertNotEquals(currentSharePrice, "450.55");	

		System.out.println("After equal assert");
sAssert.assertAll();
	}

	@Test (dependsOnMethods = "A")
	public void verifyUserCanUploadFile() {
		SoftAssert sAssert = new SoftAssert();
		System.out.println("verifyUserCanUploadFile");
		sAssert.assertNotNull(obj, "Annotation class object is not initialized");
sAssert.assertAll();
	}

	

}
