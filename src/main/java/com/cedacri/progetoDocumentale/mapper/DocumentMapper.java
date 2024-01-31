package com.cedacri.progetoDocumentale.mapper;

import com.cedacri.progetoDocumentale.dto.DocumentRequestDto;
import com.cedacri.progetoDocumentale.dto.DocumentResponseDto;
import com.cedacri.progetoDocumentale.model.DocumentTypes;
import com.cedacri.progetoDocumentale.model.Documents;
import com.cedacri.progetoDocumentale.model.Institutions;
import com.cedacri.progetoDocumentale.model.Projects;
import com.cedacri.progetoDocumentale.model.Users;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DocumentMapper {

    public Documents toDocument(DocumentRequestDto documentRequestDto, Users user, DocumentTypes documentType, Projects project, Institutions institution) {
        return Documents.builder()
                .savedPath(documentRequestDto.getSavedPath())
                .savedDate(LocalDate.now())
                .additionalInfo(documentRequestDto.getAdditionalInfo())
                .groupingDate(LocalDate.parse(documentRequestDto.getGroupingDate()))
                .institution(institution)
                .user(user)
                .documentType(documentType)
                .project(project)
                .build();
    }

    public DocumentResponseDto requestToResponse(DocumentRequestDto documentRequestDto) {
        return DocumentResponseDto.builder()
                .savedPath(documentRequestDto.getSavedPath())
                .macroId(documentRequestDto.getMacroId())
                .groupingDate(LocalDate.now())
                .build();
    }
}
