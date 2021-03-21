import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ParallelSearchAlgorithm {
    private List<Integer> elements;

    public ParallelSearchAlgorithm(List<Integer> elements) {
        this.elements = elements;
    }

    public int searchElementByValue(int key) {
        int threadCount = Runtime.getRuntime().availableProcessors();
        ExecutorService executorService = Executors.newFixedThreadPool(threadCount);
        List<Future<Integer>> futureList = new ArrayList<>();
        int block = elements.size() / threadCount;
        int start = 0;
        int finish = block - 1;
        for (int i = 0; i < threadCount; i++) {
            if (finish >= elements.size()) {
                finish = elements.size() - 1;
            }
            futureList.add(executorService.submit(new SearchTask(elements, start, finish, key)));
            start = finish + 1;
            finish = start + block - 1;
        }

        for (Future<Integer> currentFuture : futureList) {
            int currentResult;
            try {
                currentResult = currentFuture.get();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
            if (currentResult != -1) {
                return currentResult;
            }
        }

        return -1;
    }

    private class SearchTask implements Callable<Integer> {
        private List<Integer> elements;
        private int start;
        private int finish;
        private int key;

        public SearchTask(List<Integer> elements, int start, int finish, int key) {
            this.elements = elements;
            this.start = start;
            this.finish = finish;
            this.key = key;
        }

        @Override
        public Integer call() throws Exception {
            for (int i = start; i <= finish; i++) {
                if (elements.get(i) == key) {
                    return i;
                }
            }

            return -1;
        }
    }
}
