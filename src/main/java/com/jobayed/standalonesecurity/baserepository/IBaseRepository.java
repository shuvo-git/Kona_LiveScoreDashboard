package com.jobayed.standalonesecurity.baserepository;


import java.util.Map;

public interface IBaseRepository {
     public <T> T findOneByParams(String sql, Map<String, Object> params, Class<T> entity);
}
