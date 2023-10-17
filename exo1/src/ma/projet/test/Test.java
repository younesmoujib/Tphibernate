/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ma.projet.test;

import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import ma.projet.entities.Produit;


import ma.projet.service.ProduitService;
import ma.projet.util.HibernateUtil;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.Transaction;


/**
 *
 * @author Lachgar
 */
public class Test {
    
    public static void main(String[] args) throws ParseException  {
       
        ProduitService pa=new ProduitService();
      
        
    //EX1  
        
    //Cree cin produit ;
        // pa.create(new Produit("AZE",100,new Date()));
        //pa.create(new Produit("XX",200,new Date()));
        //pa.create(new Produit("AA",2,new Date()));
        //pa.create(new Produit("BB",100,new Date()));
        //pa.create(new Produit("EE",3000,new Date()));
      //Afficher la liste des produits:
        // System.out.println("List De Produit ");
         //for(Produit p:pa.findAll(null)){
           //  System.out.println(p);
         //}
        //Afficher les informations du produit dont id = 2
         
        // System.out.println(pa.findById(2));
         //Modifier les informations du produit dont id = 1,
         //Produit p =pa.findById(5);
         //p.setPrix(9999);
         //p.setRef("update");
         //pa.update(p);
       //Afficher la liste des produits dont le prix est supérieur à 100 DH,
         
     //for(Produit p:pa.findAll(null)){
      // if(p.getPrix()>100){
        //     System.out.println(p);
         //}}

        Scanner scanner = new Scanner(System.in);

        System.out.println("Entrez la date de début (format : yyyy-MM-dd) : ");
        String startDateStr = scanner.nextLine();

        System.out.println("Entrez la date de fin (format : yyyy-MM-dd) : ");
        String endDateStr = scanner.nextLine();
       
             List<Produit> produits = pa.findProduct(startDateStr, endDateStr);
            
                if (produits != null && !produits.isEmpty()) {
            System.out.println("Liste des produits commandés entre " + startDateStr + " et " + endDateStr + ":");
            for (Produit produit : produits) {
            System.out.println("ID : " + produit.getId() + ", Référence : " + produit.getRef() + ", Prix : " + produit.getPrix());
            }
            } else {
            System.out.println("Aucun produit n'a été trouvé entre ces dates.");
            }
            
            scanner.close();
            }
  
    
  
        
       
        
           
       
       

}
