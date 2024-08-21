package com.mccneb.edu.demo.mapper;

import com.mccneb.edu.demo.model.ApiDetailsResults;
import com.mccneb.edu.demo.model.Plant;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface PlantMapper {

    @Mapping(source = "apiDetailsResults.id", target = "apiId")
    @Mapping(source = "apiDetailsResults.commonName", target = "plantName")
    @Mapping(source = "apiDetailsResults.type", target = "type")
    @Mapping(target = "plantSunlight", expression = "java(apiDetailsResults.getSunlight() != null && !apiDetailsResults.getSunlight().isEmpty() ? apiDetailsResults.getSunlight().get(0) : null)")
    @Mapping(target = "origin", expression = "java(apiDetailsResults.getOrigin() != null && !apiDetailsResults.getOrigin().isEmpty() ? apiDetailsResults.getOrigin().get(0) : null)")
    @Mapping(target = "propagation", expression = "java(apiDetailsResults.getPropagation() != null && !apiDetailsResults.getPropagation().isEmpty() ? apiDetailsResults.getPropagation().get(0) : null)")
    @Mapping(target = "scientificName", expression = "java(apiDetailsResults.getScientificName() != null && !apiDetailsResults.getScientificName().isEmpty() ? apiDetailsResults.getScientificName().get(0) : null)")
    @Mapping(source = "apiDetailsResults.dimension", target = "dimension")
    @Mapping(source = "apiDetailsResults.watering", target = "plantWatering")
    @Mapping(source = "apiDetailsResults.defaultImage.mediumUrl", target = "image")



    Plant mapDetails(ApiDetailsResults apiDetailsResults, Plant plant);
}
