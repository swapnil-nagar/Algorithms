package Array;

public class LexicalOrder {
	
	public static int[]  lexicalOrder( int n) {
		int[] res = new int[n];
         int cur = 1 ;
         for ( int i = 0 ; i < n; ++ i) {
            res[i] = cur;
             if (cur * 10 <= n) {
                cur *= 10 ;
            } else {
                 if (cur >= n) {
                	 cur /= 10 ;
                 	System.out.println("in if: "+ cur);
                 }
                cur += 1 ;
            	System.out.println(cur);
                 while (cur % 10 == 0 ) cur /= 10 ;
            }
        }
        return res;
    }
	
	public static void main (String a[]) {	
		//char[] tasks = new char[] {'A','A','A','B','B','B'};
		char[] tasks = "AACBBB".toCharArray();
		int n = 102;
		int[] result = lexicalOrder(n);
		for(int i=0; i<result.length; i++) {
			System.out.print(result[i] +  " ");
		}
	}
	
}
