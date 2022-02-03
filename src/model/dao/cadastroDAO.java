/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.bean.cadastro;

/**
 *
 * @author Hugo
 */
public class cadastroDAO {
    
    public void create(cadastro C){
    
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("INSERT INTO cadastros(nome,endereco,email,CPF,RG,telefone,genero,senha,FunGe)VALUES(?,?,?,?,?,?,?,?,?)");
                stmt.setString(1, C.getNome());
                stmt.setString(2, C.getEndereco());
                stmt.setString(3, C.getEmail());
                stmt.setInt(4, C.getCPF());
                stmt.setInt(5, C.getRG());
                stmt.setInt(6, C.getTelefone());
                stmt.setString(7, C.getGenero());
                stmt.setString(8, C.getSenha());
                stmt.setBoolean(9, C.isFunge());
                
                stmt.executeUpdate();
            
                JOptionPane.showMessageDialog(null,"Salvo com sucesso!");
               
                    } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro ao salvar  " +ex);
        } finally {
        ConnectionFactory.CloseConnetion(con ,stmt);
        }
    }
    public void update(cadastro C){
    
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("UPDATE cadastros SET nome = ?,endereco = ?,email = ?,CPF = ?,RG = ? ,telefone = ?,genero = ?,senha = ?,FunGe = ? WHERE id_conta = ?");
                stmt.setString(1, C.getNome());
                stmt.setString(2, C.getEndereco());
                stmt.setString(3, C.getEmail());
                stmt.setInt(4, C.getCPF());
                stmt.setInt(5, C.getRG());
                stmt.setInt(6, C.getTelefone());
                stmt.setString(7, C.getGenero());
                stmt.setString(8, C.getSenha());
                stmt.setBoolean(9, C.isFunge());
                stmt.setInt(10, C.getId_conta());
                
                stmt.executeUpdate();
            
                JOptionPane.showMessageDialog(null,"Atualização concluida!");
               
                    } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro ao salvar  " +ex);
        } finally {
        ConnectionFactory.CloseConnetion(con ,stmt);
        }
    }
    public void delete(cadastro C){
    
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("DELETE FROM cadastros WHERE id_conta = ?");
                
                stmt.setInt(1, C.getId_conta());
                
                stmt.executeUpdate();
            
                JOptionPane.showMessageDialog(null,"Dados excluidos!");
               
                    } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro ao deletar  " +ex);
        } finally {
        ConnectionFactory.CloseConnetion(con ,stmt);
        }
    }
    
    public List<cadastro> read(){
        
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<cadastro> cadastros = new ArrayList<>();
        
        try {
            stmt = con.prepareStatement("SELECT * FROM cadastros");
            rs = stmt.executeQuery();
            
            while (rs.next()) {
                
                cadastro cadastro = new cadastro();
                
                cadastro.setId_conta(rs.getInt("id_conta"));
                cadastro.setNome(rs.getString("nome"));
                cadastro.setEndereco(rs.getString("endereco"));
                cadastro.setEmail(rs.getString("email"));
                cadastro.setCPF(rs.getInt("CPF"));
                cadastro.setRG(rs.getInt("RG"));
                cadastro.setTelefone(rs.getInt("telefone"));
                cadastro.setSenha(rs.getString("senha"));
                cadastro.setGenero(rs.getString("genero"));
                cadastro.setFunge(rs.getBoolean("FunGe"));
                cadastros.add(cadastro);
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(cadastroDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
        ConnectionFactory.CloseConnetion(con ,stmt, rs);
        }
    
        return cadastros;
    
    }
    public boolean checkLogin(String login, String senha) {

        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        boolean check = false;

        try {

            stmt = con.prepareStatement("SELECT * FROM cadastros WHERE id_conta = ? and senha = ?");
            stmt.setString(1, login);
            stmt.setString(2, senha);

            rs = stmt.executeQuery();

            if (rs.next()) {

                
                check = true;
            }

        } catch (SQLException ex) {
            Logger.getLogger(cadastroDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.CloseConnetion(con, stmt, rs);
        }

        return check;

    }
    public boolean checkGeren() {
        
        Boolean Genre = null;
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
         
        try {
           
            stmt = con.prepareStatement("SELECT * FROM cadastros WHERE FunGe = ?");
            stmt.setBoolean(1, Genre);

            

        } catch (SQLException ex) {
            Logger.getLogger(cadastroDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.CloseConnetion(con, stmt);
        }

        return Genre;

    }
    
}
