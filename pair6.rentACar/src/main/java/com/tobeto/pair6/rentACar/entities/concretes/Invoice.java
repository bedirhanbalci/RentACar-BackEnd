package com.tobeto.pair6.rentACar.entities.concretes;

import com.tobeto.pair6.rentACar.entities.abstracts.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Table(name = "invoices")
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Invoice extends BaseEntity {

    @Column(name = "invoice_no")
    private String invoiceNo;

    @Column(name = "tax_rate")
    private double taxRate;

    @ManyToOne
    @JoinColumn(name = "rental_id")
    private Rental rental;

}
