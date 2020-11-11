package com.opstty.reducer;

import java.io.IOException;

import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class reducer1_8_2 extends Reducer<Text, NullWritable, Text, NullWritable>{
	 public void reduce(Text key, NullWritable value, Context context) throws IOException, InterruptedException {
	        context.write(key,NullWritable.get() );
	    }

}
