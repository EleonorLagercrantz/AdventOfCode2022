package dec_06;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.util.*;
import java.util.stream.Collectors;

public class dec_06 {
    static File inputFile = new File("D:\\Eleonor\\Documents\\Code\\AdventOfCode\\2022\\src\\dec_06\\dec_06_input");

    public static void main(String[] args) throws IOException {
        //Part One
        System.out.println("Part One: " + partOne());

        //Part Two
        System.out.println("Part Two: " + partTwo());
    }

    public static int partOne() throws IOException {
        List<String> rows = Files.readAllLines(inputFile.toPath(), Charset.defaultCharset());
        String input = rows.get(0);

        int result = 0;

        final List<Character> chars = input.chars().mapToObj(e->(char)e).collect(Collectors.toList());
        List<Character> currentChars = new ArrayList<>(chars.subList(0, 4));
        Set<Character> currentSet = new HashSet<>(currentChars);

        if(currentSet.size() == 4) {
            result = 4;
        }
        else {
            for (int i = 4; i < chars.size() - 4; i++) {
                currentChars.remove(0);
                currentChars.add(chars.get(i));
                currentSet = new HashSet<>(currentChars);
                if(currentSet.size() == 4) {
                    result = i + 1;
                    break;
                }

            }
        }

        return result;
    }

    public static int partTwo() throws IOException {
        List<String> rows = Files.readAllLines(inputFile.toPath(), Charset.defaultCharset());
        String input = rows.get(0);

        int result = 0;

        final List<Character> chars = input.chars().mapToObj(e->(char)e).collect(Collectors.toList());
        List<Character> currentChars = new ArrayList<>(chars.subList(0, 14));
        Set<Character> currentSet = new HashSet<>(currentChars);

        if(currentSet.size() == 14) {
            result = 14;
        }
        else {
            for (int i = 14; i < chars.size() - 14; i++) {
                currentChars.remove(0);
                currentChars.add(chars.get(i));
                currentSet = new HashSet<>(currentChars);
                if(currentSet.size() == 14) {
                    result = i + 1;
                    break;
                }

            }
        }

        return result;
    }
}
