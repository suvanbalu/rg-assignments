package net.suvan.customerspringbatch.repository;

import net.suvan.customerspringbatch.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer,Integer> {
}
