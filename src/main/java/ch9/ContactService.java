package ch9;

import java.util.List;

public interface ContactService {
    List<Contact> findAll();
    Contact finddById(Long id);
    Contact save(Contact contact);
    long contactAll();
}
