package pl.aleh.RestApp.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import pl.aleh.RestApp.dto.MeasurementDTO;
import pl.aleh.RestApp.dto.SensorDTO;
import pl.aleh.RestApp.models.Measurement;
import pl.aleh.RestApp.models.Sensor;

@Mapper
public interface MeasurementMapper {

  MeasurementMapper INSTANCE = Mappers.getMapper(MeasurementMapper.class);

  MeasurementDTO mapToMeasurementDTO(Measurement measurement);

  Measurement mapToMeasurement(MeasurementDTO measurementDTO);

  SensorDTO mapToSensorDTO(Sensor sensor);

  Sensor mapToSensor(SensorDTO sensorDTO);

}
