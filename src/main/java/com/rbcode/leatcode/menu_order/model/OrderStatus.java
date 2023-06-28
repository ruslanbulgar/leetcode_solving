package com.rbcode.leatcode.menu_order.model;

public enum OrderStatus {
    //This status is used default when client starts to add items
    PENDING,
    //This status will be used after the order was places, items still could be added
    ACTIVE,
    //In this status the bill is generated, and waiting to be pay.
    CLOSED,
    COMPLETED,
    CANCELED
}
