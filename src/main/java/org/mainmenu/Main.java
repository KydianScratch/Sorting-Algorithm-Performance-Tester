package org.mainmenu;

import java.util.*;

public class Main {
    static void main() {
        while (true) {
            System.out.println("Welcome to the Sorting Algorithm Comparator!");
            System.out.println("Pick a number from 1 to 6 to perform the corresponding algorithm, or choose 0 to quit:");
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
                    throw new RuntimeException(e);
                }
                finally {
                    scanner.close();
                }
                if (entry < 0 || entry > 6) {
                    System.out.println("Invalid entry! Enter a number value between 0 and 6.\n");
                }
                else pass = true;
            }

            if (entry == 0) {
                return;
            }

            boolean done = false;
            int i = 1;
            List<String> numbersAL = new ArrayList<>();
            int element = 0;

            while (!done) {
                Scanner scanner = new Scanner(System.in);
                System.out.printf("Enter the array element number %d or enter x to finish: ", i);
                String entry2 = scanner.nextLine();

                if (entry2.toLowerCase() == "x") {
                    done = true;
                }
                else {
                    try {
                        element = Integer.parseInt(entry2);
                    }
                    catch (Exception e) {
                        System.out.println("Only enter integer values or x for finishing.");
                        continue;
                    }
                }
                numbersAL.add(entry2);
                i++;
            }

            int[] numbers = new int[numbersAL.size()];
            for (int j=0; j<numbersAL.size(); j++) {
                numbers[j] = Integer.parseInt(numbersAL.get(j));
            }

            switch (entry) {
                case 1:
                    bubbleSort(numbers);

                case 2:
                    selectionSort(numbers);

                case 3:
                    insertionSort(numbers);

                case 4:
                    mergeSort(numbers);

                case 5:
                    quickSort(numbers, 0, numbers.length - 1);
            }
        }
    }

    static void bubbleSort(int[] numbers) {
        System.out.println("Applying Bubble Sort on the given array..");
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
        long cpuTime = (endTime - startTime)/10^9;
        long space = startSpace.totalMemory();
        System.out.print("The sorted array: ");
        System.out.println(Arrays.toString(numbers));
        System.out.printf("CPU time: %d s.\n", cpuTime);
        System.out.printf("Total memory usage: %d KB.\n", space);
    }

    static void selectionSort(int[] numbers) {
        System.out.println("Applying Bubble Sort on the given array..");
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
        long cpuTime = (endTime - startTime)/10^9;
        long space = startSpace.totalMemory();
        System.out.print("The sorted array: ");
        System.out.println(Arrays.toString(numbers));
        System.out.printf("CPU time: %d s.\n", cpuTime);
        System.out.printf("Total memory usage: %d KB.\n", space);
    }

    static void insertionSort(int[] numbers) {
        System.out.println("Applying Bubble Sort on the given array..");
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
        long cpuTime = (endTime - startTime)/10^9;
        long space = startSpace.totalMemory();
        System.out.print("The sorted array: ");
        System.out.println(Arrays.toString(numbers));
        System.out.printf("CPU time: %d s.\n", cpuTime);
        System.out.printf("Total memory usage: %d KB.\n", space);
    }

    static void mergeSort(int[] numbers) {
        System.out.println("Applying Bubble Sort on the given array..");
        long startTime = System.nanoTime();
        Runtime startSpace = Runtime.getRuntime();

        split(numbers);

        long endTime = System.nanoTime();
        long cpuTime = (endTime - startTime)/10^9;
        long space = startSpace.totalMemory();
        System.out.print("The sorted array: ");
        System.out.println(Arrays.toString(numbers));
        System.out.printf("CPU time: %d s.\n", cpuTime);
        System.out.printf("Total memory usage: %d KB.\n", space);
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
        System.out.println("Applying Bubble Sort on the given array..");
        long startTime = System.nanoTime();
        Runtime startSpace = Runtime.getRuntime();

        unite(numbers, low, high);

        long endTime = System.nanoTime();
        long cpuTime = (endTime - startTime)/10^9;
        long space = startSpace.totalMemory();
        System.out.print("The sorted array: ");
        System.out.println(Arrays.toString(numbers));
        System.out.printf("CPU time: %d s.\n", cpuTime);
        System.out.printf("Total memory usage: %d KB.\n", space);
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