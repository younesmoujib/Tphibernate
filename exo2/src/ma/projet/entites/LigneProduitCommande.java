/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ma.projet.entites;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;


/**
 *
 * @author hp
 */
@Entity
@Table(name="Produit_Commande")
public class LigneProduitCommande {
    @EmbeddedId
    private LigneProduitCommandeKey ligneproduitcommandeKey= new LigneProduitCommandeKey();
    @ManyToOne
    @MapsId("produitId")
    private Produit produit;
    @ManyToOne
    @MapsId("commandeId")
    private Commande commande;
    private int quantite;

    public LigneProduitCommande() {
    }

    public LigneProduitCommande(Produit produit, Commande commande, int quantite) {
        this.produit = produit;
        this.commande = commande;
        this.quantite = quantite;
    }
    

    public Produit getProduit() {
        return produit;
    }

    public Commande getCommande() {
        return commande;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setProduit(Produit produit) {
        this.produit = produit;
    }

    public void setCommande(Commande commande) {
        this.commande = commande;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    @Override
    public String toString() {
        return "LigneProduitCommande{" + "produit=" + produit + ", commande=" + commande + ", quantite=" + quantite + '}';
    }

   
    
}
