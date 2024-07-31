import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] sizes = {100, 500, 1000, 5000, 30000, 80000, 100000, 150000, 200000};
        int repetitions = 5;

        for (int size : sizes) {
            long[] executionTimes = new long[repetitions];
            long totalTime = 0;

            for (int i = 0; i < repetitions; i++) {
                int[] array = RandomNumberGenerator.generateRandomNumbers(size);
                int[] arrayCopy = Arrays.copyOf(array, array.length);

                long startTime = System.nanoTime();
                
                // Definicao de qual algoritmo vai ser utilizado
                QuickSort quickSort = new QuickSort();
                quickSort.sort(arrayCopy);

                 //HeapSort heapSort = new HeapSort();
                 //heapSort.sort(arrayCopy);

                long endTime = System.nanoTime();
                
                long duration = endTime - startTime; // Tempo em nanosegundos
                executionTimes[i] = duration;
                totalTime += duration;

                System.out.println("Tamanho do vetor: " + size + ", Execução " + (i + 1) + ": " + duration / 1e6 + " ms");
            }

            double averageTime = totalTime / (double) repetitions;
            System.out.println("Tamanho do vetor: " + size + ", Tempo médio de execução: " + averageTime / 1e6 + " ms");
            System.out.println("----------------------------------------");
        }
    }
}
