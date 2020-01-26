package com.perso.cartesian.sequences;

import java.util.ArrayList;
import java.util.List;

public class Alpes {
    private List<Long> sequence;
    private List<Integer> bits;

    public Alpes(long target) {
        sequence = new ArrayList<Long>();
        bits = new ArrayList<Integer>();
        int b;
        sequence.add(0l);
        sequence.add(0l);
        bits.add(1); // at index 0
        int next = 4;
        for (long n = 2; n < target; n++) {
            if (n == next) {
                sequence.add(0l);
                bits.set(0, bits.get(0) + (int)n);
                next *= 2;
            } else {
                b = 0;
                while (b < bits.size()) {
                    if ( (n^bits.get(b)) == (n + bits.get(b)) ) {
                        break;
                    } else {
                        b++;
                    }
                }
                sequence.add((long)b);
                if (b == bits.size()) {
                    bits.add((int)n);
                } else {
                    bits.set(b, bits.get(b) + (int)n);
                }
            }
        }
    }

    public List<Long> getSequence() {
        return sequence;
    }

    public void setSequence(List<Long> sequence) {
        this.sequence = sequence;
    }
}