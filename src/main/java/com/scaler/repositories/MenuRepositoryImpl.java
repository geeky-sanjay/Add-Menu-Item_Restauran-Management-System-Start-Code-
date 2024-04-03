package com.scaler.repositories;

import com.scaler.models.DietaryRequirement;
import com.scaler.models.MenuItem;

import java.util.ArrayList;
import java.util.List;

public class MenuRepositoryImpl implements MenuRepository{

    List<MenuItem> menuItems = new ArrayList<>();
    @Override
    public MenuItem add(MenuItem menuItem) {
         menuItems.add(menuItem);
         return menuItem;
    }

    @Override
    public List<MenuItem> getAll() {
        return menuItems;
    }

    @Override
    public List<MenuItem> getByDietaryRequirement(DietaryRequirement dietaryRequirement) {
        List<MenuItem> itemList = new ArrayList<>();
        for(MenuItem menuItem:menuItems){
            if(menuItem.getDietaryRequirement() == dietaryRequirement){
                itemList.add(menuItem);
            }
        }
        return itemList;
    }
}
