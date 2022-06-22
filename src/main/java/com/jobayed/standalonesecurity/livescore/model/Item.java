package com.jobayed.standalonesecurity.livescore.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

@Entity
@Table(name = "items")
@Data
@NoArgsConstructor @AllArgsConstructor
@XmlRootElement(name = "item")
public class Item implements Serializable {

    private String title;
    private String link;
    private String description;

    @Id
    private String guid;
}
