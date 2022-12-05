package dec_05;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.util.*;

public class dec_05 {
    static File inputFile = new File("D:\\Eleonor\\Documents\\Code\\AdventOfCode\\2022\\src\\dec_05\\dec_05_input");

    public static void main(String[] args) throws IOException {
        //Part One
        System.out.println("Part One: " + partOne());

        //Part Two
        System.out.println("Part Two: " + partTwo());
    }

    public static String partOne() throws IOException {
        List<String> rows = Files.readAllLines(inputFile.toPath(), Charset.defaultCharset());

        Map<Integer, Stack<String>> stacks = new HashMap<>();
        stacks.put(1, new Stack<>());
        stacks.put(2, new Stack<>());
        stacks.put(3, new Stack<>());
        stacks.put(4, new Stack<>());
        stacks.put(5, new Stack<>());
        stacks.put(6, new Stack<>());
        stacks.put(7, new Stack<>());
        stacks.put(8, new Stack<>());
        stacks.put(9, new Stack<>());

        for (int i = 0; i < 8; i++) {

            String[] results = rows.get(i).split("(?<=\\G.{" + 4 + "})");
            for (int j = 0; j < results.length; j++) {

                if (results[j].trim().length() > 0) {
                    Stack stack = stacks.get(j + 1);
                    stack.push(results[j]);
                }
            }
        }

        for(int p = 0; p < stacks.size(); p++) {
            Stack stack = stacks.get(p + 1);
            Collections.reverse(stack);
        }


        for (int k = 10; k < rows.size(); k++) {
            String[] strings = rows.get(k).split(" ");

            for (int l = 0; l < Integer.valueOf(strings[1]); l++) {
                String crate = stacks.get(Integer.valueOf(strings[3])).pop();
                Stack stack = stacks.get(Integer.valueOf(strings[5]));
                stack.push(crate);
            }
        }

        String result = "";
        for(int p = 0; p < stacks.size(); p++) {
            String crate = stacks.get(p + 1).pop();
            crate = crate.replaceAll("\\W", "").trim();
            result = result + crate;
        }

        return result;
    }

    public static String partTwo() throws IOException {
        List<String> rows = Files.readAllLines(inputFile.toPath(), Charset.defaultCharset());

        Map<Integer, Stack<String>> stacks = new HashMap<>();
        stacks.put(1, new Stack<>());
        stacks.put(2, new Stack<>());
        stacks.put(3, new Stack<>());
        stacks.put(4, new Stack<>());
        stacks.put(5, new Stack<>());
        stacks.put(6, new Stack<>());
        stacks.put(7, new Stack<>());
        stacks.put(8, new Stack<>());
        stacks.put(9, new Stack<>());

        for (int i = 0; i < 8; i++) {

            String[] results = rows.get(i).split("(?<=\\G.{" + 4 + "})");
            for (int j = 0; j < results.length; j++) {

                if (results[j].trim().length() > 0) {
                    Stack stack = stacks.get(j + 1);
                    stack.push(results[j]);
                }
            }
        }

        for(int p = 0; p < stacks.size(); p++) {
            Stack stack = stacks.get(p + 1);
            Collections.reverse(stack);
        }

        for (int k = 10; k < rows.size(); k++) {
            String[] strings = rows.get(k).split(" ");

            int numberOfCrates = Integer.valueOf(strings[1]);

            Stack<String> tempStack = new Stack();

            for (int l = 0; l < numberOfCrates; l++) {
                String crate = stacks.get(Integer.valueOf(strings[3])).pop();
                tempStack.push(crate);
            }

            for(int m = 0; m < numberOfCrates; m++ ) {
                String crate = tempStack.pop();
                Stack stack = stacks.get(Integer.valueOf(strings[5]));
                stack.push(crate);
            }
        }

        String result = "";
        for(int p = 0; p < stacks.size(); p++) {
            String crate = stacks.get(p + 1).pop();
            crate = crate.replaceAll("\\W", "").trim();
            result = result + crate;
        }

        return result;
    }
}
