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

@Table(name = "assurance_packages")
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AssurancePackage extends BaseEntity {

    @Column(name = "name")
    private String name;

    @Column(name = "detail")
    private String detail;

    @Column(name = "daily_price")
    private Double dailyPrice;

    @Column(name = "image_path")
    private String imagePath;

    @OneToMany(mappedBy = "assurancePackage")
    private List<Rental> rentals;

}
