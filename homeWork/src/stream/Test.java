package stream;

import java.util.Arrays;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        List<Integer> listInteger = Arrays.asList(1, 2, 3, 2);
        List<String> listString = Arrays.asList("One", "Two", "Three", "Two" );
        System.out.println(CollectionUtils.filter(listInteger, (a) -> a == 2));
        System.out.println(CollectionUtils.anyMatch(listInteger, (a) -> a == 2));
        System.out.println(CollectionUtils.allMatch(listInteger, (a) -> a == 2));
        System.out.println(CollectionUtils.noneMatch(listInteger, (a) -> a == 5));
        System.out.println(CollectionUtils.map(listInteger, (a) -> a * 2));
        System.out.println(CollectionUtils.max(listInteger, Integer::compareTo));
        System.out.println(CollectionUtils.min(listInteger, Integer::compareTo));
        System.out.println(CollectionUtils.distinct(listInteger));
        CollectionUtils.forEach(listInteger, System.out::println);
        System.out.println(CollectionUtils.reduce(listInteger, Integer::sum));
        System.out.println(CollectionUtils.reduce(" " , listString, (s, s2) -> s + s2));
        System.out.println(CollectionUtils.partitionBy(listInteger, (a) -> a % 2 == 0));
        System.out.println(CollectionUtils.groupBy(listString, (s) -> s.substring(0)));
        System.out.println(CollectionUtils.toMap(listString, s -> s.substring(0), s -> s.length(), (count, s) -> count + s));
    }
}
