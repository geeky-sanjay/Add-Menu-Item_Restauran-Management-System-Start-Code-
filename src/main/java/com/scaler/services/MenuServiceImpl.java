package com.scaler.services;

import com.scaler.exceptions.UnAuthorizedAccess;
import com.scaler.exceptions.UserNotFoundException;
import com.scaler.models.*;
import com.scaler.repositories.MenuRepository;
import com.scaler.repositories.UserRepository;

import java.util.Optional;

public class MenuServiceImpl implements MenuService{
    UserRepository userRepository;
    MenuRepository menuRepository;

    public MenuServiceImpl(UserRepository userRepository, MenuRepository menuRepository) {
        this.userRepository = userRepository;
        this.menuRepository = menuRepository;
    }

    @Override
    public MenuItem addMenuItem(long userId, String name, double price, String dietaryRequirement, String itemType, String description) throws UserNotFoundException, UnAuthorizedAccess {
        Optional<User> user = userRepository.findById(userId);
        if(user.isEmpty()){
            throw new UserNotFoundException("User not found");
        }

        if(user.get().getUserType() != UserType.ADMIN){
            throw new UnAuthorizedAccess("unauthorized access");
        }
        MenuItem menuItem = new MenuItem();
        DietaryRequirement dietary = DietaryRequirement.valueOf(dietaryRequirement);
        ItemType type = ItemType.valueOf(itemType);
        menuItem.setName(name);
        menuItem.setPrice(price);
        menuItem.setDietaryRequirement(dietary);
        menuItem.setItemType(type);
        menuItem.setDescription(description);
        return menuRepository.add(menuItem);
    }
}
