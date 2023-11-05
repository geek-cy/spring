package com.itherima.service.impl;

import com.itherima.dao.NoteDao;
import com.itherima.service.NoteService;
import lombok.Setter;

@Setter
public class NoteServiceImpl implements NoteService {

    private NoteDao noteDao;

    @Override
    public void addNote() {
        noteDao.addNote();
    }
}
