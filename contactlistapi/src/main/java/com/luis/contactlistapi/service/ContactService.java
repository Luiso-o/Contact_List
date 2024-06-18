package com.luis.contactlistapi.service;

import com.luis.contactlistapi.document.Contact;
import com.luis.contactlistapi.dto.ContactDto;
import com.luis.contactlistapi.exception.ResourceNotFoundException;
import com.luis.contactlistapi.repository.ContactRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@AllArgsConstructor
@Service
public class ContactService {

    private final ContactRepository contactRepository;
    private final ModelMapper mapper;

    public Iterable<Contact> findAll(){
        return contactRepository.findAll();
    }

    public Contact findById(String id) {
        return contactRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Contact not found with id " + id));
    }

    public Contact create(ContactDto contactDto){
        Contact contact = mapper.map(contactDto, Contact.class);
        contact.setCreatedAt(LocalDate.now());
        return contactRepository.save(contact);
    }

    public Contact update(String id, ContactDto contactDto){
        Contact contactFromDb = findById(id);
        mapper.map(contactDto, contactFromDb);
        return contactRepository.save(contactFromDb);
    }

    public void delete(String id){
        Contact contactFromDb = findById(id);
        contactRepository.delete(contactFromDb);
    }
}
