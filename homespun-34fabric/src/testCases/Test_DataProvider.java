package testCases;

import org.testng.Assert;
import org.testng.annotations.*;

public class Test_DataProvider {

		@DataProvider(name="DP1")
		public static Object[][] readArrayData(){
				return new Object[][] {
						{1,"(([x + 2])[(y)])",true}, 
						{2,"([x +2]))y(z)",false}, 
						{3,"((][x)",false}
						};
		}
		
		static boolean evaluateExpression (String myExpr) {
			 char[] tempArray = new char[myExpr.length()];
			 char curToken;
			 int j = 0;
			  
			 for(int i=0;i<myExpr.length();i++) 
			 {
				   curToken  = myExpr.charAt(i);
				   if (curToken == '(' ) 
				   {
					   tempArray[j]=')';
					   j++;
					}
				   else if (curToken == '[' ) 
					   {
						   tempArray[j]=']';
						   j++;
					   }
				   else  if ((curToken == ')' ) || (curToken == ']' )) 
						  if (j == 0) 
							  return false;
						  else if (curToken != tempArray[j-1])
							  return false;
						  else
						  j--;
			  }

			 if (j == 0)
				  return true;
			  else
				  return false;
		}

		@Test (dataProvider = "DP1")
		public void testExpressionParser(Integer id, String myExpression, Boolean expectedResult) throws Exception {
			Boolean actualResult =evaluateExpression(myExpression);
			Assert.assertEquals(actualResult, expectedResult);
		}
		
		@AfterTest
		void TearDown() {
			System.out.println("Exiting..");
		}
}