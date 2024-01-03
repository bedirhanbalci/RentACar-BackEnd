package com.tobeto.pair6.rentACar.entities;

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
public class Invoice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "create_date")
    private LocalDate createDate;

    @ManyToOne
    @JoinColumn(name = "rental_id")
    private Rental rental;

}
