package DAY16Assignments;

public class StringOperations {
	public static String concatenateAndExtractMiddleSubstring(String str1,String str2,int middleSubstringLength)
	{
		if(str1==null||str2==null||str1.isEmpty()||str2.isEmpty())
		{
			return "";
		}
		String concatenatedString=str1.concat(str2);
		String reversedString=new StringBuilder(concatenatedString).reverse().toString();
		int middleIndex=reversedString.length()/2;
		if(middleSubstringLength>reversedString.length())
		{
			return "";
		}
		int startIndex=middleIndex-(middleSubstringLength/2);
		int endIndex=startIndex+middleSubstringLength;
		if(startIndex<0)
		{
			startIndex=0;
		}
		if(endIndex>reversedString.length()) {
			endIndex=reversedString.length();
		}
		return reversedString.substring(startIndex,endIndex);
	}
public static void main(String[] args) {
	String str1="Hello";
	String str2="World";
	int middleSubstringLength=5;
	String result=concatenateAndExtractMiddleSubstring(str1,str2,middleSubstringLength);
System.out.println(result);
}

}
