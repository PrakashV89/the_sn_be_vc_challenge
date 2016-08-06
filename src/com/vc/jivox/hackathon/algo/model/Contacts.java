package com.vc.jivox.hackathon.algo.model;

import java.util.HashSet;
import java.util.Set;

public class Contacts {

	private Set<Contact> contacts;

	public Set<Contact> getContacts() {

		if (contacts == null) {
			contacts = new HashSet<Contact>();
		}

		return contacts;
	}
	
	public boolean addContact(Contact contact){
		
		if (contacts == null) {
			contacts = new HashSet<Contact>();
		}
		
		boolean contactAdded = contacts.add(contact);
		
		return contactAdded;
	}

}
