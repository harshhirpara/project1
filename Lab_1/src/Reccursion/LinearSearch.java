package Reccursion;

public class LinearSearch { 
	 /** The method for finding a key in the list */
	 public static int linearSearch(int[] list,int i, int r, int key) {
		 if(r<=0)
		 {
			 return -1;
		 }
		 if(list[i] == key)
		 {
			 return list[i];
		 }
		 if(list[r] == key)
		 {
			 return list[r];
		 }
		 return linearSearch(list, i+1, r-1, key);
	 }
	 
	 public  static int binarySearch(int [] list, int key, int low, int high) {
		 while(low!=high)
		 {
			 int mid = (high + low)/2;
			 
			 if(list[mid] == key)
			 {
				 return list[mid];
			 }
			 else if(list[mid]<key)
			 {
				 low = mid +1;
			 }
			 else
			 {
				 high = mid -1;
			 }
		 }
		 return 0;
	 }
	 
	 public static int recursiveBinarySearch(int [] list, int key, int low, int high)
	 {
		 if(low > high)
		 {
			 return -1;
		 }
		 else
		 {
			int mid = (low+high)/2;
			if(list[mid] == key)
			{
				return list[mid];
			}
			else if(list[mid]< key)
			{
				return recursiveBinarySearch(list, key, mid+1, high);
			}
			else
			{
				return recursiveBinarySearch(list, key, low, mid-1);
			}
		 }
	 }
	 public static void swapValues(int [] list, int i, int j)
	 {
		int t = list[i];
		list[i] = list[j];
		list[j] = t;
	 }
	 public static void recursiveSelectionSort(int [] list, int i, int length)
	 {
		 int min = i;
		 for(int k = i; k<length;k++)
		 {
			 if(list[k]<list[min])
			 {
				 min = k;
			 }
		 }
		 swapValues(list, min, i);
		 if(i+1 < length)
		 {
			 recursiveSelectionSort(list, i+1, length);
		 }
	 }
	 
	public static void main(String[] args) {
		final int N = 10;
		int[] list = new int[N];
		for (int i = 0; i < N; i++) {
			//generate random positive and negative numbers from -100 to 100
			list [i]= (int)(Math.random() * 100 * (Math.random() > 0.5 ? 1 : -1));
			//print them
			//System.out.print(list[i] + "," );
		}
		int [] select = new int [N];
		for(int j = 0; j < N; j++)
		{
			select[j] = j;
		}
		long begin, end, time; // we will measure time it took to search
		begin = System.nanoTime();//we measure in nanoseconds.
		//Starting the watch
		int KEY = 50;
		//System.out.println(linearSearch(list,0,list.length-1, KEY));
		//System.out.println(recursiveBinarySearch(list, KEY, 0, list.length-1));
		//selectionSort(select);
		recursiveSelectionSort(list,0,list.length);
		end = System.nanoTime();
		time = end-begin;
		//System.out.println("it took " + time + " nanoseconds to run linear search with the key " + KEY +
		//		" on the array of " + N + " elements.");
		System.out.println("it took " + time + " nanoseconds to run selection sort and print an array of " + N + " elements.");
	 }
}
