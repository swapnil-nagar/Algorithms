package Array;

import java.util.Stack;

public class NextGreaterElement {

	public static void main (String args[]) {
		int[] arr = new int[] { 11, 4, 3, 13, 21, 3 };
		int arrLength = arr.length;
		
		NextGreaterElement(arr);
	}

	private static void NextGreaterElement(int[] arr) {
		
		Stack<Integer> stack = new Stack<Integer>();
		
		stack.push(arr[0]);
		
		for (int i=1; i<arr.length; i++)
		{
			int currentElement = arr[i];
			
			if(!stack.isEmpty()) {
				int popElement = stack.pop();
				
				while (popElement < currentElement) {

                    System.out.println(popElement + " --> " + currentElement); 
                    if(stack.empty()) {
                    	break;
                    }
                    popElement = stack.pop();
				}
				
				if(popElement > currentElement) {
					stack.push(popElement);
				}
				
			}
			stack.push(currentElement);
			System.out.println(stack);
		}
        while (!stack.isEmpty())  
        { 
			int popElement = stack.pop();
			int currentElement = -1; 
            System.out.println(popElement + " -- " + currentElement); 
        } 
	}
}
