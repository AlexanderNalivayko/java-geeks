package com.hillel.elementary.javageeks.dir.pizza_service.web.servlets;

import com.hillel.elementary.javageeks.dir.pizza_service.context.Context;
import com.hillel.elementary.javageeks.dir.pizza_service.context.SimpleImplementationContext;
import com.hillel.elementary.javageeks.dir.pizza_service.domain.Customer;
import com.hillel.elementary.javageeks.dir.pizza_service.services.customer.CustomerService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class CustomersLogin extends HttpServlet {
    private final Context context = SimpleImplementationContext.getInstance();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        String customerName = req.getParameter("customerName");

        CustomerService customerService = context.getBean("customerService");
        Customer customer = customerService.getByName(customerName);
        if (customer == null) {
            String errorMessage = "A customer with such name doesn't exist";
            req.setAttribute("customerName", customerName);
            req.setAttribute("errorMessage", errorMessage);
            doGet(req, resp);
        } else {
            HttpSession session = req.getSession();
            session.setAttribute("customer", customer);
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("/orders_list");
            requestDispatcher.forward(req, resp);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("pages/CustomersLogin.jsp");
        requestDispatcher.forward(req, resp);
    }
}
