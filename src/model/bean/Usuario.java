package model.bean;

public class Usuario {
    private int id;
    private String nomecomp;
    private String nomeusu;
    private String email;
    private String senha;
    private String telefone;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomecomp() {
        return nomecomp;
    }
    
    public void setNomecomp(String nomecomp) {
        this.nomecomp = nomecomp;
    }

    public void setLogin(String nomecomp) {
        this.nomecomp = nomecomp;
    }
    
    public String getNomeusu() {
        return nomeusu;
    }
    
    public void setNomeusu(String nomeusu) {
        this.nomeusu = nomeusu;
    }
    
    public String getEmail() {
        return email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    
    public String getSenha() {
        return senha;
    }
    
    public void setSenha(String senha) {
        this.senha = senha;
    }
    
    public String getTelefone() {
        return telefone;
    }
    
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
}
