package dec_02;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.util.List;

public class dec_02 {

    static File inputFile = new File("D:\\Eleonor\\Documents\\Code\\AdventOfCode\\2022\\src\\dec_02\\dec_02_input");

    public static void main(String[] args) throws IOException {
        //Part One
        System.out.println("Part One: " + partOne());

        //Part Two
        System.out.println("Part Two: " + partTwo());
    }

    public static int partOne() throws IOException {
        List<String> rows = Files.readAllLines(inputFile.toPath(), Charset.defaultCharset());
        int points = 0;
        for(String row : rows) {
            String[] hands = row.split("\\s+");
            String opponent = hands[0];
            String player = hands[hands.length-1];

            Hand opponentHand = null;
            Hand playerHand = null;

            switch(opponent) {
                case "A":
                    opponentHand = Hand.ROCK;
                    break;
                case "B":
                    opponentHand = Hand.PAPER;
                    break;
                case "C":
                    opponentHand = Hand.SCISSORS;
                    break;
            }

            switch(player){
                case "X":
                    points += 1;
                    playerHand = Hand.ROCK;
                    break;
                case "Y":
                    points += 2;
                    playerHand = Hand.PAPER;
                    break;
                case "Z":
                    points += 3;
                    playerHand = Hand.SCISSORS;
                    break;
            }

            if(playerHand.equals(opponentHand)) {
                points += 3;
            }
            else if ((Hand.ROCK == playerHand && Hand.SCISSORS == opponentHand) ||
                    (Hand.SCISSORS == playerHand && Hand.PAPER == opponentHand) ||
                    (Hand.PAPER == playerHand && Hand.ROCK == opponentHand))
                    {
                points += 6;
            }
        }

        return points;
    }

    public static int partTwo() throws IOException {
        List<String> rows = Files.readAllLines(inputFile.toPath(), Charset.defaultCharset());
        int points = 0;
        for(String row : rows) {
            String[] hands = row.split("\\s+");
            String opponent = hands[0];
            String player = hands[hands.length - 1];

            Hand opponentHand = null;
            Hand playerHand = null;

            switch (opponent) {
                case "A":
                    opponentHand = Hand.ROCK;
                    break;
                case "B":
                    opponentHand = Hand.PAPER;
                    break;
                case "C":
                    opponentHand = Hand.SCISSORS;
                    break;
            }

            switch(player){
                case "X":
                    if(Hand.ROCK == opponentHand)
                        playerHand = Hand.SCISSORS;
                    else if (Hand.SCISSORS == opponentHand)
                        playerHand = Hand.PAPER;
                    else {
                        playerHand = Hand.ROCK;
                    }
                    break;
                case "Y":
                    playerHand = opponentHand;
                    break;
                case "Z":
                    if(Hand.ROCK == opponentHand)
                        playerHand = Hand.PAPER;
                    else if (Hand.SCISSORS == opponentHand)
                        playerHand = Hand.ROCK;
                    else {
                        playerHand = Hand.SCISSORS;
                    }
                    break;
            }

            switch(playerHand){
                case ROCK:
                    points += 1;
                    break;
                case PAPER:
                    points += 2;
                    break;
                case SCISSORS:
                    points += 3;
                    break;
            }

            if(playerHand.equals(opponentHand)) {
                points += 3;
            }
            else if ((Hand.ROCK == playerHand && Hand.SCISSORS == opponentHand) ||
                    (Hand.SCISSORS == playerHand && Hand.PAPER == opponentHand) ||
                    (Hand.PAPER == playerHand && Hand.ROCK == opponentHand))
            {
                points += 6;
            }
        }

        return points;
    }
}

enum Hand {
    ROCK,
    PAPER,
    SCISSORS
}
