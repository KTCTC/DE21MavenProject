package annotation;

import org.testng.annotations.Test;

public class AnnotationInTestNG extends TestBase{

	@Test
	public void B() {
		System.out.println("This is B Method");
	}

	@Test
	public void A() {
		System.out.println("This is A Method");
	}

	@Test
	public void verifyUserCanUploadFile() {
		System.out.println("verifyUserCanUploadFile");
	}

	
	
}
