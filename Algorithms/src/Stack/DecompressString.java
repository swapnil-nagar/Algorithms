/**
 *
Decompress string - string (s) followed by {n} denotes s repeating n times 
"a(b(c){2}){2}d" decompresses to "abccbccd" 
"((x){3}(y){2}z){2}" decompresses to "xxxyyzxxxyyz"
 */

package Stack;

import java.util.Iterator;
import java.util.Stack;

public class DecompressString {
	public static void main (String[] args) {

		String compressedString = "((x){3}(y){2}z){2}";
		//compressedString = "(a){2}";
		//compressedString="a(b(c){2}){2}d";
		System.out.println(decompressString(compressedString));
	}
	
	public static String decompressString(String str) {
        Stack<String> stack = new Stack<>();
        StringBuilder result = new StringBuilder();
        
        for (int i = 0; i <str.length(); i++) {
        	char c = str.charAt(i);
        	if(c != ')' && c != '}') {
        		stack.push(String.valueOf(c));
        	} else if (c == ')') {
        		StringBuilder tmp = new StringBuilder();
        		String poped;
        		while (!(poped = stack.pop()).equals("(")) {
        			tmp.append(poped);
        		}
        		stack.push(tmp.toString());        		
        	} else {
        		StringBuilder tmp = new StringBuilder();
        		String poped;
        		while (!(poped = stack.pop()).equals("{")) {
        			tmp.append(poped);
        		}
        		int times = Integer.parseInt(tmp.toString());
        		String value = stack.pop();
                tmp = new StringBuilder();
                for (int j = 1; j <= times; j++) {
                    tmp.append(value);
                }
                stack.push(tmp.toString());
        	}
        }
               

        Iterator<String> it = stack.iterator();
        while (it.hasNext()) {
            result.append(it.next());
        }
        return result.reverse().toString();
	}

}
