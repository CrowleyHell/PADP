package lab2;

import org.apache.hadoop.io.WritableComparable;

import java.io.DataOutput;
import java.io.IOException;

public class WritableComp implements WritableComparable<WritableComp> {
    private int codeAir, flagAir;
    public void write(DataOutput out) throws IOException {
        out.writeInt(codeAir);
        out.writeInt(flagAir);
    }

    public void readFile()
}
