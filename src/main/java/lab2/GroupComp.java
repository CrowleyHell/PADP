package lab2;

import org.apache.hadoop.io.WritableComparable;
import org.apache.hadoop.io.WritableComparator;

public class GroupComp extends WritableComparator {

    public GroupComp() {
        super(WritableComp.class,true);
    }
    public int compare(WritableComparable first, WritableComparable second) {
        WritableComp compFirst, compSec;
        compFirst = (WritableComp) first;
        compSec = (WritableComp) second;
        return Integer.compare(compFirst.getCodeAir(), compSec.getCodeAir());
        
    }
}
