package lab2;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;


import java.io.IOException;

public class AirMapper extends Mapper<LongWritable, Text, WritableComp, Text> {
    protected static final String REGcomma = "[,]";
    protected static final String REGamper = "[&]";
    protected static final String REGslash = "[\"]";
    public void map(LongWritable key, Text value, Mapper.Context context) throws IOException, InterruptedException {
        String[] str = value.toString()
                .replaceFirst(REGcomma, REGamper)
                .replaceAll(REGslash, "")
                .split(REGamper);
        if (key.get() != 0){
            context.write(new WritableComp(Integer.parseInt(str[0]), 0), new Text(str[1]));
        }
    }
}
