package lab2;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;


public class FlyMapper extends Mapper<LongWritable, Text, WritableComp, Text> {
    protected static final int destAirID = 14;
    protected static final int destAirID = 14;
    public void map(LongWritable key, Text value, Mapper.Context context) throws IOException, InterruptedException {
        String[] str = value.toString().split(",");
        if (key.get() != 0 && !str[18].isEmpty() && Float.parseFloat(str[18]) != 0){
            context.write(new WritableComp(Integer.parseInt(str[14]), 1), new Text(str[18]));
        }
    }
}

