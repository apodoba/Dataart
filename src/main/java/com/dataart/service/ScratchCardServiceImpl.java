package com.dataart.service;
 
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dataart.dao.AccountDAO;
import com.dataart.dao.ScratchCardDAO;
import com.dataart.domain.ScratchCard;
 
@Service
public class ScratchCardServiceImpl implements ScratchCardService {
	
	@Autowired
    private ScratchCardDAO cardDAO;
	
	@Override
	@Transactional
	public void disable(ScratchCard card) {
		cardDAO.setEnable(card, false);		
	}

	@Override
	@Transactional
	public int getMoney(ScratchCard card) {
		return cardDAO.getMoney(card);
	}

	@Override
	@Transactional
	public ScratchCard getCardById(String id) {
		return cardDAO.getCardById(id);
	}
 

}