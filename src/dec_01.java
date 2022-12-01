import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class dec_01 {

    static String input = "1000\n" +
            "2000\n" +
            "3000\n" +
            "\n" +
            "4000\n" +
            "\n" +
            "5000\n" +
            "6000\n" +
            "\n" +
            "7000\n" +
            "8000\n" +
            "9000\n" +
            "\n" +
            "10000";

    public static void main(String[] args){

        String[] lines = input.split("\\n\\n");

        List<Integer> elfsCalories = new ArrayList<>();
        for(String carryString : lines) {
            int[] ints = Arrays.stream(carryString.split("\\n")).mapToInt(Integer::parseInt).toArray();
            elfsCalories.add(Arrays.stream(ints).sum());
        }
        int most = Collections.max(elfsCalories);
        System.out.print(most);
    }
}