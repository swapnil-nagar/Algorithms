package recursion;

public class CountAllPossibleDecodingFromListOfDigist {

    
    // Driver Method
    public static void main(String[] args)
    {
        //Number of pages in books
        int arr[] = {1, 2, 1};
        
        int m = 2; //No. of students
        
        String str = "";
        decodeString(str, 0, arr);
        System.out.println("Minimum number of pages = ");
    }
    
    public static void decodeString(String str, int startIndex, int[] array) {
    	if (startIndex == array.length) {
    		System.out.println(str);
    		return;
    	}
    	String str1 = str + Character.toString((char) (array[startIndex] + 64));
		decodeString(str1, startIndex + 1, array);
		
    	if (startIndex + 1 < array.length) {
    		int asciiValue = (array[startIndex] * 10 + array[startIndex + 1]);
    		if(asciiValue <= 26) {
	    		
	    		String str2 = str + Character.toString((char) (asciiValue + 64));
	    		decodeString(str2, startIndex + 2, array);
    		}
    	}
    	
    }
}
