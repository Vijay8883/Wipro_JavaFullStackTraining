package DAY18Assignments;

public class BitManipulation {
	//Function to count the number of set bits in a single integer
	public static int countSetBits(int n)
	{
		int count=0;
		while(n>0) {
			n&=(n-1);
			count++;
		}
		return count;
	}
	//Function to count the total number of set bits from 1 t0 n
	public static int totalSetBits(int n)
	{
		int total=0;
		for(int i=1;i<=n;i++)
		{
			total+=countSetBits(i);
		}
		return total;
	}
//Main method to test the functions
	public static void main(String[] args)
	{
		int n=7;//example input
		System.out.println("Total set bits from 1 to "+ n +":"+totalSetBits(n));
	}
}
