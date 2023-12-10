package com.jolmoz.objectdetectmodeltrainer.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jolmoz.objectdetectmodeltrainer.model.TrainingResult;

public interface TrainingResultRepository extends JpaRepository<TrainingResult, Long> {

}
