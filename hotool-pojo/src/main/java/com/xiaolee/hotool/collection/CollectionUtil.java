package com.xiaolee.hotool.collection;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;

public class CollectionUtil {

    /**
     * 列表分组处理
     *
     * @param source 源数组
     * @param classify 分组标识, 必须重写 equals 和 hashcode
     * @param consumer 分组处理方法
     * @param <T>
     * @param <R>
     */
    public static <T, R> void mapProcess(List<T> source, Function<T, R> classify, Consumer<List<T>> consumer) {
        if (source == null || source.size() == 0) {
            return;
        }

        if (classify == null || consumer == null) {
            return;
        }

        Map<R, List<T>> groupMap = new HashMap<>();

        source.forEach(item -> {
            R classifier = classify.apply(item);
            if (groupMap.get(classifier) != null) {
                groupMap.get(classifier).add(item);
            } else {
                groupMap.put(classifier, Arrays.asList(item));
            }
        });

        for (R group: groupMap.keySet()) {
            consumer.accept(groupMap.get(group));
        }
    }
}
