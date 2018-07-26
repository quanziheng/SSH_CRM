package cn.itcast.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import cn.itcast.dao.VisitDao;
import cn.itcast.entity.Visit;

@Transactional
public class VisitService {

	private VisitDao visitDao;

	public VisitDao getVisitDao() {
		return visitDao;
	}

	public void setVisitDao(VisitDao visitDao) {
		this.visitDao = visitDao;
	}

	public void addVisit(Visit visit) {
		// TODO Auto-generated method stub
		visitDao.add(visit);
	}

	public List<Visit> findAll() {
		// TODO Auto-generated method stub
		return visitDao.findAll();
	}
}
