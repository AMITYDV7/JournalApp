package com.finex.journal.Service;

import com.finex.journal.entity.JournalEntry;
import com.finex.journal.repository.JournalEntryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class JournalEntryService {
@Autowired
    private JournalEntryRepo journalEntryRepo;

public void saveEntry(JournalEntry journalEntry){
    journalEntryRepo.save(journalEntry);
}
public List<JournalEntry> getAll(){
    return journalEntryRepo.findAll();
}

public void deleteById(){

}
}
