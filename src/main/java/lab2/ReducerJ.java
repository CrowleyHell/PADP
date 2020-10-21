package lab2;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;

public class ReducerJ extends Reducer<WritableComp, Text, Text, Text> {
    protected void reduce(WritableComp key, Iterable<Text> values, Context context) throws IOException, InterruptedException {
        
    }
}
