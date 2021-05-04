package ee.bcs.valiit.myproject.demo.myproject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class CreateAdvertisementRepository {

    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

    public void createAdvertisement(AdvertisementDTO advertisementDTO){
        String sql="INSERT INTO advertisement (title, description, price, category, location, username, phonenumber, email)" +
                " VALUES (:dbTitle, :dbDescription, :dbPrice, :dbCategory, :dbLocation, :dbUsername, :dbPhoneNumber, :dbEmail)";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("dbTitle", advertisementDTO.getTitle());
        paramMap.put("dbDescription", advertisementDTO.getDescription());
        paramMap.put("dbPrice", advertisementDTO.getPrice());
        paramMap.put("dbCategory", advertisementDTO.getPrice());
        paramMap.put("dbLocation", advertisementDTO.getLocation());
        paramMap.put("dbUsername", advertisementDTO.getUsername());
        paramMap.put("dbPhoneNumber", advertisementDTO.getPhonenumber());
        paramMap.put("dbEmail", advertisementDTO.getEmail());
        jdbcTemplate.update(sql, paramMap);
    }

    public List<AdvertisementDTO> saveAdvertisement () {
        //String sql = "SELECT * FROM advertisement";


        String sql = "SELECT * FROM advertisement WHERE id=:dbId";

        return jdbcTemplate.query(sql, new HashMap(), new AdvertisementRowMapper());

    }









}
