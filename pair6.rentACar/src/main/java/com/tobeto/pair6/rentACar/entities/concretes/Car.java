package com.tobeto.pair6.rentACar.entities.concretes;

import com.tobeto.pair6.rentACar.entities.abstracts.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Table(name = "cars")
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Car extends BaseEntity {

    @Column(name = "kilometer")
    private int kilometer;

    @Column(name = "plate")
    private String plate;

    @Column(name = "year")
    private int year;

    @Column(name = "daily_price")
    private double dailyPrice;

    @Enumerated(EnumType.STRING)
    @Column(name = "gear_type")
    private GearType gearType;

    @Enumerated(EnumType.STRING)
    @Column(name = "fuel_type")
    private FuelType fuelType;

    @Enumerated(EnumType.STRING)
    @Column(name = "vehicle_type")
    private VehicleType vehicleType;

    @ManyToOne
    @JoinColumn(name = "model_id")
    private Model model;

    @ManyToOne
    @JoinColumn(name = "color_id")
    private Color color;

    @ManyToOne
    @JoinColumn(name = "branch_id")
    private Branch branch;

    @OneToMany(mappedBy = "car")
    private List<Rental> rentals;

}
