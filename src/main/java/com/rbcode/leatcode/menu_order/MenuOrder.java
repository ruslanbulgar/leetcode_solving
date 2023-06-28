//package com.rbcode.leatcode.menu_order;
//
//import com.rbcode.leatcode.menu_order.model.Client;
//import com.rbcode.leatcode.menu_order.model.Item;
//import com.rbcode.leatcode.menu_order.model.Order;
//import com.rbcode.leatcode.menu_order.model.OrderStatus;
//import com.rbcode.leatcode.menu_order.repository.ClientRepository;
//import com.rbcode.leatcode.menu_order.repository.ItemRepository;
//import com.rbcode.leatcode.menu_order.repository.OrderRepository;
//import lombok.RequiredArgsConstructor;
//import org.springframework.stereotype.Service;
//
//@Service
//@RequiredArgsConstructor
//public class MenuOrderService implements Menu {
//
//    private final ItemRepository itemRepository;
//    private final ClientRepository clientRepository;
//    private final OrderRepository orderRepository;
//
//    @Override
//    public Menu bill() {
//
//        return this;
//    }
//
//    @Override
//    public Menu pay() {
//        return null;
//    }
//
//    @Override
//    public Menu selectItem(Integer id) {
//        Item item = menuItems.get(id);
//        System.out.println("Add to order : " + item.toString());
//        selectedItems.add(item);
//        return this;
//    }
//
//    @Override
//    public Menu selectItems(Integer id, Integer count) {
//
//        for (int i = 0; i < count; i++) {
//            selectItem(id);
//        }
//        return this;
//    }
//
//    @Override
//    public Iterable<Item> getMenuItems() {
//        return itemRepository.findAll();
//    }
//
//    @Override
//    public Order getOrder(final Integer orderId) {
//
//        return orderRepository.findById(orderId);
//    }
//}
