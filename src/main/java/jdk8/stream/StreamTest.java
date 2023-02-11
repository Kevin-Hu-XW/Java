package jdk8.stream;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

/**
 * @author Kevin
 * @date 2023/2/7 22:06
 */
public class StreamTest {

    public static void main(String[] args) {
        //通过 java.util.Collection.stream() 方法用集合创建流
        List<String> stringList = Arrays.asList("a","b","c");
        //创建一个顺序流,由主线程对流进行操作
        Stream<String> stream = stringList.stream();
        //创建一个并行流，内部以多线程的方式对流进行操作，前提是对流中的数据没有处理要求
        Stream<String> parallelStream = stringList.parallelStream();

        List<Integer> list = Arrays.asList(7, 6, 9, 3, 8, 2, 1);
        //遍历选出大于6的元素
        //::的作用是搭配stream简化代码
        //就是把对象的方法当做参数传到stream内部，使stream的每个元素都传入到该方法当作方法的参数执行一下
        list.stream().filter(x-> x>6).forEach(System.out::println);

        //匹配第一个
        Optional<Integer> first = list.stream().filter(x -> x > 6).findFirst();
        //匹配任意值（适用于并行流）
        Optional<Integer> any = list.parallelStream().filter(x -> x > 6).findAny();
        // 是否包含符合特定条件的元素
        boolean anyMatch = list.stream().anyMatch(x-> x>6);
        System.out.println("匹配第一个值：" + first.get());
        System.out.println("匹配任意一个值：" + any.get());
        System.out.println("是否存在大于6的值：" + anyMatch);



    }

}
