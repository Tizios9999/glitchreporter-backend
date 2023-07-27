package com.ds.glitchreporter.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ds.glitchreporter.models.UploadedFile;

public interface UploadedFileRepository extends JpaRepository<UploadedFile, Long> {

	Optional<UploadedFile> findById(Long id);
}
