package com.journal.JournalController.Controller;


import com.journal.JournalController.entity.JournalEntry;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/journal")
public class JournalentryController {

    private Map<Long, JournalEntry> journalEntries=new HashMap<>();

    @GetMapping
    public List<JournalEntry> getAll()
    {
        return new ArrayList<>(journalEntries.values());
    }

    @PostMapping("/hi")
    public boolean createEntry(@RequestBody JournalEntry myEntry)
    {
        journalEntries.put(myEntry.getId(), myEntry);
        return true;
    }

    @GetMapping("id/{myId}")
    public JournalEntry getJournalEntryById(@PathVariable Long myId)
    {
       return journalEntries.get(myId);
    }

    @DeleteMapping("delete/{myId}")
    public JournalEntry deleteEntryById(@PathVariable Long myId)
        {
            return journalEntries.remove(myId);
        }

        @PutMapping("/update/{myId}")
        public JournalEntry updateEntryById(@PathVariable Long myId, @RequestBody JournalEntry myEntry)
        {
         return  journalEntries.put(myId, myEntry);
        }
}
