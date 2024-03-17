package com.propertyEditor;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.nio.file.Path;
import java.util.Date;

@Getter
@Setter
@ToString
public class MyBean {

    private Path path;

    private Date date;


}
