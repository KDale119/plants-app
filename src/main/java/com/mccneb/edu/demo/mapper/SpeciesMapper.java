package com.mccneb.edu.demo.mapper;

import com.mccneb.edu.demo.model.ApiDetailsResults;
import com.mccneb.edu.demo.model.ApiSpeciesResults;
import com.mccneb.edu.demo.model.Plant;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface SpeciesMapper {

    @Mapping(source = "apiSpeciesResults.id", target = "plantId")
    @Mapping(source = "apiSpeciesResults.commonName", target = "plantName")
    @Mapping(source = "apiSpeciesResults.defaultImage.thumbnail", target = "image")

    Plant mapSpecies(ApiSpeciesResults apiSpeciesResults, Plant plant);

}
