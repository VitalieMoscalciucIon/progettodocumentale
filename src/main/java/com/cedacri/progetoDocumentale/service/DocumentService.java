package com.cedacri.progetoDocumentale.service;

import com.cedacri.progetoDocumentale.dto.DocumentRequestDto;
import com.cedacri.progetoDocumentale.dto.DocumentResponseDto;
import com.cedacri.progetoDocumentale.exception.DocumentTypeNotFoundException;
import com.cedacri.progetoDocumentale.exception.InstitutionNotFoundException;
import com.cedacri.progetoDocumentale.exception.UserNotFoundException;
import com.cedacri.progetoDocumentale.mapper.DocumentMapper;
import com.cedacri.progetoDocumentale.model.DocumentTypes;
import com.cedacri.progetoDocumentale.model.Institutions;
import com.cedacri.progetoDocumentale.model.Projects;
import com.cedacri.progetoDocumentale.model.Users;
import com.cedacri.progetoDocumentale.repository.DocumentRepository;
import com.cedacri.progetoDocumentale.repository.DocumentTypesRepository;
import com.cedacri.progetoDocumentale.repository.InstitutionsRepository;
import com.cedacri.progetoDocumentale.repository.ProjectsRepository;
import com.cedacri.progetoDocumentale.repository.UsersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class DocumentService {
    private final InstitutionsRepository institutionsRepository;
    private final UsersRepository usersRepository;
    private final DocumentTypesRepository documentTypesRepository;
    private final ProjectsRepository projectsRepository;
    private final DocumentRepository documentRepository;
    private final DocumentMapper documentMapper;

    public DocumentResponseDto createDocument(DocumentRequestDto requestDto){
        Institutions institution = getInstitution(requestDto.getInstitutionId());
        Users user = getUser(requestDto.getUserId());
        DocumentTypes documentType = getDocumentType(requestDto.getMacroId());
        Projects project = getProject(requestDto);
        documentRepository.save(documentMapper.toDocument(requestDto,user,documentType,project,institution));
        return documentMapper.requestToResponse(requestDto);
    }

    private Institutions getInstitution(Long institutionId) {
        return institutionsRepository.findById(institutionId)
                .orElseThrow(() -> new InstitutionNotFoundException("Institution not found"));
    }

    private Users getUser(Long userId) {
        return usersRepository.findById(userId)
                .orElseThrow(() -> new UserNotFoundException("User not found"));
    }

    private DocumentTypes getDocumentType(Long documentTypeId) {
        return documentTypesRepository.findById(documentTypeId)
                .orElseThrow(() -> new DocumentTypeNotFoundException("Document type not found"));
    }

    private Projects getProject(DocumentRequestDto documentRequestDto) {
        if ("Progettazione".equals(getDocumentType(documentRequestDto.getMacroId()).getName())) {
            return projectsRepository.findById(documentRequestDto.getProjectId())
                    .orElseThrow(() -> new DocumentTypeNotFoundException("Project not found"));
        }
        return null;
    }
    public DocumentResponseDto getDocument(Long id){

    }
}
