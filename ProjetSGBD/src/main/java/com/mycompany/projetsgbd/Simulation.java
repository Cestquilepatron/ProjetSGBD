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
      //A.affiche();
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
      
      Donnees A5 = new Donnees();
      A5.set(5, 1, 0);
      Donnees A6 = new Donnees();
      A6.set(5, 1, 0);
      Donnees A7 = new Donnees();
      A7.set(7, 1, 0);
      Donnees A8 = new Donnees();
      A8.set(8, 1, 0);
      Donnees A9 = new Donnees();
      A9.set(9, 1, 0);
      Donnees A10 = new Donnees();
      A10.set(10, 1, 0);
      Donnees A11 = new Donnees();
      A11.set(11, 1, 0);
      Donnees A12 = new Donnees();
      A12.set(12, 1, 0);
      Donnees A13 = new Donnees();
      A13.set(13, 1, 0);
      Donnees A14 = new Donnees();
      A14.set(14, 1, 0);
      Donnees A15 = new Donnees();
      A15.set(15, 1, 0);
      Donnees A16 = new Donnees();
      A16.set(16, 1, 0);
      Donnees A17 = new Donnees();
      A17.set(17, 1, 0);
      Donnees A18 = new Donnees();
      A18.set(18, 1, 0);
      Donnees A19 = new Donnees();
      A19.set(19, 1, 0);
      Donnees A20 = new Donnees();
      A20.set(20, 1, 0);
      Donnees A21 = new Donnees();
      A21.set(21, 1, 0);
      Donnees A22 = new Donnees();
      A22.set(1, 1, 0);
      
       A5.insertiondonnee(0, 5);
       A6.insertiondonnee(0, 6);
      A7.insertiondonnee(0, 7);
      A8.insertiondonnee(0, 8);
      A9.insertiondonnee(0, 9);
      A10.insertiondonnee(0, 10);
      A11.insertiondonnee(0, 11);
      A12.insertiondonnee(0, 12);
      A13.insertiondonnee(0, 13);
      A14.insertiondonnee(0, 14);
      A15.insertiondonnee(0, 15);
      A16.insertiondonnee(0, 16);
      A17.insertiondonnee(0, 17);
      A18.insertiondonnee(0, 18);
      A19.insertiondonnee(0, 19);
      A20.insertiondonnee(0, 20);
      A21.insertiondonnee(0, 21);
      A22.insertiondonnee(0, 22);
      

      A.affiche();
      A2.affiche();
      
      //Création de blocs
      Block B = new Block();
      B.set(0, 2);
      B.integration(0, A);
      B.integration(1, A2);
      Block B1 = new Block();
      B.set(1, 2);
      B.integration(0, A3);
      B.integration(1, A4);
      Block B2 = new Block();
      B2.set(2, 4);
      B2.integration(0, A5);
      B2.integration(1, A6);
      B2.integration(2, A7);
      B2.integration(3, A8);
      Block B3 = new Block();
      B3.set(3, 2);
      B3.integration(0, A9);
      B3.integration(1, A10);
      Block B4 = new Block();
      B4.set(4, 2);
      B4.integration(0, A11);
      B4.integration(1, A12);
      Block B5 = new Block();
      B5.set(5, 2);
      B5.integration(0, A13);
      B5.integration(1, A14);
      Block B6 = new Block();
      B6.set(6, 2);
      B6.integration(0, A15);
      B6.integration(1, A16);
      Block B7=new Block();
      B7.set(7, 2);
      B7.integration(0,A17);
      B7.integration(1, A18);
      Block B8=new Block();
      B8.set(8, 2);
      B8.integration(0, A19);
      B8.integration(1, A20);
      Block B9 = new Block();
      B9.set(9, 2);
      B9.integration(0, A21);
      B9.integration(1, A22);
      
      
      B2.affiche();
      B.affiche();
      
      base.add(B);
      base.add(B1);
      base.add(B2);
      base.add(B3);
      base.add(B4);
      base.add(B5);
      base.add(B6);
      base.add(B7);
      base.add(B8);
      base.add(B9);
      System.out.println(" La base contient maintenant "+base.get() +" bloc de donnée");
      
     //Création d'une séquence
     Sequenceblock S=new Sequenceblock();
     S.set(3, 0, 1);
     Sequenceblock S1= new Sequenceblock();
     S1.set(0,1,3);
     Sequenceblock S2= new Sequenceblock();
     S2.set(1,5,2);
     S1.affiche();
     
     Sequenceblock S3= new Sequenceblock();
     S3.set(2, 8, 2);
     
     Sequenceblock S4= new Sequenceblock();
     S4.set(4, 4, 1);
     
     //Création d'une table
     Table T = new Table();
     T.set("Premieretable", 3);
     T.integration(0, S1);
     T.integration(1, S2);
     T.integration(2, S);
     T.affiche();
     
     Table T2= new Table();
     T2.set("2emetable", 2);
     T2.integration(0, S3);
     T2.integration(1, S4);
     
     //Création buffer et mémoire centrale
     Memoirecentrale Centrale = new Memoirecentrale();
     Centrale.set(6, base);
     
     Buffer buff0=new Buffer();
     buff0.set(0, 2);
     Centrale.composition(0, buff0);
     
     Buffer buff1=new Buffer();
     buff0.set(1, 2);
     Centrale.composition(1, buff1);
     
     Buffer buff2=new Buffer();
     buff0.set(2, 2);
     Centrale.composition(2, buff2);
     
     Buffer buff3=new Buffer();
     buff0.set(3, 2);
     Centrale.composition(3, buff3);
     
     Buffer buff4=new Buffer();
     buff0.set(4, 2);
     Centrale.composition(4, buff4);
     
     Buffer buff5=new Buffer();
     buff0.set(5, 2);
     Centrale.composition(5, buff5);
     
     System.out.println("Nombre de buffer dans la mémoire centrale :" + Centrale.get() );
     
     Hashage hash = new Hashage();
     hash.set(T, Centrale);
     Centrale.chargement(T, hash);
     System.out.println("clef de A2 : "+ A2.clef());
     
     hash.set(T2,Centrale);
     Centrale.chargement(T2, hash);
     
     
     Tablehash tabhash= Centrale.chargementbucket(T);
     tabhash.affiche();
     
     Tablehash tablehash = Centrale.chargementbucket(T2);
     
     //création de la table de jointure
      Table jointure= new Table();
      String nomjointure= "jointure "+ tabhash.get() +" "+tablehash.get();
      jointure.set(nomjointure, 1);
      Sequenceblock Seqjoin= new Sequenceblock();
      Seqjoin.set(base.get(),base.get(),1);
      Block b=new Block();
      b.set(base.get(), 4);
      base.add(b);
      jointure.integration(0, Seqjoin);
      

      
      Jointure Join = new Jointure();
      Join.set(jointure, Centrale);
      Centrale.chargement(tabhash, tablehash, Join);
      
      System.out.println("Marche : ");
      jointure.affiche();
      
      base.research(10).affiche();
     
   }
  
}
