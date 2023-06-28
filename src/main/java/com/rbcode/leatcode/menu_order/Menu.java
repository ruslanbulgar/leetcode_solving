package com.rbcode.leatcode.menu_order;

import com.rbcode.leatcode.menu_order.model.Item;

public interface Menu {

    Menu bill();

    Menu pay();
    Menu selectItem(Integer id);

    Menu selectItems(Integer id, Integer count);

    void showSelected();
    Iterable<Item> showMenu();

}
