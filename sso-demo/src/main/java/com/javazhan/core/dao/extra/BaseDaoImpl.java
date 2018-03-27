package com.javazhan.core.dao.extra;

import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;

public class BaseDaoImpl extends SqlSessionDaoSupport implements BaseDao {

	public int delete(String sqlmapper, Object obj) {
		return this.getSqlSession().delete(sqlmapper, obj);
	}

	public int insert(String sqlmapper, Object obj) {
		return this.getSqlSession().insert(sqlmapper, obj);
	}

	public List<?> query(String sqlmapper, Object obj) {
		return this.getSqlSession().selectList(sqlmapper, obj);
	}

	public int update(String sqlmapper, Object obj) {
		return this.getSqlSession().update(sqlmapper, obj);
	}

	public Object queryOne(String sqlmapper, Object obj) {
		return this.getSqlSession().selectOne(sqlmapper,obj);
	}

	public List<?> query(String sqlmapper) {		
		return this.getSqlSession().selectList(sqlmapper);
	}

	public Integer queryTotal(String sqlmapper, Object obj) {		
		return (Integer)this.getSqlSession().selectOne(sqlmapper,obj);
	}
	public Integer queryTotal(String sqlmapper) {		
		return (Integer)this.getSqlSession().selectOne(sqlmapper);
	}
	@Override
	public Double queryMoney(String sqlmapper) {
		// TODO Auto-generated method stub
		return this.getSqlSession().selectOne(sqlmapper);
	}

	@Override
	public Double queryMoney(String sqlmapper, Object map) {
		// TODO Auto-generated method stub
		return (Double)this.getSqlSession().selectOne(sqlmapper,map);
	}


}
