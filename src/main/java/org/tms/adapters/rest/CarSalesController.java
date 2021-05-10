package org.tms.adapters.rest;

import org.springframework.web.bind.annotation.*;
import org.tms.application.dto.CarDto;
import org.tms.application.services.RegisterCarService;
import org.tms.application.services.FindAllCarsService;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/cars")
public class CarSalesController {

    private final RegisterCarService registerCarService;
    private final FindAllCarsService findAllCarsService;

    CarSalesController(final RegisterCarService registerCarService, final FindAllCarsService findAllCarsService) {
        this.registerCarService = registerCarService;
        this.findAllCarsService = findAllCarsService;
    }

    @GetMapping("/")
    Flux<CarDto> getAllCars() {
        return findAllCarsService.invoke(null);
    }

    @PostMapping("/")
    Mono<CarDto> registerCar(final @RequestBody CarDto carDto) {
        return registerCarService.invoke(carDto);
    }
}
