package invocation;

import org.testng.Assert;
import org.testng.annotations.Test;

public class InvocationInTestNG {
	
	static int count=0;
	
	@Test (invocationCount = 5)
	public void verifyUserCanBeAdded()
	{
		System.out.println("verify User Can Be Added");
		count++;
		if (count==4)
		{
			Assert.assertTrue(false);
		}
		System.out.println("After assertion");
	}

}
