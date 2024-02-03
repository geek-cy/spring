package com.itherima.dao.impl;

import com.itherima.dao.NoteDao;
import lombok.Data;
import lombok.Setter;

import javax.annotation.Resource;

@Resource
@Setter
@Data
public class NoteDaoImpl implements NoteDao {

    private int noteNum;
    @Override
    public void addNote() {
        System.out.println("add note");
    }
}
