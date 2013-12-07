package com.dataart.dao;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dataart.domain.ScratchCard;

@Repository
public class ScratchCardDAOImpl implements ScratchCardDAO {

    @Autowired
    private SessionFactory sessionFactory;
    
    @Override
    public void setEnable(ScratchCard card, boolean en) {
    	card.setEnable(en);
		sessionFactory.getCurrentSession().merge(card);
    }

    @Override
    public boolean getEnable(ScratchCard card) {
    	return card.getEnable();
	}
    
    @Override
    public int getMoney(ScratchCard card){
    	return (int) card.getMoney();
    }
    
	@Override
    public ScratchCard getCardById(String id){
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(ScratchCard.class);
		criteria.add(Restrictions.eq("id", id));
		return  (ScratchCard) criteria.uniqueResult();
    }
}