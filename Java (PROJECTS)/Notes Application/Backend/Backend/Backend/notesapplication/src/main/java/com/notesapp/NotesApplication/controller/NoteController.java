package com.notesapp.NotesApplication.controller;

import com.notesapp.NotesApplication.entity.Note;
import com.notesapp.NotesApplication.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/notes")
@CrossOrigin
public class NoteController {
    @Autowired
    private NoteService noteService;

    @GetMapping
    public List<Note> getNotes(@AuthenticationPrincipal UserDetails user) {
        return noteService.getUserNotes(user.getUsername());
    }

    @PostMapping
    public Note createNote(@AuthenticationPrincipal UserDetails user, @RequestBody Note note) {
        return noteService.createNote(user.getUsername(), note);
    }
}
