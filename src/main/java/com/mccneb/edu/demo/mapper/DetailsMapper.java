package com.mccneb.edu.demo.mapper;
import com.mccneb.edu.demo.model.ApiDetailsResults;
import com.mccneb.edu.demo.model.Plant;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface DetailsMapper {

    @Mapping(source = "apiDetailsResults.id", target = "apiId")
    @Mapping(source = "apiDetailsResults.commonName", target = "plantName")
    @Mapping(source = "apiDetailsResults.type", target = "type")
    @Mapping(source = "apiDetailsResults.dimension", target = "dimension")
    @Mapping(source = "apiDetailsResults.watering", target = "watering")
    @Mapping(source = "apiDetailsResults.sunlight", target = "sunlight")


    Plant mapDetails(ApiDetailsResults apiDetailsResults, Plant plant);
}
