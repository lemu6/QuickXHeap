import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        // Tamanhos dos vetores para teste
        int[] sizes = {100, 500, 1000, 5000, 30000, 80000, 100000, 150000, 200000};
        int repetitions = 5;

        for (int size : sizes) {
            long totalLomutoTime = 0;
            long totalHoareTime = 0;
            long totalHeapTime = 0;

            for (int i = 0; i < repetitions; i++) {
                int[] array = RandomNumberGenerator.generateRandomNumbers(size);

                // Teste para QuickSort com partição de Lomuto
                int[] arrayCopyLomuto = Arrays.copyOf(array, array.length);
                long startTimeLomuto = System.nanoTime();
                QuickSortLomuto.quickSort(arrayCopyLomuto, 0, arrayCopyLomuto.length - 1);
                long endTimeLomuto = System.nanoTime();
                long durationLomuto = endTimeLomuto - startTimeLomuto;

                // Teste para QuickSort com partição de Hoare
                int[] arrayCopyHoare = Arrays.copyOf(array, array.length);
                long startTimeHoare = System.nanoTime();
                QuickSortHoare.quickSort(arrayCopyHoare, 0, arrayCopyHoare.length - 1);
                long endTimeHoare = System.nanoTime();
                long durationHoare = endTimeHoare - startTimeHoare;

                // Teste para HeapSort
                int[] arrayCopyHeap = Arrays.copyOf(array, array.length);
                long startTimeHeap = System.nanoTime();
                HeapSort.heapSort(arrayCopyHeap);
                long endTimeHeap = System.nanoTime();
                long durationHeap = endTimeHeap - startTimeHeap;

                // Acumulando os tempos de execução
                totalLomutoTime += durationLomuto;
                totalHoareTime += durationHoare;
                totalHeapTime += durationHeap;

                // Exibindo resultados
                System.out.println("Tamanho do vetor: " + size);
                System.out.println("Execução " + (i + 1) + ":");
                System.out.println(" - QuickSort Lomuto: " + durationLomuto + " ns");
                System.out.println(" - QuickSort Hoare: " + durationHoare + " ns");
                System.out.println(" - HeapSort: " + durationHeap + " ns");
            }

            double averageLomutoTime = totalLomutoTime / (double) repetitions;
            double averageHoareTime = totalHoareTime / (double) repetitions;
            double averageHeapTime = totalHeapTime / (double) repetitions;

            System.out.println("Tamanho do vetor: " + size);
            System.out.println("Tempo médio de execução:");
            System.out.println(" - QuickSort Lomuto: " + averageLomutoTime + " ns");
            System.out.println(" - QuickSort Hoare: " + averageHoareTime + " ns");
            System.out.println(" - HeapSort: " + averageHeapTime + " ns");
            System.out.println("----------------------------------------");
        }
    }
}
