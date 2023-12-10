package com.jolmoz.objectdetectmodeltrainer.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jolmoz.objectdetectmodeltrainer.model.Region;

public interface RegionRepository extends JpaRepository<Region, Long> {

}
