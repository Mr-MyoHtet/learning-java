package com.query.entity.convector;

import java.time.DayOfWeek;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.util.StringUtils;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter
// <List<DayOfWeek>,String>  change list type to string type
public class DaysConvector implements AttributeConverter <List<DayOfWeek>,String> {

	@Override
	public String convertToDatabaseColumn(List<DayOfWeek> attribute) {
		if(attribute !=null) {
			attribute.stream().map(DayOfWeek::name).collect(Collectors.joining(","));
		}
		return null;
	}

	@Override
	public List<DayOfWeek> convertToEntityAttribute(String dbData) {
		if(StringUtils.hasLength(dbData)) {
			Arrays.stream(dbData.split(",")).map(str ->DayOfWeek.valueOf(str)).toList();
		}
		return null;
	}

}
