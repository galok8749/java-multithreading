package com.alok.concurrenthashmap;

import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

public class Main {
    public static void main(String[] args) {
        ConcurrentHashMap<Character, Integer> map = new ConcurrentHashMap<>();
        String str = "hi how are you";

        for(Character character : str.toCharArray()) {
            map.compute(character, (((character1, integer1) -> {
                if (integer1 == null) {
                    return 1;
                }
                return integer1 + 1;
            })));
        }
    }
}
