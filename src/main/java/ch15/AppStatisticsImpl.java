package ch15;

import ch12.ContactService;
import org.springframework.beans.factory.annotation.Autowired;

public class AppStatisticsImpl implements AppStatistic {
    @Autowired
    private ContactService contactService;

    @Override
    public int getTotalContactCount() {
        return contactService.findAll().size();
    }
}
