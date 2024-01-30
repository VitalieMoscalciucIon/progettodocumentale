package com.cedacri.progetoDocumentale.service;

import com.cedacri.progetoDocumentale.dto.InstitutionDto;
import com.cedacri.progetoDocumentale.model.Institutions;
import com.cedacri.progetoDocumentale.repository.InstitutionRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class InstitutionService {

    private final InstitutionRepository institutionRepository;
    private final ModelMapper mapper;

    public void createInstitution(InstitutionDto institutionDto) {
        Institutions institution = mapper.map(institutionDto, Institutions.class);
        institutionRepository.save(institution);
    }

    public List<InstitutionDto> getAllInstitutions() {
        return institutionRepository.findAll().stream()
                .map(i -> mapper.map(i, InstitutionDto.class))
                .toList();
    }

    public List<InstitutionDto> getPaginateInstitutions(int pageNumber, int pageSize) {
        return institutionRepository.findAll(PageRequest.of(pageNumber, pageSize)).stream()
                .map(i -> mapper.map(i, InstitutionDto.class))
                .toList();
    }

    public Optional<InstitutionDto> updateInstitution(long id, InstitutionDto institutionDto) {
        return institutionRepository.findById(id)
                .map(i -> {
                    i.setInstCode(institutionDto.getInstCode());
                    i.setName(institutionDto.getName());
                    i.setAdditionalInfo(institutionDto.getAdditionalInfo());
                    return i;
                })
                .map(i -> mapper.map(i, InstitutionDto.class));
    }

    public void removeInstitution(long id) {
        institutionRepository.deleteById(id);
    }
}
