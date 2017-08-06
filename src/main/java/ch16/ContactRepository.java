package ch16;

import org.springframework.data.repository.PagingAndSortingRepository;
public interface ContactRepository extends PagingAndSortingRepository<Contact, Long> {
}
