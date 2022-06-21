package com.jobayed.standalonesecurity.baserepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import java.util.Map;

@Repository
@RequiredArgsConstructor
@Slf4j
public class BaseRepository implements IBaseRepository {

    private final EntityManager em;

    @Override
    public <T> T findOneByParams(String sql, Map<String, Object> params, Class<T> entity)
    {
        Query query = em.createNativeQuery(sql,entity);

        if (params != null && params.size() > 0) {
            params.forEach((k, v) -> query.setParameter(k, v));
        }

        query.setFirstResult(0).setMaxResults(1);
        try {
            return (T) query.getSingleResult();
        } catch (NoResultException ne) {
            return null;
        }
    }
}
