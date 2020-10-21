package lab2;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;


import java.io.IOException;

public class AirMapper extends Mapper<Text, IntWritable, Text, LongWritable> {
    public void map(LongWritable key, Text value, Mapper.Context context) throws IOException, InterruptedException
}
