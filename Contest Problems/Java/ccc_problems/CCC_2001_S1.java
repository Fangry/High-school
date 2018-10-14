package ccc_problems;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class CCC_2001_S1 {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            String input = reader.readLine();
            List<Character> clubs = new ArrayList<>();
            List<Character> diamonds = new ArrayList<>();
            List<Character> hearts = new ArrayList<>();
            List<Character> spades = new ArrayList<>();
            int suit = 0;

            for (int i = 0; i < input.length(); i++) {
                char card = input.charAt(i);
                switch (card) {
                    case 'C':
                        suit = 1;
                        break;
                    case 'D':
                        suit = 2;
                        break;
                    case 'H':
                        suit = 3;
                        break;
                    case 'S':
                        suit = 4;
                        break;
                    default:
                        if (suit == 1) {
                            clubs.add(card);
                        } else if (suit == 2) {
                            diamonds.add(card);
                        } else if (suit == 3) {
                            hearts.add(card);
                        } else if (suit == 4) {
                            spades.add(card);
                        }
                        break;
                }
            }
            int cPoints = points(clubs), dPoints = points(diamonds), hPoints = points(hearts), sPoints = points(spades);

            System.out.println("Cards Dealt\t\t\tPoints");
            System.out.println("Clubs " + printList(clubs) + "\t" + cPoints);
            System.out.println("Diamonds " + printList(diamonds) + "\t" + dPoints);
            System.out.println("Hearts " + printList(hearts) + "\t" + hPoints);
            System.out.println("Spades " + printList(spades) + "\t" + sPoints);
            System.out.println("\t\t\t\tTotal " + (cPoints + dPoints + hPoints + sPoints));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static int points(List<Character> list) {
        int points = 0;
        int size = list.size();

        for (int i = 0; i < size; i++) {
            char c = list.get(i);
            switch (c) {
                case 'A':
                    points += 4;
                    break;
                case 'K':
                    points += 3;
                    break;
                case 'Q':
                    points += 2;
                    break;
                case 'J':
                    points++;
                    break;
            }
        }

        switch (size) {
            case 0:
                points += 3;
                break;
            case 1:
                points += 2;
                break;
            case 2:
                points++;
                break;
        }
        return points;
    }

    public static <T> String printList(List<T> list) {
        StringBuilder out = new StringBuilder("");
        for (T t : list) {
            out.append(t + " ");
        }
        return out.toString();
    }
}
