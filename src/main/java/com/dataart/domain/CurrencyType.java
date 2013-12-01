package com.dataart.domain;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "CURRENCY_TYPE")
public class CurrencyType {
	@Id
	@Column(name = "ID")
	@GeneratedValue
	private Integer id;

	@Column(name = "NAME")
	private String name;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "currencyType")
	private Set<Account> accounts;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Account> getAccounts() {
		return accounts;
	}

	public void setAccounts(Set<Account> accounts) {
		this.accounts = accounts;
	}
}
