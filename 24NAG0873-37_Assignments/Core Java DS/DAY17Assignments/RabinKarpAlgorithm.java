package DAY17Assignments;
import java.util.*;
public class RabinKarpAlgorithm {
	private final static int d=256;//number of chars in input alphabet
	private final static int q=101;// A prime number for modulo operations 
	//function to perform the RabinKarp search
	public static List<Integer>search(String text,String pattern)
	{
		int M=pattern.length();
		int N=text.length();
	int i,j;
	int p=0;
	int t=0;
	int h=1;
	List<Integer>result=new ArrayList<>();
	//the value of h would be "pow(d,M-1)%q"
	for(i=0;i<M-1;i++)
	{
		h=(h*d)%q;
	}
	//calculate the hash value of pattern and first window of text
	for(i=0;i<M;i++) {
		p=(d*p+pattern.charAt(i))%q;
	t=(d*t+text.charAt(i))%q;
	}
	//slide the pattern over text one by one
	for(i=0;i<N-M;i++)
	{
		//check the hash values of current window of text and pattern
		//if the hash values match then only check for chars one by one
		if(p==t) {
			//check for chars one by one
			for(j=0;j<M;j++)
			{
				if(text.charAt(i+j)!=pattern.charAt(j))
					break;
			}
if(j==M) {
	result.add(i);
		}
}
if(i<N-M)
	{
	t=(d*(t-text.charAt(i)*h)+text.charAt(i+1))%q;
	//we might get negative value of t,converting it to positive
	if(t<0)
		t=(t+q);
	}
	}
return result;
}
public static void main(String[] args)
{
	String text="GEEKS FOR GEEKS";
	String pattern="GEEK";
	List<Integer> result=search(text,pattern);
 for(int index:result)
 {
	 System.out.println("Pattern found at index: "+index);
 }
}
}
/*
 * *Hash Collisions:*
In the Rabin-Karp algorithm, a hash collision occurs when two different strings have the same hash value. This is a problem because it can lead to false positives in the search results.

*Impact on Performance:*
Hash collisions can significantly impact the performance of the Rabin-Karp algorithm. When a collision occurs, the algorithm must check the actual string characters to determine if the match is genuine or a false positive. This additional checking can slow down the search, especially if collisions are frequent.

*Handling Hash Collisions:*
To handle hash collisions, the Rabin-Karp algorithm performs a character-by-character comparison whenever the hash values match. If the actual characters do not match, the algorithm dismisses the potential match and continues the search.

To minimize the number of collisions, it's important to:
- Use a large prime number for the modulus q.
- Ensure the hash function distributes values uniformly.

The rolling hash function in the Rabin-Karp algorithm is designed to be efficient and to minimize the number of collisions, but it's still possible for them to occur. By handling them correctly, the algorithm maintains its effectiveness in substring search tasks.

*/
