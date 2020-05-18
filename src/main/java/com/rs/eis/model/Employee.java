package com.rs.eis.model;

	import java.util.Date;

	import javax.persistence.CascadeType;
	import javax.persistence.Column;
	import javax.persistence.Entity;
	import javax.persistence.EntityListeners;
	import javax.persistence.GeneratedValue;
	import javax.persistence.GenerationType;
	import javax.persistence.Id;
	import javax.persistence.OneToOne;
	import javax.persistence.PrimaryKeyJoinColumn;
	import javax.persistence.Table;

	import org.springframework.data.jpa.domain.support.AuditingEntityListener;
	@Entity
	@Table(name = "Employee")
	public class Employee {

		@Id
		@Column(updatable = false, nullable = false)
		@GeneratedValue
		private int id;
		@Column
		private String firstName;
		@Column
		private String middleName;
		@Column
		private String lastName;
		@Column
		private String email;
		@Column
		private String mobile;
		@Column
		private String userName;
		@Column
		private String password;
		@Column
		private Address address;
		
		public Employee() {
		}
		public Employee(int id, String firstName, String middleName, String lastName, String email, String mobile,
				String userName, String password, Address address) {
			
			this.id = id;
			this.firstName = firstName;
			this.middleName = middleName;
			this.lastName = lastName;
			this.email = email;
			this.mobile = mobile;
			this.userName = userName;
			this.password = password;
			this.address = address;
		}
		
		@OneToOne(cascade=CascadeType.ALL)
		@PrimaryKeyJoinColumn
		private Employee beneficiary;

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getFirstName() {
			return firstName;
		}

		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}

		public String getMiddleName() {
			return middleName;
		}

		public void setMiddleName(String middleName) {
			this.middleName = middleName;
		}

		public String getLastName() {
			return lastName;
		}

		public void setLastName(String lastName) {
			this.lastName = lastName;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public String getMobile() {
			return mobile;
		}

		public void setMobile(String mobile) {
			this.mobile = mobile;
		}

		public String getUserName() {
			return userName;
		}

		public void setUserName(String userName) {
			this.userName = userName;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

		public Address getAddress() {
			return address;
		}

		public void setAddress(Address address) {
			this.address = address;
		}
		@Override
		public String toString() {
			return "User [userid=" + id + ", firstName=" + firstName + ", middleName=" + middleName + ", lastName="
					+ lastName + ", email=" + email + ", moblie=" + mobile + ", userName=" + userName + ", address=" + address + "]";
		}
			}


