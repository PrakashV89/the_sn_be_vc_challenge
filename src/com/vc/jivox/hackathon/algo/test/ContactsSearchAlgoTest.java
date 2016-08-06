package com.vc.jivox.hackathon.algo.test;

import java.util.HashSet;
import java.util.Set;

import com.vc.jivox.hackathon.algo.ContactsSearchAlgo;
import com.vc.jivox.hackathon.algo.model.Contact;

public class ContactsSearchAlgoTest {

	public static void main(String[] args) {
		
		ContactsSearchAlgoTest contactsSearchAlgoTest = new ContactsSearchAlgoTest();
		
		Contact prakash = new Contact("Prakash", "Varman", "prakashxxxxxxxxx@gmail.com", "+911234567890");
		
		ContactsSearchAlgo contactsSearchAlgo = new ContactsSearchAlgo();
		Set<Contact> extendedContacts = contactsSearchAlgo.search(prakash, contactsSearchAlgoTest.mockAllContacts());
		
		System.out.println("Friends for " + prakash.getFirstName() + " " + prakash.getLastName() + " : ");
		for(Contact contact : extendedContacts){
			System.out.println(contact.getFirstName() + " " + contact.getLastName());
		}
		
	}
	
	public Contact getContact(String firstName, String lastName, String email, String mobile){
		return new Contact(firstName, lastName, email, mobile);
	}
	
	public Set<Contact> mockAllContacts(){
		Set<Contact> contacts = new HashSet<Contact>();
		
		Contact prakash = getContact("Prakash", "Varman", "prakashxxxxxxxxx@gmail.com", "+911234567890");
		Contact rajat = getContact("Rajat", "Singh", "rajatxxxxxxxxx@gmail.com", "+911334567890");
		Contact nikit = getContact("Nikit", "Jain", "nikitxxxxxxxxx@gmail.com", "+911434567890");
		Contact ashok = getContact("Ashok", "Jain", "ashokxxxxxxxxx@gmail.com", "+911534567890");
		
		prakash.getContacts().add(nikit);
		
		rajat.getContacts().add(prakash);
		rajat.getContacts().add(ashok);
		
		nikit.getContacts().add(prakash);
		nikit.getContacts().add(rajat);
		nikit.getContacts().add(ashok);
		
		contacts.add(nikit);
		contacts.add(prakash);
		contacts.add(rajat);
		contacts.add(ashok);
		
		return contacts;
		
	}
	
}
