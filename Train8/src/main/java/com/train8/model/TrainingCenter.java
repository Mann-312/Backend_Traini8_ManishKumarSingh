package com.train8.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

import java.time.Instant;
import java.util.List;

@Entity
@Data
public class TrainingCenter {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Center name is mandatory")
    @Size(max = 40, message = "Center name must be less than 40 characters")
    private String centerName;

    @NotBlank(message = "Center code is mandatory")
    @Pattern(regexp = "^[a-zA-Z0-9]{12}$", message = "Center code must be exactly 12 alphanumeric characters")
    private String centerCode;

    @Embedded
    private Address address;

    @Min(value = 0, message = "Student capacity must be a positive number")
    private Integer studentCapacity;

    @ElementCollection
    private List<String> coursesOffered;

    private Long createdOn;

    @Email(message = "Invalid email format")
    private String contactEmail;

    @NotBlank(message = "Contact phone is mandatory")
    @Pattern(regexp = "^[0-9]{10}$", message = "Phone number must be exactly 10 digits")
    private String contactPhone;

    @PrePersist
    public void prePersist() {
        createdOn = Instant.now().toEpochMilli(); // Set server-generated timestamp
    }
}

@Embeddable
@Data
class Address {
    @NotBlank(message = "Detailed Address is mandatory")
    private String detailedAddress;

    @NotBlank(message = "City is mandatory")
    private String city;

    @NotBlank(message = "State is mandatory")
    private String state;

    @NotBlank(message = "Pincode is mandatory")
    @Pattern(regexp = "^[0-9]{6}$", message = "Pincode must be exactly 6 digits")
    private String pincode;
}
