package com.tobeto.pair6.rentACar.entities.concretes;

import com.tobeto.pair6.rentACar.entities.abstracts.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Table(name = "rentals")
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Rental extends BaseEntity {

    @Column(name = "start_date")
    private LocalDate startDate;

    @Column(name = "end_date")
    private LocalDate endDate;

    @Column(name = "return_date")
    private LocalDate returnDate;

    @Column(name = "start_kilometer")
    private Integer startKilometer;

    @Column(name = "end_kilometer")
    private Integer endKilometer;

    @Column(name = "total_price")
    private Double totalPrice;

    @Column(name = "discount_rate")
    private Double discountRate;

    @ManyToOne
    @JoinColumn(name = "car_id")
    private Car car;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "assurance_package_id")
    private AssurancePackage assurancePackage;

    @ManyToOne
    @JoinColumn(name = "additional_feature_id")
    private AdditionalFeature additionalFeature;

    @OneToMany(mappedBy = "rental")
    private List<Invoice> invoices;

}
