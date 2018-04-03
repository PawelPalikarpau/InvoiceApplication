package my.projects.invoiceapplication.application.repository;

import my.projects.invoiceapplication.application.entity.Address;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AddressRepository extends CrudRepository<Address, String> {
    List<Address> findAll();
}
