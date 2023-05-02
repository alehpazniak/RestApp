package pl.aleh.RestApp.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import pl.aleh.RestApp.models.Sensor;
import pl.aleh.RestApp.services.SensorService;

@Component
public class SensorValidator implements Validator {

  private final SensorService sensorService;

  @Autowired
  public SensorValidator(final SensorService sensorService) {
    this.sensorService = sensorService;
  }

  @Override
  public boolean supports(Class<?> clazz) {
    return Sensor.class.equals(clazz);
  }

  @Override
  public void validate(Object target, Errors errors) {
    Sensor sensor = (Sensor) target;

    if (sensorService.findByName(sensor.getName()).isPresent()) {
      errors.rejectValue("name", "Sensor with that name already exists");
    }
  }
  
}
