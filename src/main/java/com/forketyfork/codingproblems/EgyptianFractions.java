package com.forketyfork.codingproblems;

import java.util.ArrayList;

public class EgyptianFractions {

    public Integer[] egyptian(int num, int denom) {
        var denominators = new ArrayList<Integer>();
        do {
            int multiplier = (int) Math.ceil(1.0 * denom / num);
            num = num * multiplier - denom;
            denom *= multiplier;
            denominators.add(multiplier);
        } while (num > 0);
        return denominators.toArray(new Integer[0]);
    }

}
