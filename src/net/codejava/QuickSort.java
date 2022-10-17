package net.codejava;

public class QuickSort 
{
	public static int partition(int[] arr, int startIndex, int endIndex)
	{
		//selects middle value as pivot
		int midpoint = startIndex + (endIndex - startIndex) / 2;
		int pivot = arr[midpoint];
		
		//starts at opposite ends of array
		int low = startIndex;
		int high = endIndex;
		
		boolean done = false;
		while(!done)
		{
			while(arr[low] < pivot)
			{
				low = low + 1;
			}
			
			while(pivot < arr[high])
			{
				high = high - 1;
			}
			
			if(low >= high)
			{
				done = true;
			}
			else
			{
				int temp = arr[low];
				arr[low] = arr[high];
				arr[high] = temp;
				low++;
				high--;
			}
		}
		return high;
	}
	
	public static void quick(int[] arr, int startIndex, int endIndex)
	{
		if(endIndex <= startIndex)
		{
			return;
		}
		
		int high = partition(arr, startIndex, endIndex);
		quick(arr, startIndex, high);
		quick(arr, high + 1, endIndex);
	}
	
	public static void bubble(int[] arr)
	{	
		int swaps = 0;
		for(int i = 0; i < arr.length; i++)
			// i is needed so the algorithm doesn't sort farthest right again
		{
			for(int j = 0; j < arr.length - i - 1 ; j++)
				// .length - i - 1 means the list does not need to compare values of 
				// the most right because they've already been sorted
			{
				if(arr[j] > arr[j + 1])
				{
					swaps++;
					int temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}
			}
		}
		System.out.println("bubble swaps: " + swaps);
	}

	public static void insertion(int[] arr)
	{
		int swaps = 0;
		for(int i = 1; i < arr.length; i++)
		{
			int j = i;
			// while loop will run as long as it's true
			while(j > 0 && arr[j] < arr[j-1]) //compares current value to all previous
			{
				swaps++;
				int temp = arr[j];
				arr[j] = arr[j-1];
				arr[j-1] = temp;
				j--; // return to while conditional until false, then jump out of loop
			}
		}
		System.out.println("insertion swaps: " + swaps);
	}
	
	public static void selection(int[] arr)
	{
		int swaps = 0;
		for(int i = 0; i < arr.length -1; i++)
		{
			int smallestIndex = i;
			//searches through unsorted to find smallest index
			for(int j = i + 1; j < arr.length; j++)
			{
				if(arr[j] < arr[smallestIndex])
				{
					swaps++;
					smallestIndex = j;
				}
			}
			//once sorted through all unsorted for smallest,
			//places smallest index value at end of sorted and updates
			//smallest index to start at beginning of unsorted
			int temp = arr[i];
			arr[i] = arr[smallestIndex]; 
			arr[smallestIndex] = temp;
		}
		System.out.println("selection swaps: " + swaps);
	}

	public static int insertInShell(int[] arr, int startIndex, int gap)
	{
		int swaps = 0;
		//gives starting index and stops loop after sorting to end of array
		for(int i = startIndex + gap; i < arr.length; i = i + gap) 
		{
			int j = i;
		
			while(j - gap >= startIndex && arr[j] < arr[j - gap]) 
			// compares current value to previous gap values
			{
				swaps++;
				int temp = arr[j];
				arr[j] = arr[j - gap]; 
				arr[j-gap] = temp; 
				j = j - gap; // changes to previous gap and return to while condition
			}
		}
		return swaps;
	}
	
	public static void shell(int[] arr, int[] gapValues)
	{
		int totalSwaps = 0;
		//goes through one gap value at a time
		for(int g = 0; g < gapValues.length; g++)
		{
			int gapSwaps = 0;
			//gives starting point for insertion in shell
			for(int i = 0; i < gapValues[g]; i++)
			{
				gapSwaps = gapSwaps + insertInShell(arr, i, gapValues[g]);
			}
			totalSwaps = totalSwaps + gapSwaps;
		}
		System.out.println("shell swaps: " + totalSwaps);
	}
}