package com.assignment.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.assignment.entity.Contact;
import com.assignment.repository.ContactRepository;

@Controller
@RequestMapping("/auth")
public class ContactController {
	@Autowired
	private ContactRepository contactRepository;

	@GetMapping("/add")
	public String viewPage() {
		return "create_lead";
	}

	@PostMapping("/save")
	public String createContact(@RequestParam("cmd") String cmd, @ModelAttribute Contact contact1,
			 @RequestHeader("Authorization") String authorizationHeader,
			Model model) {
		if (!validateAuthorization(authorizationHeader)) {
			System.out.println("hii hello");
            return "null";
        }
		
		if ("create".equals(cmd)) {
			if (contact1.getFirstName() == null || contact1.getLastName() == null) {
				model.addAttribute("msg", "First Name or Last Name is missing");
				System.out.println("NOT" + contact1.getFirstName());
				return "login";
			} else {
				contactRepository.save(contact1);
				List<Contact> contact = contactRepository.findAll();
				model.addAttribute("contact", contact);
				return "CustomerList";
			}
		} else {
			model.addAttribute("msg", "Invalid command");
			return "login";
		}
	}
	private boolean validateAuthorization(String authorizationHeader) {
        return true;
    }

	@GetMapping("/delete/{uuid}/{cmd}")
	public String delete(@PathVariable("uuid") long LongId, @PathVariable("cmd") String cmd, Model model) {
		// long LongId = Long.parseLong(id);
		if ("delete".equals(cmd)) {
			try {
				Optional<Contact> optionalContact = contactRepository.findById(LongId);
				Contact contact1 = optionalContact.get();

				if (optionalContact.isPresent()) {
					contactRepository.deleteById(LongId);
					List<Contact> contact = contactRepository.findAll();
					System.out.println(contact);
					model.addAttribute("contact", contact);
					model.addAttribute("msg", "Successfully deleted");
					model.addAttribute("contact", contact);

					return "CustomerList";
				} else {
					model.addAttribute("msg", "UUID not found");
					return "CustomerList";
				}
			} catch (NumberFormatException e) {
				model.addAttribute("msg", "Invalid UUID formate");
				return "CustomerList";
			} catch (Exception e) {
				List<Contact> contact = contactRepository.findAll();
				System.out.println(contact);
				model.addAttribute("contact", contact);
				model.addAttribute("msg", "Error not deleted");
				return "CustomerList";
			}
		} else {
			model.addAttribute("msg", "Bad Request");
			return "CustomerList";
		}
	}

	@GetMapping("/edit/{id}")
	public String updatePage(@PathVariable("id") long id, Model model) {
		Optional<Contact> findById = contactRepository.findById(id);
		Contact contact = findById.get();
		model.addAttribute("contact", contact);
		return "updatePage";
	}

	@PostMapping("/update/{id}")
	public String updateById(@PathVariable("id") String id, @RequestParam("cmd") String cmd,
			@ModelAttribute Contact contact1,
			// @RequestHeader("Authorization") String authorizationHeader,
			Model model) {
		System.out.println(Long.parseLong(id));
		if ("update".equals(cmd)) {
			if (id == null) {

				model.addAttribute("msg", "UUID parameter is missing");
				List<Contact> contact = contactRepository.findAll();
				model.addAttribute("contact", contact);
				return "CustomerList";
			}
			if (contact1 == null) {
				model.addAttribute("msg", "Body is empty");
				return "login";
			}
			try {
				// Find and update the contact by UUID
				Optional<Contact> optionalContact = contactRepository.findById(Long.parseLong(id));
				if (optionalContact.isPresent()) {
					Contact existingContact = optionalContact.get();
					existingContact.setFirstName(contact1.getFirstName());
					existingContact.setLastName(contact1.getLastName());
					existingContact.setStreet(contact1.getStreet());
					existingContact.setAddress(contact1.getAddress());
					existingContact.setCity(contact1.getCity());
					existingContact.setState(contact1.getState());
					existingContact.setEmail(contact1.getEmail());
					existingContact.setPhone(contact1.getPhone());
					contactRepository.save(existingContact);
					model.addAttribute("msg", "Successfully Updated");
					List<Contact> contact = contactRepository.findAll();
					model.addAttribute("contact", contact);
					return "CustomerList";
				} else {
					model.addAttribute("msg", "UUID not found");
					return "updatePage";
				}
			} catch (NumberFormatException e) {
				model.addAttribute("msg", "Invalid UUID format");
				return "updatePage";
			} catch (Exception e) {
				model.addAttribute("msg", "Error updating");
				return "updatePage";
			}
		} else {
			model.addAttribute("msg", "Bad Reequest");
			return "updatePage";
		}
	}

}
