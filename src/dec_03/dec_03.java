package dec_03;


import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.util.*;

public class dec_03 {

    static File inputFile = new File("D:\\Eleonor\\Documents\\Code\\AdventOfCode\\2022\\src\\dec_03\\dec_03_input");
    static Map<Character, Integer> prioritiesMap = new HashMap<>();

    public static void main(String[] args) throws IOException {
        //Part One
        System.out.println("Part One: " + partOne());

        //Part Two
        System.out.println("Part Two: " + partTwo());
    }

    public static int partOne() throws IOException {
        createPrioritiesList();
        List<String> rows = Files.readAllLines(inputFile.toPath(), Charset.defaultCharset());
        int sum = 0;
        for (String row : rows) {
            final int mid = row.length() / 2;
            Set<Character> compartment1 = new HashSet<>();
            Set<Character> compartment2 = new HashSet<>();

            for(char c : row.substring(0,mid).toCharArray()){
                compartment1.add(c);
            }

            for(char c2 : row.substring(mid).toCharArray()) {
                compartment2.add(c2);
            }

            compartment1.retainAll(compartment2);

            sum += prioritiesMap.get(compartment1.iterator().next()).intValue();

        }
        return sum;
    }

    public static int partTwo() throws IOException {
        createPrioritiesList();
        List<String> rows = Files.readAllLines(inputFile.toPath(), Charset.defaultCharset());
        int sum = 0;
        for(int i = 0; i < rows.size(); i+=3) {
            List<String> threeElfs = rows.subList(i, i+3);

            Set<Character> elf1 = new HashSet<>();
            Set<Character> elf2 = new HashSet<>();
            Set<Character> elf3 = new HashSet<>();

            for(char elf1Items : threeElfs.get(0).toCharArray()) {
                elf1.add(elf1Items);
            }

            for(char elf2Items : threeElfs.get(1).toCharArray()){
                elf2.add(elf2Items);
            }

            for(char elf3Items : threeElfs.get(2).toCharArray()){
                elf3.add(elf3Items);
            }

            elf1.retainAll(elf2);
            elf1.retainAll(elf3);

            sum += prioritiesMap.get(elf1.iterator().next()).intValue();
        }
        return sum;
    }

    public static void createPrioritiesList() {
        char[] lowerCaseAlphabet = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
        int i = 1;
        for (char c : lowerCaseAlphabet) {
            prioritiesMap.put(c, i);
            i++;
        }
    }
}

