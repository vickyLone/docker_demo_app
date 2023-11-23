package com.anarghya.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.anarghya.entity.ContactEntity;
import com.anarghya.repo.ContactRepository;

@RestController
@RequestMapping("/api/contacts")
public class ContactRestController {

	@Autowired
	private ContactRepository contactRepository;

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public ResponseEntity<String> saveContact(@RequestBody ContactEntity contact) {
		try {
			ContactEntity savedContact = contactRepository.save(contact);
			return ResponseEntity.ok("Contact saved successfully");
		} catch (Exception e) {
			return ResponseEntity.badRequest().body("Failed to save contact: " + e.getMessage());
		}
	}

	@GetMapping("/findByName")
	public ResponseEntity<ContactEntity> getContactByName(@RequestParam String name) {
		ContactEntity contact = contactRepository.findByName(name);

		if (contact != null) {
			return ResponseEntity.ok(contact);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@GetMapping("/findByContact")
	public ResponseEntity<ContactEntity> getNameByContact(@RequestParam String phoneNumber) {
		ContactEntity contact = contactRepository.findByPhoneNumber(phoneNumber);

		if (contact != null) {
			return ResponseEntity.ok(contact);
		} else {
			return ResponseEntity.notFound().build();
		}
	}
}
