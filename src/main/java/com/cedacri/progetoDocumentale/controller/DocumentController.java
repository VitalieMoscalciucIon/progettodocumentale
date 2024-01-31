package com.cedacri.progetoDocumentale.controller;

import com.cedacri.progetoDocumentale.dto.DocumentRequestDto;
import com.cedacri.progetoDocumentale.dto.DocumentResponseDto;
import com.cedacri.progetoDocumentale.service.DocumentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/OperatoreCedacriPage")
public class DocumentController {

    private final DocumentService documentService;

    @PostMapping("/createDocument")
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public DocumentResponseDto createDocument(@RequestBody DocumentRequestDto requestDto){
        return documentService.reateDocument(requestDto);
    }

}
