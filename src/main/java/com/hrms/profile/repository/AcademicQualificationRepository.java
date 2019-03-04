package com.hrms.profile.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hrms.profile.entity.AcademicQualification;
import com.hrms.profile.entity.User;

public interface AcademicQualificationRepository extends JpaRepository<AcademicQualification, Integer> {

	List<AcademicQualification> findByUser(User user);
}
