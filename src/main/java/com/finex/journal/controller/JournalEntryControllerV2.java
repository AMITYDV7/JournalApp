package com.finex.journal.controller;

import com.finex.journal.Service.JournalEntryService;
import com.finex.journal.entity.JournalEntry;
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



    @PostMapping
    public JournalEntry createEntry(@RequestBody JournalEntry myEntry){
    myEntry.setDate(LocalDateTime.now());
        journalEntryService.saveEntry(myEntry);
        return myEntry;
    }

    @PutMapping
    public JournalEntry updateJournalById(@PathVariable Long id,@RequestBody JournalEntry myEntry){
        return null;
    }


}

