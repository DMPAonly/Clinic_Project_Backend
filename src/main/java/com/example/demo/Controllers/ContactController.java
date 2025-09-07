package com.example.demo.Controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.contact;
import com.example.demo.repository.ContactRepository;

@CrossOrigin(origins = {"http://localhost:5173/"}, methods = {RequestMethod.GET, RequestMethod.POST})
@RestController
@RequestMapping("/contact")
public class ContactController {
    private final ContactRepository contactRepository;

    public ContactController(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }

    @PostMapping("/tryContact")
    public String createContact(@RequestBody contact newContact) {
        contactRepository.save(newContact);
        return "Contact saved";
    }
}
