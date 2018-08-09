package DynamicPrograming;

public class MinimumInsertionToMkaeStringPlindrome {
	// A DP function to find minimum number
    // of insersions
    static int findMinInsertionsDP(char str[], int n)
    {
        // Create a table of size n*n. table[i][j]
        // will store minumum number of insertions
        // needed to convert str[i..j] to a palindrome.
        int table[][] = new int[n][n];
        int l, h, gap;
 
        // Fill the table
        for (gap = 1; gap < n; ++gap) {
        for (l = 0, h = gap; h < n; ++l, ++h) {
        	System.out.println("l, h : " + l + " , "+ h);
        	System.out.println("table[l+1][h-1] : " + table[l+1][h-1]);
        	System.out.println("table[l][h-1] : " + table[l][h-1]);
        	System.out.println("table[l+1][h] : " + table[l+1][h]);
            table[l][h] = (str[l] == str[h])?
                           table[l+1][h-1] :
                          (Integer.min(table[l][h-1],
                                 table[l+1][h]) + 1);
                           for (int i=0; i<table[0].length; i++) {
                        	   for (int j=0; j<table.length; j++) {
                        		   System.out.print(table[i][j] + " ");
                        	   }
                    		   System.out.println();
                           }
                		   System.out.println();
                           }
		   System.out.println();
        }
 
        // Return minimum number of insertions
        // for str[0..n-1]
                           for (int i=0; i<table[0].length; i++) {
                        	   for (int j=0; j<table.length; j++) {
                        		   System.out.print(table[i][j] + " ");
                        	   }
                    		   System.out.println();
                           }
        return table[0][n-1];
    }
 
    // Driver program to test above function.
    public static void main(String args[])
    {
        String str = "geeks";
        System.out.println(
        findMinInsertionsDP(str.toCharArray(), str.length()));
    }
}
