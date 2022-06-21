package com.jobayed.standalonesecurity.livescore.repository;

import com.jobayed.standalonesecurity.livescore.model.Item;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {
    Page<Item> findByTitleContainsOrDescriptionContainsOrLinkContainsOrGuidContains(String keyword1, String keyword2, String keyword3, String keyword4, Pageable pageable);
}
