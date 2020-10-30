package lab2;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;


import java.io.IOException;

public class AirMapper extends Mapper<LongWritable, Text, WritableComp, Text> {
    private static final String REGCOMMA = ",";
    private static final String REGAMPER = "&";
    private static final String REGSLASH = "\"";
    public void map(LongWritable key, Text value, Mapper.Context context) throws IOException, InterruptedException {
        String[] str = value.toString()
                .replaceFirst(REGCOMMA, REGAMPER)
                .replaceAll(REGSLASH, "")
                .split(REGAMPER);
        if (key.get() != 0){
            context.write(new WritableComp(Integer.parseInt(str[0]), 0), new Text(str[1]));
        }
    }
}
