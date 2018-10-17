/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendingmachinespringmvc.dao;

import com.sg.vendingmachinespringmvc.model.Item;
import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Lizz
 */
public class VendingMachineDaoJdbcImpl implements VendingMachineDao{
    private JdbcTemplate jdbc;
    
    public void setJdbcTemplate(JdbcTemplate jdbc){
        this.jdbc = jdbc;
    }
    
    private static final String SQL_UPDATE_ITEM
            = "update item set amount = amount - 1 where itemid = ?";
    
     private static final String SQL_SELECT_ITEM_BY_ITEMID
            = "select * from item where itemid = ?";
     
      private static final String SQL_SELECT_ALL_ITEMS
            = "select * from item";

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public Item purchaseItem(int itemId) {
     jdbc.update(SQL_UPDATE_ITEM, itemId);
    
     return getItemById(itemId);
    }

    @Override
    public Item getItemById(int itemId) {
        
        try{
    return jdbc.queryForObject(SQL_SELECT_ITEM_BY_ITEMID, new ItemMapper(), itemId);
        } catch (EmptyResultDataAccessException ex){
            return null;
        }
    }

    @Override
    public List<Item> getAllItems() {
        return jdbc.query(SQL_SELECT_ALL_ITEMS, new ItemMapper());
    }
    
    private static final class ItemMapper implements RowMapper<Item> {

        @Override
        public Item mapRow(ResultSet rs, int i) throws SQLException {
        Item item = new Item();
        item.setItemId(rs.getInt("itemid"));
        item.setName(rs.getString("itemname"));
        item.setAmountInStock(rs.getInt("amount"));
        item.setPrice(new BigDecimal(rs.getString("price")));
        
        return item;
        
        
        }
        
    }
    
}
