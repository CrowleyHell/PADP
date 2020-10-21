package lab2;

import org.apache.hadoop.io.WritableComparable;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public class WritableComp implements WritableComparable<WritableComp> {
    private int codeAir, flagAir;

    public WritableComp(int codeAir, int flagAir) {
        this.codeAir = codeAir;
        this.flagAir = flagAir;
    }

    public WritableComp(){}

    public int getCodeAir() {
        return codeAir;
    }

    public int getFlagAir() {
        return flagAir;
    }

    public void write(DataOutput out) throws IOException {
        out.writeInt(codeAir);
        out.writeInt(flagAir);
    }

    public void readFields(DataInput inp) throws IOException {
        codeAir = inp.readInt();
        flagAir = inp.readInt();
    }

    public int compareTo(WritableComp obj) {
        int res = Integer.compare(this.codeAir, obj.getCodeAir());
        if (res == 0){
            int secRes = Integer.compare(this.flagAir, obj.getFlagAir());
            return secRes;
        }
        return res;
    }

    @Override
    public String toString() {
        return "WritableComp{" +
                "codeAir=" + codeAir +
                ", flagAir=" + flagAir +
                '}';
    }
}
