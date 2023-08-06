package com.ds.glitchreporter.security.services;

import java.util.List;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ds.glitchreporter.dto.MessageDTO;
import com.ds.glitchreporter.dto.UploadedFileDTO;
import com.ds.glitchreporter.models.Message;
import com.ds.glitchreporter.models.UploadedFile;
import com.ds.glitchreporter.repository.MessageRepository;
import com.ds.glitchreporter.repository.UploadedFileRepository;

@Service
public class MessageService {

	@Autowired
	MessageRepository messageRepository;
	
	@Autowired
	UploadedFileRepository uploadedFileRepository;
	
	public MessageDTO mapToMessageDTO(Message message) {
		
		MessageDTO messageDTO = new MessageDTO(message);
		
		List<UploadedFile> uploadedFiles = uploadedFileRepository.findByMessage(message);
		
		List<UploadedFileDTO> uploadedFilesDTO = new ArrayList<>();
		
		for (UploadedFile file : uploadedFiles) {
	    	 
			UploadedFileDTO fileDTO = new UploadedFileDTO(file);
	    	 
	    	 uploadedFilesDTO.add(fileDTO);
	     }
		
		messageDTO.setUploadedFiles(uploadedFilesDTO);
		
		return messageDTO;
	}
	
}
