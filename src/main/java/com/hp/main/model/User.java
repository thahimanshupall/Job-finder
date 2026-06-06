package com.hp.main.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Name is required")
    private String name;

    @NotBlank(message = "Mobile number is required")
    @Pattern(regexp = "^[0-9]{10}$", message = "Enter valid 10 digit number")
    private String number;

    @NotBlank(message = "Email is required")
    @Email(message = "Enter valid email")
    @Column(unique = true)
    private String email;

    @NotBlank(message = "State is required")
    private String state;

    @NotBlank(message = "District is required")
    private String district;

    @NotBlank(message = "Country is required")
    private String country;

    @NotBlank(message = "Pincode is required")
    @Pattern(regexp = "^[0-9]{6}$", message = "Enter valid 6 digit pincode")
    private String pincode;

    @NotBlank(message = "Password is required")
    @Size(min = 6, message = "Password must be at least 6 characters")
    private String password;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public User(Long id, @NotBlank(message = "Name is required") String name,
			@NotBlank(message = "Mobile number is required") @Pattern(regexp = "^[0-9]{10}$", message = "Enter valid 10 digit number") String number,
			@NotBlank(message = "Email is required") @Email(message = "Enter valid email") String email,
			@NotBlank(message = "State is required") String state,
			@NotBlank(message = "District is required") String district,
			@NotBlank(message = "Country is required") String country,
			@NotBlank(message = "Pincode is required") @Pattern(regexp = "^[0-9]{6}$", message = "Enter valid 6 digit pincode") String pincode,
			@NotBlank(message = "Password is required") @Size(min = 6, message = "Password must be at least 6 characters") String password) {
		super();
		this.id = id;
		this.name = name;
		this.number = number;
		this.email = email;
		this.state = state;
		this.district = district;
		this.country = country;
		this.pincode = pincode;
		this.password = password;
	}

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

    // Getters and Setters
}
