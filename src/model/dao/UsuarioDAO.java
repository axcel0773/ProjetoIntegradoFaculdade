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
import model.bean.Usuario;

public class UsuarioDAO {

    public boolean checkLogin(String nomeusu, String senha) {

        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        boolean check = false;

        try {
            stmt = con.prepareStatement("SELECT * FROM usuario WHERE nomeusu = ? and senha = ?");
            stmt.setString(1, nomeusu);
            stmt.setString(2, senha);

            rs = stmt.executeQuery();

            if (rs.next()) {
                check = true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }

        return check;
    }
    //create crud
    public void create(Usuario c) {

        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("INSERT INTO usuario (nomecomp, nomeusu, telefone, email, senha) VALUES (?, ?, ?, ?, ?)");
            stmt.setString(1, c.getNomecomp());
            stmt.setString(2, c.getNomeusu());
            stmt.setString(3, c.getTelefone());
            stmt.setString(4, c.getEmail());
            stmt.setString(5, c.getSenha());
            
            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Cadastrado com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar: " + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
        //metodo read do crud
    public List<Usuario> read() {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<Usuario> usuarios = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT * FROM usuario");
            rs = stmt.executeQuery();

            while (rs.next()) {
                Usuario projeto = new Usuario();

                projeto.setId(rs.getInt("id"));
                projeto.setNomecomp(rs.getString("nomecomp"));
                projeto.setNomeusu(rs.getString("nomeusu"));
                projeto.setTelefone(rs.getString("telefone"));
                projeto.setEmail(rs.getString("email"));
                projeto.setSenha(rs.getString("senha"));

                
                usuarios.add(projeto);
            }
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return usuarios;
    }
    //update crud
    public void update(Usuario c) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
       try {
            stmt = con.prepareStatement("UPDATE usuario SET nomecomp = ?, nomeusu = ?, telefone = ?, email = ?, senha = ? WHERE id = ?");
            
            stmt.setString(1, c.getNomecomp());
            stmt.setString(2, c.getNomeusu());
            stmt.setString(3, c.getTelefone());
            stmt.setString(4, c.getEmail());
            stmt.setString(5, c.getSenha());

            stmt.setInt(6, c.getId());
            
            stmt.executeUpdate();
           
        JOptionPane.showMessageDialog(null, "Alterado com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar: " + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
    //delete crud
    public void delete(Usuario c) {

        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("DELETE FROM usuario WHERE id = ?");
            
            stmt.setInt(1, c.getId());

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Deletado com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao deletar: " + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }

    /*    public Iterable<Usuario> read() {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }*/
}
