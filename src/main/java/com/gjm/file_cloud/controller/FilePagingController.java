package com.gjm.file_cloud.controller;

import com.gjm.file_cloud.entity.PagingInfo;
import com.gjm.file_cloud.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Locale;

import static com.gjm.file_cloud.controller.FileController.createResponseEntity;

@RestController
@RequestMapping("/api")
public class FilePagingController {
    private FileService fileService;

    @Autowired
    public FilePagingController(FileService fileService) {
        this.fileService = fileService;
    }

    @GetMapping("/files/names/paged/{pageNumber}")
    public ResponseEntity getFileNamesPaged(@PathVariable("pageNumber") int pageNumber, Locale locale) {
        List<String> fileNamesPaged = fileService.getFileNamesPaged(pageNumber, locale);

        return createResponseEntity(HttpStatus.OK, fileNamesPaged);
    }

    @GetMapping("/files/paging")
    public ResponseEntity getFilePagingInfo(Locale locale) {
        PagingInfo pagingInfo = fileService.getFilePagingInfo(locale);

        return createResponseEntity(HttpStatus.OK, pagingInfo);
    }
}