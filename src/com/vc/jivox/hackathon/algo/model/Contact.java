package com.vc.jivox.hackathon.algo.model;

import java.util.Set;

public class Contact implements IContact {

	private Contacts contacts;
	private String firstName;
	private String lastName;
	private String email;
	private String mobile;

	public Contact() {

	}

	public Contact(String firstName, String lastName, String email, String mobile) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.mobile = mobile;
	}

	@Override
	public String getLastName() {
		return lastName;
	}

	@Override
	public String getEmail() {
		return email;
	}

	@Override
	public String getMobile() {
		return mobile;
	}

	@Override
	public String getFirstName() {
		return firstName;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		result = prime * result + ((mobile == null) ? 0 : mobile.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Contact other = (Contact) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		if (mobile == null) {
			if (other.mobile != null)
				return false;
		} else if (!mobile.equals(other.mobile))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Contact [firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + ", mobile=" + mobile
				+ "]";
	}

	public Set<Contact> getContacts() {
		if(contacts == null){
			contacts = new Contacts();
		}
		return contacts.getContacts(this);
	}
	
	public Set<Contact> addContact(Contact contact){
		if(contacts == null){
			contacts = new Contacts();
		}
		
		contacts.addContact(contact, this);
		
		return contacts.getContacts();
	}

	public Contacts getContactsObj() {
		if(contacts == null){
			contacts = new Contacts();
		}
		
		return contacts;
	}

}
