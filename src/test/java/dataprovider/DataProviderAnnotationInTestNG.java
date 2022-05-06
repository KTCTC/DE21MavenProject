package dataprovider;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderAnnotationInTestNG {
	
	
	@DataProvider (name = "FirstName")
	public Object[] getData()
	{
		Object arr[] = {"Ajay", "Sandeep", "Amar"};
		
		return arr;
	}
	
	
	@Test (dataProvider = "FirstName", enabled = false)
	public void addUsertWithFirstName(String name)
	{
		System.out.println(name);
	}
	
	
	@Test (dataProvider =  "UserDetails")
	public void addUserWithProvidedDetails(String name, String lname, String email, String age, String salary, String dept)
	{
		System.out.println(name);
		System.out.println(lname);
		System.out.println(email);
		System.out.println(age);
		System.out.println(salary);
		System.out.println(dept);
		
		
	}
	
	@DataProvider (name = "UserDetails")
	public String[][] getUserDetails()
	{
		String [][] arr = {{"Amar", "P", "amar@p.com","23","23456","IT"}, {"Amol", "G", "amol@g.com", "44", "56787","Finance"}};
		
		return arr;
		
	}
	

}
