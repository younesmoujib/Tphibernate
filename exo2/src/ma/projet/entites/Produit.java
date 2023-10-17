/*
 * To change this license header, choose License Headers in Produitoject Produitoperties.
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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;

/**
 *
 * @author hp
 */
@Entity
public class Produit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String ref;
    private float prix;
    @OneToMany(mappedBy="produit",fetch = FetchType.EAGER)
    List<LigneProduitCommande> produitcommande=new ArrayList<>();
    
    @ManyToOne(fetch = FetchType.EAGER)
    private Categorie categorie;

    public Produit() {
    }

    public Produit(String ref, float prix) {
        this.ref = ref;
        this.prix = prix;
    }

    public List<LigneProduitCommande> getProduitcommande() {
        return produitcommande;
    }
  
   

    public int getId() {
        return id;
    }

    public String getRef() {
        return ref;
    }

    public float getPrix() {
        return prix;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setRef(String ref) {
        this.ref = ref;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }

    

   /* public void setProduitsCommandes(List<LigneProduitCommande> produitsCommandes) {
        this.produitsCommandes = produitsCommandes;
    }*/

    

  /*  public List<LigneProduitCommande> getProduitsCommandes() {
        return produitsCommandes;
    }*/

    @Override
    public String toString() {
        
        return  "      "+ref + "               " + prix ;
    }
}
