/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.online.sorting.dao;

import org.hibernate.SessionFactory;

public interface JpaSessionFactory {
    
    public SessionFactory getSortingSessionFactory();


}
