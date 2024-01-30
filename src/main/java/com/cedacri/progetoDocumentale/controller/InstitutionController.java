package com.cedacri.progetoDocumentale.controller;

import com.cedacri.progetoDocumentale.dto.InstitutionDto;
import com.cedacri.progetoDocumentale.service.InstitutionService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/institution")
@RequiredArgsConstructor
public class InstitutionController {

    private final InstitutionService institutionService;

    @PostMapping("/create")
    public ResponseEntity<InstitutionDto> createInstitution(@RequestBody @Valid InstitutionDto institutionDto) {
        try {
            institutionService.createInstitution(institutionDto);
            return new ResponseEntity<>(institutionDto, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
    }

    @GetMapping("/getAll")
    public List<InstitutionDto> getAllInstitutions() {
        return institutionService.getAllInstitutions();
    }

    @GetMapping("/getPaginate")
    public List<InstitutionDto> getPaginateInstitutions(@RequestParam int pageNumber,
                                                        @RequestParam int pageSize) {
        return institutionService.getPaginateInstitutions(pageNumber, pageSize);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<InstitutionDto> updateInstitution(@PathVariable long id,
                                  @RequestBody InstitutionDto institutionDto) {
        try {
            Optional<InstitutionDto> dto =  institutionService.updateInstitution(id, institutionDto);
            return dto
                    .map(d -> new ResponseEntity<>(d, HttpStatus.OK))
                    .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
    }

    @DeleteMapping("/remove/{id}")
    public ResponseEntity<String> removeInstitution(@PathVariable long id) {
        institutionService.removeInstitution(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
