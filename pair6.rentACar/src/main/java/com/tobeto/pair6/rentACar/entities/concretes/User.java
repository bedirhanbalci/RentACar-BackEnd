package com.tobeto.pair6.rentACar.entities.concretes;

import com.tobeto.pair6.rentACar.entities.abstracts.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Table(name = "users")
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User extends BaseEntity {

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "address")
    private String address;

    @Column(name = "image_url")
    private String imageUrl;

    @Column(name = "credit_note")
    private String creditNote;

    @OneToMany(mappedBy = "user")
    private List<Rental> rentals;

    @OneToMany(mappedBy = "user")
    private List<IndividualCustomer> individualCustomers;

    @OneToMany(mappedBy = "user")
    private List<CorporateCustomer> corporateCustomers;

}
