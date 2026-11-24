package org.mainmenu;

import java.util.*;
import java.util.stream.IntStream;

public class Main {
    static void main() {
        System.out.println("Welcome to the Sorting Algorithm Comparator!");
        while (true) {
            System.out.println("\n\nPick a number from 1 to 6 to perform the corresponding algorithm, or choose 0 to quit:");
            System.out.println("1. Bubble Sort.");
            System.out.println("2. Selection Sort.");
            System.out.println("3. Insertion Sort.");
            System.out.println("4. Merge Sort.");
            System.out.println("5. Quick Sort.");
            System.out.println("6. Compare All Algorithms.");
            System.out.println("0. Exit.");

            boolean pass = false;
            int entry = 0;

            while (!pass) {
                Scanner scanner = new Scanner(System.in);
                System.out.print("\nYour entry: ");
                try {
                    entry = scanner.nextInt();
                }
                catch (InputMismatchException e) {
                    System.out.println("Invalid entry! Enter a number value between 0 and 6.\n");
                    continue;
                }
                if (entry < 0 || entry > 6) {
                    System.out.println("Invalid entry! Enter a number value between 0 and 6.\n");
                }
                else pass = true;
            }

            if (entry == 0) {
                return;
            }

            pass = false;
            int arraySize = 0;

            while (!pass) {
                Scanner scanner = new Scanner(System.in);
                System.out.print("Enter the size of the desired array size: ");
                try {
                    arraySize = scanner.nextInt();
                }
                catch (InputMismatchException e) {
                    System.out.println("Invalid entry, enter a valid integer value!\n");
                    continue;
                }
                pass = true;
            }

            int[]  numbers = IntStream.generate(() -> new Random().nextInt(1000)).limit(arraySize).toArray();

            switch (entry) {
                case 1:
                    bubbleSort(numbers);
                    break;

                case 2:
                    selectionSort(numbers);
                    break;

                case 3:
                    insertionSort(numbers);
                    break;

                case 4:
                    mergeSort(numbers);
                    break;

                case 5:
                    quickSort(numbers, 0, numbers.length - 1);
                    break;
            }
        }
    }

    static void bubbleSort(int[] numbers) {
        long[] timeSamples = {0, 0, 0, 0, 0};
        long[] spaceSamples = {0, 0, 0, 0, 0};
        System.out.println("Applying Bubble Sort on the given array..");

        for (int iter=0; iter<5; iter++) {
            long startTime = System.nanoTime();
            Runtime startSpace = Runtime.getRuntime();

            int loop = numbers.length - 1;
            boolean sorted = false;
            while (loop > 1 && !sorted) {
                sorted = true;
                for (int i = 0; i < loop; i++) {
                    if (numbers[i] > numbers[i + 1]) {
                        int temp = numbers[i];
                        numbers[i] = numbers[i + 1];
                        numbers[i + 1] = temp;
                        sorted = false;
                    }
                }
                loop--;
            }

            long endTime = System.nanoTime();
            long cpuTime = (endTime - startTime) / 10 ^ 9;
            long space = startSpace.totalMemory() / 1024;

            timeSamples[iter] = cpuTime;
            spaceSamples[iter] = space;
        }

        long total = 0;
        long realCpuTime;
        for (int iter=0; iter<5; iter++) {
            total = total + timeSamples[iter];
        }
        realCpuTime = total/5;

        long realSpace;
        for (int iter=0; iter<5; iter++) {
            total = total + spaceSamples[iter];
        }
        realSpace = total/5;

        System.out.print("The sorted array: ");
        System.out.println(Arrays.toString(numbers));
        System.out.printf("CPU time: %d s.\n", realCpuTime);
        System.out.printf("Total memory usage: %d KB.\n", realSpace);
    }

    static void selectionSort(int[] numbers) {
        long[] timeSamples = {0, 0, 0, 0, 0};
        long[] spaceSamples = {0, 0, 0, 0, 0};
        System.out.println("Applying Bubble Sort on the given array..");

        for (int iter=0; iter<5; iter++) {
            long startTime = System.nanoTime();
            Runtime startSpace = Runtime.getRuntime();

            int index = 0;
            while (index < numbers.length) {
                int min = numbers[index];
                for (int i = index + 1; i < numbers.length; i++) {
                    if (numbers[i] < min) {
                        min = numbers[i];
                        numbers[i] = numbers[index];
                        numbers[index] = min;
                    }
                }
                index++;
            }

            long endTime = System.nanoTime();
            long cpuTime = (endTime - startTime) / 10 ^ 9;
            long space = startSpace.totalMemory() / 1024;

            timeSamples[iter] = cpuTime;
            spaceSamples[iter] = space;
        }

        long total = 0;
        long realCpuTime;
        for (int iter=0; iter<5; iter++) {
            total = total + timeSamples[iter];
        }
        realCpuTime = total/5;

        long realSpace;
        for (int iter=0; iter<5; iter++) {
            total = total + spaceSamples[iter];
        }
        realSpace = total/5;

        System.out.print("The sorted array: ");
        System.out.println(Arrays.toString(numbers));
        System.out.printf("CPU time: %d s.\n", realCpuTime);
        System.out.printf("Total memory usage: %d KB.\n", realSpace);
    }

    static void insertionSort(int[] numbers) {
        long[] timeSamples = {0, 0, 0, 0, 0};
        long[] spaceSamples = {0, 0, 0, 0, 0};
        System.out.println("Applying Bubble Sort on the given array..");

        for (int iter=0; iter<5; iter++) {
            long startTime = System.nanoTime();
            Runtime startSpace = Runtime.getRuntime();

            for (int i = 1; i < numbers.length; i++) {
                int k = numbers[i];
                int j = i - 1;
                while (j >= 0 && k < numbers[j]) {
                    numbers[j + 1] = numbers[j];
                    j--;
                }
                numbers[j + 1] = k;
            }

            long endTime = System.nanoTime();
            long cpuTime = (endTime - startTime) / 10 ^ 9;
            long space = startSpace.totalMemory() / 1024;

            timeSamples[iter] = cpuTime;
            spaceSamples[iter] = space;
        }

        long total = 0;
        long realCpuTime;
        for (int iter=0; iter<5; iter++) {
            total = total + timeSamples[iter];
        }
        realCpuTime = total/5;

        long realSpace;
        for (int iter=0; iter<5; iter++) {
            total = total + spaceSamples[iter];
        }
        realSpace = total/5;

        System.out.print("The sorted array: ");
        System.out.println(Arrays.toString(numbers));
        System.out.printf("CPU time: %d s.\n", realCpuTime);
        System.out.printf("Total memory usage: %d KB.\n", realSpace);
    }

    static void mergeSort(int[] numbers) {
        long[] timeSamples = {0, 0, 0, 0, 0};
        long[] spaceSamples = {0, 0, 0, 0, 0};
        System.out.println("Applying Bubble Sort on the given array..");

        for (int iter=0; iter<5; iter++) {
            long startTime = System.nanoTime();
            Runtime startSpace = Runtime.getRuntime();

            split(numbers);

            long endTime = System.nanoTime();
            long cpuTime = (endTime - startTime) / 10 ^ 9;
            long space = startSpace.totalMemory() / 1024;

            timeSamples[iter] = cpuTime;
            spaceSamples[iter] = space;
        }

        long total = 0;
        long realCpuTime;
        for (int iter=0; iter<5; iter++) {
            total = total + timeSamples[iter];
        }
        realCpuTime = total/5;

        long realSpace;
        for (int iter=0; iter<5; iter++) {
            total = total + spaceSamples[iter];
        }
        realSpace = total/5;

        System.out.print("The sorted array: ");
        System.out.println(Arrays.toString(numbers));
        System.out.printf("CPU time: %d s.\n", realCpuTime);
        System.out.printf("Total memory usage: %d KB.\n", realSpace);
    }

    static int[] split(int[] numbers) {

        int size = numbers.length;
        if (size < 2) {
            return numbers;
        }
        int mid = size / 2;
        int[] l = new int[mid];
        int[] r = new int[size - mid];

        for (int i = 0; i < mid; i++) {
            l[i] = numbers[i];
        }
        for (int i = mid; i < size; i++) {
            r[i - mid] = numbers[i];
        }

        split(l);
        split(r);

        merge(numbers, l, r, mid, size - mid);

        return numbers;
    }

    static void merge(int[] numbers, int[] l, int[] r, int left, int right) {

        int i = 0, j = 0, k = 0;
        while (i < left && j < right) {
            if (l[i] <= r[j]) {
                numbers[k++] = l[i++];
            } else {
                numbers[k++] = r[j++];
            }
        }
        while (i < left) {
            numbers[k++] = l[i++];
        }
        while (j < right) {
            numbers[k++] = r[j++];
        }
    }

    static void quickSort(int[] numbers, int low, int high) {
        long[] timeSamples = {0, 0, 0, 0, 0};
        long[] spaceSamples = {0, 0, 0, 0, 0};
        System.out.println("Applying Bubble Sort on the given array..");


        for (int iter=0; iter<5; iter++) {
            long startTime = System.nanoTime();
            Runtime startSpace = Runtime.getRuntime();

            unite(numbers, low, high);

            long endTime = System.nanoTime();
            long cpuTime = (endTime - startTime) / 10 ^ 9;
            long space = startSpace.totalMemory() / 1024;

            timeSamples[iter] = cpuTime;
            spaceSamples[iter] = space;
        }

        long total = 0;
        long realCpuTime;
        for (int iter=0; iter<5; iter++) {
            total = total + timeSamples[iter];
        }
        realCpuTime = total/5;

        long realSpace;
        for (int iter=0; iter<5; iter++) {
            total = total + spaceSamples[iter];
        }
        realSpace = total/5;

        System.out.print("The sorted array: ");
        System.out.println(Arrays.toString(numbers));
        System.out.printf("CPU time: %d s.\n", realCpuTime);
        System.out.printf("Total memory usage: %d KB.\n", realSpace);
    }

    static int[] unite(int numbers[], int low, int high) {
        if (low < high) {
            int part = partition(numbers, low, high);

            unite(numbers, low, part-1);
            unite(numbers, part+1, high);
        }
        return numbers;
    }

    static int partition(int numbers[], int low, int high) {
        int pivot = numbers[high];
        int i = low-1;
        for (int j=low; j<high; j++) {
            if (numbers[j] <= pivot) {
                i++;

                int temp = numbers[i];
                numbers[i] = numbers[j];
                numbers[j] = temp;
            }
        }

        int temp = numbers[i+1];
        numbers[i+1] = numbers[high];
        numbers[high] = temp;

        return i+1;
    }
}