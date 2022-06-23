package retryLogicExample;



import org.testng.Assert;
import org.testng.annotations.Test;

public class AmazonTest {
	
	
	
	
	@Test
	public void serachItem() {
		
		System.out.println("Search Test Case");
	}

	

	//@Test(retryAnalyzer = RetryLogic.class)
	
	@Test
	public void addItems() {
		
		System.out.println("addItems Test Case");
		Assert.assertTrue(false);
	}

	
	

	@Test
	public void payment() {
		
		System.out.println("payment Test Case");
		Assert.assertTrue(false);
	}

	

	@Test
	public void checkout() {
		
		System.out.println("checkout Test Case");
	}

}
