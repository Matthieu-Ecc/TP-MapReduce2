package com.opstty.reducer;

import java.io.IOException;


import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.mapreduce.Reducer;

import com.opstty.newclasse1_8_6;


public class reducer1_8_6 extends Reducer<IntWritable,newclasse1_8_6,newclasse1_8_6,NullWritable>{
	private newclasse1_8_6 result = new newclasse1_8_6();

	
	 public void reduce(IntWritable key,Iterable<newclasse1_8_6> value , Context context) throws IOException, InterruptedException {
		
		 
		 for (newclasse1_8_6 val : value) {
	    	 if(val.getAge().get()<result.getAge().get()) {
	            result.setAge(val.getAge());
	            result.setId(val.getId());
	        }
		 
		 context.write(result,NullWritable.get());
	    }

	 }}
