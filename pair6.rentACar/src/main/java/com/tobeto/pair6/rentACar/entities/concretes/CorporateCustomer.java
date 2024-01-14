package com.tobeto.pair6.rentACar.entities.concretes;

import com.tobeto.pair6.rentACar.entities.abstracts.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "corporate_customers")
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CorporateCustomer extends BaseEntity {

    @Column(name = "company_name")
    private String companyName;

    @Column(name = "contact_name")
    private String contactName;

    @Column(name = "contact_title")
    private String contactTitle;

    @Column(name = "tax_number")
    private String taxNumber;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

}
