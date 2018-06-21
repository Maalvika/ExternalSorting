package Sorting;

public class MergeSort {

	public void sort(int[] arr){
		if(arr.length<=0) {
			return;
		}
		//System.out.println("-------------------- Before sorting: "+arr[0]);
		merge_sort(arr, 0, arr.length-1);
		//System.out.println("-------------------- After sorting: "+arr[0]);
	}
	
	private void merge_sort(int[] arr, int p, int r) {
		
		if(p>=r){
			return;
		}
		
		int q = (p+r)/2;
		merge_sort(arr, p, q);
		merge_sort(arr, q+1, r);
		merge(arr, p, q, r);
	}

	private void merge(int[] arr, int p, int q, int r) {
		// TODO Auto-generated method stub
		int size_l = q-p+1;
		int size_r = r-q;
		int[] l_arr = new int[size_l+1];
		int[] r_arr = new int[size_r+1];
		
		for(int i=0; i<size_l; i++) {
			l_arr[i] = arr[p+i];
		}
		for(int i=0; i<size_r; i++) {
			r_arr[i] = arr[q+i+1];
		}
		
		l_arr[size_l] = Integer.MAX_VALUE;
		r_arr[size_r] = Integer.MAX_VALUE;
		
		int i=0, j=0;
		
		for(int k=p; k<=r; k++) {
			if(l_arr[i] < r_arr[j]) {
				
				arr[k] = l_arr[i];
				i++;		
			} else {
				
				arr[k] = r_arr[j];
				j++;
			}
		}
		
	}
	
	public static void main(String[] args) {
		int[] arr = {2,4,5,7,1,2,3,6};
		
		MergeSort ms = new MergeSort();
		
		ms.sort(arr);
		
		for(int i=0; i<arr.length; i++) {
			System.out.println(arr[i]+" ");
		}
		
	}
	
	
}
