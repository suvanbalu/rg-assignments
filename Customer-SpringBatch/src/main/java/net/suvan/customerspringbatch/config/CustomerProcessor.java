package net.suvan.customerspringbatch.config;

import net.suvan.customerspringbatch.entity.Customer;
import org.springframework.batch.item.ItemProcessor;

public class CustomerProcessor implements ItemProcessor<Customer,Customer> {
    @Override
    public Customer process(Customer customer) throws Exception{
        if(customer.getCountry().equals("United States") || customer.getCountry().equals("China")){
            return customer;
        }
        else{
            return null;
        }
    }
}
