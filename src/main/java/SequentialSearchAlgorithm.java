import java.util.List;

public class SequentialSearchAlgorithm {
    private List<Integer> elements;

    public SequentialSearchAlgorithm(List<Integer> elements) {
        this.elements = elements;
    }

    public int searchElementByValue(int key) {
        for (int i = 0; i < elements.size(); i++) {
            if (elements.get(i) == key) {
                return i;
            }
        }

        return -1;
    }
}
