import java.util.Random;

public class Helper {
    public  static Random random = new Random();
    public static int randomNumber(){
        int min = 1; // Minimum value of the range
        int max = 100; // Maximum value of the range
        int randomNumber = random.nextInt(max - min + 1) + min;
        return randomNumber;
    }
}
