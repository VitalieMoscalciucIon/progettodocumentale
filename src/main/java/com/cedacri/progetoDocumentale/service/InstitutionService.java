package com.cedacri.progetoDocumentale.service;

import com.cedacri.progetoDocumentale.dto.InstitutionDto;
import com.cedacri.progetoDocumentale.exception.ResourceAlreadyExistsException;
import com.cedacri.progetoDocumentale.exception.ResourceNotFoundException;
import com.cedacri.progetoDocumentale.model.Institutions;
import com.cedacri.progetoDocumentale.repository.InstitutionRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class InstitutionService {

    private final ModelMapper mapper;
    private final InstitutionRepository institutionRepository;

    public void createInstitution(InstitutionDto institutionDto) {
        try {
            institutionRepository.save(mapper.map(institutionDto, Institutions.class));
        } catch (Exception e) {
            throw new ResourceAlreadyExistsException();
        }
    }

    public List<InstitutionDto> getAllInstitutions() {
        return institutionRepository.findAll()
                .stream()
                .map(i -> mapper.map(i, InstitutionDto.class))
                .toList();
    }

    public List<InstitutionDto> getPaginateInstitutions(int pageNumber, int pageSize) {
        return institutionRepository.findAll(PageRequest.of(pageNumber, pageSize))
                .stream()
                .map(i -> mapper.map(i, InstitutionDto.class))
                .toList();
    }

    public void updateInstitution(long id, InstitutionDto institutionDto) {
        Institutions institution = institutionRepository.findById(id)
                .orElseThrow(ResourceNotFoundException::new);

        // TODO: extract mapping
        institution.setInstCode(institutionDto.getInstCode());
        institution.setName(institutionDto.getName());
        institution.setAdditionalInfo(institutionDto.getAdditionalInfo());
        institutionRepository.save(institution);
    }

    public void removeInstitution(long id) {
        institutionRepository.deleteById(id);
    }
}
