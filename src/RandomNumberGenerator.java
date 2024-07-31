import java.util.Random;

public class RandomNumberGenerator {
    public static int[] generateRandomNumbers(int size) {
        Random random = new Random();
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt(1000000); // Gera números aleatórios até 999999
        }
        return array;
    }
}
