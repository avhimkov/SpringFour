package ch8;

public interface ContactService {
    List<Contact> findAll();
    List<Contact> findAllWithDetail();
    Contact findByid(Long id);
    Contact save(Contact contact);
    void delete(Contact contact);
}
