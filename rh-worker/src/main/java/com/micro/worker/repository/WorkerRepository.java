package com.micro.worker.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.micro.worker.model.Worker;

public interface WorkerRepository extends JpaRepository<Worker, Long>{
	

}
