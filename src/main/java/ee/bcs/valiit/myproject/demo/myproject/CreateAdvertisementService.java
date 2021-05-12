package ee.bcs.valiit.myproject.demo.myproject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Service

public class CreateAdvertisementService {
    @Autowired
    private CreateAdvertisementRepository createAdvertisementRepository;

    @Autowired
    private PhotoHibernateRepository photoHibernateRepository;

    public void createAdvertisement(AdvertisementDTO advertisementDTO) {
        createAdvertisementRepository.createAdvertisement(advertisementDTO);
    }

    public void savePhoto(MultipartFile file) throws IOException {
        PhotoDatabaseEntity photoDatabase = new PhotoDatabaseEntity();
        photoDatabase.setPhoto(file.getBytes());
        photoHibernateRepository.save(photoDatabase);


    }
    public void getPhoto(Integer id, HttpServletResponse response) throws IOException {
        PhotoDatabaseEntity photo= photoHibernateRepository.findById(id).get();
        response.setHeader ("Photo", "filename=\""+photo.getId()+"\"");
       // response.setContentType();
        response.setContentLength(photo.getPhoto().length);
        response.getOutputStream().write(photo.getPhoto());
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

    public List<AdvertisementDTO> getAdsByCategory(String category) {
        return createAdvertisementRepository.getAdsByCategory(category);

    }

    public List<AdvertisementDTO> filterAdsByPriceCategoryLocation(String category, String location, Double priceFrom, Double priceTo, String input, String orderByColumn, String orderByDirection) {
        return createAdvertisementRepository.filterAdsByPriceCategoryLocation(category, location, priceFrom, priceTo, input, orderByColumn, orderByDirection);
    }

    public List<AdvertisementDTO> searchAdsByTitleDescription(String input) {
        return createAdvertisementRepository.searchAdsByTitleDescription(input);
    }


}
