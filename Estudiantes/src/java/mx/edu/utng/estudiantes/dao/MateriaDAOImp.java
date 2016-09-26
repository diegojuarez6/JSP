/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.edu.utng.estudiantes.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import mx.edu.utng.estudiantes.model.Materia;
import mx.edu.utng.estudiantes.util.UtilDB;

/**
 *
 * @author Diego
 */
public class MateriaDAOImp implements MateriaDAO{

    private Connection connection;
    
    public MateriaDAOImp(){
        connection = UtilDB.getConnection();
    }
    
    @Override
    public void agregarMateria(Materia materia) {
        try {
          String query = "INSERT INTO materias (descripcion, fechaInicio, "
                  + " fechaFin, totalHoras) VALUES (?,?,?,?)";
            PreparedStatement ps = connection.prepareCall(query);
            ps.setString(1, materia.getDescripcion());
            ps.setString(2, materia.getFechaInicio());
            ps.setString(3, materia.getFechaFin());
            ps.setInt(4, materia.getTotalHoras());
            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void borrarMateria(int idMateria) {
        try {
             String query = "DELETE FROM materias WHERE idMateria = ?";
             PreparedStatement ps = connection.prepareCall(query);
             ps.setInt(1, idMateria);
             ps.executeUpdate();
             ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void cambiarMateria(Materia materia) {
    try {
          String query = "UPDATE materias SET descripcion = ?, "
                  + " fechaInicio= ?, fechaFin=?, totalHoras=? WHERE "
                  + " idMateria = ?";
            PreparedStatement ps = connection.prepareCall(query);
            ps.setString(1, materia.getDescripcion());
            ps.setString(2, materia.getFechaInicio());
            ps.setString(3, materia.getFechaFin());
            ps.setInt(4, materia.getTotalHoras());
            ps.setInt(5, materia.getIdMateria());
            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Materia> desplegarMaterias() {
        List<Materia> materias = new ArrayList<Materia>();
        try{
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(
                "SELECT * FROM materias");
            while (resultSet.next()) {
              Materia materia = new Materia(
              resultSet.getInt("idMateria"),
              resultSet.getString("descripcion"),
              resultSet.getString("fechaInicio"),
              resultSet.getString("fechaFin"),
              resultSet.getInt("totalHoras"));
              materias.add(materia);
            }
            resultSet.close();
            statement.close();
        }catch(SQLException e){
            e.printStackTrace();
        }
        return materias;
    }

    @Override
    public Materia elegirMateria(int idMateria) {
       Materia materia = new Materia();
        try{
        PreparedStatement statement = 
                connection.prepareStatement(
                        "SELECT * FROM materias WHERE "
                                + " idMateria = ?");
        statement.setInt(1, idMateria);
        ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
              materia.setIdMateria(
                      resultSet.getInt("idMateria"));
              materia.setDescripcion(
                      resultSet.getString("descripcion"));
              materia.setFechaInicio(
                      resultSet.getString("fechaInicio"));
              materia.setFechaFin(
                      resultSet.getString("fechaFin"));
              materia.setTotalHoras(resultSet.getInt("totalHoras"));
            }
            resultSet.close();
            statement.close();
        }catch(SQLException e){
            e.printStackTrace();
        }
        return materia;
    }
}