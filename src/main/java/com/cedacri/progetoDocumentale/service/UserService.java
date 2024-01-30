package com.cedacri.progetoDocumentale.service;

import com.cedacri.progetoDocumentale.dto.UserDto;
import com.cedacri.progetoDocumentale.dto.UserView;
import com.cedacri.progetoDocumentale.exception.ResourceAlreadyExistsException;
import com.cedacri.progetoDocumentale.exception.ResourceNotFoundException;
import com.cedacri.progetoDocumentale.model.Institutions;
import com.cedacri.progetoDocumentale.model.UserRoles;
import com.cedacri.progetoDocumentale.model.Users;
import com.cedacri.progetoDocumentale.repository.InstitutionRepository;
import com.cedacri.progetoDocumentale.repository.UserRepository;
import com.cedacri.progetoDocumentale.repository.UserRoleRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final UserRoleRepository userRoleRepository;
    private final InstitutionRepository institutionRepository;
    private final ModelMapper mapper;

    public void createUser(UserDto userDto) {
        List<UserRoles> roles = userRoleRepository.getByRoleNameIn(userDto.getRoles());
        Institutions institution = institutionRepository.findByName(userDto.getInstitution());

        if (roles.isEmpty() || institution == null)
            throw new ResourceNotFoundException();

        // TODO: extract mapping
        Users user = new Users();
        user.setUsername(userDto.getUsername());
        user.setPassword(userDto.getPassword());
        user.setEmail(userDto.getEmail());
        user.setName(userDto.getName());
        user.setSurname(userDto.getSurname());
        user.setPatronymic(userDto.getPatronymic());
        user.setRoles(roles);
        user.setInstitution(institution);
        user.setIsEnabled(userDto.isActive());

        try {
            userRepository.save(user);
        } catch (Exception e) {
            throw new ResourceAlreadyExistsException();
        }
    }

    public List<UserView> getAllUsers() {
        return userRepository.findAll().stream()
                .map(u -> mapper.map(u, UserView.class))
                .toList();
    }

    public List<UserView> getPaginateUsers(int pageNumber, int pageSize) {
        Page<Users> page = userRepository.findAll(PageRequest.of(pageNumber, pageSize));
        return page.stream()
                .map(u -> mapper.map(u, UserView.class))
                .toList();
    }

    public void updateUser(long id, UserDto userDto) {
        Users user = userRepository.findById(id)
                .orElseThrow(ResourceNotFoundException::new);

        // TODO: refactor bellow this line
        List<UserRoles> roles = userRoleRepository.getByRoleNameIn(userDto.getRoles());
        Institutions institution = institutionRepository.findByName(userDto.getInstitution());

        if (roles.isEmpty() || institution == null)
            throw new ResourceNotFoundException();

        user.setUsername(userDto.getUsername());
        user.setPassword(userDto.getPassword());
        user.setEmail(userDto.getEmail());
        user.setName(userDto.getName());
        user.setSurname(userDto.getSurname());
        user.setPatronymic(userDto.getPatronymic());
        user.setRoles(roles);
        user.setInstitution(institution);
        user.setIsEnabled(userDto.isActive());

        try {
            userRepository.save(user);
        } catch (Exception e) {
            throw new ResourceAlreadyExistsException();
        }
    }

    public void removeUser(long id) {
        userRepository.deleteById(id);
    }
}
