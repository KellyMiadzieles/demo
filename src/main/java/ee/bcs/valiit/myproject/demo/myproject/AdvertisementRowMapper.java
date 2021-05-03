package ee.bcs.valiit.myproject.demo.myproject;


import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AdvertisementRowMapper implements RowMapper <AdvertisementDTO> {


    @Override
    public AdvertisementDTO mapRow(ResultSet resultSet, int i) throws SQLException {

        AdvertisementDTO response = new AdvertisementDTO();
        response.setTitle(resultSet.getString("title"));
        response.setDescription(resultSet.getString("description"));
        response.setPrice(resultSet.getDouble("price"));
        response.setCategory(resultSet.getString("category"));
        response.setLocation(resultSet.getString("location"));
        response.setUsername(resultSet.getString("username"));
        response.setPhonenumber(resultSet.getString("phonenumber"));
        response.setEmail(resultSet.getString("email"));

        return response;
    }
}
