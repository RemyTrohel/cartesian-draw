package sequences;

import java.util.ArrayList;
import java.util.List;

public class VanEck {

    private List<Long> sequence;

    public VanEck(long target) {
        sequence = new ArrayList<Long>();
        long current = 0;
        int id = 0;
        int lastId = 0;
        sequence.add(0l);
        while (id < target) {
            lastId = sequence.subList(0, id).lastIndexOf(sequence.get(id));
            if (lastId == -1) {
                sequence.add(0l);
            }
            else {
                current = id - lastId;
                sequence.add(current);
            }
            id++;
        }
    }

    public List<Long> getSequence() {
        return sequence;
    }

    public void setSequence(List<Long> sequence) {
        this.sequence = sequence;
    }
}
