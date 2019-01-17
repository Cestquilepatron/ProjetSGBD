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
    private int tab1;
    private int rang1;
    private int tab2;
    private int rang2;
    
    public void set(Table nomtab,Memoirecentrale nommemoire,int tab1cible,int rang1c, int tab2cible, int rang2c){
        this.mem=nommemoire;
        this.tab=nomtab;
        this.tab1 = tab1cible;//entier qui permet de choisir le tableau utiliser dans la 1ère table lors de la jointure
        //si tab1 = 2 on utilise le tableau de string sinon on utilise le tableau d'entier
        this.rang1=rang1c;//entier qui permet de choisir l'élément utiliser dans la 1ère table lors de la jointure
        this.tab2 = tab2cible;//entier qui permet de choisir le tableau utiliser dans la 2ème table lors de la jointure
        this.rang2 = rang2c;//entier qui permet de choisir le tableau utiliser dans la 2ème table lors de la jointure
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
            boolean conditionjointure;
            Bucket buc1=buf1.dechargement2();
            Bucket buc2=buf2.dechargement2();
                if (buc1.clef()==buc2.clef()){
                   System.out.println("Jointure du bucket "+buc1.get()+ " et du bucket "+buc2.get());
                    for (int parcour = 0; parcour<buc1.taille() ;parcour++){//parcours du bucket dans le buffer 1
                        for (int parcours=0 ; parcours<buc2.taille();parcours++){//parcour du bucket dans le buffer 2 puis création du nouveau tuple
                            int[] entier1 = buc1.utilisation(parcour).lectureentier() ;
                            int[] entier2 = buc2.utilisation(parcours).lectureentier();
                            int[] concat = new int [entier1.length+entier2.length];

                            String[] string1 = buc1.utilisation(parcour).lecturestring() ;
                            String[] string2 = buc2.utilisation(parcours).lecturestring();
                            String[] motconcat = new String [string1.length+string2.length];
                            
                            //critère de jointure
                            if (tab1==tab2){
                                if(tab1!=2){
                                    conditionjointure= (entier1[rang1]==entier2[rang2]);
                                }
                                else{
                                    conditionjointure= (string1[rang1].equals(string2[rang2]));
                                }
                            }
                            else{
                                conditionjointure=false;
                            }
                            
                            if(conditionjointure){
                                System.out.println("entre");
                                System.arraycopy(string1, 0, motconcat, 0, string1.length);
                                System.arraycopy(string2, 0, motconcat, string1.length, string2.length);
                                System.arraycopy(entier1, 0, concat, 0, entier1.length);
                                System.arraycopy(entier2, 0, concat, entier1.length, entier2.length);

                                Donnees don = new Donnees();
                                Random rand= new Random();
                                int nbaupif = rand.nextInt(100000000);
                                don.set(nbaupif, concat, motconcat);
                                int[] Seq=this.tab.liaison(0).get();
                                //Intégration du nouveau tuple dans la table
                                Block bloc= this.mem.base().research(Seq[1]+Seq[2]-1);
                                if (!bloc.remplis()){
                                    bloc.integration2(don);
                                }
                                else{
                                    Block bloc2= new Block();
                                    bloc2.set(Seq[1]+Seq[2], 4);
                                    this.tab.liaison(0).agrandissement();
                                    bloc2.integration2(don);
                                    this.mem.base().add(bloc2);

                                }
                            
                            }

                        }

                    }
                }
    }
}
