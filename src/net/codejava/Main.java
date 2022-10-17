package net.codejava;

import java.util.Random;

public class Main 
{

	public static void main(String[] args) 
	{
		long startT;
		long endT;
		long resultT;
		
		Random rand = new Random();
		int[] quickArr = new int[10000];
		int[] bubbleArr = new int[10000];
		int[] insertArr	= new int[10000];
		int[] selectArr = new int[10000];
		int[] shellArr = new int[10000];
		
		for(int i = 0; i < 10000; i++)
		{
			quickArr[i] = rand.nextInt(10000);
			bubbleArr[i] = rand.nextInt(10000);
			insertArr[i] = rand.nextInt(10000);
			selectArr[i] = rand.nextInt(10000);
			shellArr[i] = rand.nextInt(10000);
		}
		
		startT = System.currentTimeMillis();
		QuickSort.quick(quickArr, 0, quickArr.length - 1);
		endT = System.currentTimeMillis();
		resultT = endT = startT;
		
		System.out.println("quick time: " + resultT);
		
		startT = System.currentTimeMillis();
		QuickSort.bubble(bubbleArr);
		endT = System.currentTimeMillis();
		resultT = endT = startT;
		
		System.out.println("bubble time: " + resultT);
		
		startT = System.currentTimeMillis();
		QuickSort.insertion(insertArr);
		endT = System.currentTimeMillis();
		resultT = endT = startT;
		
		System.out.println("insertion time: " + resultT);
		
		startT = System.currentTimeMillis();
		QuickSort.selection(selectArr);
		endT = System.currentTimeMillis();
		resultT = endT = startT;
		
		System.out.println("selection time: " + resultT);
		
		int[] gapValues = {4,2,1};
		startT = System.currentTimeMillis();
		QuickSort.shell(shellArr, gapValues);
		endT = System.currentTimeMillis();
		resultT = endT = startT;
		
		System.out.println("shell time: " + resultT);
	}
}