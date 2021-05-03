package ee.bcs.valiit.myproject.demo.myproject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class CreateAdvertisementService {
    @Autowired
    private CreateAdvertisementRepository repository;

    public void createAdvertisement(AdvertisementDTO advertisementDTO) {
        repository.createAdvertisement(advertisementDTO);
    }
}
