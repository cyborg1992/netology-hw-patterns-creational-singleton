package ru.netology;

import java.util.ArrayList;
import java.util.List;

public class Filter {
    private final int threshold;

    public Filter(int threshold) {
        this.threshold = threshold;
    }

    public List<Integer> filterOut(List<Integer> source) {
        Logger logger = Logger.getInstance();
        List<Integer> result = new ArrayList<>();
        source.forEach(element -> {
            if (element < threshold) {
                logger.log("Элемент \"" + element + "\" не проходит");
            } else {
                result.add(element);
                logger.log("Элемент \"" + element + "\" проходит");
            }
        });
        return result;
    }
}
