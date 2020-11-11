package com.opstty.mapper;

import java.io.IOException;



import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class mapper1_8_2 extends Mapper<LongWritable, Text, Text, NullWritable> {

	 public void map(LongWritable key, Text value, Context context)throws IOException, InterruptedException {
		 if(!value.toString().contains("GEOPOINT")){
			 	Text district = new Text(value.toString().split(";")[1]);
	            context.write(district, NullWritable.get());
	        }

	        
}
}
