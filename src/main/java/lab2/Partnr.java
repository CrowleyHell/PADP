package lab2;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Partitioner;

public class Partnr extends Partitioner<WritableComp, Text> {
    public int getPartition(WritableComp key, Text value, int numReduceTasks) {
        return (key.getCodeAir() & Integer.MAX_VALUE) % numReduceTasks;
    }
}