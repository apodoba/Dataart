package com.dataart.service;

import java.util.List;

import com.dataart.dao.ServiceDao;
import com.dataart.domain.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

@org.springframework.stereotype.Service
public class ServicesImpl implements Services{
	
	@Autowired
	private ServiceDao serviceDao;
	
	@Override
	@Transactional
	public List<Service> getServices() {
		return serviceDao.getServices();
	}

}
