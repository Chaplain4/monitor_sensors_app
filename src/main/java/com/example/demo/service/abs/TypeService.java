package com.example.demo.service.abs;

import com.example.demo.model.Type;

import java.util.List;

public interface TypeService {
    List<Type> getAllTypes();
    Type getTypeById(Integer id);
    Type saveType(Type type);
    void deleteType(Integer id);
}
