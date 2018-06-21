package Sorting;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import DataStructure.MinHeap;
import DataStructure.MinNode;

public class ExternalMergeSort {

	MergeSort mergesort;
	MinHeap heap;
	String input_path, output_path;
	int tot_runs = 10;
	int run_size = 100000;

	public ExternalMergeSort() {
		// TODO Auto-generated constructor stub
		mergesort = new MergeSort();
		heap = new MinHeap();
//		heap = new PriorityQueue<>(new Comparator<MinNode>() {
//
//			@Override
//			public int compare(MinNode arg0, MinNode arg1) {
//				// TODO Auto-generated method stub
//				if(arg0.getVal()<arg1.getVal()) {
//					return -1;
//				} else if(arg0.getVal()>arg1.getVal()) {
//					return 1;
//				}
//				return 0;
//			}
//		});
		input_path = "input.txt";
		output_path = "output.txt";

	}

	public void run() throws FileNotFoundException {
		
		ArrayList<int[]> nums = this.createArraysFromFiles(input_path, 
															tot_runs, run_size);

		// sort each array
		System.out.println("-------------------- Sorting each array using merge sort");
		for (int[] num_arr : nums) {
			mergesort.sort(num_arr);
		}
		System.out.println("-------------------- Done sorting");

		// todo: make mergesort for k sort file/array
		System.out.println("-------------------- Creating Heap with first element of each array");
		this.initHeap(nums);
		System.out.println("-------------------- Done");
		System.out.println("-------------------- Running MergeSort with K sorted array");
		this.mergeKsortedArray(nums);
		System.out.println("-------------------- Program completed and the output is in:" + output_path);
	}

	public static void main(String[] args) throws FileNotFoundException {
		long startTime = System.nanoTime();
		ExternalMergeSort external_sort = new ExternalMergeSort();
		external_sort.run();
		long endTime   = System.nanoTime();
		long totalTime = endTime - startTime;
		System.out.println("-------Total Execution time in ns is: "+totalTime);

	}

	private ArrayList<int[]> createArraysFromFiles(String filename, int tot_runs, int runs_size)
			throws FileNotFoundException {

		System.out.println("-------------------- Reading File and creating arrays");
		File file = new File(filename);
		Scanner scan = new Scanner(file);
		ArrayList<int[]> results = new ArrayList<>();
		for (int i = 0; i < tot_runs; i++) {
			int[] temp = new int[runs_size];
			for (int j = 0; j < runs_size; j++) {
				temp[j] = scan.nextInt();
			}
			results.add(temp);
		}
		scan.close();
		System.out.println("--------------------Done");
		return results;
	}
	
	private void writeToFile(BufferedWriter br, int value){
		
        
        String dataWithNewLine=value+System.getProperty("line.separator");
        try {
			br.write(dataWithNewLine);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
		
	}

	private void initHeap(ArrayList<int[]> sortedChunks){
		
		for(int i=0; i<sortedChunks.size(); i++) {
			MinNode temp = new MinNode(sortedChunks.get(i)[0], i, 0);
			//System.out.println("-------------------- Inserting in heap:"+temp.getVal());
			heap.insert(temp);
		}
		//System.out.println("-------------------- Top of the heap:"+heap.getMinimum().getVal());
		
		//System.out.println("-------------------- Size of the heap:"+heap.size());
	}
	private void mergeKsortedArray(ArrayList<int[]> sortedChunks) {
		
		File file = new File(output_path);
		FileWriter fr = null;
        BufferedWriter br = null;
        try {
			fr = new FileWriter(file);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        br = new BufferedWriter(fr);
        
		while(heap.size()>0) {
			MinNode temp = heap.extractMin();
			//System.out.println("Data:"+temp.getVal()+" writing to file");
			//System.out.println("Heap size:"+heap.size());
			writeToFile(br, temp.getVal());
			if (temp.getPosition() + 1 < sortedChunks.get(temp.getArr_idx()).length) {
				
				MinNode newTemp = new MinNode(sortedChunks.get(temp.getArr_idx())[temp.getPosition() + 1],
						temp.getArr_idx(), temp.getPosition() + 1);
				heap.insert(newTemp);
			}
		}
		
		try {
			br.close();
			fr.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
