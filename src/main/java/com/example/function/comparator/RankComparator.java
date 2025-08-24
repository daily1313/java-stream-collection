package com.example.function.comparator;

import java.util.Comparator;

public class RankComparator implements Comparator<Player> {

    @Override
    public int compare(Player o1, Player o2) {
        return Integer.compare(o1.getRank(), o2.getRank());
    }
}
