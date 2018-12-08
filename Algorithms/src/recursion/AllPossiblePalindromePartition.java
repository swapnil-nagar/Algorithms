package recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author swnagar
 *
 *Given a string, print all possible palindromic partitions
Given a string, find all possible palindromic partitions of given string.
 */
public class AllPossiblePalindromePartition {
	public static List<List<String>> result = new ArrayList<List<String>>();  
	public static void main(String arg[]) {
		String str = "geeks";
		allPossiblePalindromPartition (str, 0, new ArrayList<String>());
		
		for (List<String> ret: result) {
			for (String string: ret) {
				System.out.print(string + " ");
			}
			System.out.println();
		}
	}
	
	public static void allPossiblePalindromPartition(String str, 
			int startIndex,
			List<String> ret) {
		if(startIndex == str.length()) {
			result.add(ret);
			return;
		}
		for (int i = startIndex; i < str.length(); i++) {
			String tempStr = str.substring(startIndex, i+1);
			if(isPalindrome(tempStr.toCharArray())) {
				List<String> tempRet = new ArrayList<String>(ret);
				tempRet.add(tempStr);
				allPossiblePalindromPartition(str, i+1, tempRet);
			}
		}
	}
	
	public static boolean isPalindrome(char[] charArray) {
		int i = 0, j = charArray.length - 1;
		
		while (i<=j) {
			if (charArray[i] != charArray[j]) {
				return false;
			}
			i++;
			j--;
		}
		return true;
	}
}
