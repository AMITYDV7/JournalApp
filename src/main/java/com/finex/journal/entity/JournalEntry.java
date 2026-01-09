package com.finex.journal.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.Date;
@Data
@Document
public class JournalEntry {

    @Id //this is our primary key
    private ObjectId id;
    private String title;
    private LocalDateTime date;
    private String content;

    }




