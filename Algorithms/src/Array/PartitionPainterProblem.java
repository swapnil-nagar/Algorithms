package Array;

public class PartitionPainterProblem 
{

    public static void main(String[] args)
    {
    	 int arr[] = { 10, 20, 60, 50, 30, 40 }; 
    	   
    	    // Calculate size of array. 
    	    int n = arr.length; 
    	        int k = 3; 
    	 System.out.println(partition(arr, n, k));   
    	 dynamicProgrammingSolution(arr, n, k);
        
    }

	private static int partition(int[] arr, int n, int k) {		
		if(k==1 || n==1) {
			return sum(arr, 0, n-1);
		} 
		
		int optimumResult = Integer.MAX_VALUE;
		
		for(int i = 0; i<= n; i++) {
			optimumResult = Math.min(optimumResult, Math.max(partition(arr,  i, k-1),  sum(arr, i, n-1)));
		}
		
		return optimumResult;
	}
	
	
	static int sum(int[] arr, int from, int to)
	{
		int result = 0;		
		for (int i = from; i<= to; i++) {
			result += arr[i];
		}		
		return result;
	}
	
	static void dynamicProgrammingSolution (int[] arr, int n, int k) {
		
	    // initialize table 
	    int dp[][] = new int[k+1][n+1]; 

		for(int i = 1; i<= n; i++) {
			dp[1][i] = sum(arr, 0, i-1);
			System.out.print(arr[i-1] + "\t");
		}

	    // n=1 
	    for (int i = 1; i <= k; i++) {
	        dp[i][1] = arr[0]; 
	    }

	    
		printArray(dp);
	    // 2 to k partitions 
	    for (int i = 2; i <= k; i++) { // 2 to n boards 
	        for (int j = 2; j <= n; j++) { 
	   
	            // track minimum 
	            int best = Integer.MAX_VALUE; 
	   
	            // i-1  separator before position arr[p=1..j] 
	            for (int p = 1; p <= j; p++)  {
	            	System.out.println("p: " + p);
	            	System.out.println("j: " + j);
	            	System.out.println("i: " + i);
	            	System.out.println("dp[" + (i-1) + "][" + p  + "]: " + dp[i - 1][p]);
	            	System.out.println("sum(arr," + p + ", " + (j - 1) + ") : " + sum(arr, p, j - 1));
	                best = Math.min(best, Math.max(dp[i - 1][p], 
	                              sum(arr, p, j - 1)));    
	            }
	   
	            dp[i][j] = best; 
	    		printArray(dp);
	        } 
	    } 
	    
		printArray(dp);
	}
	
	static void printArray (int[][] dp) {
		int n = dp.length;
		int m = dp[0].length;

		System.out.println();
		for (int i=0; i<n; i++) {

			for (int j=0; j<m; j++) {
				System.out.print(dp[i][j] + "\t");
			}
			System.out.println();
		}
	}

}
