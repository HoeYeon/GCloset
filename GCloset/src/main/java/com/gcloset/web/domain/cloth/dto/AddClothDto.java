package com.gcloset.web.domain.cloth.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class AddClothDto {
    private List<ClothDto> clothDtoList;
}
