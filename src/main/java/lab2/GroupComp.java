package lab2;

import org.apache.hadoop.io.RawComparator;
import org.apache.hadoop.io.WritableComparable;

public class GroupComp implements RawComparator {
    public int compare(WritableComparable first, WritableComparable second) {
        WritableComp compFirst, compSec;
        compFirst = (WritableComp) first;
        compSec = (WritableComp) second;
        return Integer.compare(compFirst.getCodeAir(), compSec.getCodeAir());
    }
}
