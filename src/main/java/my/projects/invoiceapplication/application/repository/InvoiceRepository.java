package my.projects.invoiceapplication.application.repository;

import my.projects.invoiceapplication.application.entity.Invoice;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InvoiceRepository extends CrudRepository<Invoice, String> {
    List<Invoice> findAll();
}
