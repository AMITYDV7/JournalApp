package com.finex.journal.controller;

import com.finex.journal.Service.JournalEntryService;
import com.finex.journal.entity.JournalEntry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
        return null;
    }

    @PostMapping
    public String createEntry(@RequestBody JournalEntry myEntry){
        journalEntryService.saveEntry(myEntry);
        return "Done";
    }

    @PutMapping
    public JournalEntry updateJournalById(@PathVariable Long id,@RequestBody JournalEntry myEntry){
        return null;
    }


}

