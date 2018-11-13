package Array;

/**
 * Quick Select 
 * 
 * @author swnagar
 *
 */
public class KthElementInUnsortedArray {

	static int kthSmallest (Integer[] arr, int left, int right, int k) {		
		int pivotIndex = -1;
		int partitionIndex = -1;
		
		while (partitionIndex != k-1) {
			pivotIndex = left + (int) Math.floor(Math.random() * (right - left + 1));
			
			partitionIndex = partition(arr, left, right, pivotIndex);
			
			if (partitionIndex < k-1) {
				left  = partitionIndex + 1;
			}
			else if (partitionIndex > k-1) {
				right = partitionIndex - 1;
			}			
		}
		
		return arr[partitionIndex];
	}
	
    private static int partition(Integer[] arr, int left, int right, int pivotIndex) {  	
    	swap (arr, right, pivotIndex);
    	int partitionIndex = left;
    	
    	for (int i = left; i < right; i++) {
    		if (arr[right] > arr[i]) {
    			swap (arr, partitionIndex, i);
    			partitionIndex++;
    		}
    	}

		swap (arr, partitionIndex, right);
		return partitionIndex;
	}

	private static void swap(Integer[] arr, int to, int from) {
		int temp = arr[to];
		 arr[to] = arr[from];
		 arr[from] = temp;		
	}

	static void printArray(Integer[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(", " + arr[i]);
		}
	}
	// driver program 
    public static void main(String[] args)  
    { 
        Integer arr[] = new Integer[]{12, 19, 7, 5, 4, 3, 26}; 
        int left = 0;
        int right = arr.length - 1;
        int k = 3; 
        System.out.println( "K'th smallest element is "+ 
                            kthSmallest(arr, left, right, k) );    
        printArray(arr);
    } 
}
