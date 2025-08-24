package com.example.function.comparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Application {

    public static void main(String[] args) {
        Player player1 = new Player(59, "Kim", 20);
        Player player2 = new Player(68, "Lee", 15);
        Player player3 = new Player(23, "Park", 29);

        List<Player> players = new ArrayList<>(List.of(player1, player2, player3));

        System.out.println("sort age");
        Collections.sort(players, new AgeComparator());
        System.out.println(players);

        System.out.println("sort rank");
        Collections.sort(players, new RankComparator());
        System.out.println(players);
    }
}
