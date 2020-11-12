package com.opstty.job;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;

import org.apache.hadoop.io.NullWritable;

import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.util.GenericOptionsParser;

import com.opstty.newclasse1_8_6;
import com.opstty.mapper.mapper1_8_6;
import com.opstty.reducer.reducer1_8_6;

public class district_oldest_tree {
	
	public static void main(String[] args) throws Exception {
        Configuration conf = new Configuration();
        String[] otherArgs = new GenericOptionsParser(conf, args).getRemainingArgs();
        if (otherArgs.length < 2) {
            System.err.println("Usage: district_oldest_tree <in> [<in>...] <out>");
            System.exit(2);
        }
        Job job = Job.getInstance(conf, "district_oldest_tree");
        job.setJarByClass(district_oldest_tree.class);
        job.setMapperClass(mapper1_8_6.class);
        //job.setCombinerClass(reducer1_8_6.class);
        job.setReducerClass(reducer1_8_6.class);
        job.setOutputKeyClass(NullWritable.class);
        job.setOutputValueClass(newclasse1_8_6.class);
        for (int i = 0; i < otherArgs.length - 1; ++i) {
            FileInputFormat.addInputPath(job, new Path(otherArgs[i]));
        }
        FileOutputFormat.setOutputPath(job,
                new Path(otherArgs[otherArgs.length - 1]));
        System.exit(job.waitForCompletion(true) ? 0 : 1);
    }


}
