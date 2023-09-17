package com.ds.glitchreporter.services;

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

/**
 * Service class for managing messages and their associated files.
 */

@Service
public class MessageService {

	@Autowired
	MessageRepository messageRepository;
	
	@Autowired
	UploadedFileRepository uploadedFileRepository;
	
    /**
     * Maps a Message entity to a MessageDTO.
     *
     * @param message The Message entity to be mapped.
     * @return A MessageDTO containing information from the given Message entity.
     */
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
