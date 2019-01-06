/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.projetsgbd;

/**
 *
 * @author Bastien
 */
public class Simulation {
    
  public static void  main (String [] args){
      //Création base de données
      Basededonnees base = new Basededonnees();
      base.set(1000);
      
      
      //Création de données
      Donnees A = new Donnees();
      A.set(1, 1, 0);
      A.affiche();
      Donnees A2 = new Donnees();
      A2.set(2, 5, 1);
      Donnees A3 = new Donnees();
      A3.set(3, 1, 0);
      Donnees A4 = new Donnees();
      A4.set(4, 1, 0);
      
      A.insertiondonnee(0, 1);
      A3.insertiondonnee(0, 1);
      A4.insertiondonnee(0, 1);
      A2.insertiondonnee(0, 1);
      A2.insertiondonnee(1, 1);
      A2.insertiondonnee(2, 1);
      A2.insertiondonnee(3, 1);
      A2.insertiondonnee(4, 1);
      A2.insertiondonnee(0, "donne");
      
      

      A.affiche();
      A2.affiche();
      
      //Création de blocs
      Block B = new Block();
      B.set(0, 2);
      B.integration(0, A);
      B.integration(1, A);
      Block B1 = new Block();
      B.set(1, 2);
      B.integration(0, A);
      B.integration(1, A);
      Block B2 = new Block();
      B2.set(2, 4);
      B2.integration(0, A);
      B2.integration(1, A4);
      B2.integration(2, A2);
      B2.integration(3, A3);
      Block B3 = new Block();
      B3.set(3, 2);
      B3.integration(0, A4);
      B3.integration(1, A3);
      Block B4 = new Block();
      B4.set(4, 2);
      B4.integration(0, A4);
      B4.integration(1, A3);
      Block B5 = new Block();
      B5.set(5, 2);
      B5.integration(0, A2);
      B5.integration(1, A);
      Block B6 = new Block();
      B6.set(6, 2);
      B6.integration(0, A3);
      B6.integration(1, A3);
      
      B2.affiche();
      B.affiche();
      
      base.add(B);
      base.add(B1);
      base.add(B2);
      base.add(B3);
      base.add(B4);
      base.add(B5);
      base.add(B6);
      
      System.out.println(" La base contient maintenant "+base.get() +" bloc de donnée");
      
     //Création d'une séquence
     Sequenceblock S1= new Sequenceblock();
     S1.set(0,1,3);
     Sequenceblock S2= new Sequenceblock();
     S2.set(1,5,2);
     S1.affiche();
     
     //Création d'une table
     Table T = new Table();
     T.set("Premieretable", 2);
     T.integration(0, S1);
     T.integration(1, S2);
     T.affiche();
     
     //Création buffer et mémoire centrale
     Memoirecentrale Centrale = new Memoirecentrale();
     Centrale.set(6, base);
     
     Buffer buff0=new Buffer();
     buff0.set(0, 4);
     Centrale.composition(0, buff0);
     
     Buffer buff1=new Buffer();
     buff0.set(1, 4);
     Centrale.composition(1, buff1);
     
     Buffer buff2=new Buffer();
     buff0.set(2, 4);
     Centrale.composition(2, buff2);
     
     Buffer buff3=new Buffer();
     buff0.set(3, 4);
     Centrale.composition(3, buff3);
     
     Buffer buff4=new Buffer();
     buff0.set(4, 4);
     Centrale.composition(4, buff4);
     
     Buffer buff5=new Buffer();
     buff0.set(5, 4);
     Centrale.composition(5, buff5);
     
     System.out.println("Nombre de buffer dans la mémoire centrale :" + Centrale.get() );
     
     Hashage hash = new Hashage();
     hash.set(T, Centrale);
     Centrale.chargement(T, hash);
     System.out.println("clef de A"+ A.clef());
     
   }
  
}
