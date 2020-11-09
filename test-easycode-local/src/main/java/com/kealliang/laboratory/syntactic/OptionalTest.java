package com.kealliang.laboratory.syntactic;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;

/**
 * @author lsr
 * @ClassName Optional
 * @Date 2020-11-05
 * @Vertion 1.0
 */
public class OptionalTest {

    /*
     * PECS 运用
     * @author lsr
     * @description get
     * @Date 2020/11/6
     */
    public <T, U, X extends Throwable> Map<T, U> get(List<? extends T> producer, Function<? super T, ? extends U> func) throws X {
        Map<T, U> result = new HashMap<>(producer.size());
        for (T t : producer) {
            if (t == null) {
                throw new NullPointerException("不允许为空");
            }
            result.put(t, func.apply(t));
        }
        return result;
    }

    public static void main(String[] args) {
//        baseUse();

        presentMethod();
    }

    private static void presentMethod() {
        Person p = null;
        Optional<Person> op = Optional.ofNullable(p);
        System.out.println("ifPresent(Consumer<? super T> consumer) 方法不会抛异常");
        op.ifPresent(o -> System.out.println(o.getName()));
        System.out.println("==============================");

        if (op.isPresent()) {
            System.out.println(op.get());
        } else {
            System.out.println("get方法会抛 NoSuchElementException 异常");
            System.out.println(op.get());
        }
    }

    private static void baseUse() {
        Person p = null;
        Person person = Optional.ofNullable(p).orElse(new Person("张三", 18));
        System.out.println(person);
    }

    @Data
    @ToString
    @NoArgsConstructor
    @AllArgsConstructor
    static class Person {
        private String name;
        private Integer age;
    }
}
