/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.avectis.transportcontrol.DAO;

import com.avectis.transportcontrol.entity.Car;
import com.avectis.transportcontrol.entity.Card;
import java.util.List;

/**
 *
 * @author DPoplauski
 */
public interface CardDAO {

    public void Update(Object object);
    public Card createCard();
    public Card createCard(Car car, long cardNumber, int accessLevel, int state);
    public Card getCard(Long id);
    public List<Card> getCards();
    public void deleteCard(Card card);
}
