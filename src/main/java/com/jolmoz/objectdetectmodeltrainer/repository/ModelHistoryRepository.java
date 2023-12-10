package com.jolmoz.objectdetectmodeltrainer.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jolmoz.objectdetectmodeltrainer.model.ModelHistory;

public interface ModelHistoryRepository extends JpaRepository<ModelHistory, Long> {

}
