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
    private Table tab;
    private Memoirecentrale mem;
    
    public void set(Table nomtab,Memoirecentrale nommemoire){
        this.mem=nommemoire;
        this.tab=nomtab;
    }
    
    public void jointure(){
        for (int i = 0; i< this.mem.get()/2; i++){
            for(int j=this.mem.get()/2;j<mem.get();j++){
                try{
                    join(this.mem.utilisation(i),this.mem.utilisation(j));
                }catch(Exception e){
                    //System.out.println(e);
                }
            }

        }
    }
    
    public void join (Buffer buf1, Buffer buf2){
            Bucket buc1=buf1.dechargement2();
            Bucket buc2=buf2.dechargement2();
                if (buc1.clef()==buc2.clef()){
                   
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
                            
                            System.arraycopy(string1, 0, motconcat, 0, string1.length);
                            System.arraycopy(string2, 0, motconcat, string1.length, string2.length);
                           
                            Donnees don = new Donnees();
                            Random rand= new Random();
                            int nbaupif = rand.nextInt(100000000);
                            don.set(nbaupif, concat, motconcat);
                            int[] Seq=this.tab.liaison(0).get();
                             System.out.println("joint");
                            Block bloc= this.mem.base().research(Seq[1]+Seq[2]-1);
                            System.out.println("joint2");
                            if (!bloc.remplis()){
                                bloc.integration2(don);
                                System.out.println("ajout dans mm bloc");
                            }
                            else{
                                Block bloc2= new Block();
                                bloc2.set(Seq[1]+Seq[2], 4);
                                this.tab.liaison(0).agrandissement();
                                bloc2.integration2(don);
                                this.mem.base().add(bloc2);
                                System.out.println("nouveau bloc");
                                
                            }

                        }

                    }
                }
    }
}
