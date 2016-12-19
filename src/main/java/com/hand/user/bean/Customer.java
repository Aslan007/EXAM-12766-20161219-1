package com.hand.user.bean;

import java.util.Date;

public class Customer {
    private Integer customerId;

    private Integer storeId;

    private String firstName;

    private String lastName;

    private String email;

    private Integer addressId;

    private Boolean active;

    private Date createDate;

    private Date lastUpdate;

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer i) {
        this.customerId = i;
    }

    public Integer getStoreId() {
        return storeId;
    }

    public void setStoreId(Integer storeId) {
        this.storeId = storeId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName == null ? null : firstName.trim();
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName == null ? null : lastName.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public Integer getAddressId() {
        return addressId;
    }

    public void setAddressId(Integer addressId) {
        this.addressId = addressId;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", storeId=" + storeId + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", email=" + email + ", addressId=" + addressId + ", active=" + active
				+ ", createDate=" + createDate + ", lastUpdate=" + lastUpdate + "]";
	}
}