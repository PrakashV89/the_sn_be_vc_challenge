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
	
	public Set<Contact> getContacts(Contact contact) {

		if (contacts == null) {
			contacts = new HashSet<Contact>();
		}
		Set<Contact> contactSet = new HashSet<Contact>();

		for(Contact contact2 : contacts){
			if(!contact.equals(contact2)){
				contactSet.add(contact2);
			}
		}
		
		return contactSet;
	}
	
	public boolean addContact(Contact contact, Contact actualContact){
		
		if (contacts == null) {
			contacts = new HashSet<Contact>();
		}
		
		if(contact.equals(actualContact)){
			return false;
		}
		
		boolean contactAdded = contacts.add(contact);
		
		return contactAdded;
	}

}
