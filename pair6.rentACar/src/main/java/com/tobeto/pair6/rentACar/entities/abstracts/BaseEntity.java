package com.tobeto.pair6.rentACar.entities.abstracts;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@MappedSuperclass
@Data
@NoArgsConstructor
@AllArgsConstructor
public abstract class BaseEntity {

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "is_active")
    private boolean isActive;

    @Column(name = "created_date")
    private LocalDate createdDate;

    @Column(name = "updated_date")
    private LocalDate updatedDate;

    @Column(name = "deleted_date")
    private LocalDate deletedDate;

    @PrePersist
    public void beforeAdd(){
        isActive = true;
        createdDate = LocalDate.now();
    }

    @PreUpdate
    public void beforeUpdate(){
        updatedDate = LocalDate.now();
    }

    @PreRemove
    public void beforeRemove(){
        deletedDate = LocalDate.now();
    }

}
