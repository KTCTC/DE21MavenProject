package priority;

import org.testng.annotations.Test;

public class PriorityInTestNG {
	
	@Test  (priority = 10, dependsOnMethods = {"A"})
	public void B() {
		System.out.println("This is B Method");
	}

	@Test (priority = 2)
	public void A() {
		System.out.println("This is A Method");
	}

	@Test (priority = 3)
	public void verifyUserCanUploadFile() {
		System.out.println("verifyUserCanUploadFile");
	}
	
	@Test
	public void z()
	{
		System.out.println("This is z Method");
	}

}
