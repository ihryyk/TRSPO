import java.util.List;

public class Main {
    public static void main(String[] args) {
        String fileName = "D:\\Java\\LW-1\\src\\main\\java\\test_data.txt";
        FileProcessor fileProcessor = new FileProcessor(fileName);
        List<Integer> elements = fileProcessor.readFromFile();

        SequentialSearchAlgorithm sequentialSearchAlgorithm = new SequentialSearchAlgorithm(elements);
        long startTimeSequential = System.currentTimeMillis();
        System.out.println("Sequential result -> " + sequentialSearchAlgorithm.searchElementByValue(742068619));
        long durationSequential = System.currentTimeMillis() - startTimeSequential;
        System.out.println("Sequential duration -> " + durationSequential + " ms.");

        ParallelSearchAlgorithm parallelSearchAlgorithm = new ParallelSearchAlgorithm(elements);
        long startTimeParallel = System.currentTimeMillis();
        System.out.println("Parallel result -> " + parallelSearchAlgorithm.searchElementByValue(742068619));
        long durationParallel = System.currentTimeMillis() - startTimeParallel;
        System.out.println("Parallel duration -> " + durationParallel + " ms.");
    }
}
