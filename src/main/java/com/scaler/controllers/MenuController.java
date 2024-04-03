package com.scaler.controllers;

import com.scaler.dtos.*;
import com.scaler.exceptions.UnAuthorizedAccess;
import com.scaler.exceptions.UserNotFoundException;
import com.scaler.models.MenuItem;
import com.scaler.services.MenuService;

import java.util.List;

public class MenuController {

    private MenuService menuService;

    public MenuController(MenuService menuService) {
        this.menuService = menuService;
    }

    public AddMenuItemResponseDto addMenuItem(AddMenuItemRequestDto requestDto){
        MenuItem menuItem = null;
        AddMenuItemResponseDto responseDto = new AddMenuItemResponseDto();
        try {
            menuItem = menuService.addMenuItem(requestDto.getUserId(), requestDto.getName(), requestDto.getPrice(), requestDto.getDietaryRequirement(), requestDto.getItemType(), requestDto.getDescription());
            responseDto.setStatus(ResponseStatus.SUCCESS);
            responseDto.setMenuItem(menuItem);
            return  responseDto;
        } catch (UserNotFoundException | UnAuthorizedAccess e) {
            responseDto.setStatus(ResponseStatus.FAILURE);
            responseDto.setMenuItem(null);
            return  responseDto;
        }


    }
}
