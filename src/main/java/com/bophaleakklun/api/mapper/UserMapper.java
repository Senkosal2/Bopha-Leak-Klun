package com.bophaleakklun.api.mapper;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.validator.internal.util.stereotypes.Lazy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bophaleakklun.api.dto.UserDetailDTO;
import com.bophaleakklun.api.entity.UserDetail;

@Component
public class UserMapper {
    
    // @Autowired
    // @Lazy
    // private AddressMapper addressMapper;

    public UserDetail toUser(UserDetailDTO userDTO) {
        UserDetail user = new UserDetail();
        // user.setId(userDTO.getId());
        // user.setUsername(userDTO.getUsername());
        // user.setEmail(userDTO.getEmail());
        // user.setDateOfBirth(userDTO.getDateOfBirth());
        // user.setPhoneNumber(userDTO.getPhoneNumber());
        // user.setPassword(userDTO.getPassword());
        // user.setAddress(addressMapper.toAddress(userDTO.getAddressDTO()));
        // user.setUserType(userDTO.getUserType());

        return user;
    }

    public List<UserDetail> toUsers(List<UserDetailDTO> userDTOs) {
        List<UserDetail> users = new ArrayList<>();
        for (UserDetailDTO userDTO : userDTOs) {
            users.add(toUser(userDTO));
        }
        return users;
    }

    public UserDetailDTO toUserDTO(UserDetail user) {
        UserDetailDTO userDTO = new UserDetailDTO();
        // userDTO.setId(user.getId());
        // userDTO.setUsername(user.getUsername());
        // userDTO.setPassword(user.getPassword());
        // userDTO.setEmail(user.getEmail());
        // userDTO.setDateOfBirth(user.getDateOfBirth());
        // userDTO.setPhoneNumber(user.getPhoneNumber());
        // userDTO.setAddressDTO(addressMapper.toAddressDTO(user.getAddress()));
        // userDTO.setUserType(user.getUserType());
        return userDTO;
    }

    public List<UserDetailDTO> toUserDTOs(List<UserDetail> users) {
        List<UserDetailDTO> userDTOs = new ArrayList<>();
        for (UserDetail user : users) {
            userDTOs.add(toUserDTO(user));
        }
        return userDTOs;
    }
}