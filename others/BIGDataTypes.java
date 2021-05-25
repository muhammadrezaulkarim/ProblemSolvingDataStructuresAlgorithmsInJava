import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.util.Scanner;


public class BIGDataTypes {
	
	public static void main(String args[])
	{
		//Big decimal types
		BigDecimal tax = new BigDecimal("980000000000000000000009.0084578639");
		tax = tax.setScale(2, RoundingMode.CEILING);
		//RoundingMode.FLOOR

		BigDecimal arbitraryVal = new BigDecimal("100000000000000000000009.0084578639");
		arbitraryVal = arbitraryVal.setScale(2, RoundingMode.CEILING);
		
		System.out.println(arbitraryVal.toBigInteger());
		
		BigInteger num1=new BigInteger("50000000000000000000000000");
		BigInteger num2=new BigInteger("10000000000000000000000000");
		System.out.println(num1.add(num2));
	
		BigInteger numOne=BigInteger.ONE;  // assignment
		
		System.out.println("remainder:");
		BigInteger remainder = num2.mod(num1);
		System.out.println(remainder);
		
		System.out.println("power:");
		BigInteger power = num1.pow(3);
		System.out.println(power);
		
		
		// reading big integer and decimal
		/*Scanner sc=null;
		BigInteger num3=sc.nextBigInteger();
		sc=new Scanner(System.in);
		//BigInteger.ZERO   for assignment
		//BigInteger.ONE
		BigInteger num4=sc.nextBigInteger();
		BigDecimal num5=sc.nextBigDecimal(); */
	}

}
