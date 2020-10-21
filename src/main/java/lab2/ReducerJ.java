package lab2;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;
import java.util.Iterator;

public class ReducerJ extends Reducer<WritableComp, Text, Text, Text> {
    protected void reduce(WritableComp key, Iterable<Text> values, Context context) throws IOException, InterruptedException {
        Iterator<Text> iter = values.iterator();
        Text nameAir = new Text(iter.next());
        float delTimePrev = Float.parseFloat(iter.next().toString());
        float minDel = delTimePrev;
        float maxDel = delTimePrev;
        float sum = delTimePrev;
        int amount = 1;
        while (iter.hasNext()) {
            float delTime = Float.parseFloat(iter.next().toString());
            if (delTime > maxDel) {
                maxDel = delTime;
            }
            if (delTime < minDel) {
                minDel = delTime;
            }
            sum += delTime;
            amount++;
        }
        sum = sum/amount;
        context.write();
    }
}
