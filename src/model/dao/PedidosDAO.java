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
import model.bean.Pedidos;
import model.bean.Produto;

/**
 *
 * @author Hugo
 */
public class PedidosDAO {
    public void create(Pedidos pd) {
        
        Connection con = ConnectionFactory.getConnection();
        
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("INSERT INTO pedidos (prato,mesa,hora)VALUES(?,?,?)");
            stmt.setString(1, pd.getPrato());
            stmt.setInt(2, pd.getMesa());
            stmt.setInt(3, pd.getHora());

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Salvo com sucesso!");
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            ConnectionFactory.CloseConnetion(con, stmt);
        }

    }
    
    public String[] read() {

        Connection con = ConnectionFactory.getConnection();
        
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<Produto> produtos = new ArrayList<>();
        String[] array = new String[produtos.size()]; int index = 0; for (Object value : produtos) { array[index] = (String) value; index++; }
        

        try {
            stmt = con.prepareStatement("SELECT descricao FROM produto");
            rs = stmt.executeQuery();

            while (rs.next()) {

                Produto produto = new Produto();

                produto.setDescricao(rs.getString("descricao"));
                produtos.add(produto);
            }

        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.CloseConnetion(con, stmt, rs);
        }

        return array;
 
}
}
