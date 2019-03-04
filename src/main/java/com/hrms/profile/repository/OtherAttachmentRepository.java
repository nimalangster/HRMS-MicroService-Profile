package com.hrms.profile.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hrms.profile.entity.OtherAttachment;
import com.hrms.profile.entity.User;

public interface OtherAttachmentRepository extends JpaRepository<OtherAttachment, Integer>{

	public List<OtherAttachment> findByAttachmentName(String name);
	public List<OtherAttachment> findByUser(User user);
}
