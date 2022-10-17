package com.mintic.usa.AlquilerBarcos.Web;

import com.mintic.usa.AlquilerBarcos.Modelo.Reservation;
import com.mintic.usa.AlquilerBarcos.Service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/Reservation")
@CrossOrigin(origins="*", methods = {RequestMethod.GET, RequestMethod.PUT, RequestMethod.POST, RequestMethod.DELETE})
public class ReservationController {
    @Autowired
    private ReservationService reservationService;

    @GetMapping("/all")
    public List<Reservation> getReservations(){
        return reservationService.getAll();
    }
    @GetMapping("/{id}")
    public Optional<Reservation> getReservation(@PathVariable("id")int id){
        return reservationService.getReservation(id);
    }
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Reservation save(@RequestBody Reservation reservation){
        return reservationService.save(reservation);
    }
    @PutMapping("/update")
    public Reservation update(@RequestBody Reservation reservation){
        return reservationService.update(reservation);
    }
    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable("id") int id){
        return reservationService.delete(id);
    }

}
