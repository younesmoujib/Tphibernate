/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ma.projet.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import ma.projet.entites.Categorie;
import ma.projet.entites.Commande;
import ma.projet.entites.LigneProduitCommande;
import ma.projet.entites.Produit;
import ma.projet.service.CategorieService;
import ma.projet.service.CommandeService;
import ma.projet.service.ProduitCommandeService;
import ma.projet.service.ProduitService;
import ma.projet.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author hp
 */
public class Test {

    public static void main(String[] args) throws ParseException {
        ProduitService pa = new ProduitService();
        CommandeService ca = new CommandeService();
        ProduitCommandeService pc = new ProduitCommandeService();
        CategorieService cs = new CategorieService();
        // ca.create(new Commande("aa",new Date()));

        // 4Créer une méthode permettant d’afficher la liste des produits commandés entre deux dates
        Scanner scanner = new Scanner(System.in);

        //System.out.println("Entrez la date de début (format : yyyy-MM-dd) : ");
        //String startDateStr = scanner.nextLine();

        //System.out.println("Entrez la date de fin (format : yyyy-MM-dd) : ");
        //String endDateStr = scanner.nextLine();

        //List<Produit> produits = pa.findProduct(startDateStr, endDateStr);

        //if (produits != null && !produits.isEmpty()) {
         //   System.out.println("Liste des produits commandés entre " + startDateStr + " et " + endDateStr + ":");
           // for (Produit produit : produits) {
             //   System.out.println("ID : " + produit.getId() + ", Référence : " + produit.getRef() + ", Prix : " + produit.getPrix());
            //}
        //} else {
          //  System.out.println("Aucun produit n'a été trouvé entre ces dates.");
        //}

     
        //  Créer une méthode permettant d’afficher les produits commandés dans une commande donnée :

        System.out.println("Enter id de la commande :");
        int id = scanner.nextInt();
        Commande commande = ca.findById(id );
        if (commande != null) {
            
            List<LigneProduitCommande> pre = commande.getProduitcommande();
           if(!pre.isEmpty()){
               System.out.println("Commande: "+id +"          Date :"+commande.getDate()+"\n"
                    + "    Référence            Prix"
                    + "                          Quantité");
                for (int i = 0; i < pre.size(); i++) {
                System.out.println(pre.get(i).getProduit() + "                           " + pre.get(i).getQuantite());
            }
                
           }else{
               System.out.println("La commande n'a pas de relation avec les produits");
           }
        } else {
            System.out.println("Commande n'existe pas");
        }
           scanner.close();
           // d’afficher la liste des produits dont le prix est supérieur à 100 DH dans la classe ProduitService en utilisant une requête nommée.
           //   System.out.println("les la liste des produits dont le prix est supérieur à 100 DH");
           //List<Produit> pr=pa.finddProduct();
           //for(int i=0 ;i<pr.size();i++){
            //   System.out.println("id: "+pr.get(i).getId()+", ref :"+pr.get(i).getRef()+" ,prix:"+pr.get(i).getPrix()+"DH");
           //}
    }
    
  
}
