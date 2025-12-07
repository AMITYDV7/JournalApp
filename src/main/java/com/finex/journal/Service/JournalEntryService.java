package com.finex.journal.Service;

import com.finex.journal.entity.JournalEntry;
import com.finex.journal.repository.JournalEntryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class JournalEntryService {
@Autowired
    private JournalEntryRepo journalEntryRepo;

public void saveEntry(JournalEntry journalEntry){
    journalEntryRepo.save(journalEntry);
}
}
