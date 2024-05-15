package com.example.example.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ClientController {
    @GetMapping("/customers")
    public String getHome(){
        return "customers";
    }
    @GetMapping("/customers/{id}")
    public String getCustomerById(@PathVariable int id, Model model) {
        Customer customer = clientService.getCustomerById(id);
        model.addAttribute("customer", customer);
        return "customerDetail";
    }

    @GetMapping("/customers/search")
    public String searchCustomers(@RequestParam(name = "name", required = false) String name, Model model) {
        List<Customer> customers = clientService.searchCustomersByName(name);
        model.addAttribute("customers", customers);
        return "customerList";
    }

    @PostMapping("/customers/add")
    public String addCustomer(@ModelAttribute Customer customer, Model model) {
        clientService.addCustomer(customer);
        model.addAttribute("message", "Customer added successfully");
        return "customers";
    }

    @PutMapping("/customers/update/{id}")
    public String updateCustomer(@PathVariable int id, @ModelAttribute Customer customer, Model model) {
        clientService.updateCustomer(id, customer);
        model.addAttribute("message", "Customer updated successfully");
        return "customers";
    }

    @DeleteMapping("/customers/delete/{id}")
    public String deleteCustomer(@PathVariable int id, Model model) {
        clientService.deleteCustomer(id);
        model.addAttribute("message", "Customer deleted successfully");
        return "customers";
    }
}

