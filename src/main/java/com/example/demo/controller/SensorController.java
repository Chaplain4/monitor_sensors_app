package com.example.demo.controller;

import com.example.demo.model.Sensor;
import com.example.demo.service.abs.SensorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/sensors")
@Validated
@SpringBootApplication
public class SensorController {

    @Autowired
    private SensorService sensorService;

    @GetMapping
    public List<Sensor> getAllSensors() {
        System.out.println();
        return sensorService.getAllSensors();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Sensor> getSensorById(@PathVariable Integer id) {
        Sensor sensor = sensorService.getSensorById(id);
        return sensor != null ? ResponseEntity.ok(sensor) : ResponseEntity.notFound().build();
    }



    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSensor(@PathVariable Integer id) {
        Sensor existingSensor = sensorService.getSensorById(id);
        if (existingSensor == null) {
            return ResponseEntity.notFound().build();
        }
        sensorService.deleteSensor(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/search/name")
    public List<Sensor> searchSensorsByName(@RequestParam String name) {
        return sensorService.searchSensorsByName(name);
    }

    @GetMapping("/search/model")
    public List<Sensor> searchSensorsByModel(@RequestParam String model) {
        return sensorService.searchSensorsByModel(model);
    }

    @PostMapping("/update/{id}")
    public String updateSensor(@PathVariable Integer id, @RequestBody Sensor updatedSensor) {
        if (sensorService.getSensorById(id) == null) {
            return "No sensor found";
        } else
            updatedSensor.setId(id);
            return sensorService.saveSensor(updatedSensor).toString();
    }

    @PostMapping("/create")
    public ResponseEntity<Sensor> createSensor(@RequestBody Sensor sensor) {
        String name=sensor.getName();
        if (name.isEmpty()||name.length()<3||name.length()>30){
//            return ResponseEntity.badRequest("Name не пустое поле и количество символов не меньше 3 и не превышает 30.",);

        }
//        Sensor createdSensor = sensorService.createSensor(sensor);
        return ResponseEntity.ok(sensor);
    }
}
