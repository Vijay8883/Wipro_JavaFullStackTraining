package com.patternsearching;
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
