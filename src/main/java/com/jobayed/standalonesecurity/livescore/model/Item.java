package com.jobayed.standalonesecurity.livescore.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "items")
@Data
@NoArgsConstructor @AllArgsConstructor
@XmlRootElement(name = "item")
public class Item {

    private String title;
    private String link;
    private String description;

    @Id
    private String guid;
}
