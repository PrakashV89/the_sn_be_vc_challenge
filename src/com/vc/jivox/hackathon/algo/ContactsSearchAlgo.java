package com.vc.jivox.hackathon.algo;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import com.vc.jivox.hackathon.algo.model.Contact;

public class ContactsSearchAlgo implements SearchAlgo<Contact, Contact> {

	@Override
	public Set<Contact> search(Contact e, Set<Contact> contacts) {
		Contact actualContact = getContact(e, contacts);
		
		Set<Contact> contactsToIgnore = getDirectContacts(actualContact);

		contactsToIgnore.add(actualContact);

		Set<Contact> extendedContacts = getExtendedContacts(actualContact.getContacts(), contactsToIgnore,
				actualContact);

		return extendedContacts;
	}

	private Contact getContact(Contact e, Set<Contact> contacts) {
		for (Contact contact : contacts) {
			if (contact.equals(e)) {
				return contact;
			}
		}
		return e;
	}

	public void intializeAllExtendedContactsList() {

	}

	public Set<Contact> getExtendedContacts(Set<Contact> contacts, Set<Contact> contactsToIgnore,
			Contact actualContact) {
		HashSet<Contact> extendedContacts = new HashSet<Contact>();
		for (Contact contact : contacts) {
			if (contact.equals(actualContact)) {
				continue;
			}
			
			if (contactsToIgnore.contains(contact) && !extendedContacts.contains(contact)) {
				Set<Contact> newExtendedContacts = getExtendedContacts(removeIgnoredContacts(contact.getContacts(), contactsToIgnore), contactsToIgnore, actualContact);
				extendedContacts.addAll(newExtendedContacts);
				continue;
			} else if( !extendedContacts.contains(contact)) {
				Set<Contact> newExtendedContacts = getExtendedContacts(removeIgnoredContacts(contact.getContacts(), contactsToIgnore), contactsToIgnore, actualContact);
				extendedContacts.addAll(newExtendedContacts);
				extendedContacts.add(contact);
			}

		}
		return extendedContacts;
	}

	public Set<Contact> getDirectContacts(Contact contact) {
		return contact.getContacts();
	}

	@Override
	public Map<Contact, Set<Contact>> searchMultiple(Set<Contact> contactsBase, Set<Contact> contacts) {
		Map<Contact, Set<Contact>> contactsWithSearchResult = new HashMap<Contact, Set<Contact>>();
		
		for(Contact contact: contactsBase){
			contactsWithSearchResult.put(contact, search(contact, contacts));
//			break;			
		}
		
		return contactsWithSearchResult;
	}
	
	public Set<Contact> removeIgnoredContacts(Set<Contact> contacts,Set<Contact> ignoredContacts){
		Set<Contact> contactsWoIC = new HashSet<Contact>();
		
		for(Contact contact: contacts){
			if(!ignoredContacts.contains(contact)){
				contactsWoIC.add(contact);
			}
		}
		
		return contactsWoIC;
	}

}
