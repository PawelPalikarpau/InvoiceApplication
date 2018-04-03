package my.projects.invoiceapplication.application.repository;

import my.projects.invoiceapplication.application.entity.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, String> {
    List<Customer> findAll();
}
