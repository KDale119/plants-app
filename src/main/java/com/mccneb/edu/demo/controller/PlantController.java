package com.mccneb.edu.demo.controller;

import com.mccneb.edu.demo.model.Plant;
import com.mccneb.edu.demo.service.PlantService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/plants")
@CrossOrigin
public class PlantController {

    private final PlantService plantService;

    public PlantController(PlantService plantService) {
        this.plantService = plantService;
    }

    @GetMapping
    public ResponseEntity<List<Plant>> getAllPlants() {
        return plantService.getAllPlants();
    }

    @GetMapping("/{plantId}")
    public ResponseEntity<Plant> getPlantById(@PathVariable Integer plantId) {
        return plantService.findPlantById(plantId);
    }

    @PostMapping()
    public ResponseEntity<Plant> createPlant(@RequestBody Plant add) {
        return plantService.addPlant(add);
    }

    @PutMapping("/{plantId}")
    public ResponseEntity<Plant> updatePlant(@PathVariable Integer plantId, @RequestBody Plant update) {
        return plantService.plantUpdate(plantId, update);
    }

    @DeleteMapping("{plantId}")
    public ResponseEntity<Plant> deletePlant(@PathVariable Integer plantId) {
        return plantService.deletePlant(plantId);
    }
}
