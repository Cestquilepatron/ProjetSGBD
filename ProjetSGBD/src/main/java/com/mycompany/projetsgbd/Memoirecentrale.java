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
        System.out.println("\n \n \n \n Début hachage\n \n \n");
        
        while (parcourtab < tab.taille()){//parcours de la table
            boolean prece;
            for (int i=0 ; i < this.nbbuffer ;i++ ){//chargement des blocs dans les buffers
                try{
                    if (i==0){
                        
                        prece = !(this.Memoire[this.nbbuffer-1].Seqfinie());
                    }
                    else{
                        prece=!(this.Memoire[i-1].Seqfinie());
                    }
                   
                    if (prece){//Vérification de si la sequence est entierement chargé
                        System.out.println("charge buffer "+i);System.out.println("buffer"+(i-1)%(nbbuffer-1)+" indice "+this.Memoire[(i-1)%(nbbuffer-1)].indiceseqrestante()+" "+this.Memoire[(i-1)%(nbbuffer-1)].Seqfinie());
                        this.Memoire[i].chargementseq(tab.liaison(parcourtab), this.base,this.Memoire[(i-1)%(this.nbbuffer-1)].indiceseqrestante());
                        if (this.Memoire[i].Seqfinie()){
                            System.out.println("\n\n\n\n\n\n\n parcours en cours \n\n\n\n\n");
                            parcourtab++;
                        }
                    }
                    else{
                        System.out.println("chargement buffer "+i +" truc" + (i!=0||parcourtab!=0) + " buf prec" + (i-1)%(nbbuffer-1));
                        this.Memoire[i].chargementseq(tab.liaison(parcourtab),this.base,0);
                        if (this.Memoire[i].Seqfinie()){
                            System.out.println("\n\n\n\n\n\n\n parcours en cours \n\n\n\n\n");
                            parcourtab++;
                        }
                        
                        
                    }
                }catch(Exception e){System.out.println("chargement pour hash fail à l'étape "+i+" tab chargé jusqu'à la séquence "+parcourtab+ " sur une taille de tab de"+ tab.taille());}
            }
            //tout les buffers sont chargés, mais la table ne tient pas dans la memoire centrale, donc on hache les buffers puis on les reremplis
            H.fonctiondehachage();
        }
        H.fonctiondehachage();//hachage en sortie de while pour finir la table
        System.out.println("\n \n \n \n Fin hachage\n \n \n");
        for (int i=0 ; i < this.nbbuffer ;i++ ){
            this.Memoire[i].videBuff();
        }
    }
    
    public Tablehash chargementbucket(Table T){
        int prece;
        Tablehash tabhash=new Tablehash();
        tabhash.set(T.get(), 50);
        int parcourstab=0;
        System.out.println("\n \n \n \n Début bucket\n \n \n");
        while (parcourstab < T.taille()){//parcours de la table
            for (int i=0 ; i < nbbuffer ;i++ ){//chargement des blocs dans les buffers
                try{
                    if (i==0){
                        
                        prece = this.Memoire[this.nbbuffer-1].indiceseqrestante() ;
                    }
                    else{
                        prece= this.Memoire[(i-1)%(this.nbbuffer)].indiceseqrestante() ;
                    }
                    
                    if ( prece!=0 ){//Vérification de si la sequence est entierement chargé
                        System.out.println("charge buffer "+i);
                        this.Memoire[i].chargementseq(T.liaison(parcourstab), this.base,prece/*this.Memoire[(i-1)%(nbbuffer-1)].indiceseqrestante()*/);
                        if(this.Memoire[i].Seqfinie()){
                            parcourstab++;
                        }
                    }
                    else{
                        System.out.println("chargement buffer "+i);
                        this.Memoire[i].chargementseq(T.liaison(parcourstab),this.base,0);
                        if (this.Memoire[i].Seqfinie()){
                            parcourstab++;
                        }
                        
                    }
                    if (i==0){
                        this.Memoire[nbbuffer-1].videBuff();
                    }
                }catch(Exception e){System.out.println("chargement pour mise dans bucket fail à l'étape "+i+" tab chargé jusqu'à la séquence "+parcourstab+ " sur une taille de tab de"+ T.taille());}
            }
            //tout les buffers sont chargés, mais la table ne tient pas dans la memoire centrale, donc on hache les buffers puis on les reremplis
           remplissagebucket2(tabhash);
           for (int i=0 ; i < this.nbbuffer-1 ;i++ ){
                this.Memoire[i].videBuff();
            }
           System.out.println(" Buffer vidé");
        }
        remplissagebucket2(tabhash);
        System.out.println("\n \n \n Fin mise en bucket\n \n \n");
        for (int i=0 ; i < this.nbbuffer ;i++ ){
            this.Memoire[i].videBuff();
        }
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
                            Bucket buck=base.researchclef(donne.clef());
                            boolean pascomplet = buck.pascomplet();
                            boolean associe=tabhash.get().equals(buck.tableassocie());
                            boolean nonlie=buck.tableassocie().equals("");
                            boolean clef = donne.clef()==buck.clef();
                            if ( pascomplet && (associe|| nonlie) && clef ){//buck n'est pas complet, est bien lié à tabhash ou lié à aucune table
                               buck.integration(donne,tabhash.get());
                               System.out.println("mise dans bucket "+ buck.get()+"de clef "+buck.clef()+" réussi pour l'étape "+parcour +"alors que"+buck.place()+" "+buck.pascomplet()+"et que clef données="+donne.clef()); 
                            }
                            else{
                                buck.set(base.get2(), 5, donne.clef());
                                buck.integration(donne,tabhash.get());
                                base.add2(buck);
                                tabhash.integration( buck);
                                System.out.println(pascomplet+" "+associe+" "+nonlie+" création puis mise dans bucket "+base.get2()+"de clef"+donne.clef()+" réussi pour l'étape "+parcour);
                            }
                            
                        }catch(Exception e)
                           {
                                Bucket buck = new Bucket();
                                buck.set(base.get2(), 5, donne.clef());
                                buck.integration(donne,tabhash.get());
                                base.add2(buck);
                                tabhash.integration( buck);
                                System.out.println(e +" création puis mise dans bucket "+base.get2()+"de clef"+donne.clef()+" réussi pour l'étape "+parcour);
                            }
                    }
                }
            }catch(Exception e){System.out.println(e+" Erreur mise dans bucket du buffer "+i);}
        }
    }
    
     public void remplissagebucket2(Tablehash tabhash){
        for (int i = 0; i< nbbuffer; i++){
            try{
                for (int j=0; j< Memoire[i].taille();j++){
                    Block bloc = Memoire[i].dechargement(j);
                    for (int parcour = 0; parcour<bloc.taille();parcour++){
                        Donnees donne = bloc.utilisation(parcour);
                        try{
                            Bucket buck=tabhash.researchclef(donne.clef());
                            boolean pascomplet = buck.pascomplet();
                            boolean associe=tabhash.get().equals(buck.tableassocie());
                            boolean nonlie=buck.tableassocie().equals("");

                            if ( pascomplet && (associe|| nonlie) ){//buck n'est pas complet, est bien lié à tabhash ou lié à aucune table
                               buck.integration(donne,tabhash.get());
                               System.out.println("mise dans bucket "+ buck.get()+"de clef "+buck.clef()+" réussi pour l'étape "+parcour +"alors que"+buck.place()+" "+buck.pascomplet()+"et que clef données="+donne.clef()); 
                            }
                            else{
                                buck.set(base.get2(), 5, donne.clef());
                                buck.integration(donne,tabhash.get());
                                tabhash.integration( buck);
                                System.out.println(pascomplet+" "+associe+" "+nonlie+" création puis mise dans bucket "+base.get2()+"de clef"+donne.clef()+" réussi pour l'étape "+parcour);
                            }
                            
                        }catch(Exception e)
                           {
                                Bucket buck = new Bucket();
                                buck.set(base.get2(), 5, donne.clef());
                                buck.integration(donne,tabhash.get());
                                tabhash.integration( buck);
                                System.out.println(e +" création puis mise dans bucket "+base.get2()+"de clef"+donne.clef()+" réussi pour l'étape "+parcour);
                            }
                    }
                }
            }catch(Exception e){System.out.println(e+" Erreur mise dans bucket du buffer "+i);}
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
                        this.Memoire[j].chargement2(tabdeux.liaison(parcourstabdeux));
                        parcourstabdeux++;
                    }catch(Exception e){}

                }
                try{
                    J.jointure();
                    System.out.println("bob");
                }catch (Exception e){System.out.println(e);}
                
            }while(parcourstabdeux < tabdeux.taille());
            parcourstabdeux=0;
        }while (parcourstab < tab.taille());
       
       System.out.println("\n Fin JOINTURE \n");
        for (int i=0 ; i < this.nbbuffer ;i++ ){
            this.Memoire[i].videBuff();
        }
    }
}
