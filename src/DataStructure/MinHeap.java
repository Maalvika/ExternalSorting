package DataStructure;

import java.util.*;

public class MinHeap {
	
	private List<MinNode> arr;
	
	public MinHeap() {
		// TODO Auto-generated constructor stub
		arr = new ArrayList<>();
		
	}
	
	public int size(){
		return arr.size();
	}
	
	public MinNode getMinimum(){
		return arr.get(0);
	}
	
	public void insert(MinNode data){
		
		int pos = arr.size();
		arr.add(data);
		while(pos>0 && arr.get(parentPos(pos)).getVal() > arr.get(pos).getVal()) {
			swap(parentPos(pos), pos);
			pos = parentPos(pos);
		}
	}
	
	public MinNode extractMin(){
		if(arr.size() == 0){
			return null;
		}
		MinNode item = arr.get(0);
		swap(0, arr.size()-1);
		arr.remove(arr.size()-1);
		heapify(0);
		return item;
		
	}

	/////////////////////////////// Private Method
	
	private int parentPos(int i) {
		int val = (i-1)/2;
		return val<0?-1:val;
	}
	
	private int leftChildPos(int i){
		int val = (i+1)*2-1;
		return val>=arr.size()?-1:val;
	}
	
	private int rightChildPos(int i){
		int val = (i+1)*2;
		return val>=arr.size()?-1:val;
	}
	
	private void swap(int i, int j) {
		// TODO Auto-generated method stub
		MinNode temp = arr.get(i);
		arr.set(i, arr.get(j));
		arr.set(j, temp);
		
	}
	
	private void heapify(int i) {
		int l = leftChildPos(i);
		int r = rightChildPos(i);
		if(l == -1){
			return;
		} 
		int minPos = l;
		if(r!=-1){
			if(arr.get(r).getVal()>arr.get(l).getVal()){
				minPos = r;
			}
		}
		
		if(arr.get(minPos).getVal()<arr.get(i).getVal()){
			swap(minPos, i);
			heapify(minPos);
		}
		
	}
	

}
