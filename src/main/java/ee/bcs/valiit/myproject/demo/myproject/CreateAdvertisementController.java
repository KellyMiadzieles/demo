package ee.bcs.valiit.myproject.demo.myproject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping ("api")
public class CreateAdvertisementController {

    @Autowired
    private CreateAdvertisementService createAdvertisementService;

    public static void main(String[] args) {
    }
    @PostMapping("/createAdvertisement/")
    public void createAdvertisement(@RequestBody AdvertisementDTO advertisementDTO){
        createAdvertisementService.createAdvertisement(advertisementDTO);
    }

    @GetMapping("/getAllAdvertisements/")
    public List<AdvertisementDTO> getAllAdvertisements(){
        return createAdvertisementService.getAllAdvertisements();
    }

    @GetMapping("/getAdvertisement/{id}")
    public AdvertisementDTO getAdvertisement(@PathVariable ("id") int id){
        return createAdvertisementService.getAdvertisement(id);
    }
}
