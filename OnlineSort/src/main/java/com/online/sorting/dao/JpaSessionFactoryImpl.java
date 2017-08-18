/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.online.sorting.dao;


import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;



@Repository
public class JpaSessionFactoryImpl implements JpaSessionFactory {

	@Autowired
	@Qualifier(value = "sessionFactorySorting")
	protected SessionFactory sessionFactorySorting;

	public SessionFactory getSortingSessionFactory() {
		return sessionFactorySorting;
	}

}
