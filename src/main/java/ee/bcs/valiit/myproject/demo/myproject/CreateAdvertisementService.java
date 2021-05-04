package ee.bcs.valiit.myproject.demo.myproject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class CreateAdvertisementService {
    @Autowired
    private CreateAdvertisementRepository createAdvertisementRepository;

    public void createAdvertisement(AdvertisementDTO advertisementDTO) {
        createAdvertisementRepository.createAdvertisement(advertisementDTO);
    }

    public List<AdvertisementDTO> getAllAdvertisements() {
        return createAdvertisementRepository.getAllAdvertisements();
    }

    public List<AdvertisementDTO> getAdsByLocation(String location) {
        return createAdvertisementRepository.getAdsByLocation(location);
    }

    public AdvertisementDTO getAdvertisement(int id) {
        return createAdvertisementRepository.getAdvertisement(id);
    }

    public List<AdvertisementDTO> getAdsByPrice(Double priceFrom, Double priceTo) {
        return createAdvertisementRepository.getAdsByPrice(priceFrom, priceTo);
    }

}
