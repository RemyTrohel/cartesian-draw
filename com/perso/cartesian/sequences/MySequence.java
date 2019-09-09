package com.perso.cartesian.sequences;

import java.util.ArrayList;
import java.util.List;

public class MySequence {

    private List<Integer> sequence;

    public MySequence(int target) {
        sequence = new ArrayList<Integer>();
        int current = 0;
        int id = 0;
        int lastId = 0;
        sequence.add(0);
        while (id < target) {
            lastId = sequence.subList(0, id).lastIndexOf(sequence.get(id));
            if (lastId == -1) {
                sequence.add(0);
            }
            else {
                current = id - lastId;
                sequence.add(current);
            }
            id++;
        }
    }

    public List<Integer> getSequence() {
        return sequence;
    }

    public void setSequence(List<Integer> sequence) {
        this.sequence = sequence;
    }
}