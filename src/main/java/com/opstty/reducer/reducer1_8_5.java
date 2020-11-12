package com.opstty.reducer;

import java.io.IOException;

import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;


public class reducer1_8_5 extends Reducer<DoubleWritable,Text,DoubleWritable,Text>{
	
	 public void reduce(DoubleWritable value,Text key , Context context) throws IOException, InterruptedException {
		 
		 context.write(value, key);
	    }

}

