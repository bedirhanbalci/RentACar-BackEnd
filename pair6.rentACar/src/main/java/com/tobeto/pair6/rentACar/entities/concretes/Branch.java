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

@Table(name = "branchs")
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Branch extends BaseEntity {

    @Column(name = "city_name")
    private String cityName;

    @Column(name = "address")
    private String address;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "location")
    private String location;

    @OneToMany(mappedBy = "branch")
    private List<Car> cars;

    @OneToMany(mappedBy = "branch")
    private List<Rental> rentals;

}
