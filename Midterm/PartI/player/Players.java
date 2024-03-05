package player;

import java.util.ArrayList;
import java.util.Collections;

public class Players {

    public static double getAverageWeight(ArrayList<SportsPlayer> players) {
        double totalWeight = 0;
        for (SportsPlayer player : players) {
            totalWeight += (double) player.getWeight();
        }
        return totalWeight / players.size();
    }

    public static void main(String[] args) {

        ArrayList<SportsPlayer> players = new ArrayList<SportsPlayer>();

        players.add(new BaseballPlayer(12, 60, Gender.MALE));
        players.add(new BaseballPlayer(13, 61, Gender.FEMALE));
        players.add(new VolleyballPlayer(10, 50, Gender.MALE));
        players.add(new VolleyballPlayer(11, 49, Gender.FEMALE));
        players.add(new BasketballPlayer(new int[] { 6, 5 }, 65, Gender.MALE));
        players.add(new BasketballPlayer(new int[] { 5, 7 }, 63, Gender.FEMALE));
        players.add(new ShotputPlayer(20, 59, Gender.MALE));
        players.add(new ShotputPlayer(22, 62, Gender.FEMALE));
        players.add(new PoleVaultPlayer(20, 57, Gender.MALE));
        players.add(new PoleVaultPlayer(22, 66, Gender.FEMALE));
        players.add(new TrackPlayer(2, 56, Gender.MALE));
        players.add(new TrackPlayer(3, 55, Gender.FEMALE));
        players.add(new CrossCountryPlayer(0.4, 54, Gender.MALE));
        players.add(new CrossCountryPlayer(0.5, 58, Gender.FEMALE));
        
        // sort by weight
        Collections.sort(players);

        for (SportsPlayer player : players) {
            System.out.println(player);
        }

        System.out.printf("\nAverage weight: %f\n", Players.getAverageWeight(players));
    }
}
