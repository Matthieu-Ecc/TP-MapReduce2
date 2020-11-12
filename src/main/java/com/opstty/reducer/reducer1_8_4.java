package com.opstty.reducer;

import java.io.IOException;

import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class reducer1_8_4 extends Reducer<Text, DoubleWritable, Text, DoubleWritable> {
	private DoubleWritable result = new DoubleWritable();

	public void reduce(Text key, Iterable<DoubleWritable> value, Context context)
			throws IOException, InterruptedException {

		Double verif = 0.0;
		for (DoubleWritable val : value) {
			if (verif <= val.get()) {
				verif = val.get();
			}
		}
		result.set(verif);
		context.write(key, result);

	}
}