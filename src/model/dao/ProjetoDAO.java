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
import model.bean.Projeto;

public class ProjetoDAO {

    //metodo create do crud
    public void create(Projeto p) {

        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("INSERT INTO projeto (nome, modulo, funcionalidade, datacriacao, autor, versao, prioridade, complexidade, esforco, estado, fase, descricao)VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
            stmt.setString(1, p.getNome());
            stmt.setString(2, p.getModulo());
            stmt.setString(3, p.getFuncionalidade());
            stmt.setString(4, p.getDatacriacao());
            stmt.setString(5, p.getAutor());
            stmt.setString(6, p.getVersao());
            stmt.setString(7, p.getPrioridade());
            stmt.setString(8, p.getComplexidade());
            stmt.setString(9, p.getEsforco());
            stmt.setString(10, p.getEstado());
            stmt.setString(11, p.getFase());
            stmt.setString(12, p.getDescricao());

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Salvo com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar: " + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }

    //metodo read do crud
    public List<Projeto> read() {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<Projeto> requisitos = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT * FROM projeto");
            rs = stmt.executeQuery();

            while (rs.next()) {
                Projeto projeto = new Projeto();

                projeto.setId(rs.getInt("id"));
                projeto.setNome(rs.getString("nome"));
                projeto.setModulo(rs.getString("modulo"));
                projeto.setFuncionalidade(rs.getString("funcionalidade"));
                projeto.setDatacriacao(rs.getString("datacriacao"));
                projeto.setAutor(rs.getString("autor"));
                projeto.setVersao(rs.getString("versao"));
                projeto.setPrioridade(rs.getString("prioridade"));
                projeto.setComplexidade(rs.getString("complexidade"));
                projeto.setEsforco(rs.getString("esforco"));
                projeto.setEstado(rs.getString("estado"));
                projeto.setFase(rs.getString("fase"));
                projeto.setDescricao(rs.getString("descricao"));
                
                requisitos.add(projeto);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProjetoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return requisitos;
    }
    
    public List<Projeto> readForDesc(String desc) {

        Connection con = ConnectionFactory.getConnection();
        
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<Projeto> requisitos = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT * FROM projeto WHERE descricao LIKE ?");
            stmt.setString(1, "%"+desc+"%");
            
            rs = stmt.executeQuery();

            while (rs.next()) {

                Projeto projeto = new Projeto();

                projeto.setId(rs.getInt("id"));
                projeto.setNome(rs.getString("nome"));
                projeto.setModulo(rs.getString("modulo"));
                projeto.setFuncionalidade(rs.getString("funcionalidade"));
                projeto.setDatacriacao(rs.getString("datacriacao"));
                projeto.setAutor(rs.getString("autor"));
                projeto.setVersao(rs.getString("versao"));
                projeto.setPrioridade(rs.getString("prioridade"));
                projeto.setComplexidade(rs.getString("complexidade"));
                projeto.setEsforco(rs.getString("esforco"));
                projeto.setEstado(rs.getString("estado"));
                projeto.setFase(rs.getString("fase"));
                projeto.setDescricao(rs.getString("descricao"));
                
                requisitos.add(projeto);
            }

        } catch (SQLException ex) {
            Logger.getLogger(ProjetoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }

        return requisitos;

    }
    //método update do crud
    public void update(Projeto p) {

        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("UPDATE projeto SET nome = ?, modulo = ?, funcionalidade = ?, datacriacao = ?, autor = ?, versao = ?, prioridade = ?, complexidade = ?, esforco = ?, estado = ?, fase = ?, descricao = ? WHERE id = ?");
            stmt.setString(1, p.getNome());
            stmt.setString(2, p.getModulo());
            stmt.setString(3, p.getFuncionalidade());
            stmt.setString(4, p.getDatacriacao());
            stmt.setString(5, p.getAutor());
            stmt.setString(6, p.getVersao());
            stmt.setString(7, p.getPrioridade());
            stmt.setString(8, p.getComplexidade());
            stmt.setString(9, p.getEsforco());
            stmt.setString(10, p.getEstado());
            stmt.setString(11, p.getFase());
            stmt.setString(12, p.getDescricao());
            stmt.setInt(13, p.getId());
            stmt.executeUpdate();
            

            JOptionPane.showMessageDialog(null, "Atualizado com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar: " + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
    
        public void delete(Projeto p) {

        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("DELETE FROM projeto WHERE id = ?");
            
            stmt.setInt(1, p.getId());

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Deletado com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao deletar: " + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
}
