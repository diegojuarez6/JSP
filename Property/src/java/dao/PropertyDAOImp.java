/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.Property;
import util.UtilDB;

/**
 *
 * @author Diego
 */
public class PropertyDAOImp implements PropertyDAO {

    private Connection connection;

    public PropertyDAOImp() {
        connection = UtilDB.getConnection();
    }

    @Override
    public void agregarProperty(Property property) {
        String sql = "INSERT INTO properties "
                + " (property_key, property_val) "
                + " VALUES(?, ?)";
        try {
            PreparedStatement ps
                    = connection.prepareStatement(sql);
            ps.setString(1, property.getPropertyKey());
            ps.setString(2, property.getPropertyVal());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void borrarProperty(int idSeq) {
        String sql = "DELETE FROM properties WHERE id_seq=?";
        try {
            PreparedStatement ps
                    = connection.prepareStatement(sql);
            ps.setInt(1, idSeq);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void cambiarProperty(Property property) {
        String sql = "UPDATE properties SET "
                + " property_key=?, property_val=?"
                + " WHERE id_seq=?";
        try {
            PreparedStatement ps
                    = connection.prepareStatement(sql);
            ps.setString(1, property.getPropertyKey());
            ps.setString(2, property.getPropertyVal());
            ps.setInt(3, property.getIdSeq());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Property> desplegarProperties() {
        List<Property> properties = new ArrayList<Property>();
        try {
            Statement s = connection.createStatement();
            ResultSet rs = s.executeQuery(
                    "SELECT * FROM properties");
            while (rs.next()) {
                Property property = new Property(
                        rs.getInt("id_seq"),
                        rs.getString("property_key"),
                        rs.getString("property_val"));
                properties.add(property);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return properties;
    }

    @Override
    public Property elegirProperty(int idSeq) {
        Property property = null;
        try {
            PreparedStatement ps
                    = connection.prepareStatement(
                            "SELECT * FROM properties"
                            + " WHERE id_seq=?");
            ps.setInt(1, idSeq);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                property = new Property(
                        rs.getInt("id_seq"),
                        rs.getString("property_key"),
                        rs.getString("property_val"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return property;
    }

}
