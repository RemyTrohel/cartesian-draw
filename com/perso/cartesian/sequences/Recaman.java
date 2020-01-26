package com.perso.cartesian.sequences;

import java.util.ArrayList;
import java.util.List;

public class Recaman {

    private List<Long> sequence;
    private boolean[] usedNumber;

    public Recaman(long target) {
        this.sequence = new ArrayList<Long>();
        usedNumber = new boolean[(int)(7*target)];
        sequence.add(0l);
        long number;
        for (long i = 1; i <= target; i++) {
            number = sequence.get(sequence.size() - 1) - i;
            if (number > 0 && !alreadyUsed(number)) {
                sequence.add(number);
                usedNumber[(int)number] = true;
            } else {
                sequence.add(number + 2*i);
                usedNumber[(int)(number + 2*i)] = true;
            }
        }
    }

    public boolean alreadyUsed(long number) {
        return usedNumber[(int)number];     //this.usedNumber.indexOf(number) != -1;
    }

    public void showRecaman() {
        for (long i : this.sequence) {
            System.out.print(i + ", ");
        }
    }

    public List<Long> getSequence() {
        return sequence;
    }

    public void setSequence(List<Long> sequence) {
        this.sequence = sequence;
    }
}