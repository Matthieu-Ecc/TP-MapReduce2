package com.opstty.mapper;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import com.opstty.newclasse1_8_6;


public class mapper1_8_6 extends Mapper<LongWritable, Text, IntWritable , newclasse1_8_6> {
	newclasse1_8_6 group = new newclasse1_8_6();
	IntWritable one = new IntWritable(1);

	 public void map(LongWritable key, Text value, Context context)throws IOException, InterruptedException {
		 if(!value.toString().contains("GEOPOINT")){
			 	IntWritable id = new IntWritable(Integer.parseInt(value.toString().split(";")[1]));
			 	IntWritable age = new IntWritable(Integer.parseInt(value.toString().split(";")[5]));
			 	group.setId(id);
			 	group.setAge(age);
			 	
	            context.write(one, group);
	        }
     
	 }
	 
}

