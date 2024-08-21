package com.mccneb.edu.demo.mapper;

import com.mccneb.edu.demo.model.ApiSpeciesResults;
import com.mccneb.edu.demo.model.Data;
import com.mccneb.edu.demo.model.Plant;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface SpeciesMapper {

    @Mapping(source = "data.id", target = "apiId")
    @Mapping(source = "data.commonName", target = "plantName")
    @Mapping(source = "data.defaultImage.thumbnail", target = "image")

    Plant mapSpecies(Data data);

}
