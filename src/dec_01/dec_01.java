package dec_01;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class dec_01 {

    static File inputFile = new File("D:\\Eleonor\\Documents\\Code\\AdventOfCode\\2022\\src\\dec_01\\dec_01_input");

    public static void main(String[] args) throws IOException {
        //Part One
        System.out.println("Part One: " + partOne());

        //Part Two
        System.out.println("Part Two: " + partTwo());
    }

    public static int partOne() throws IOException {
        String input = Files.readString(inputFile.toPath(), StandardCharsets.UTF_8);

        String[] lines = input.split("\\r\\n\\r\\n");

        List<Integer> elfsCalories = new ArrayList<>();
        for(String carryString : lines) {
            int[] ints = Arrays.stream(carryString.split("\\r\\n")).mapToInt(Integer::parseInt).toArray();
            elfsCalories.add(Arrays.stream(ints).sum());
        }
        return Collections.max(elfsCalories);
    }

    public static int partTwo() throws IOException {
        String input = Files.readString(inputFile.toPath(), StandardCharsets.UTF_8);

        String[] lines = input.split("\\r\\n\\r\\n");

        List<Integer> elfsCalories = new ArrayList<>();
        for(String carryString : lines) {
            int[] ints = Arrays.stream(carryString.split("\\r\\n")).mapToInt(Integer::parseInt).toArray();
            elfsCalories.add(Arrays.stream(ints).sum());
        }

        Collections.sort(elfsCalories);
        List<Integer> top3 = new ArrayList<>(elfsCalories.subList(elfsCalories.size() - 3, elfsCalories.size()));

        return top3.stream()
                .collect(Collectors.summingInt(Integer::intValue));
    }
}