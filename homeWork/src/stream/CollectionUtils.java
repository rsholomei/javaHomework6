package stream;

import java.util.*;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class CollectionUtils {

    private CollectionUtils() {}

    public static <E> List<E> filter(List<E> elements, Predicate<E> filter) {
        List<E> list = new ArrayList<>();
        for (E element : elements)
        {
            if (filter.test(element))
            {
                list.add(element);
            }
        }
        return list;
    }


    public static <E> boolean anyMatch(List<E> elements, Predicate<E> predicate) {
        for (E element : elements)
        {
            if (predicate.test(element))
            {
                return true;
            }
        }
        return false;
    }


    public static <E> boolean allMatch(List<E> elements, Predicate<E> predicate) {
        for (E element : elements)
        {
            if (!predicate.test(element))
            {
                return false;
            }
        }
        return true;
    }


    public static <E> boolean noneMatch(List<E> elements, Predicate<E> predicate) {
        for (E element : elements)
        {
            if (predicate.test(element))
            {
                return false;
            }
        }
        return true;
    }


    public static <T, R> List<R> map(List<T> elements, Function<T, R> mappingFunction) {
        List<R> list = new ArrayList<>();
        for (T element : elements)
        {
            list.add(mappingFunction.apply(element));
        }
        return list;
    }


    public static <E> Optional<E> max(List<E> elements, Comparator<E> comparator) {
        if(elements.size() != 0) {
            E element = elements.get(0);
            for (int i = 1; i < elements.size(); i++) {
                element = comparator.compare(element, elements.get(i)) > 0 ? element : elements.get(i);
                }
            return Optional.of(element);
            }
        else return Optional.empty();
    }


    public static <E> Optional<E> min(List<E> elements, Comparator<E> comparator) {
        if(elements.size() != 0) {
            E element = elements.get(0);
            for (int i = 1; i < elements.size(); i++) {
                element = comparator.compare(element, elements.get(i)) < 0 ? element : elements.get(i);
            }
            return Optional.of(element);
        }
        else return Optional.empty();
    }


    public static <E> Set<E> distinct(List<E> elements) {
        Set<E> set = new HashSet<>();
        for (E element : elements)
        {
            set.add(element);
        }
        return set;
    }


    public static <E> void forEach(List<E> elements, Consumer<E> consumer) {
        for (E element : elements)
        {
            consumer.accept(element);
        }
    }


    public static <E> Optional<E> reduce(List<E> elements, BinaryOperator<E> accumulator) {
        if (elements.size() != 0)
        {
            E element = elements.get(0);
            for (int i = 1; i < elements.size(); i++)
            {
                element = accumulator.apply(element, elements.get(i));
            }
            return Optional.of(element);
        }
        else return Optional.empty();
    }


    public static <E> E reduce(E seed, List<E> elements, BinaryOperator<E> accumulator) {
        E result = seed;
        for (E element : elements)
        {
            result = accumulator.apply(result, element);
        }
        return result;
    }


    public static <E> Map<Boolean, List<E>> partitionBy(List<E> elements, Predicate<E> predicate) {
        Map<Boolean, List<E>> map = new HashMap<>();
        List<E> trueList = new ArrayList<>();
        List<E> falseList = new ArrayList<>();
        for (E element : elements)
        {
            if (predicate.test(element))
            {
                trueList.add(element);
            }
            else falseList.add(element);
        }
        map.put(true, trueList);
        map.put(false, falseList);
        return map;
    }


    public static <T, K> Map<K, List<T>> groupBy(List<T> elements, Function<T, K> classifier) {
        Map<K,List<T>> map = new HashMap<>();
        for(T element:elements) {
            K key = classifier.apply(element);
            if (map.containsKey(key)){
                map.get(key).add(element);
            }else {
                ArrayList<T> list = new ArrayList<>();
                list.add(element);
                map.put(key, list);
            }
        }
        return map;
    }


    public static <T, K, U> Map<K, U> toMap(List<T> elements,
                                            Function<T, K> keyFunction,
                                            Function<T, U> valueFunction,
                                            BinaryOperator<U> mergeFunction) {
        Map<K,U> map = new HashMap<>();
        K key;
        U value;
        for(T element:elements){
            key=keyFunction.apply(element);
            value=valueFunction.apply(element);
            if(map.containsKey(key)) {
                map.put(key, mergeFunction.apply(map.get(key), value));
            }else{
                map.put(key,value);
            }
        }
        return map;
    }
}

