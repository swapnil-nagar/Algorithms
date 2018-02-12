/***
 * 
You have to cut a wood stick into pieces. The most affordable company, The Analog Cutting Machinery, 
Inc. (ACM), charges money according to the length of the stick being cut. Their procedure of work 
requires that they only make one cut at a time. 
It is easy to notice that different selections in the order of cutting can led to different prices. For 
example, consider a stick of length 10 meters that has to be cut at 2, 4 and 7 meters from one end. 
There are several choices. One can be cutting first at 2, then at 4, then at 7. This leads to a price 
of 10 + 8 + 6 = 24 because the first stick was of 10 meters, the resulting of 8 and the last one of 6. 
Another choice could be cutting at 4, then at 2, then at 7. This would lead to a price of 10 + 4 + 6 = 
20, which is a better price. 
Your boss trusts your computer abilities to find out the minimum cost for cutting a given stick.




Solution:

First notice this problem is an 'ordering' problem. We are trying to find an order. To determine an order you make a choice which one is the first one to go, and then which is next, and so on.

A little fiddling make me realize the sub-problems are overlapped. It doesn't matter how I get to the state of cutting a stick from the mth endpoint to the nth endpoint, I just have to solve that sub-problem optimally.

So in the view of this, we define the recurrence relation as follow

Let opt(m, n) be the minimal cost of cutting the stick from the mth endpoint to the nth endpoint.

Base case, we have opt(m, m+1) = 0, because there is no need to cut a segment with no internal endpoints.

Inductively, we have opt(m, n) = endpoints(n) - endpoint(m) + min over k (opt(m, k) + opt(k, n)). We have to make a cut anyway and that will always cost us endpoints(n) - endpoint(m) independent on where we choose, and we need to choose one, that minimize subsequent costs.

*/


package DynamicPrograming;

import java.util.Arrays;

public class MinimumStick {
    public static void main(String[] args) {
        System.out.println("Hello World!"); // Display the string.
        
        int[] endpoints = new int[] {0, 2, 4, 7, 10};
        
        int[][] opt = new int[endpoints.length - 1][endpoints.length];

        // Initialization - minimal cost of cutting a segment with no cutting point in it is 0
        for (int i = 0; i < endpoints.length - 1; i++)
        {
            opt[i][i + 1] = 0;
        }

        for (int gap = 2; gap <= endpoints.length - 1; gap++)
        {
        	//System.out.println(Arrays.deepToString(opt));
            for (int i = 0; i + gap < endpoints.length; i++)
            {
                int j = i + gap;
                int segment_length = endpoints[j] - endpoints[i];
                boolean first = true;
                int min = -1;
                for (int k = i + 1; k < j; k++)
                {
                    int cost = opt[i][k] + opt[k][j];;
                    if (first)
                    {
                        min = cost;
                        first = false;
                    }
                    else
                    {
                        if (cost < min)
                        {
                            min = cost;
                        }
                    }
                }
                opt[i][j] = segment_length + min;
            }
        }
        
        System.out.println("The minimum cutting is " + opt[0][endpoints.length - 1] + "." );
    }
}
