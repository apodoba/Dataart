package com.dataart.dao;

import com.dataart.domain.ScratchCard;

public interface ScratchCardDAO {
	
	public void setEnable(ScratchCard card, boolean en);
	
	public boolean getEnable(ScratchCard card);
	
	public int getMoney(ScratchCard card);
	
	public ScratchCard getCardById(String id);
}