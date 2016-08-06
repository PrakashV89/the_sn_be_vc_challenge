package com.vc.jivox.hackathon.algo.test;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import com.vc.jivox.hackathon.algo.ContactsSearchAlgo;
import com.vc.jivox.hackathon.algo.model.Contact;

public class ContactsSearchAlgoTest {

	public static void main(String[] args) {
		
		ContactsSearchAlgoTest contactsSearchAlgoTest = new ContactsSearchAlgoTest();
		
		Set<Contact> contactsToSearch = contactsSearchAlgoTest.prepareInitalDataToSearch();
		
		ContactsSearchAlgo contactsSearchAlgo = new ContactsSearchAlgo();
		
		
		/*Contact rajat = contactsSearchAlgoTest.getContact("Rajat", "Singh", "rajatxxxxxxxxx@gmail.com", "+911334567890");
		
		Set<Contact> contact = contactsSearchAlgo.search(rajat, contactsSearchAlgoTest.mockAllContacts());
		
		contactsSearchAlgoTest.printFriends(rajat, contact);*/
		
		Map<Contact, Set<Contact>> contactsWithRespectiveExtendedContacts = contactsSearchAlgo.searchMultiple(contactsToSearch, contactsSearchAlgoTest.mockAllContacts());
		
		for(Contact contact: contactsWithRespectiveExtendedContacts.keySet()){
			contactsSearchAlgoTest.printFriends(contact, contactsWithRespectiveExtendedContacts.get(contact));
		}
		
	}
	
	public Contact getContact(String firstName, String lastName, String email, String mobile){
		return new Contact(firstName, lastName, email, mobile);
	}
	
	public Set<Contact> prepareInitalDataToSearch(){
		Set<Contact> dataToSearch = new HashSet<Contact>();
		
		Contact prakash = getContact("Prakash", "Varman", "prakashxxxxxxxxx@gmail.com", "+911234567890");
		Contact rajat = getContact("Rajat", "Singh", "rajatxxxxxxxxx@gmail.com", "+911334567890");
		Contact nikit = getContact("Nikit", "Jain", "nikitxxxxxxxxx@gmail.com", "+911434567890");
		Contact ashok = getContact("Ashok", "Jain", "ashokxxxxxxxxx@gmail.com", "+911534567890");
		
		dataToSearch.add(nikit);
		dataToSearch.add(prakash);
		dataToSearch.add(rajat);
		dataToSearch.add(ashok);
		
		return dataToSearch;
	}
	
	public Set<Contact> mockAllContacts(){
		Set<Contact> contacts = new HashSet<Contact>();
		
		Contact prakash = getContact("Prakash", "Varman", "prakashxxxxxxxxx@gmail.com", "+911234567890");
		Contact rajat = getContact("Rajat", "Singh", "rajatxxxxxxxxx@gmail.com", "+911334567890");
		Contact nikit = getContact("Nikit", "Jain", "nikitxxxxxxxxx@gmail.com", "+911434567890");
		Contact ashok = getContact("Ashok", "Jain", "ashokxxxxxxxxx@gmail.com", "+911534567890");
		
		prakash.addContact(nikit);
		
		rajat.addContact(prakash);
		rajat.addContact(ashok);
		
		nikit.addContact(prakash);
		nikit.addContact(rajat);
		nikit.addContact(ashok);
		
		contacts.add(nikit);
		contacts.add(prakash);
		contacts.add(rajat);
		contacts.add(ashok);
		
		return contacts;
		
	}
	
	public void printFriends(Contact actualContact, Set<Contact> extendedContacts){
		System.out.println("Friends for " + actualContact.getFirstName() + " " + actualContact.getLastName() + " : ");
		for(Contact contact : extendedContacts){
			System.out.println(contact.getFirstName() + " " + contact.getLastName());
		}
	}
	
}
