package lab2;

import org.apache.hadoop.mapreduce.Partitioner;

public class Partnr<WritableComp, Text> extends Partitioner<WritableComp, Text> {
    public int getPartition(WritableComp key, Text value, int numReduceTasks) {
        return (key.hashCode() & Integer.MAX_VALUE) % numReduceTasks;
    }
}