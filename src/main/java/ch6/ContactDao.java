package ch6;

import java.util.List;

public interface ContactDao {
    String findLastNameById(Long id);
    List<Contact> findAllWithDetail();

}
