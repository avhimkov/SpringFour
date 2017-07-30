package ch15;

import ch14.ContactService;
import org.springframework.beans.factory.annotation.Autowired;

public class AppStaticsImpl implements AppStatistic {
    @Autowired
    private ContactService contactService;

    @Override
    public int getTotalContactCount() {
        return contactService.findAll().size();
    }
}
