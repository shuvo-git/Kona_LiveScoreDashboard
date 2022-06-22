package com.jobayed.standalonesecurity.livescore.dto;

import com.jobayed.standalonesecurity.livescore.model.Item;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@Data
@XmlRootElement(name = "rss")
@AllArgsConstructor @NoArgsConstructor
public class Rss {
    private Channel channel;
}
