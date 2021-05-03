package myproject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
//@RequestMapping ("api")
public class Controller {

    @Autowired
    private Service service;

    public static void main(String[] args) {
    }
    @PostMapping("/createAdvertisement/")
    public void createAdvertisement(@RequestBody AdvertisementDTO advertisementDTO){
        service.createAdvertisement(advertisementDTO);
    }
}
