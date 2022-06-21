package com.jobayed.standalonesecurity.livescore.service;

import com.jobayed.standalonesecurity.baserepository.IBaseRepository;
import com.jobayed.standalonesecurity.livescore.model.Item;
import com.jobayed.standalonesecurity.livescore.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import javax.xml.transform.stream.StreamSource;
import java.io.Reader;
import java.io.StringReader;
import java.util.*;

@Service
@Slf4j
@RequiredArgsConstructor
public class ItemService {

    private final ItemRepository itemRepository;
    private final IBaseRepository repository;
    private static final String LIVE_SCORE_URL = "http://static.cricinfo.com/rss/livescores.xml";
    private final RestTemplate restTemplate = new RestTemplate();

    @Scheduled(cron = "0 */5 * * * *") //Every 5 mins
    public void loadItem() {
        log.info("Scheduler Started at: " + new Date().toLocaleString());

        String channel = restTemplate.getForObject(LIVE_SCORE_URL, String.class);

        List<Item> items = new ArrayList<Item>();
        try {
            JAXBContext jc = JAXBContext.newInstance(Item.class);

            Reader reader = new StringReader(channel);
            XMLInputFactory factory = XMLInputFactory.newInstance();

            XMLStreamReader xsr = factory.createXMLStreamReader(reader);


            Unmarshaller unmarshaller = jc.createUnmarshaller();
            while (xsr.getEventType() != XMLStreamReader.END_DOCUMENT) {
                if (xsr.isStartElement() && "item".equals(xsr.getLocalName())) {
                    Item item = (Item) unmarshaller.unmarshal(xsr);
                    items.add(item);

                    this.saveItem(item);
                }
                xsr.next();
            }

            System.out.println(items.size());

        } catch (JAXBException | XMLStreamException e) {
            e.printStackTrace();
        }
    }

    public Item saveItem(Item item) {
        log.info("Saving Item with guid: " + item.getGuid());
        return itemRepository.save(item);
    }

    public Item getOneItem(String id) {
        String sql = "Select * from items i where i.guid = :guid";
        Map<String, Object> params = new HashMap<>();
        params.put("guid",id);
        return repository.findOneByParams(sql,params,Item.class);
    }

    public Page<Item> getItems(int pageNumber, int pageSize) {
        return itemRepository.findAll(PageRequest.of(pageNumber, pageSize));
    }

    public Page<Item> searchItems(int pageNumber, int pageSize, String keyword) {
        System.out.println(keyword);
        return itemRepository.findByTitleContainsOrDescriptionContainsOrLinkContainsOrGuidContains(keyword, keyword, keyword, keyword, PageRequest.of(pageNumber, pageSize));
    }

}
