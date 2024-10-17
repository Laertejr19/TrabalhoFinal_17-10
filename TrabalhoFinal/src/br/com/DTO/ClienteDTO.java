

package br.com.DTO;

/**
 *
 * @author Eder
 */
public class ClienteDTO {
    private int id_cliente, telefonecliente, cpf_cnpjcliente;
    private String  nomecliente, endereçocliente, emailcliente;

    public String getNomeCliente() {
        return nomecliente;
    }

    public void setNomeCliente(String nomecliente) {
        this.nomecliente = nomecliente;
    }

    public int getTelefoneCliente() {
        return telefonecliente;
    }

    public void setTelefoneCliente(int telefonecliente) {
        this.telefonecliente = telefonecliente;
    }

    public String getEndereçoCliente() {
        return endereçocliente;
    }

    public void setEndereçoCliente(String endereçocliente) {
        this.endereçocliente = endereçocliente;
    }

    public String getEmailCliente() {
        return emailcliente;
    }

    public void setEmailCliente(String emailcliente) {
        this.emailcliente = emailcliente;
    }

    public int getCpfCnpjCliente() {
        return cpf_cnpjcliente;
    }

    public void setCpfCnpjCliente(int cpf_cnpjcliente) {
        this.cpf_cnpjcliente = cpf_cnpjcliente;
    }
public int getIDCliente(){
    return id_cliente;
}
   public void setIDCliente(int id_cliente){
       this.id_cliente = id_cliente;
   }
    }
    
