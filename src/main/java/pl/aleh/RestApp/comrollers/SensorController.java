package pl.aleh.RestApp.comrollers;

import static pl.aleh.RestApp.exception.ErrorClientResponse.returnErrorsToClient;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.aleh.RestApp.dto.SensorDTO;
import pl.aleh.RestApp.mapper.SensorMapper;
import pl.aleh.RestApp.models.Sensor;
import pl.aleh.RestApp.services.SensorService;
import pl.aleh.RestApp.util.SensorValidator;

@RestController
@RequestMapping("/sensors")
public class SensorController {

  private final SensorService sensorService;
  private final SensorValidator sensorValidator;

  @Autowired
  public SensorController(final SensorService sensorService, final SensorValidator sensorValidator) {
    this.sensorService = sensorService;
    this.sensorValidator = sensorValidator;
  }

  @PostMapping("/registration")
  public ResponseEntity<HttpStatus> registration(@RequestBody @Valid SensorDTO sensorDTO, BindingResult bindingResult) {
    Sensor sensor = SensorMapper.INSTANCE.mapToSensor(sensorDTO);
    sensorValidator.validate(sensor, bindingResult);

    if (bindingResult.hasErrors()) {
      returnErrorsToClient(bindingResult);
    }

    sensorService.addRegister(sensor);
    return ResponseEntity.ok(HttpStatus.OK);
  }

}
