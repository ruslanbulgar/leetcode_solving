package com.rbcode.leatcode.collections;

import java.util.Map;
import java.util.TreeMap;

public class TreeMapStudy {

    public static void main(String[] args) {

        Map<String, Integer> treeMap = new TreeMap<>();

        // Adding elements to the tree map
        treeMap.put("E", 0);
        treeMap.put("A", 1);
        treeMap.put("D", 4);
        treeMap.put("C", 3);
        treeMap.put("B", 2);

        for (String key : treeMap.keySet()) {
            System.out.println("Key: " + key + ", Value: " + treeMap.get(key));
        }

    }
}

