/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.projetsgbd;
import java.util.Random;
/**
 *
 * @author Bastien
 */
public class Jointure {
    private Tablehash tab1;
    private Tablehash tab2;
    private Memoirecentrale mem;
    
    public void set(Tablehash nomtab,Tablehash nomtab2,Memoirecentrale nommemoire){
        this.mem=nommemoire;
        this.tab1=nomtab;
        this.tab2= nomtab2;
    }
    
    public void join (Buffer buf1, Buffer buf2){
        for (int i=0; i<buf1.remplis();i++){
            Bucket buc1=buf1.dechargement2(i);
            for (int j=0; j<buf2.remplis();j++){
                Bucket buc2=buf2.dechargement2(j);
                for (int parcour = 0; parcour<buc1.taille() ;parcour++){
                    for (int parcours=0 ; parcours<buc2.taille();parcours++){
                        int[] entier1 = buc1.utilisation(parcour).lectureentier() ;
                        int[] entier2 = buc2.utilisation(parcours).lectureentier();
                        int[] concat = new int [entier1.length+entier2.length];
                        System.arraycopy(entier1, 0, concat, 0, entier1.length);
                        System.arraycopy(entier2, 0, concat, entier1.length, entier2.length);
                        
                        String[] string1 = buc1.utilisation(parcour).lecturestring() ;
                        String[] string2 = buc2.utilisation(parcours).lecturestring();
                        String[] motconcat = new String [string1.length+string2.length];
                        System.arraycopy(string1, 0, concat, 0, string1.length);
                        System.arraycopy(string2, 0, concat, string1.length, string2.length);
                        
                        Donnees don = new Donnees();
                        Random rand= new Random();
                        int nbaupif = rand.nextInt(100000000);
                        don.set(nbaupif, concat, motconcat);//Achanger clef primaire naze
                        
                    }
                    
                    
                }
            }
        }
    }
}
