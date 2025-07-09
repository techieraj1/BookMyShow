package com.bookmyshow.poc.utility;

import org.mapstruct.Mapper;

import com.bookmyshow.poc.dto.UserDetailsDTO;
import com.bookmyshow.poc.entity.UserDetails;

@Mapper(componentModel = "spring")
public interface UserDetailsMapper {
    UserDetails toUserDetailsEntity(UserDetailsDTO userDetailsDTO);
    UserDetailsDTO toUserDetailsDTO(UserDetails userDetails);
}
