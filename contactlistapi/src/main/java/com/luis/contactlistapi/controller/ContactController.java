package com.luis.contactlistapi.controller;

import com.luis.contactlistapi.document.Contact;
import com.luis.contactlistapi.dto.ContactDto;
import com.luis.contactlistapi.service.ContactService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/contact")
@AllArgsConstructor
public class ContactController {

    private final ContactService contactService;

    @GetMapping("/list")
    public Iterable<Contact> list(){
        return contactService.findAll();
    }

    @GetMapping("{id}")
    public Contact get(@PathVariable String id){
        return contactService.findById(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public Contact create(@Validated @RequestBody ContactDto contactDto){
        return contactService.create(contactDto);
    }

    @PutMapping("/{id}")
    public Contact update(@PathVariable String id,@Validated @RequestBody ContactDto contactDto){
        return contactService.update(id, contactDto);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id){
        contactService.delete(id);
    }
}
