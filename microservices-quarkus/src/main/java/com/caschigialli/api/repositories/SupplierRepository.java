package com.caschigialli.api.repositories;

import com.caschigialli.api.models.Supplier;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface SupplierRepository extends CrudRepository<Supplier, Long> {
    List<Supplier> findByUserName(String userName);
}
