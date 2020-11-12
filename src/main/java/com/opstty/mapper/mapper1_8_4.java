package com.opstty.mapper;

import java.io.IOException;

import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;


public class mapper1_8_4 extends Mapper<LongWritable, Text, Text, DoubleWritable> {
	

	 public void map(LongWritable key, Text value, Context context)throws IOException, InterruptedException {
		 if(!value.toString().contains("GEOPOINT")){
			 	Text species = new Text(value.toString().split(";")[3]);
			 	DoubleWritable height = new DoubleWritable(Double.parseDouble(value.toString().split(";")[6]));
			 	
	            context.write(species, height);
	        }
       
	 }
	 
}
