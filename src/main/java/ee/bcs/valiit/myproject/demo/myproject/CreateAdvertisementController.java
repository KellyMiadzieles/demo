package ee.bcs.valiit.myproject.demo.myproject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api")
public class CreateAdvertisementController {

    @Autowired
    private CreateAdvertisementService createAdvertisementService;

    public static void main(String[] args) {
    }

    @PostMapping("/createAdvertisement/")
    public void createAdvertisement(@RequestBody AdvertisementDTO advertisementDTO) {
        createAdvertisementService.createAdvertisement(advertisementDTO);
    }

    @GetMapping("/getAdsByLocation/{location}")
    public List<AdvertisementDTO> getAdsByLocation(@PathVariable("location") String location) {
        return createAdvertisementService.getAdsByLocation(location);
    }

    @GetMapping("/getAllAdvertisements/")
    public List<AdvertisementDTO> getAllAdvertisements() {
        return createAdvertisementService.getAllAdvertisements();
    }

    @GetMapping("/getAdvertisement/{id}")
    public AdvertisementDTO getAdvertisement(@PathVariable("id") int id) {
        return createAdvertisementService.getAdvertisement(id);
    }


    @GetMapping("/getAdsByPrice/{priceFrom}/{priceTo}")
    public List<AdvertisementDTO> getAdsByPrice(@PathVariable("priceFrom") Double priceFrom,
                                                @PathVariable("priceTo") Double priceTo) {
        return createAdvertisementService.getAdsByPrice(priceFrom, priceTo);
    }

    @GetMapping("/getAdsByCategory/{category}")
    public List<AdvertisementDTO> getAdsByCategory(@PathVariable("category") String category) {
        return createAdvertisementService.getAdsByCategory(category);
    }

    @GetMapping("/filterAdsByPriceCategoryLocation/")
    public List<AdvertisementDTO> filterAdsByPriceCategoryLocation(@RequestParam(value = "a", required = false) String category,
                                                                   @RequestParam(value = "b", required = false) String location,
                                                                   @RequestParam(value = "c", required = false) Double priceFrom,
                                                                   @RequestParam(value = "d", required = false) Double priceTo,
                                                                   @RequestParam(value = "e", required = false) String input) {
        return createAdvertisementService.filterAdsByPriceCategoryLocation(category, location, priceFrom, priceTo, input);
    }

    @GetMapping("/searchAdsByTitleDescription/{input}")
    public List<AdvertisementDTO> searchAdsByTitleDescription(@PathVariable("input") String input) {
        return createAdvertisementService.searchAdsByTitleDescription(input);
    }


}
