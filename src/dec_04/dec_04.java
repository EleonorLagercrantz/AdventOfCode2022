package dec_04;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.util.List;
import java.util.stream.Stream;

public class dec_04 {

    static File inputFile = new File("D:\\Eleonor\\Documents\\Code\\AdventOfCode\\2022\\src\\dec_04\\dec_04_input");

    public static void main(String[] args) throws IOException {
        //Part One
        System.out.println("Part One: " + partOne());

        //Part Two
        System.out.println("Part Two: " + partTwo());
    }

    public static int partOne() throws IOException {
        List<String> pairs = Files.readAllLines(inputFile.toPath(), Charset.defaultCharset());
        int count = 0;
        for(String pair : pairs) {
            String[] elves = pair.split(",");

            int[] firstElfParts = Stream.of(elves[0].split("-")).mapToInt(Integer::parseInt).toArray();
            int[] secondElfParts = Stream.of(elves[1].split("-")).mapToInt(Integer::parseInt).toArray();

            if(firstElfParts[0] >= secondElfParts[0] && firstElfParts[1] <= secondElfParts[1]
            || (secondElfParts[0] >= firstElfParts[0] && secondElfParts[1] <= firstElfParts[1])) {
                count++;
            }
        }
      return count;
    }

    public static int partTwo() throws IOException {
        List<String> pairs = Files.readAllLines(inputFile.toPath(), Charset.defaultCharset());
        int count = 0;
        for(String pair : pairs) {
            String[] elves = pair.split(",");

            int[] firstElfParts = Stream.of(elves[0].split("-")).mapToInt(Integer::parseInt).toArray();
            int[] secondElfParts = Stream.of(elves[1].split("-")).mapToInt(Integer::parseInt).toArray();

            if(firstElfParts[1] >= secondElfParts[0] && firstElfParts[0] <= secondElfParts[0]
                    || (secondElfParts[1] >= firstElfParts[0] && secondElfParts[0] <= firstElfParts[0])) {
                count++;
            }
        }
        return count;
    }

}
