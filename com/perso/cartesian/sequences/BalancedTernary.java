package com.perso.cartesian.sequences;

import java.util.ArrayList;
import java.util.List;

public class BalancedTernary {
    
    private List<Long> sequence;

    public BalancedTernary(long target, long ySlide) {
        sequence = new ArrayList<Long>();
        for (long i = 0; i <= target; i++) {
            sequence.add(
                balanceTernary(
                    decimalToTernary(i)
                )
            + ySlide
            );
        }
    }

    public static long decimalToTernary(long number) {
        long result = 0;
        long factor = 1;
        while (number > 0) {
            result += number % 3 * factor;
            number /= 3;
            factor *= 10;
        }
        return result;
    }

    public static long balanceTernary(long number) {
        long result = 0;
        long factor = 1;
        long digit = 0;
        while (number > 0) {
            digit = number % 10;
            result += factor * ((digit == 2)? -1 : digit);
            number /= 10;
            factor *= 3;
        }
        return result;
    }

    public List<Long> getSequence() {
        return sequence;
    }

    public void setSequence(List<Long> sequence) {
        this.sequence = sequence;
    }
}
