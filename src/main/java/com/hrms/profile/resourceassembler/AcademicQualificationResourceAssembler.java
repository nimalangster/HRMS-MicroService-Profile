package com.hrms.profile.resourceassembler;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import org.springframework.hateoas.Resource;
import org.springframework.hateoas.ResourceAssembler;

import com.hrms.profile.controller.AcademicQualificationController;
import com.hrms.profile.entity.AcademicQualification;

public class AcademicQualificationResourceAssembler implements ResourceAssembler<AcademicQualification, Resource<AcademicQualification>> {
@Override
	public Resource<AcademicQualification> toResource(AcademicQualification academicQualification) {

		return new Resource<>(academicQualification,
			linkTo(methodOn(AcademicQualificationController.class).getAcademicQualificationById(academicQualification.getId())).withSelfRel(),
			linkTo(methodOn(AcademicQualificationController.class).getAllAcademicQualifications()).withRel("AcademicQualifications"));
	}
}
