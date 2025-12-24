package com.finex.journal.controller;

import com.finex.journal.JournalApplication;
import com.finex.journal.Service.JournalEntryService;
import com.finex.journal.entity.JournalEntry;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Id;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;


@RestController
@RequestMapping("/journal")
public class JournalEntryControllerV2 {

@Autowired
private JournalEntryService journalEntryService;

@GetMapping
public String togetmethod(){
    return "api is working properly";
}

    @GetMapping("/get")
    public List<JournalEntry> getAll(){
        return journalEntryService.getAll();
    }


    @GetMapping("id/{myId}")
    public JournalEntry getJournalEntryById(@PathVariable ObjectId myId){
        return journalEntryService.findMyId(myId).orElse(null);
    }



    @PostMapping
    public JournalEntry createEntry(@RequestBody JournalEntry myEntry){
    myEntry.setDate(LocalDateTime.now());
        journalEntryService.saveEntry(myEntry);
        return myEntry;
    }

    @PutMapping("/id/{id}")
    public JournalEntry updateJournalById(@PathVariable ObjectId id,@RequestBody JournalEntry newEntry){
        JournalEntry old = journalEntryService.findMyId(id).orElse(null);
        if(old !=null){
            old.setTitle(newEntry.getTitle() != null && !newEntry.getTitle().equals("") ? newEntry.getTitle() : old.getTitle());
            old.setContent(newEntry.getContent() != null && !newEntry.getContent().equals("") ? newEntry.getContent() : old.getContent());

        }
        journalEntryService.saveEntry(old);
        return old;
    }


    @DeleteMapping("id/{myId}")
    public String deleteEntity(@PathVariable ObjectId myId){
      journalEntryService.deleteById(myId);
      return "Deleting is done from database";
    }

}

