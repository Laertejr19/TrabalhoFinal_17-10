package br.com.DAO;

import br.com.DTO.ClienteDTO;
import br.com.VIEWS.TelaCadastroCliente;
import java.awt.Color;
import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Eder
 */
public class ClienteDAO {

    Connection conexao = null;
    PreparedStatement pst = null;
    ResultSet rs = null;

    

    public void inserirUsuario(ClienteDTO objClienteDTO) {
        String sql = "insert into tb_usuarios (id_cliente, nomecliente, emailcliente, endereçocliente, telefonecliente, cpf_cnpjcliente)"
                + " values (?, ?, ?, ?, ?, ?)";
        conexao = ConexaoDAO.conector();

        try {
            pst = conexao.prepareStatement(sql);
            pst = conexao.prepareStatement(sql);
            pst.setInt(5, objClienteDTO.getCpfCnpjCliente());
            pst.setString(4, objClienteDTO.getEmailCliente());
            pst.setString(3, objClienteDTO.getEndereçoCliente());
            pst.setString(2, objClienteDTO.getNomeCliente());
            pst.setInt(1, objClienteDTO.getTelefoneCliente());
            int add  = pst.executeUpdate();
            if (add > 0) {
                pesquisaAuto();
                pst.close();
                limparCampos();
                JOptionPane.showMessageDialog(null, "Usuário inserido com sucesso! ");
            }

        } catch (SQLException e) {

            JOptionPane.showMessageDialog(null, " Método Inserir " + e);
        }
    }

    public void pesquisar(ClienteDTO objClienteDTO) {
        String sql = "select * from tbusuarios where id_cliente = ?";
        conexao = ConexaoDAO.conector();

        try {
            pst = conexao.prepareStatement(sql);
            pst.setInt(1, objClienteDTO.getIDCliente());
            rs = pst.executeQuery();
            if (rs.next()) {
                TelaCadastroCliente.txtNomeCliente.setText(rs.getString(2));
                TelaCadastroCliente.txtEmailCliente.setText(rs.getString(3));
                TelaCadastroCliente.txtEndereçoCliente.setText(rs.getString(4));
                TelaCadastroCliente.txtTelefoneCliente.setText(rs.getString(5));
                TelaCadastroCliente.txtCPFCNPJCliente.setText(rs.getString(6));
               
                conexao.close();
            } else {
                JOptionPane.showMessageDialog(null, "Usuário não cadastrado!");
                limparCampos();
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, " Método Pesquisar" + e);
        }
    }

    public void pesquisaAuto() {
        String sql = "select * from tb_usuarios";
        conexao = ConexaoDAO.conector();

        try {
            pst = conexao.prepareStatement(sql);
            rs = pst.executeQuery();
            DefaultTableModel model = (DefaultTableModel) TelaCadastroCliente.TbUsuarios.getModel();
            model.setNumRows(0);

            while (rs.next()) {
                int id_cliente = rs.getInt("id_cliente");
                String nomecliente = rs.getString("nome");
                String emailcliente = rs.getString("email");
                String telefonecliente = rs.getString("telefone");
                String endereçocliente = rs.getString("endereço");
                model.addRow(new Object[]{id_cliente, nomecliente, emailcliente, telefonecliente, endereçocliente});
            }
            conexao.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, " Método Pesquisar Automático " + e);
        }
    }
                                                                                                                       
    //Método editar
    public void editar(ClienteDTO objClienteDTO) {
        String sql = "update tb_usuarios set usuario = ?, login = ?, senha = ?, perfil = ? where id_usuario = ?";
        conexao = ConexaoDAO.conector();
        try {
            pst = conexao.prepareStatement(sql);
            pst.setInt(5, objClienteDTO.getCpfCnpjCliente());
            pst.setString(4, objClienteDTO.getEmailCliente());
            pst.setString(3, objClienteDTO.getEndereçoCliente());
            pst.setString(2, objClienteDTO.getNomeCliente());
            pst.setInt(1, objClienteDTO.getTelefoneCliente());
            int add = pst.executeUpdate();
            if (add > 0) {
                JOptionPane.showMessageDialog(null, "Usuário editado com sucesso!");
                pesquisaAuto();
                conexao.close();
                limparCampos();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, " Método editar " + e);
        }
    }

    //Método deletar
    public void deletar(ClienteDTO objClienteDTO) {
        String sql = "delete from tbclientes where id_usuario = ?";
        conexao = ConexaoDAO.conector();

        try {
            pst = conexao.prepareStatement(sql);
            pst.setInt(1, objClienteDTO.getIDCliente());
            int del = pst.executeUpdate();
            if (del > 0) {
                JOptionPane.showMessageDialog(null, " Usuário deletado com sucesso!");
                pesquisaAuto();
                conexao.close();
                limparCampos();
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, " Método deletar " + e);
        }
    }

    public void limparCampos() {
        TelaCadastroCliente.txtIDCliente.setText(null);
        TelaCadastroCliente.txtEmailCliente.setText(null);
        TelaCadastroCliente.txtNomeCliente.setText(null);
        TelaCadastroCliente.txtEndereçoCliente.setText(null);
        TelaCadastroCliente.txtTelefoneCliente.setText(null);
        TelaCadastroCliente.txtCPFCNPJCliente.setText(null);
    }

}