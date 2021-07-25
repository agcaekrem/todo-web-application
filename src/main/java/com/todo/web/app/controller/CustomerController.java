package com.todo.web.app.controller;


import com.todo.web.app.model.Customer;
import com.todo.web.app.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by ekrem on 25.07.2021.
 */


@Controller
public class CustomerController {

    @Autowired
    private CustomerService customerService;


    //customer listesini display ederiz
    @GetMapping("/")
    public String viewHomePage(Model model) {
        return findPaginated(1, "firstName", "asc", model);
    }

    @GetMapping("/showNewCustomerForm")
    public String showNewCustomerForm(Model model) {
        //form verilerini bağlamak için model attr. oluştururuz
        Customer customer = new Customer();
        model.addAttribute("customer", customer);
        return "new_customer";
    }

    @PostMapping("/saveCustomer")
    public String saveCustomer(@ModelAttribute("customer") Customer customer) {
        //customer'ı veri tabanına kaydederiz
        customerService.saveCustomer(customer);
        return "redirect:/";
    }

    @GetMapping("/showFormForUpdate/{id}")
    public String showFormForUpdate(@PathVariable(value = "id") long id, Model model) {
        //service'ten customer'ı get ederiz
        Customer customer = customerService.getCustomerById(id);
        //pre-populate yapabilmek için model attr. set ederiz
        model.addAttribute("customer", customer);
        return "update_customer";
    }

    @GetMapping("/deleteCustomer/{id}")
    public String deleteCustomer(@PathVariable(value = "id") long id) {

        //customer silme metodunu çağırıyoruz

        this.customerService.deleteCustomerById(id);
        return "redirect:/";

    }

    @GetMapping("/page/{pageNo}")
    public String findPaginated(@PathVariable(value = "pageNo") int pageNo,
                                @RequestParam("sortField") String sortField,
                                @RequestParam("sortField") String sortDir,

                                Model model) {

        int pageSize = 5;


        Page<Customer> page = customerService.findPaginated(pageNo, pageSize, sortField, sortDir);
        List<Customer> ListCustomers = page.getContent();

        model.addAttribute("currentPage", pageNo);
        model.addAttribute("totalPages", page.getTotalPages());
        model.addAttribute("totalitems", page.getTotalElements());

        model.addAttribute("sortField", sortField);
        model.addAttribute("sortDir", sortDir);
        model.addAttribute("reverseSortDir", sortDir.equals("asc") ? "desc" : "asc");

        model.addAttribute("listCustomers", ListCustomers);
        return "index";
    }

}
