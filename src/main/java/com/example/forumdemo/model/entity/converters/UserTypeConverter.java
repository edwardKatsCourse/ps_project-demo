package com.example.forumdemo.model.entity.converters;

import com.example.forumdemo.model.entity.UserType;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = true)
public class UserTypeConverter implements AttributeConverter<UserType, Integer> {

    @Override
    public Integer convertToDatabaseColumn(UserType userType) {
        return userType == null ? UserType.GUEST.getId() : userType.getId();
    }

    @Override
    public UserType convertToEntityAttribute(Integer integer) {
        return UserType.getById(integer);
    }
}
