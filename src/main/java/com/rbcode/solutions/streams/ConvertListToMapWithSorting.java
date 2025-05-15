package com.rbcode.solutions.streams;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ConvertListToMapWithSorting {
    record Employee(int id, String name, int salary) { }

    public static void main(String[] args) {
        final List<Employee> employees = Arrays.asList(
                new Employee(1, "Jim", 1000),
                new Employee(2, "Jack", 1200),
                new Employee(3, "Bob", 900),
                new Employee(4, "Fill", 1100)
        );

        Map<Integer, String> employeeMap = employees.stream()
                .sorted((e1, e2) -> Integer.compare(e2.salary(), e1.salary())) // Sort by salary descending
                .collect(Collectors.toMap(e -> e.id,
                        Employee::name, // Collect value (Employee object)
                        (oldValue, newValue) -> oldValue, // Merge function (not needed here)
                        LinkedHashMap::new // Ensure insertion order is preserved
                ));

        System.out.println(employeeMap);
    }
}
