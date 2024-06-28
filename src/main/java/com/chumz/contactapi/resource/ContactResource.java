package com.chumz.contactapi.resource;

import com.chumz.contactapi.domain.Contact;
import com.chumz.contactapi.service.ContactService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping("/contacts")
@RequiredArgsConstructor
public class ContactResource {
    private final ContactService contactService;

    @PostMapping
    public ResponseEntity<Contact> createContact(@RequestBody Contact contact) {
        //return ResponseEntity.ok().body(contactService.createContact(contact));
        return ResponseEntity.created(URI.create("/contacts/<user ID")).body(contactService.createContact(contact));
    }

    @GetMapping
    public ResponseEntity<Page<Contact>> getContact(@RequestParam(value = "page", defaultValue = "0") int page,
                                                    @RequestParam(value = "size", defaultValue = "10") int size) {
        return ResponseEntity.ok().body(contactService.getAllContacts(page, size));
    }
}
