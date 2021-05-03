package ee.bcs.valiit.myproject.demo.myproject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
//@RequestMapping ("api")
public class CreateAdvertisementController {

    @Autowired
    private CreateAdvertisementService service;

    public static void main(String[] args) {
    }
    @PostMapping("/createAdvertisement/")
    public void createAdvertisement(@RequestBody AdvertisementDTO advertisementDTO){
        service.createAdvertisement(advertisementDTO);
    }
}
