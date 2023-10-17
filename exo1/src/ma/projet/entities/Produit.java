/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ma.projet.entities;

import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
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
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date date_Achat;
   
   
    
 
    public Produit(){
        
    }
    public Produit(String ref,float prix, Date date_Achat){
        this.ref=ref;
        this.prix=prix;
        this.date_Achat=date_Achat;
       }
    
    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the ref
     */
    public String getRef() {
        return ref;
    }

    /**
     * @param ref the ref to set
     */
    public void setRef(String ref) {
        this.ref = ref;
    }

    /**
     * @return the prix
     */
    public float getPrix() {
        return prix;
    }

    /**
     * @param prix the prix to set
     */
    public void setPrix(float prix) {
        this.prix = prix;
    }

    /**
     * @return the date_Achat
     */
    public Date getDate_Achat() {
        return date_Achat;
    }

    /**
     * @param date_Achat the date_Achat to set
     */
    public void setDate_Achat(Date date_Achat) {
        this.date_Achat = date_Achat;
    }

    /**
     * @return the commandes
     */
   

    @Override
    public String toString() {
        return "ref=" + ref + ", prix=" + prix + ", date_Achat=" + date_Achat ;
    }

   
    
}
