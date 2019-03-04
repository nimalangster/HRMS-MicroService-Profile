package com.hrms.profile.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hrms.profile.entity.AcademicQualification;
import com.hrms.profile.entity.ExamType;

public interface ExamTypeRepository extends JpaRepository<ExamType, Integer>{

	public List<ExamType> findByExamTypeName(String name);
	public List<ExamType> findByAcademicQualification(AcademicQualification academicQualification);

}
