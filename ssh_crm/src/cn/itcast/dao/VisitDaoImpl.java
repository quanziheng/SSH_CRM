package cn.itcast.dao;

import java.util.List;

import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import cn.itcast.entity.User;
import cn.itcast.entity.Visit;

public class VisitDaoImpl extends HibernateDaoSupport implements VisitDao {

	@Override
	public void add(Visit visit) {
		// TODO Auto-generated method stub
		
		this.getHibernateTemplate().save(visit);
	}

	//拜访列表
	@Override
	public List<Visit> findAll() {
				
		return (List<Visit>) this.getHibernateTemplate().find("from Visit");
	}

	

}
