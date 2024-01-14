package com.tobeto.pair6.rentACar.entities.concretes;

import com.tobeto.pair6.rentACar.entities.abstracts.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Table(name = "additional_services")
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AdditionalService extends BaseEntity {

    @Column(name = "name")
    private String name;

    @Column(name = "detail")
    private String detail;

    @Column(name = "daily_price")
    private double dailyPrice;

    @Column(name = "quantity")
    private int quantity;

    @OneToMany(mappedBy = "additionalService")
    private List<Rental> rentals;

}
