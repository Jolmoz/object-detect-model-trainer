package com.jolmoz.objectdetectmodeltrainer.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jolmoz.objectdetectmodeltrainer.model.DataSet;

public interface DataSetRepository extends JpaRepository<DataSet, Long> {

}
