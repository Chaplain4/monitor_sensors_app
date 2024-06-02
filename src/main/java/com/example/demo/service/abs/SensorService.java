package com.example.demo.service.abs;

import com.example.demo.model.Sensor;

import java.util.List;

public interface SensorService {
    List<Sensor> getAllSensors();
    Sensor getSensorById(Integer id);
    Sensor saveSensor(Sensor sensor);
    void deleteSensor(Integer id);
    List<Sensor> searchSensorsByName(String name);
    List<Sensor> searchSensorsByModel(String model);

}
