package com.opstty.job;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.util.GenericOptionsParser;

import com.opstty.mapper.mapper1_8_5;
import com.opstty.reducer.reducer1_8_5;

public class sort_trees_small_to_height {
	
	public static void main(String[] args) throws Exception {
        Configuration conf = new Configuration();
        String[] otherArgs = new GenericOptionsParser(conf, args).getRemainingArgs();
        if (otherArgs.length < 2) {
            System.err.println("Usage: sort_trees_small_to_height <in> [<in>...] <out>");
            System.exit(2);
        }
        Job job = Job.getInstance(conf, "sort_trees_small_to_height");
        job.setJarByClass(sort_trees_small_to_height.class);
        job.setMapperClass(mapper1_8_5.class);
        job.setCombinerClass(reducer1_8_5.class);
        job.setReducerClass(reducer1_8_5.class);
        job.setOutputKeyClass(DoubleWritable.class);
        job.setOutputValueClass(Text.class);
        for (int i = 0; i < otherArgs.length - 1; ++i) {
            FileInputFormat.addInputPath(job, new Path(otherArgs[i]));
        }
        FileOutputFormat.setOutputPath(job,
                new Path(otherArgs[otherArgs.length - 1]));
        System.exit(job.waitForCompletion(true) ? 0 : 1);
    }


}
