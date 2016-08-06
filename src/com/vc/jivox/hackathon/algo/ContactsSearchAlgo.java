package com.vc.jivox.hackathon.algo;

import java.util.HashSet;
import java.util.Set;

import com.vc.jivox.hackathon.algo.model.Contact;

public class ContactsSearchAlgo implements SearchAlgo<Contact, Contact>{

	@Override
	public Set<Contact> search(Contact e, Set<Contact> contacts) {
		Contact actualContact = getContact(e, contacts);

		Set<Contact> contactsToIgnore = getDirectContacts(actualContact);
		
		contactsToIgnore.add(actualContact);
		
		Set<Contact> extendedContacts = getExtendedContacts(actualContact.getContacts(), contactsToIgnore, actualContact);
		
		
		return extendedContacts;
	}
	
	private Contact getContact(Contact e, Set<Contact> contacts) {
		for(Contact contact: contacts){
			if(contact.equals(e)){
				return contact;
			}
		}
		return e;
	}

	public void intializeAllExtendedContactsList(){
		
	}
	
	public Set<Contact> getExtendedContacts(Set<Contact> contacts, Set<Contact> contactsToIgnore, Contact actualContact){
		HashSet<Contact> extendedContacts = new HashSet<Contact>();
		for(Contact contact : contacts){
			if(contact.equals(actualContact)){
				continue;
			}
			if(contactsToIgnore.contains(contact)){
				extendedContacts.addAll(getExtendedContacts( contact.getContacts() , contactsToIgnore, actualContact));
				continue;
			}
			else{
				extendedContacts.addAll(getExtendedContacts(contact.getContacts() , contactsToIgnore, actualContact));
				extendedContacts.add(contact);
			}
			
		}
		return extendedContacts;
	}
	
	public Set<Contact> getDirectContacts(Contact contact){
		return contact.getContacts();
	}
	
}
