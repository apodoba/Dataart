package com.dataart.service;

import com.dataart.domain.ScratchCard;

public interface ScratchCardService {
	
	public void disable(ScratchCard card);

	public int getMoney(ScratchCard card);
	
	public ScratchCard getCardById(String id);
}