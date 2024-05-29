package DAY16Assignments;

public class NaivePatternSearching {
public static void search(String text,String pattern)
{
	int n=text.length();
    int m=pattern.length();
//Loop over each possible starting point in the text
    for(int i=0;i<=n-m;i++)
    {
    	int j;
    	//check for pattern match
    	for(j=0;j<m;j++)
    	{
    		if(text.charAt(i+j)!=pattern.charAt(j))
    		{
    			break;
    		}
    	}
    	//if the pattern matches the substring in text
    	if(j==m)
    	{
    		System.out.println("Pattern found at index "+i);
    	}
    }
}
public static void main(String[] args)
{
	String text="ABABAB";
	String pattern="AB";
	search(text,pattern);
}
}
