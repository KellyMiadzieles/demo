package myproject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import java.util.HashMap;
import java.util.Map;

@org.springframework.stereotype.Repository
public class Repository {

    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

    public void createAdvertisement(AdvertisementDTO advertisementDTO){
        String sql="INSERT INTO advertisement (id, title, description, price, category, location, username, phonenumber, email) VALUES (:dbId, :dbTitle, :dbDescription, :dbPrice, :dbCategory, :dbLocation, :dbUsername, :dbPhoneNumber, :dbEmail)";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put(":dbId", advertisementDTO.getId());
        paramMap.put(":dbTitle", advertisementDTO.getTitle());
        paramMap.put(":dbDescription", advertisementDTO.getDescription());
        paramMap.put(":dbPrice", advertisementDTO.getPrice());
        paramMap.put(":dbCategory", advertisementDTO.getPrice());
        paramMap.put(":dbLocation", advertisementDTO.getLocation());
        paramMap.put(":dbUsername", advertisementDTO.getUsername());
        paramMap.put(":dbPhoneNumber", advertisementDTO.getPhonenumber());
        paramMap.put(":dbEmail", advertisementDTO.getEmail());
        jdbcTemplate.update(sql, paramMap);
    }

}
