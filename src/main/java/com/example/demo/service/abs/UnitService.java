package com.example.demo.service.abs;

import com.example.demo.model.Unit;

import java.util.List;

public interface UnitService {
    List<Unit> getAllUnits();
    Unit getUnitById(Integer id);
    Unit saveUnit(Unit unit);
    void deleteUnit(Integer id);
}
