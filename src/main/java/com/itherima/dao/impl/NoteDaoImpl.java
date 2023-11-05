package com.itherima.dao.impl;

import com.itherima.dao.NoteDao;
import lombok.Setter;

@Setter
public class NoteDaoImpl implements NoteDao {

    private int noteNum;
    @Override
    public void addNote() {
        System.out.println("add note");
    }
}
