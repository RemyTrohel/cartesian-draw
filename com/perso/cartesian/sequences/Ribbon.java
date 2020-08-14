package sequences;

import java.util.ArrayList;
import java.util.List;

public class Ribbon {
    private List<Long> sequence;

    public Ribbon(long target) {
        sequence = new ArrayList<Long>();
        sequence.add(0l);
        sequence.add(1l);
        sequence.add(1l);
        for (int n = 3; n <= target; n++) {
            sequence.add(
                sequence.get((int)(long)sequence.get(n-1)) + sequence.get((int)(n - sequence.get(n - 2)) - 1)
            );
        }
    }

    public List<Long> getSequence() {
        return sequence;
    }

    public void setSequence(List<Long> sequence) {
        this.sequence = sequence;
    }
}