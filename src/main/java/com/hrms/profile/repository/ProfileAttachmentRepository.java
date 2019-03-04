package com.hrms.profile.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hrms.profile.entity.ProfileAttachments;

public interface ProfileAttachmentRepository extends JpaRepository<ProfileAttachments, Integer>{

}
