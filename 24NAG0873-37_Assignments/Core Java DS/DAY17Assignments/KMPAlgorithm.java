package DAY17Assignments;
/*The Knuth-Morris-Pratt (KMP) algorithm is a string searching (or pattern matching) algorithm that improves the worst-case time complexity to O(n) compared to the naive approach’s O(mn), where n is the length of the text and m is the length of the pattern. This efficiency is achieved through preprocessing of the pattern to create a longest proper prefix which is also a suffix (LPS) array.

The LPS array stores the length of the longest proper prefix which is also a suffix for each sub-pattern of the pattern up to that point. During the search, when a mismatch occurs, instead of moving the pattern by just one character (as in the naive approach), the KMP algorithm uses the LPS array to skip characters in the text that will match the prefix of the pattern, thus reducing unnecessary comparisons.


 The Boyer-Moore algorithm is efficient because it uses two heuristics—*Bad Character* and *Good Suffix*—which allow it to skip along the text more than algorithms like Naive or even the Knuth-Morris-Pratt (KMP) algorithm in the best case. These heuristics let the algorithm skip sections of the text, leading to sub-linear time complexity on average, which is particularly effective when the pattern being searched for is long and the alphabet size is large.

Here's a Java function that uses the Boyer-Moore algorithm to find the last occurrence of a substring:*/
public class KMPAlgorithm {
	void KMPSearch(String pat, String txt) {
        int M = pat.length();
        int N = txt.length();
        
        // create lps[] that will hold the longest prefix suffix values for pattern
        int lps[] = new int[M];
        int j = 0; // index for pat[]
        
        // Preprocess the pattern (calculate lps[] array)
        computeLPSArray(pat, M, lps);
        
        int i = 0; // index for txt[]
        while (i < N) {
            if (pat.charAt(j) == txt.charAt(i)) {
                j++;
                i++;
            }
            if (j == M) {
                System.out.println("Found pattern at index " + (i - j));
                j = lps[j - 1];
            }
            // mismatch after j matches
            else if (i < N && pat.charAt(j) != txt.charAt(i)) {
                // Do not match lps[0..lps[j-1]] characters, they will match anyway
                if (j != 0)
                    j = lps[j - 1];
                else
                    i = i + 1;
            }
        }
    }
    
    void computeLPSArray(String pat, int M, int lps[]) {
        // length of the previous longest prefix suffix
        int len = 0;
        int i = 1;
        lps[0] = 0; // lps[0] is always 0
        
        // the loop calculates lps[i] for i = 1 to M-1
        while (i < M) {
            if (pat.charAt(i) == pat.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            } else {
                // (pat[i] != pat[len])
                if (len != 0) {
                    len = lps[len - 1];
                } else {
                    lps[i] = len;
                    i++;
                }
            }
        }
    }
    
    public static void main(String[] args) {
        KMPAlgorithm kmp = new KMPAlgorithm();
        String txt = "ABABDABACDABABCABAB";
        String pat = "ABABCABAB";
        kmp.KMPSearch(pat, txt);
    }
}