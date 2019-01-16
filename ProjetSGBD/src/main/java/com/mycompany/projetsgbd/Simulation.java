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
      base.set(100);
      
      
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
     buff1.set(1, 2);
     Centrale.composition(1, buff1);
     
     Buffer buff2=new Buffer();
     buff2.set(2, 2);
     Centrale.composition(2, buff2);
     
     Buffer buff3=new Buffer();
     buff3.set(3, 2);
     Centrale.composition(3, buff3);
     
     Buffer buff4=new Buffer();
     buff4.set(4, 2);
     Centrale.composition(4, buff4);
     
     Buffer buff5=new Buffer();
     buff5.set(5, 2);
     Centrale.composition(5, buff5);
     
     System.out.println("Nombre de buffer dans la mémoire centrale :" + Centrale.get() );
     
     Hashage hash = new Hashage();
     hash.set(T, Centrale,"modulo",1,0,5);
     Centrale.chargement(T, hash);
     System.out.println("clef de A2 : "+ A2.clef());
     
     hash.set(T2,Centrale,"modulo",1,0,5);
     Centrale.chargement(T2, hash);
     
     
     Tablehash tabhash= Centrale.chargementbucket(T);
     Tablehash tablehash = Centrale.chargementbucket(T2);
     
     tabhash.affiche();
     System.out.println();
     tablehash.affiche();
     System.out.println();
     
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
      
      System.out.println("Jointure obtenue : ");
      jointure.affiche();
    
      base.research(10).affiche();

     

      //*************************************************************************************************
      // 2eme exemple
      //********************************************************
      System.out.println("\n \n \n");
      System.out.println("2ème exemple");
      System.out.println("\n \n \n");
      
      Basededonnees newbase = new Basededonnees();
      newbase.set(100);
      
      //Création données block séquences de blocs puis table
      Donnees don0 = new Donnees();
      Donnees don1 = new Donnees();
      Donnees don2 = new Donnees();
      Donnees don3 = new Donnees();
      Donnees don4 = new Donnees();
      Donnees don5 = new Donnees();
      Donnees don6 = new Donnees();
      Donnees don7 = new Donnees();
      Donnees don8 = new Donnees();
      Donnees don9 = new Donnees();
      Donnees don10 = new Donnees();
      Donnees don11 = new Donnees();
      Donnees don12 = new Donnees();
      Donnees don13 = new Donnees();
      Donnees don14 = new Donnees();
      Donnees don15 = new Donnees();
      Donnees don16 = new Donnees();
      Donnees don17 = new Donnees();
      Donnees don18 = new Donnees();
      Donnees don19 = new Donnees();
      
      don0.set(0, 1, 0);
      don1.set(1, 1, 0);
      don2.set(2, 1, 0);
      don3.set(3, 1, 0);
      don4.set(4, 1, 0);
      don5.set(5, 1, 0);
      don6.set(6, 1, 0);
      don7.set(7, 1, 0);
      don8.set(8, 1, 0);
      don9.set(9, 1, 0);
      don10.set(10, 1, 0);
      don11.set(11, 1, 0);
      don12.set(12, 1, 0);
      don13.set(13, 1, 0);
      don14.set(14, 1, 0);
      don15.set(15, 1, 0);
      don16.set(16, 1, 0);
      don17.set(17, 1, 0);
      don18.set(18, 1, 0);
      don19.set(19, 1, 0);
      
      don0.insertiondonnee(0, 0);
      don1.insertiondonnee(0, 8);
      don2.insertiondonnee(0, 9);
      don3.insertiondonnee(0, 5);
      don4.insertiondonnee(0, 4);
      don5.insertiondonnee(0, 5);
      don6.insertiondonnee(0, 8);
      don7.insertiondonnee(0, 7);
      don8.insertiondonnee(0, 7);
      don9.insertiondonnee(0, 8);
      don10.insertiondonnee(0, 8);
      don11.insertiondonnee(0, 4);
      don12.insertiondonnee(0, 7);
      don13.insertiondonnee(0, 1);
      don14.insertiondonnee(0, 3);
      don15.insertiondonnee(0, 9);
      don16.insertiondonnee(0, 4);
      don17.insertiondonnee(0, 7);
      don18.insertiondonnee(0, 1);
      don19.insertiondonnee(0, 2);
      
      Block Bk0 = new Block();
      Bk0.set(0, 5);
      Block Bk1 = new Block();
      Bk1.set(1, 5);
      Block Bk2 = new Block();
      Bk2.set(2, 5);
      Block Bk3 = new Block();
      Bk3.set(3, 5);
      
      Bk0.integration(0, don0);
      Bk0.integration(1, don1);
      Bk0.integration(2, don2);
      Bk0.integration(3, don3);
      Bk0.integration(4, don4);
      Bk1.integration(0, don5);
      Bk1.integration(1, don6);
      Bk1.integration(2, don7);
      Bk1.integration(3, don8);
      Bk1.integration(4, don9);
      Bk2.integration(0, don10);
      Bk2.integration(1, don11);
      Bk2.integration(2, don12);
      Bk2.integration(3, don13);
      Bk2.integration(4, don14);
      Bk3.integration(0, don15);
      Bk3.integration(1, don16);
      Bk3.integration(2, don17);
      Bk3.integration(3, don18);
      Bk3.integration(4, don19);
      
      newbase.add(Bk0);
      newbase.add(Bk1);
      newbase.add(Bk2);
      newbase.add(Bk3);
      
      Sequenceblock Seq=new Sequenceblock();
      Seq.set(0, 0, 3);
      Sequenceblock Seq2=new Sequenceblock();
      Seq2.set(3, 3, 2);
      
      Table Table1ex2 = new Table();
      Table1ex2.set("Premiere table ex2", 1);
      Table1ex2.integration(0, Seq);
      Table Table2ex2 = new Table();
      Table2ex2.set("Seconde table ex2", 1);
      Table2ex2.integration(0, Seq2);
      
      
      //Création mémoire centrale et buffer
      Memoirecentrale Centraleex2 = new Memoirecentrale();
      Centraleex2.set(2, newbase);
     
      Buffer buff0ex2=new Buffer();
      buff0ex2.set(0, 1);
      Centraleex2.composition(0, buff0ex2);
      Buffer buff1ex2=new Buffer();
      buff1ex2.set(1, 1);
      Centraleex2.composition(1, buff1ex2);
      
      // Hashage des tables
      Hashage hashex2 = new Hashage();
      
      hashex2.set(Table1ex2, Centraleex2,"modulo",1,0,5);
      Centraleex2.chargement(Table1ex2, hashex2);
      Tablehash Table1ex2H = Centraleex2.chargementbucket(Table1ex2);
      
      hashex2.set(Table2ex2, Centraleex2,"modulo",1,0,5);
      Centraleex2.chargement(Table2ex2, hashex2);
      Tablehash Table2ex2H = Centraleex2.chargementbucket(Table2ex2);
      
      Table jointureex2= new Table();
      String nomjointureex2= "jointure "+ Table2ex2.get() +" "+Table1ex2.get();
      jointureex2.set(nomjointureex2, 1);
      Sequenceblock Seqjoinex2= new Sequenceblock();
      Seqjoinex2.set(newbase.get(),newbase.get(),1);
      Block bex2=new Block();
      bex2.set(newbase.get(), 4);
      newbase.add(bex2);
      jointureex2.integration(0, Seqjoinex2);
      
      Table2ex2H.affiche();
      System.out.println();
      Table1ex2H.affiche();
      
      Jointure Joinex2 = new Jointure();
      Joinex2.set(jointureex2, Centraleex2);
      Centraleex2.chargement( Table1ex2H, Table2ex2H, Joinex2);
      
      System.out.println("Jointure obtenue : ");
      jointureex2.affiche();
      
      newbase.research(4).affiche();
   }
  
}
