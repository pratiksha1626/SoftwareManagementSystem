package com.example.SoftwareManagement.Softwaremodel;

import org.hibernate.annotations.DynamicUpdate;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * In this class, we declare private attributes to represent software details and
 * provide getters and setters for accessing these attributes.
 */

@Entity
@Table(name = "software_table")
@DynamicUpdate


public class Software {

		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Integer softwareId;

		
		private String softwareName;

		@Column( nullable = false)
		private String developer;
		

		@Column
		private int rating;
		
		@Column
		private int price;
		
		@Column
		private Boolean isDesktopApplication;
		
		

	    public Boolean getIsDesktopApplication() {
			return isDesktopApplication;
		}

		public Integer getSoftwareId() {
			return softwareId;
		}

		public void setSoftwareId(Integer softwareId) {
			this.softwareId = softwareId;
		}

		public void setIsDesktopApplication(Boolean isDesktopApplication) {
			this.isDesktopApplication = isDesktopApplication;
		}

		// Getters and setters for the attributes.
		public String getDeveloper() {
			return developer;
		}

		public String getSoftwareName() {
			return softwareName;
		}

		public void setSoftwareName(String softwareName) {
			this.softwareName = softwareName;
		}

		public void setDeveloper(String developer) {
			this.developer = developer;
		}

		public int getRating() {
			return rating;
		}

		public void setRating(int rating) {
			this.rating = rating;
		}

		public int getPrice() {
			return price;
		}

		public void setPrice(int price) {
			this.price = price;
		}

	    // Default constructor.
		public Software() {
			System.out.println("no args con");	
		}

		@Override
		public String toString() {
			return "Software [softwareId=" + softwareId + ", softwareName=" + softwareName + ", developer=" + developer
					+ ", rating=" + rating + ", price=" + price + ", isDesktopApplication=" + isDesktopApplication
					+ "]";
		}

		public Software(Integer softwareId, String softwareName, String developer, int rating, int price,
				Boolean isDesktopApplication) {
			this.softwareId = softwareId;
			this.softwareName = softwareName;
			this.developer = developer;
			this.rating = rating;
			this.price = price;
			this.isDesktopApplication = isDesktopApplication;
		}


			
}


