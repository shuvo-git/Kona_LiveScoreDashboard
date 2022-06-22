package com.jobayed.standalonesecurity.livescore.dto;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.jobayed.standalonesecurity.livescore.model.Item;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "channel")
@XmlAccessorType(XmlAccessType.FIELD)
@Data
@NoArgsConstructor @AllArgsConstructor
public class Channel implements Serializable {
    private String  title;
    private String  ttl;
    private String  link;
    private String  description;
    private String  copyright;
    private String  language;
    private String  pubDate;

    @JacksonXmlElementWrapper(useWrapping = false)
    private List<Item> item = new ArrayList<>();
}
