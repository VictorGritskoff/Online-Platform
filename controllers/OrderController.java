package com.example.example.controllers;

import org.springframework.stereotype.Controller;

@Controller
public class OrderController {
      @Autowired
    private OrderService orderService;

    @GetMapping("/orders")
    public String getOrdersHome() {
        return "orders";
    }

    @PostMapping("/orders/add")
    public String addOrder(@ModelAttribute Order order, Model model) {
        orderService.addOrder(order);
        model.addAttribute("message", "Order added successfully");
        return "orders";
    }

    @PutMapping("/orders/update/{id}")
    public String updateOrder(@PathVariable int id, @ModelAttribute Order order, Model model) {
        orderService.updateOrder(id, order);
        model.addAttribute("message", "Order updated successfully");
        return "orders";
    }

    @DeleteMapping("/orders/delete/{id}")
    public String deleteOrder(@PathVariable int id, Model model) {
        orderService.deleteOrder(id);
        model.addAttribute("message", "Order deleted successfully");
        return "orders";
    }

    @GetMapping("/orders/purchase/{id}")
    public String purchaseOrder(@PathVariable int id, Model model) {
        orderService.purchaseOrder(id);
        model.addAttribute("message", "Order purchased successfully");
        return "orders";
    }

    @GetMapping("/orders/search")
    public String searchClientsByOrder(@RequestParam(name = "orderId", required = false) int orderId, Model model) {
        List<Client> clients = orderService.searchClientsByOrder(orderId);
        model.addAttribute("clients", clients);
        return "clientList";
    }

}
