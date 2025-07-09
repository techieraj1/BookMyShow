package com.bookmyshow.poc.entity;

import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name= "USER_DETAILS", /*uniqueConstraints = {
        @UniqueConstraint(columnNames = "EMAIL_ID"),
        @UniqueConstraint(columnNames = "CONTACT")
},*/ schema = "public")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="USER_ID")
    private long userId;
    @Column(name = "NAME", nullable = false)
    private String name;
    @Column(name = "EMAIL_ID", nullable = false)
    private String emailId;
    @Column(name = "CONTACT", nullable = false)
    private String contact;


}
