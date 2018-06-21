package Sorting;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class GenerateRandomNum {

	public static void main(String[] args) throws IOException {

		int tot_runs = 10;
		int run_size = 100000;
		
		BufferedWriter writer = new BufferedWriter(new FileWriter("input.txt"));
		Random rand = new Random();
		
	    for(int i=0; i<tot_runs*run_size; i++) {
	    	int num = rand.nextInt(tot_runs*run_size*tot_runs*10);
	    	//System.out.println(num);
	    	writer.write(num+"\n");
	    }
	    writer.close();
	}
}
