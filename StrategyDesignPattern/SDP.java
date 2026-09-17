import java.util.Arrays;
import java.util.List;

interface SortingStrategy {
    void sort(List<Integer> numbers);
}

class BubbleSortSterategy implements SortingStrategy {
    @Override 
    public void sort(List<Integer> numbers) {
        // Bubble sort logic
    }
}

class QuickSortStrategy implements SortingStrategy {
    @Override 
    public void sort(List<Integer> number) {
        // Quick sort logic
    }
}

class Sorter {
    private SortingStrategy strategy;
    public Sorter(SortingStrategy strategy) {
        this.strategy=strategy;
    }
    public void setStrategy(SortingStrategy strategy) {
        this.strategy = strategy;
    }
    public void sortNumbers(List<Integer> numbers) {
        strategy.sort(numbers);
    }
}
public class SDP {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(5,3,2,8,1);
        Sorter sorter = new Sorter(new BubbleSortSterategy());
        sorter.sortNumbers(numbers);
        sorter.setStrategy(new QuickSortStrategy());
        sorter.sortNumbers(numbers);
    }
}
