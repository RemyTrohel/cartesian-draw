package com.perso.cartesian.sequences;

import java.util.ArrayList;
import java.util.List;

public class VanEck {

    private List<Long> sequence;
    private int[] lastIndex;

    public VanEck(long target) {
        sequence = new ArrayList<Long>();
        lastIndex = new int[(int)target];
        sequence.add(0l); // id 0
        sequence.add(0l); // id 1
        int id = 1;
        int lastId = 0;
        int temp = 0;
        while (id < target) {
            lastId = lastIndex[(int)(long)sequence.get(id)];
            lastIndex[temp] = id;
            if (lastId == 0 && id != 1) {
                sequence.add(0l);
                temp = 0;
            }
            else {
                sequence.add((long)(id - lastId));
                temp = id - lastId;
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