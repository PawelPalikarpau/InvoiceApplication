package my.projects.invoiceapplication.application.service;

import my.projects.invoiceapplication.application.entity.Address;
import my.projects.invoiceapplication.application.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressService {

    private AddressRepository addressRepository;

    @Autowired
    public AddressService(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    public List<Address> findAll() { return addressRepository.findAll(); }

    public void remove(Address address) {
        addressRepository.delete(address);
    }

    public void save(Address address) {
        addressRepository.save(address);
    }
}
