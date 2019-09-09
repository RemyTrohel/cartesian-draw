package com.perso.cartesian.sequences;

import java.util.ArrayList;
import java.util.List;

public class Recaman {

    private List<Integer> sequence;

    public Recaman(int target) {
        this.sequence = new ArrayList<Integer>();
        sequence.add(0);
        int number;
        for (int i = 1; i <= target; i++) {
            number = sequence.get(sequence.size() - 1) - i;
            if (number > 0 && !alreadyUsed(number)) {
                sequence.add(number);
            } else {
                sequence.add(number + 2*i);
            }
        }
    }

    public boolean alreadyUsed(int number) {
        return this.sequence.contains(number);
    }

    public void showRecaman() {
        for (int i : this.sequence) {
            System.out.print(i + ", ");
        }
    }

    public List<Integer> getSequence() {
        return sequence;
    }

    public void setSequence(List<Integer> sequence) {
        this.sequence = sequence;
    }
}