package net.suvan.customerspringbatch.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@Table(name="CUSTOMERS_INFO")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Customer {
    @Id
    @Column(name = "CUSTOMER_ID")
    private int id;
    @Column(name = "FIRST_NAME")
    private String firstName;
    @Column(name = "LAST_NAME")
    private String lastName;
    @Column(name = "EMAIL")
    private String email;
    @Column(name = "GENDER")
    private String gender;
    @Column(name="CONTACT")
    private String contactNo;
    @Column(name="COUNTRY")
    private String country;
    @Column(name="DOB")
    private String dob;

}
