package myproject;

import org.springframework.beans.factory.annotation.Autowired;

@org.springframework.stereotype.Service

public class Service {
    @Autowired
    private Repository repository;

    public void createAdvertisement(AdvertisementDTO advertisementDTO) {
        repository.createAdvertisement(advertisementDTO);
    }
}
