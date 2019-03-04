package com.hrms.profile.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

import javax.print.attribute.standard.MediaSize.Other;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.hrms.profile.entity.OtherAttachment;
import com.hrms.profile.entity.User;
import com.hrms.profile.service.OtherAttachmentService;

@RestController
@RequestMapping(value = "/otherattachment")
public class OtherAttachmentController {

	@Autowired
	OtherAttachmentService attachmentService;
	@Autowired
	OtherAttachment otherAttachment;
	@Autowired
	User user;

	@RequestMapping(value = "", method = RequestMethod.POST)
	public ResponseEntity<Object> addOtherAttachments(@RequestParam("file") MultipartFile[] files, @RequestParam Integer id,
			@RequestParam String name, @RequestParam Integer userId) throws IOException, URISyntaxException {

		if (files != null && files.length > 0) {
			
			for (MultipartFile file : files) {
				File fileUploaded = new File(
						"C:\\Users\\ex1\\Documents\\SpringBoot\\HRMS-MicroService-Profile\\UploadedFiles\\"
								+ file.getOriginalFilename());
				fileUploaded.createNewFile();
				FileOutputStream fout = new FileOutputStream(fileUploaded);
				fout.write(file.getBytes());
				fout.close();
			}
			
			int localId = id;
			for (MultipartFile file : files) {
				user.setId(userId);
				otherAttachment.setId(localId);
				otherAttachment.setAttachmentName(file.getOriginalFilename());
				otherAttachment.setAttachment(file.getBytes());
				otherAttachment.setUser(user);
				attachmentService.addOtherAttachment(otherAttachment);
				localId ++;
			}
		}
		return new ResponseEntity<Object>("The otherattachment files are successfully added.", HttpStatus.CREATED);

	}

	@RequestMapping(value = "/download", method = RequestMethod.GET)
	public ResponseEntity<Object> downloadFile() throws FileNotFoundException {

		File fieToDownload = new File("C:\\Users\\ex1\\Desktop\\git procedures.txt");
		InputStreamResource inputFile = new InputStreamResource(new FileInputStream(fieToDownload));

		ResponseEntity<Object> responseEntity = ResponseEntity.ok()
				.contentType(MediaType.parseMediaType("application/txt")).body(inputFile);
		return responseEntity;
		// return new ResponseEntity<Object>(inputFile, HttpStatus.OK);
	}

	@RequestMapping(value = "", method = RequestMethod.GET)
	public ResponseEntity<List<OtherAttachment>> getAllOtherAttachments() {

		return attachmentService.getAllOtherAttachments();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<OtherAttachment> getAttachmentById(@PathVariable("id") Integer id) {

		return attachmentService.getOtherAttachmentById(id);
	}
	

	@RequestMapping(value = "", method = RequestMethod.PUT)
	public ResponseEntity<OtherAttachment> editOtherAttachment(@RequestBody OtherAttachment otherAttachment,
			@PathVariable("id") Integer id) throws URISyntaxException {

		return attachmentService.editOtherAttachment(otherAttachment, id);
	}

	@RequestMapping(value = "", method = RequestMethod.DELETE)
	public ResponseEntity<HttpStatus> deleteOtherAttachment(@PathVariable("id") Integer id) {

		return attachmentService.deleteOtherAttachment(id);
	}

	@RequestMapping(value = "/search/{name}", method = RequestMethod.GET)
	public ResponseEntity<List<OtherAttachment>> searchByName(@PathVariable("name") String name) {

		return attachmentService.searchByName(name);
	}

	@RequestMapping(value = "/search/{userId}", method = RequestMethod.GET)
	public ResponseEntity<List<OtherAttachment>> searchByUser(@PathVariable("userId") Integer userId) {

		return attachmentService.searchByUser(userId);
	}

}
