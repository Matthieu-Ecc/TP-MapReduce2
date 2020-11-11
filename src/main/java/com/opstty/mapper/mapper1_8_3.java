package com.opstty.mapper;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;


public class mapper1_8_3 extends Mapper<LongWritable, Text, Text, IntWritable> {
	private final static IntWritable one = new IntWritable(1);

	 public void map(LongWritable key, Text value, Context context)throws IOException, InterruptedException {
		 if(!value.toString().contains("GEOPOINT")){
			 	Text species = new Text(value.toString().split(";")[3]);
	            context.write(species, one);
	        }
       
	 }
	 
}
