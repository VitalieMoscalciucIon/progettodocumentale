package com.cedacri.progetoDocumentale.mapper;

import com.cedacri.progetoDocumentale.dto.UserDto;
import com.cedacri.progetoDocumentale.exception.ResourceNotFoundException;
import com.cedacri.progetoDocumentale.model.Institutions;
import com.cedacri.progetoDocumentale.model.UserRoles;
import com.cedacri.progetoDocumentale.model.Users;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class UserMapper {

    private final ModelMapper mapper;

    public Users fromDto(UserDto userDto, List<UserRoles> roles, Institutions institution) {
        if (roles.isEmpty() || institution == null)
            throw new ResourceNotFoundException();

        Users user = new Users();
        mapper.map(userDto, user);
        user.setRoles(roles);
        user.setInstitution(institution);
        user.setIsEnabled(userDto.isEnabled());
        return user;
    }
}
