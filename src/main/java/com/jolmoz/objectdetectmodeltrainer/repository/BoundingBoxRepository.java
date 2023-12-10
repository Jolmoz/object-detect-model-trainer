package com.jolmoz.objectdetectmodeltrainer.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jolmoz.objectdetectmodeltrainer.model.BoundingBox;

public interface BoundingBoxRepository extends JpaRepository<BoundingBox, Long> {

}
