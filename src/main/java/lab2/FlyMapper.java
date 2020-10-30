package lab2;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;


public class FlyMapper extends Mapper<LongWritable, Text, WritableComp, Text> {
    private static final int DESTAIRID = 14;
    private static final int DELAY = 18;
    private static final String REGCOMMA = ",";
    public void map(LongWritable key, Text value, Mapper.Context context) throws IOException, InterruptedException {
        String[] str = value.toString().split(REGCOMMA);
        if (key.get() != 0 && !str[DELAY].isEmpty() && Float.parseFloat(str[DELAY]) != 0){
            context.write(new WritableComp(Integer.parseInt(str[DESTAIRID]), 1), new Text(str[DELAY]));
        }
    }
}

