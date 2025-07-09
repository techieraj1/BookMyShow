package com.bookmyshow.poc.service;

import com.bookmyshow.poc.dto.UserDetailsDTO;
import com.bookmyshow.poc.entity.UserDetails;
import com.bookmyshow.poc.repository.BMSUserRepository;
import com.bookmyshow.poc.utility.UserDetailsMapper;
import exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BMSUserServiceImpl implements BMSUserService{

    @Autowired
    private BMSUserRepository bmsUserRepository;

    @Autowired
    UserDetailsMapper userDetailsMapper;

    public List<UserDetailsDTO> getAllUser(){
        return bmsUserRepository.findAll().stream()
                .map(userDetailsMapper::toUserDetailsDTO).collect(Collectors.toList());
    }

    @Override
    @Transactional
    public UserDetailsDTO createUser(UserDetailsDTO userDetailsDTO) {
        UserDetails userDetails = userDetailsMapper.toUserDetailsEntity(userDetailsDTO);
        return userDetailsMapper.toUserDetailsDTO(bmsUserRepository.save(userDetails));
    }

    @Override
    public UserDetailsDTO updateUser(UserDetailsDTO userDetailsDTO, long userId) {
        return bmsUserRepository.findById(userId).map(userDetailsMapper::toUserDetailsDTO)
                .orElseThrow(()-> new ResourceNotFoundException(userId+"user not found"));
    }

    @Override
    public UserDetailsDTO getUserById(long userId) {
        return bmsUserRepository.findById(userId).map(userDetailsMapper::toUserDetailsDTO)
                .orElseThrow(()-> new ResourceNotFoundException(userId+"user not found"));
    }

    @Override
    public void deleteUser(long userId) {
        UserDetails userDetails = bmsUserRepository.findById(userId)
                .orElseThrow(()-> new ResourceNotFoundException(userId+"user not found"));
        bmsUserRepository.delete(userDetails);
    }
}
