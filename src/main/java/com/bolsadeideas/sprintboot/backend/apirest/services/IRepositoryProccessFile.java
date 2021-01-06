package com.bolsadeideas.sprintboot.backend.apirest.services;

import org.springframework.web.multipart.MultipartFile;

public interface IRepositoryProccessFile {
    public boolean ProcessReadFile(MultipartFile File);
}
