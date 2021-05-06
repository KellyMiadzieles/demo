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

    public void createAdvertisement(AdvertisementDTO advertisementDTO) {
        String sql = "INSERT INTO advertisement (title, description, price, category, location, username, phonenumber, email)" +
                " VALUES (:dbTitle, :dbDescription, :dbPrice, :dbCategory, :dbLocation, :dbUsername, :dbPhoneNumber, :dbEmail)";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("dbTitle", advertisementDTO.getTitle());
        paramMap.put("dbDescription", advertisementDTO.getDescription());
        paramMap.put("dbPrice", advertisementDTO.getPrice());
        paramMap.put("dbCategory", advertisementDTO.getCategory());
        paramMap.put("dbLocation", advertisementDTO.getLocation());
        paramMap.put("dbUsername", advertisementDTO.getUsername());
        paramMap.put("dbPhoneNumber", advertisementDTO.getPhonenumber());
        paramMap.put("dbEmail", advertisementDTO.getEmail());
        jdbcTemplate.update(sql, paramMap);
    }

    public List<AdvertisementDTO> getAllAdvertisements() {
        String sql = "SELECT * FROM advertisement";
        return jdbcTemplate.query(sql, new HashMap(), new AdvertisementRowMapper());
    }

    public AdvertisementDTO getAdvertisement( int id) {
        String sql = "SELECT * FROM advertisement WHERE id=:dbId";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("dbId", id);
        return jdbcTemplate.queryForObject(sql, paramMap, new AdvertisementRowMapper());
    }

  public List<AdvertisementDTO> getAdsByPrice(Double priceFrom, Double priceTo) {
        String sql = "SELECT * FROM advertisement WHERE true ";
        Map<String, Object> paramMap = new HashMap<>();
        if (priceFrom != null) {
            sql += "AND :priceFrom <= price ";
            paramMap.put("priceFrom", priceFrom);
        }
        if (priceTo != null) {
            sql += "AND price <= :priceTo ";
            paramMap.put("priceTo", priceTo);
        }
        return jdbcTemplate.query(sql, paramMap, new AdvertisementRowMapper());
    }
    public List <AdvertisementDTO> getAdsByCategory(String category){
        String sql = "SELECT * FROM advertisement WHERE category=:dbCategory";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("dbCategory", category);
        return jdbcTemplate.query(sql, paramMap, new AdvertisementRowMapper());
    }
    public List <AdvertisementDTO> getAdsByLocation(String location){
        String sql = "SELECT * FROM advertisement WHERE location=:dbLocation";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("dbLocation", location);
        return jdbcTemplate.query(sql, paramMap, new AdvertisementRowMapper());
    }

    public List<AdvertisementDTO> filterAdsByPriceCategoryLocation (String category, String location, Double priceFrom, Double priceTo){
        String sql = "SELECT * FROM advertisement WHERE true ";
        Map<String, Object> paramMap = new HashMap<>();
        sql+= "AND :dbCategory = category ";
        paramMap.put("dbCategory", category);
        sql += "AND :dbLocation = location ";
        paramMap.put("dbLocation", location);
        if (priceFrom != null) {
            sql += "AND :priceFrom <= price ";
            paramMap.put("priceFrom", priceFrom);
        }
        if (priceTo != null) {
            sql += "AND price <= :priceTo ";
            paramMap.put("priceTo", priceTo);
        }
        return jdbcTemplate.query(sql, paramMap, new AdvertisementRowMapper());
    }

    public List <AdvertisementDTO> searchAdsByTitleDescription(String input){
        String sql = "SELECT * FROM advertisement WHERE title like :dbTitle OR description like :dbTitle";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("dbTitle", "%" + input + "%");
        return jdbcTemplate.query(sql, paramMap, new AdvertisementRowMapper());
    }



}
