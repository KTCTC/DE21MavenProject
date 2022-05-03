package annotation;

import org.testng.annotations.Test;

public class Annotation2 extends TestBase{
	
	@Test
	public void verifyUserCanLoginWithValidCredentials()
	{
		System.out.println("verify User Can Login With Valid Credentials");
	}
	
	@Test
	public void verifyUserCanNotLoginWithInvalidCredentials()
	{
		System.out.println("verify User Can Not Login With InValid Credentials");
	}

}
