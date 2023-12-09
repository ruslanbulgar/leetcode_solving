package com.rbcode.leatcode.tablesaw;

import tech.tablesaw.api.DoubleColumn;
import tech.tablesaw.api.Table;

public class MainClass {
    public static void main(String[] args) {
        DoubleColumn doubleColumn = DoubleColumn.create("nr", new double[]{1,2,3,4});
        System.out.println(doubleColumn.print());
        doubleColumn.setName("Number");
        Table t = Table.create(doubleColumn);
        System.out.println(t.print());
    }
}
