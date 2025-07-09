package com.bookmyshow.poc.service;

import com.bookmyshow.poc.dto.UserDetailsDTO;

import java.util.List;

public interface BMSUserService {
    List<UserDetailsDTO> getAllUser();
    UserDetailsDTO createUser(UserDetailsDTO userDetailsDTO);
    UserDetailsDTO updateUser(UserDetailsDTO userDetailsDTO, long userId);
    UserDetailsDTO getUserById(long userId);
    void deleteUser(long userId);
}
