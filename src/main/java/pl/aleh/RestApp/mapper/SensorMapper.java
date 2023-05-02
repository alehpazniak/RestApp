package pl.aleh.RestApp.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import pl.aleh.RestApp.dto.SensorDTO;
import pl.aleh.RestApp.models.Sensor;

@Mapper
public interface SensorMapper {

  SensorMapper INSTANCE = Mappers.getMapper(SensorMapper.class);

  SensorDTO mapToSensorDTO(Sensor sensor);

  Sensor mapToSensor(SensorDTO sensorDTO);
}
