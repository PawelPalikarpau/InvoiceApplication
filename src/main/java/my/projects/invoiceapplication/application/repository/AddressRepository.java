package my.projects.invoiceapplication.application.repository;

import my.projects.invoiceapplication.application.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {
}
