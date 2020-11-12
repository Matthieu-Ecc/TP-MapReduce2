package com.opstty.mapper;

import java.io.IOException;

import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class mapper1_8_5 extends Mapper<LongWritable, Text,DoubleWritable , Text> {
	

	 public void map(LongWritable key, Text value, Context context)throws IOException, InterruptedException {
		 if(!value.toString().contains("GEOPOINT")){
			 	Text id = new Text(value.toString().split(";")[12]);
			 	DoubleWritable height = new DoubleWritable(Double.parseDouble(value.toString().split(";")[6]));
			 	
	            context.write(height, id);
	        }
      
	 }
	 
}
