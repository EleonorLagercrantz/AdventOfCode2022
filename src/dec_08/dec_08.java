package dec_08;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.util.Collections.max;

public class dec_08 {
    static File inputFile = new File("D:\\Eleonor\\Documents\\Code\\AdventOfCode\\2022\\src\\dec_08\\dec_08_input");

    public static void main(String[] args) throws IOException {
        //Part One
        System.out.println("Part One: " + partOne());

        //Part Two
        System.out.println("Part Two: " + partTwo());
    }

    public static int partOne() throws IOException  {
        List<String> rows = Files.readAllLines(inputFile.toPath(), Charset.defaultCharset());

        int treesVisible = 0;
        List<List<Integer>> matrix = new ArrayList<>();
        for(String row : rows) {
            List<Integer> intList = new ArrayList<>();
            for(String s : row.split("")) {
                intList.add(Integer.parseInt(s));
            }
            matrix.add(intList);
        }

        treesVisible += matrix.get(0).size();
        treesVisible += matrix.get(matrix.size() - 1).size();

        for(int i = 1; i < matrix.size() - 1; i++) {
            treesVisible += 2;
            List<Integer> row = matrix.get(i);
            for(int j = 1; j < row.size() -1; j++) {
                int tree = row.get(j);
                List<Integer> leftTrees = new ArrayList<>(row.subList(0, j));
                List<Integer> rightTrees = new ArrayList<>(row.subList(j +1, row.size()));
                List<Integer> upperTrees = new ArrayList<>();
                for(int k = 0; k < i; k++) {
                    upperTrees.add(matrix.get(k).get(j));
                }
                List<Integer> lowerTrees = new ArrayList<>();
                for(int k = i + 1; k < matrix.size(); k++) {
                    lowerTrees.add(matrix.get(k).get(j));
                }
                if(max(leftTrees) < tree) {
                    treesVisible++;
                }
                else if(max(rightTrees) < tree) {
                    treesVisible++;
                }
                else if(max(upperTrees) < tree) {
                    treesVisible++;
                }
                else if(max(lowerTrees) < tree) {
                    treesVisible++;
                }
            }
        }

        return treesVisible;
    }


    public static int partTwo() throws IOException {
        List<String> rows = Files.readAllLines(inputFile.toPath(), Charset.defaultCharset());

        int highestScenicScore = 0;
        List<List<Integer>> matrix = new ArrayList<>();
        for(String row : rows) {
            List<Integer> intList = new ArrayList<>();
            for(String s : row.split("")) {
                intList.add(Integer.parseInt(s));
            }
            matrix.add(intList);
        }

        for(int i = 1; i < matrix.size() - 1; i++) {
            List<Integer> row = matrix.get(i);
            for(int j = 1; j < row.size() -1; j++) {
                int tree = row.get(j);
                List<Integer> leftTrees = new ArrayList<>(row.subList(0, j));
                List<Integer> rightTrees = new ArrayList<>(row.subList(j +1, row.size()));
                List<Integer> upperTrees = new ArrayList<>();
                for(int k = 0; k < i; k++) {
                    upperTrees.add(matrix.get(k).get(j));
                }
                List<Integer> lowerTrees = new ArrayList<>();
                for(int k = i + 1; k < matrix.size(); k++) {
                    lowerTrees.add(matrix.get(k).get(j));
                }

                int leftScore = 0;
                Collections.reverse(leftTrees);
                for(int leftTree : leftTrees) {
                    if(tree > leftTree) {
                        leftScore++;
                    }
                    else {
                        leftScore++;
                        break;
                    }
                }

                int rightScore = 0;
                for(int rightTree : rightTrees) {
                    if(tree > rightTree) {
                        rightScore++;
                    }
                    else {
                        rightScore++;
                        break;
                    }
                }
                Collections.reverse(upperTrees);
                int upperScore = 0;
                for(int upperTree : upperTrees) {
                    if(tree > upperTree) {
                        upperScore++;
                    }
                    else {
                        upperScore++;
                        break;
                    }
                }
                int lowerScore = 0;
                for(int lowerTree : lowerTrees) {
                    if (tree > lowerTree) {
                        lowerScore++;
                    } else {
                        lowerScore++;
                        break;
                    }
                }

                int score = leftScore * rightScore * upperScore * lowerScore;

                if(score > highestScenicScore) {
                    highestScenicScore = score;
                }
            }
        }

        return highestScenicScore;
    }
}
