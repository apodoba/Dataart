package com.dataart.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "SCRATCH_CARDS")
public class ScratchCard {

    @Id
    @Column(name = "ID")
    @GeneratedValue
    private String id;

    @Column(name = "money")
    private Integer money;

    @Column(name = "enable")
    private Boolean enable;
   
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getMoney() {
		return money;
	}
	
	public void setMoney(int money) {
		this.money = money;
	}

	public void setEnable(boolean enable) {
		this.enable = enable;
	}

	public Boolean getEnable() {
		return enable;
	}
	
}

