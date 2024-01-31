package com.cedacri.progetoDocumentale.controller;

import com.cedacri.progetoDocumentale.dto.InstitutionDto;
import com.cedacri.progetoDocumentale.service.InstitutionService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/institutions")
@RequiredArgsConstructor
public class InstitutionController {

    private final InstitutionService institutionService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createInstitution(@RequestBody @Valid InstitutionDto institutionDto) {
        institutionService.createInstitution(institutionDto);
    }

    @GetMapping("/all")
    public List<InstitutionDto> getAllInstitutions() {
        return institutionService.getAllInstitutions();
    }

    @GetMapping("/paginate")
    public List<InstitutionDto> getPaginateInstitutions(@RequestParam int pageNumber,
                                                        @RequestParam int pageSize) {
        return institutionService.getPaginateInstitutions(pageNumber, pageSize);
    }

    @PutMapping("/{id}")
    public void updateInstitution(@PathVariable long id,
                                  @RequestBody @Valid InstitutionDto institutionDto) {
        institutionService.updateInstitution(id, institutionDto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removeInstitution(@PathVariable long id) {
        institutionService.removeInstitution(id);
    }
}
