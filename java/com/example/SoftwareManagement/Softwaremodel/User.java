package com.example.SoftwareManagement.Softwaremodel;

import java.time.LocalDate;

import org.hibernate.annotations.DynamicUpdate;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "User_table")
@DynamicUpdate
public class User {

		
	@Id
		private Integer userID;
		private String userName;
		private LocalDate date;
		private String userEmail;
		
		@ManyToOne(cascade = CascadeType.ALL)
		@JoinColumn(name="SoftwareId")
		private Software Details;

		public Integer getUserID() {
			return userID;
		}

		public String getUserName() {
			return userName;
		}

		public LocalDate getDate() {
			return date;
		}

		public String getUserEmail() {
			return userEmail;
		}

		public Software getSoftwareDetails() {
			return getSoftwareDetails();
		}


		public void setUserID(Integer userID) {
			this.userID = userID;
		}


		public void setUserName(String userName) {
			this.userName = userName;
		}


		public void setDate(LocalDate date) {
			this.date = date;
		}


		public void setUserEmail(String userEmail) {
			this.userEmail = userEmail;
		}


		public void setsoftwareDetails(Software SoftwareDetails) {
			this.Details = SoftwareDetails;
		}

		
}
