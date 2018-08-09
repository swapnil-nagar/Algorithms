package Array;

import java.util.Arrays;

public class TaskScheduleLeetCode {
	public static void main (String a[]) {	
		//char[] tasks = new char[] {'A','A','A','B','B','B'};
		char[] tasks = "AACBBB".toCharArray();
		int n = 2;
		int result = leastInterval(tasks, n);
		System.out.println(result);
	}
	
	public static int leastInterval(char[] tasks, int n) {
        int[] counter = new int[26];
        int max = 0;
        int maxCount = 0;
        for(char task : tasks) {
            counter[task - 'A']++;
            if(max == counter[task - 'A']) {
                maxCount++;
            }
            else if(max < counter[task - 'A']) {
                max = counter[task - 'A'];
                maxCount = 1;
            }
        }
        int i=25;
        while (i >=0) {
        	System.out.println("i :" + i + " " + counter[i]);
        	i--;
        }
        
        System.out.println("max: "+max+ " maxCount: "+ maxCount);
        int partCount = max - 1;
        int partLength = n - (maxCount - 1);
        int emptySlots = partCount * partLength;
        int availableTasks = tasks.length - max * maxCount;
        int idles = Math.max(0, emptySlots - availableTasks);
        
        return tasks.length + idles;
    }
	
    public static int leastInterval1(char[] tasks, int n) {

        int[] c = new int[26];
        for(char t : tasks){
            c[t - 'A']++;
        }
        Arrays.sort(c);
        int i = 25;
        
        while (i >=0) {
        	System.out.println("i :" + i + " " + c[i]);
        	i--;
        }
        i=25;
        while(i >= 0 && c[i] == c[25]) {
        	System.out.println(" in while i :" + i );
        	i--;
        }
        System.out.println(" outside i :" + i + " n : "+ n);
        return Math.max(tasks.length, (c[25] - 1) * (n + 1) + 25 - i);
    }
}
