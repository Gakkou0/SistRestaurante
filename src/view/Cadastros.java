/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *
 * @author Hugo
 */
@Entity
@Table(name = "cadastros", catalog = "bd_restaurante", schema = "")
@NamedQueries({
    @NamedQuery(name = "Cadastros.findAll", query = "SELECT c FROM Cadastros c")
    , @NamedQuery(name = "Cadastros.findByIdConta", query = "SELECT c FROM Cadastros c WHERE c.idConta = :idConta")
    , @NamedQuery(name = "Cadastros.findByNome", query = "SELECT c FROM Cadastros c WHERE c.nome = :nome")
    , @NamedQuery(name = "Cadastros.findByEndereco", query = "SELECT c FROM Cadastros c WHERE c.endereco = :endereco")
    , @NamedQuery(name = "Cadastros.findByEmail", query = "SELECT c FROM Cadastros c WHERE c.email = :email")
    , @NamedQuery(name = "Cadastros.findByCpf", query = "SELECT c FROM Cadastros c WHERE c.cpf = :cpf")
    , @NamedQuery(name = "Cadastros.findByRg", query = "SELECT c FROM Cadastros c WHERE c.rg = :rg")
    , @NamedQuery(name = "Cadastros.findByTelefone", query = "SELECT c FROM Cadastros c WHERE c.telefone = :telefone")
    , @NamedQuery(name = "Cadastros.findByGenero", query = "SELECT c FROM Cadastros c WHERE c.genero = :genero")
    , @NamedQuery(name = "Cadastros.findBySenha", query = "SELECT c FROM Cadastros c WHERE c.senha = :senha")
    , @NamedQuery(name = "Cadastros.findByFunGe", query = "SELECT c FROM Cadastros c WHERE c.funGe = :funGe")})
public class Cadastros implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_conta")
    private Integer idConta;
    @Basic(optional = false)
    @Column(name = "nome")
    private String nome;
    @Basic(optional = false)
    @Column(name = "endereco")
    private String endereco;
    @Basic(optional = false)
    @Column(name = "email")
    private String email;
    @Basic(optional = false)
    @Column(name = "CPF")
    private int cpf;
    @Basic(optional = false)
    @Column(name = "RG")
    private int rg;
    @Basic(optional = false)
    @Column(name = "telefone")
    private int telefone;
    @Basic(optional = false)
    @Column(name = "genero")
    private String genero;
    @Basic(optional = false)
    @Column(name = "senha")
    private String senha;
    @Basic(optional = false)
    @Column(name = "FunGe")
    private boolean funGe;

    public Cadastros() {
    }

    public Cadastros(Integer idConta) {
        this.idConta = idConta;
    }

    public Cadastros(Integer idConta, String nome, String endereco, String email, int cpf, int rg, int telefone, String genero, String senha, boolean funGe) {
        this.idConta = idConta;
        this.nome = nome;
        this.endereco = endereco;
        this.email = email;
        this.cpf = cpf;
        this.rg = rg;
        this.telefone = telefone;
        this.genero = genero;
        this.senha = senha;
        this.funGe = funGe;
    }

    public Integer getIdConta() {
        return idConta;
    }

    public void setIdConta(Integer idConta) {
        Integer oldIdConta = this.idConta;
        this.idConta = idConta;
        changeSupport.firePropertyChange("idConta", oldIdConta, idConta);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        String oldNome = this.nome;
        this.nome = nome;
        changeSupport.firePropertyChange("nome", oldNome, nome);
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        String oldEndereco = this.endereco;
        this.endereco = endereco;
        changeSupport.firePropertyChange("endereco", oldEndereco, endereco);
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        String oldEmail = this.email;
        this.email = email;
        changeSupport.firePropertyChange("email", oldEmail, email);
    }

    public int getCpf() {
        return cpf;
    }

    public void setCpf(int cpf) {
        int oldCpf = this.cpf;
        this.cpf = cpf;
        changeSupport.firePropertyChange("cpf", oldCpf, cpf);
    }

    public int getRg() {
        return rg;
    }

    public void setRg(int rg) {
        int oldRg = this.rg;
        this.rg = rg;
        changeSupport.firePropertyChange("rg", oldRg, rg);
    }

    public int getTelefone() {
        return telefone;
    }

    public void setTelefone(int telefone) {
        int oldTelefone = this.telefone;
        this.telefone = telefone;
        changeSupport.firePropertyChange("telefone", oldTelefone, telefone);
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        String oldGenero = this.genero;
        this.genero = genero;
        changeSupport.firePropertyChange("genero", oldGenero, genero);
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        String oldSenha = this.senha;
        this.senha = senha;
        changeSupport.firePropertyChange("senha", oldSenha, senha);
    }

    public boolean getFunGe() {
        return funGe;
    }

    public void setFunGe(boolean funGe) {
        boolean oldFunGe = this.funGe;
        this.funGe = funGe;
        changeSupport.firePropertyChange("funGe", oldFunGe, funGe);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idConta != null ? idConta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cadastros)) {
            return false;
        }
        Cadastros other = (Cadastros) object;
        if ((this.idConta == null && other.idConta != null) || (this.idConta != null && !this.idConta.equals(other.idConta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "view.Cadastros[ idConta=" + idConta + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
