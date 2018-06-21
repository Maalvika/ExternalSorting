package DataStructure;

public class MinNode {
	
	private int val;
	private int arr_idx;
	private int position;
	
	public MinNode(int val, int arr_idx, int pos){
		this.val = val;
		this.arr_idx = arr_idx;		
		this.position = pos;
	}

	public int getPosition() {
		return position;
	}

	public void setPosition(int position) {
		this.position = position;
	}

	public int getVal() {
		return val;
	}

	public void setVal(int val) {
		this.val = val;
	}

	public int getArr_idx() {
		return arr_idx;
	}

	public void setArr_idx(int arr_idx) {
		this.arr_idx = arr_idx;
	}
	
	
	

}
