package ch6;

import java.util.List;

public interface ContactDao {
    List<Contact> findAll();
    List<Contact> findByFirstname(String firstName);
    String findLastNameById(Long id);
    String findFirstNameById(Long id);
    void insert (Contact contact);
    void update (Contact contact);
    void delete (Long contactId);
}
