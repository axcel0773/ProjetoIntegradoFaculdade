package model.bean;

public class Projeto {
    private int id;
    private String nome;
    private String modulo;
    private String funcionalidade;
    private String datacriacao;
    private String autor;
    private String versao;
    private String prioridade;
    private String complexidade;
    private String esforco;
    private String estado;
    private String fase;
    private String descricao;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public String getNome() {
        return nome;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public String getModulo() {
        return modulo;
    }
    
    public void setModulo(String modulo) {
        this.modulo = modulo;
    }
    
    public String getFuncionalidade() {
        return funcionalidade;
    }
    
    public void setFuncionalidade(String funcionalidade) {
        this.funcionalidade = funcionalidade;
    }
    
    public String getDatacriacao() {
        return datacriacao;
    }
    
    public void setDatacriacao(String datacriacao) {
        this.datacriacao = datacriacao;
    }
    
    public String getAutor() {
        return autor;
    }
    
    public void setAutor(String autor) {
        this.autor = autor;
    }
    
    public String getVersao() {
        return versao;
    }
    
    public void setVersao(String versao) {
        this.versao = versao;
    }
    
    public String getPrioridade() {
        return prioridade;
    }
    
    public void setPrioridade(String prioridade) {
        this.prioridade = prioridade;
    }
    
    public String getComplexidade() {
        return complexidade;
    }
    
    public void setComplexidade(String complexidade) {
        this.complexidade = complexidade;
    }
    
    public String getEsforco() {
        return esforco;
    }
    
    public void setEsforco(String esforco) {
        this.esforco = esforco;
    }
    
    public String getEstado() {
        return estado;
    }
    
    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    public String getFase() {
        return fase;
    }
    
    public void setFase(String fase) {
        this.fase = fase;
    }
    
    public String getDescricao() {
        return descricao;
    }
    
        public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
