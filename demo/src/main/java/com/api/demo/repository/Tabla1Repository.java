package com.api.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.api.demo.entity.Tabla1;

@Repository("repositorytabla1")
public interface Tabla1Repository extends JpaRepository<Tabla1, Integer> {

	public List<Tabla1> findById(Long id);

}
