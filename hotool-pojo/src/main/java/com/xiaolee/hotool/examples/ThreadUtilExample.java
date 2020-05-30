package com.xiaolee.hotool.examples;

import com.xiaolee.hotool.thread.ThreadPoolBuilder;

import java.util.concurrent.ExecutorService;

public class ThreadUtilExample {
    public static void main(String[] args) {
        ExecutorService executor = ThreadPoolBuilder.builder()
                .corePoolSize(10)
                .build();

    }
}
