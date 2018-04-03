package my.projects.invoiceapplication.application.service;

import my.projects.invoiceapplication.application.entity.Customer;
import my.projects.invoiceapplication.application.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    private CustomerRepository customerRepository;

    @Autowired
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    public void remove(Customer customer) {
        customerRepository.delete(customer);
    }

    public void save(Customer customer) {
        customerRepository.save(customer);
    }
}
