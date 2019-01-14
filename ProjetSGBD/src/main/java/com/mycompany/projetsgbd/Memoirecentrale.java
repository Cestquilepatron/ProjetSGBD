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
public class Memoirecentrale {
    private int nbbuffer;
    private Buffer[] Memoire;
    private Basededonnees base;
    
    public void set(int nombre,Basededonnees bd){
        this.nbbuffer = nombre;
        this.Memoire = new Buffer[nombre];
        this.base = bd;
    }
    
    public void composition(int i,Buffer buf){
        this.Memoire[i]= buf;
    }
    
    public Buffer utilisation(int i){
        return this.Memoire[i];
    }
    
    public int get(){
        return this.nbbuffer;
    }
    
    public Basededonnees base(){
        return this.base ;
    }
    
    public void chargement (Table tab,Hashage H){
        int parcourtab = 0;
        while (parcourtab < tab.taille()){//parcours de la table
            
            for (int i=0 ; i < nbbuffer ;i++ ){//chargement des blocs dans les buffers
                try{
                    if (i!=0 && this.Memoire[(i-1)%(nbbuffer-1)].indiceseqrestante()!=0){//Vérification de si la sequence est entierement chargé
                        System.out.println("charge buffer "+i);
                        this.Memoire[i].chargementseq(tab.liaison(parcourtab), base,this.Memoire[(i-1)%(nbbuffer-1)].indiceseqrestante());
                    }
                    else{
                        
                        this.Memoire[i].chargementseq(tab.liaison(parcourtab),base,0);
                        System.out.println("chargement buffer "+i);
                        parcourtab++;
                        
                    }
                }catch(Exception e){System.out.println("chargement fail à l'étape "+i+" tab chargé jusqu'à la séquence "+parcourtab+ " sur une taille de tab de"+ tab.taille());}
            }
            //tout les buffers sont chargés, mais la table ne tient pas dans la memoire centrale, donc on hache les buffers puis on les reremplis
            H.fonctiondehachage("pair");
        }
        H.fonctiondehachage("pair"); //hachage en sortie de while pour finir la table
    }
    
    public Tablehash chargementbucket(Table T){
        Tablehash tabhash=new Tablehash();
        tabhash.set(T.get(), 50);
        int parcourstab=0;
        while (parcourstab < T.taille()){//parcours de la table
            for (int i=0 ; i < nbbuffer ;i++ ){//chargement des blocs dans les buffers
                try{
                    if (i!=0 && this.Memoire[(i-1)%(nbbuffer-1)].indiceseqrestante()!=0){//Vérification de si la sequence est entierement chargé
                        System.out.println("charge buffer "+i);
                        this.Memoire[i].chargementseq(T.liaison(parcourstab), base,this.Memoire[(i-1)%(nbbuffer-1)].indiceseqrestante());
                    }
                    else{
                        System.out.println("chargement buffer "+i);
                        this.Memoire[i].chargementseq(T.liaison(parcourstab),base,0);
                        parcourstab++;
                        
                    }
                }catch(Exception e){System.out.println("chargement fail à l'étape "+i+" tab chargé jusqu'à la séquence "+parcourstab+ " sur une taille de tab de"+ T.taille());}
            }
            //tout les buffers sont chargés, mais la table ne tient pas dans la memoire centrale, donc on hache les buffers puis on les reremplis
           remplissagebucket(tabhash);
        }
        remplissagebucket(tabhash);
        
        return tabhash;
    }
    
    public void remplissagebucket(Tablehash tabhash){
        for (int i = 0; i< nbbuffer; i++){
            try{
                for (int j=0; j< Memoire[i].taille();j++){
                    Block bloc = Memoire[i].dechargement(j);
                    for (int parcour = 0; parcour<bloc.taille();parcour++){
                        Donnees donne = bloc.utilisation(parcour);
                        try{
                            Bucket buck=base.research2(donne.clef());
                            buck.integration(donne);
                            System.out.println("mise dans bucket "+ buck.get()+"réussi pour l'étape "+parcour);
                        }catch(Exception e)
                           {
                                Bucket buck = new Bucket();
                                buck.set(base.get2(), 5, donne.clef());
                                base.add2(buck);
                                tabhash.integration( buck);
                                System.out.println(e +" création puis mise dans bucket réussi pour l'étape "+parcour);
                            }
                    }
                }
            }catch(Exception e){System.out.println("Erreur mise dans bucket "+i);}
        }
    }
    
    
    public void chargement (Tablehash tab, Tablehash tabdeux,Jointure J){
        int parcourstab=0;
        int parcourstabdeux=0;
       do {
            for (int i=0;i<this.nbbuffer/2;i++){
                try{
                    this.Memoire[i].chargement2(tab.liaison(parcourstab));
                    parcourstab++;
                }catch(Exception e){}
            }
            do {
                for (int j=this.nbbuffer/2;j<this.nbbuffer;j++){
                    try{
                        this.Memoire[j].chargement2(tab.liaison(parcourstabdeux));
                        parcourstabdeux++;
                    }catch(Exception e){}

                }
                try{
                    J.jointure();
                    //System.out.println("jointure" +parcourstabdeux+" "+parcourstab);
                }catch (Exception e){}
                
            }while(parcourstabdeux < tabdeux.taille());
            parcourstabdeux=0;
        }while (parcourstab < tab.taille());
        
    }
}
