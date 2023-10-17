/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ma.projet.entites;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;

/**
 *
 * @author hp
 */
@Entity
public class Commande {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String code;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date date;
    @OneToMany(mappedBy="commande",fetch = FetchType.EAGER)
    List<LigneProduitCommande> produitcommande=new ArrayList<>();

    public Commande(String code, Date date) {
        this.code = code;
        this.date = date;
    }

    public Commande() {
    }

    public List<LigneProduitCommande> getProduitcommande() {
        return produitcommande;
    }

    public void setProduitcommande(List<LigneProduitCommande> produitcommande) {
        this.produitcommande = produitcommande;
    }
    
  
    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Commande{" + "id=" + id + ", code=" + code + ", date=" + date + '}';
    }

    public String getCode() {
        return code;
    }

    public Date getDate() {
        return date;
    }

  
    public void setId(int id) {
        this.id = id;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setDate(Date date) {
        this.date = date;
    }

   
    
   
}
