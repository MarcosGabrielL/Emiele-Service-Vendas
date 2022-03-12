/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.softsaj.gibgasVenda.file;

/**
 *
 * @author Marcos
 */

import com.softsaj.gibgasVenda.models.Produto;
import java.io.IOException;
import java.util.List;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;


@Service
public class FileStorageService {

  @Autowired
  private FileDBRepository fileDBRepository;

  public FileDB store(MultipartFile file, String idpost) throws IOException {
      
    String fileName = StringUtils.cleanPath(file.getOriginalFilename());
    FileDB FileDB = new FileDB(fileName, file.getContentType(), file.getBytes(), idpost);

    return fileDBRepository.save(FileDB);
  }

  public FileDB getFile(Long id) {
    return fileDBRepository.findById(id).get();
  }
  
  public List<FileDB> findByIdProduto(String id) {
    return fileDBRepository.findByIdProduto(id);
  }
  
  public Stream<FileDB> getAllFiles() {
    return fileDBRepository.findAll().stream();
  }
}
