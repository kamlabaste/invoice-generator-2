import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * I N F 1 1 2 0
 *
 * FacturationTPT : Cette classe calcule et affiche les informations saisies
 * d'une facture de toiture et du nombre total
 * des recouvrements selon l'option choisie, à partir de l'utilisation des
 * différentes méthodes définies
 * qui sont appelées à l'intérieur de la méthode main.
 * 
 * @author Kameha Dylan Labaste-Nauta
 * @version 23 novembre 2022
 *
 *          LABK02049404
 *          labaste-nauta.kameha_dylan@courrier.uqam.ca
 */

public class FacturationTPT {

    // Declaration des constantes.
    public static final String MESSAGE_BIENVENUE = "\n----------------------------------------------------------------"
            + "\nBienvenue dans le système de facturation de \"Toiture-pour-tous\""
            + "\n----------------------------------------------------------------";
    public static final String MESSAGE_CHOIX_MENU = "\n    *** Menu de choix ***\n"
            + "    1. Facturer le recouvrement d'une toiture.\n"
            + "    2. Afficher le nombre de recouvrements et le montant total de tous les recouvrements.\n"
            + "    3. Quitter le programme.\n"
            + "\n    Entrez votre choix : ";
    public static final String MESSAGE_FIN_PROGRAMME = "\nMerci et à la prochaine !";
    public static final double PRIX_ELASTOMERE = 21.75;
    public static final double PRIX_TPO = 13.25;
    public static final double PRIX_EPDM = 12.50;
    public static final double PRIX_GRAVIER_BITUME = 12.25;
    public static final double PRIX_ASPHALTE = 7.50;
    public static final double PRIX_TOLE = 26.50;
    public static final double PRIX_ARDOISE = 36.25;
    public static final String TYPE_TOIT_PLAT = "Plat";
    public static final String TYPE_TOIT_PENTE = "En pente";
    public static final String TYPE_COUVERTURE_ELASTOMERE = "Membrane élastomère";
    public static final String TYPE_COUVERTURE_TPO = "Membrane TPO";
    public static final String TYPE_COUVERTURE_EPDM = "Membrane EPDM";
    public static final String TYPE_COUVERTURE_GRAVIER_BITUME = "Multicouche gravier et bitume";
    public static final String TYPE_COUVERTURE_ASPHALTE = "Bardeau en asphalte";
    public static final String TYPE_COUVERTURE_TOLE = "Tôle";
    public static final String TYPE_COUVERTURE_ARDOISE = "Ardoise";
    public static final String DUREE_VIE_ELASTOMERE = "30 ans";
    public static final String DUREE_VIE_TPO = "28 ans";
    public static final String DUREE_VIE_EPDM = "25 ans";
    public static final String DUREE_VIE_GRAVIER_BITUME = "23 ans";
    public static final String DUREE_VIE_ASPHALTE = "20 ans";
    public static final String DUREE_VIE_TOLE = "50 ans";
    public static final String DUREE_VIE_ARDOISE = "125 ans";
    public static final String PAIEMENT_CASH = "Cash";
    public static final String PAIEMENT_DEBIT = "Débit";
    public static final String PAIEMENT_CREDIT = "Crédit";
    public static final double TAUX_TPS = 0.05;
    public static final double TAUX_TVQ = 0.09975;

    /*
     * Cette methode affiche un message de bienvenue et ne recoit donc aucun
     * parametre.
     */

    public static void affichageMessageBienvenue() {

        System.out.println(MESSAGE_BIENVENUE);
    }

    /*
     * Cette methode invite l'utilisateur a saisir une option du menu qui s'affiche.
     * Elle ne recoit aucun parametre mais
     * retourne la valeur du menu choisie.
     * Si l'option saisie est invalide, elle affiche un message d'erreur et
     * re-invite l'utilisateur a saisir une nouvelle fois.
     * 
     * @return choixMenu
     */

    public static int saisieEtValidationOptionChoisi() {

        System.out.println(MESSAGE_CHOIX_MENU);

        int choixMenu = Clavier.lireInt();

        while (choixMenu < 1 || choixMenu > 3) {
            System.out.println("\nL'option choisie est invalide !");
            System.out.println("\n  *** Menu de choix ***");
            System.out.println("    1. Facturer le recouvrement d'une toiture.");
            System.out.println(
                    "    2. Afficher le nombre de recouvrements et le montant total de tous les recouvrements.");
            System.out.println("    3. Quitter le programme.");
            System.out.print("\nEntrez votre choix : ");
            choixMenu = Clavier.lireInt();
        }

        return choixMenu;
    }

    /*
     * Cette methode invite l'utilisateur a saisir le nom du client. Elle ne recoit
     * aucun parametre mais retourne la valeur saisie.
     * Si le nom saisie ne respecte pas le minimum et le maximum de caratères
     * permis, elle affiche un message d'erreur et re-invite l'utilisateur
     * a saisir une nouvelle valeur.
     * 
     * @return nomClient
     */

    public static String saisirNomClient() {
        String nomClient = "";

        do {
            System.out.print("\nEntrez le nom du client (entre 2 et 25 inclusivement): ");
            nomClient = Clavier.lireString();
            if (nomClient.length() < 2 || nomClient.length() > 25) {
                System.out.print("\nLe nom est invalide !");
            }
        } while (nomClient.length() < 2 || nomClient.length() > 25);

        return nomClient;
    }

    /*
     * Cette methode invite l'utilisateur a saisir le prenom du client. Elle ne
     * recoit aucun parametre mais retourne la valeur saisie.
     * Si le prenom saisie ne respecte pas le minimum et le maximum de caratères
     * permis, elle affiche un message d'erreur et re-invite l'utilisateur
     * a saisir une nouvelle valeur.
     * 
     * @return prenomClient
     */

    public static String saisirPrenomClient() {
        String prenomClient = "";

        do {
            System.out.print("\nEntrez le prénom du client (entre 2 et 25 inclusivement): ");
            prenomClient = Clavier.lireString();
            if (prenomClient.length() < 2 || prenomClient.length() > 25) {
                System.out.print("\nLe prénom est invalide !");
            }
        } while (prenomClient.length() < 2 || prenomClient.length() > 25);

        return prenomClient;
    }

    /*
     * Cette methode invite l'utilisateur a saisir le telephone du client. Elle ne
     * recoit aucun parametre mais retourne la valeur saisie.
     * Si le telephone saisie ne respecte pas le format permis, elle affiche un
     * message d'erreur et re-invite l'utilisateur
     * a saisir une nouvelle valeur.
     * 
     * @return telephoneClient
     */

    public static String saisirTelephoneClient() {

        String telephoneClient = "";
        String temp;

        do {
            System.out.print("\nEntrez le numéro de téléphone du client (format : NNN NNN-NNNN): ");
            temp = Clavier.lireString();
            if (temp.length() == 12) {
                if (temp.charAt(3) == ' ' && temp.charAt(7) == '-') {
                    telephoneClient = temp;
                } else {
                    System.out.println("\nLe numéro de téléphone est invalide !");
                }
            } else {
                System.out.println("\nLe numéro de téléphone est invalide !");
            }
        } while (telephoneClient != temp);

        return telephoneClient;
    }

    /*
     * Cette methode invite l'utilisateur a saisir l'adresse du client. Elle ne
     * recoit aucun parametre mais retourne la valeur saisie.
     * Si l'adresse saisie ne respecte pas le minimum et le maximum de caratères
     * permis, elle affiche un message d'erreur et re-invite l'utilisateur
     * a saisir une nouvelle valeur.
     * 
     * @return adresseClient
     */

    public static String saisirAdresseClient() {

        String adresseClient = "";

        do {
            System.out.print("\nEntrez l'adresse du client : ");
            adresseClient = Clavier.lireString();
            if (adresseClient.length() < 10 || adresseClient.length() > 80) {
                System.out.println("\nL'adresse du client est invalide !");
            }
        } while (adresseClient.length() < 10 || adresseClient.length() > 80);

        return adresseClient;
    }

    /*
     * Cette methode invite l'utilisateur a saisir l'identifiant du type de toit.
     * Elle ne recoit aucun parametre mais retourne la valeur
     * de l'identifiant du type de toit saisie.
     * Si l'identifiant du type de toit saisie est invalide, elle affiche un message
     * d'erreur et re-invite l'utilisateur a saisir une nouvelle fois.
     * 
     * @return choixTypeToit
     */

    public static int choixTypeDeToit() {

        int choixTypeToit;

        do {
            System.out.println("\nEntrez le type de toit (1 pour le toit plat ou 2 pour le toit en pente) : ");
            choixTypeToit = Clavier.lireInt();
            if (choixTypeToit < 1 || choixTypeToit > 2) {
                System.out.println("\nL'identifiant du type de toit est invalide");
            }
        } while (choixTypeToit < 1 || choixTypeToit > 2);

        return choixTypeToit;
    }

    /*
     * Cette methode invite l'utilisateur a saisir l'identifiant du type de
     * couverture pour le type de toit plat. Elle ne recoit aucun parametre
     * mais retourne la valeur de l'identifiant du type de couverture saisie.
     * Si l'identifiant du type de couverture saisie est invalide, elle affiche un
     * message d'erreur et re-invite l'utilisateur a
     * saisir une nouvelle fois.
     * 
     * @return choixTypeCouvertureToit
     */

    public static int choixTypeDeCouvertureToitPlat() {

        int choixTypeCouvertureToit;

        do {
            System.out.print("\nEntrez le type de couverture ( 1 pour la membrane élastomère," +
                    " 2 pour la membrane TPO," +
                    " 3 pour la membrane EPDM," +
                    " ou 4 pour le multicouche gravier et bitume) : ");
            choixTypeCouvertureToit = Clavier.lireInt();
            if (choixTypeCouvertureToit < 1 || choixTypeCouvertureToit > 4) {
                System.out.println("\nL'identifiant du type de la couverture est invalide !");
            }

        } while (choixTypeCouvertureToit < 1 || choixTypeCouvertureToit > 4);

        return choixTypeCouvertureToit;
    }

    /*
     * Cette methode invite l'utilisateur a saisir l'identifiant du type de
     * couverture pour le type de toit en pente. Elle ne recoit aucun parametre
     * mais retourne la valeur de l'identifiant du type de couverture saisie.
     * Si l'identifiant du type de couverture saisie est invalide, elle affiche un
     * message d'erreur et re-invite l'utilisateur a saisir une
     * nouvelle fois.
     * 
     * @return choixTypeCouvertureToit
     */

    public static int choixTypeDeCouvertureToitPente() {

        int choixTypeCouvertureToit;

        do {
            System.out.print("\nEntrez le type de couverture ( 5 pour le bardeau en asphalte," +
                    " 6 pour la tôle," +
                    " 7 pour l'ardoise.) : ");
            choixTypeCouvertureToit = Clavier.lireInt();

            if (choixTypeCouvertureToit < 5 || choixTypeCouvertureToit > 7) {
                System.out.println("\nL'identifiant du type de la couverture est invalide !");
            }

        } while (choixTypeCouvertureToit < 5 || choixTypeCouvertureToit > 7);

        return choixTypeCouvertureToit;
    }

    /*
     * Cette methode invite l'utilisateur a saisir la surface a couvrir. Elle ne
     * recoit aucun parametre mais retourne
     * la valeur de la surface a couvrir saisie.
     * Si la surface a couvrir saisie est inferieur a 0 inclusivement, elle affiche
     * un message d'erreur et re-invite l'utilisateur
     * a saisir une nouvelle fois.
     * 
     * @return surfacePiedCarre
     */

    public static double saisirSurfaceACouvrir() {

        double surfacePiedCarre;

        do {
            System.out.print("\nEntrez la surface à couvrir en pieds carrés : ");
            surfacePiedCarre = Clavier.lireDouble();
            if (surfacePiedCarre <= 0) {
                System.out.println("\nLa surface est invalide !");
            }
        } while (surfacePiedCarre <= 0);

        return surfacePiedCarre;
    }

    /*
     * Cette methode invite l'utilisateur a saisir l'idetifiant du mode de paiement.
     * Elle ne recoit aucun parametre mais retourne
     * la valeur de l'identifiant du mode de paiement saisie.
     * Si l'identifiant du mode de paiement saisie ne respecte pas les criteres,
     * elle affiche un message d'erreur et re-invite l'utilisateur
     * a saisir une nouvelle fois.
     * 
     * @return choixModePaiement
     */

    public static char saisirModeDePaiement() {

        char choixModePaiement;

        do {
            System.out.print("\nEntrez le mode de paiement (s ou S pour Cash, d ou D pour Débit," +
                    " et c ou C pour Crédit) : ");
            choixModePaiement = Clavier.lireCharLn();

            if (choixModePaiement != 's' && choixModePaiement != 'S' && choixModePaiement != 'd'
                    && choixModePaiement != 'D'
                    && choixModePaiement != 'c' && choixModePaiement != 'C') {
                System.out.println("\nL'identifiant du mode de paiement est invalide !");
            }

        } while (choixModePaiement != 's' && choixModePaiement != 'S' && choixModePaiement != 'd'
                && choixModePaiement != 'D'
                && choixModePaiement != 'c' && choixModePaiement != 'C');

        return choixModePaiement;
    }

    /*
     * Cette methode affiche un message d'au revoir. Elle ne recoit aucun parametre
     * et ne retourne aucune valeur.
     */

    public static void affichageMessageFinProgramme() {

        System.out.println(MESSAGE_FIN_PROGRAMME);
    }

    // Méthodes règles d'affaires (ou de calcul)

    /*
     * Cette methode prends 1 parametre et determine le prix de la couverture par
     * pied carre a partir de l'identifiant du type de la couverture saisie.
     * Elle retourne la valeur du prix par pied carre.
     * 
     * @param choixTypeCouvertureToit
     * 
     * @return prixPiedCarre
     */

    public static double prixParPiedCarre(int choixTypeCouvertureToit) {

        double prixPiedCarre;

        switch (choixTypeCouvertureToit) {
            case 1:
                prixPiedCarre = PRIX_ELASTOMERE;
                break;
            case 2:
                prixPiedCarre = PRIX_TPO;
                break;
            case 3:
                prixPiedCarre = PRIX_EPDM;
                break;
            case 4:
                prixPiedCarre = PRIX_GRAVIER_BITUME;
                break;
            case 5:
                prixPiedCarre = PRIX_ASPHALTE;
                break;
            case 6:
                prixPiedCarre = PRIX_TOLE;
                break;
            default:
                prixPiedCarre = PRIX_ARDOISE;
                break;
        }

        return prixPiedCarre;
    }

    /*
     * Cette methode prends 2 parametres et calcule le montant total avant taxes a
     * partir de la surface par pied carre saisie et
     * le prix par pied carre, puis, retourne la valeur du montant total avant
     * taxes.
     * 
     * @param surfacePiedCarre
     * 
     * @param prixPiedCarre
     * 
     * @return totalAvantTaxes
     */

    public static double calculSousTotal(double surfacePiedCarre, double prixPiedCarre) {

        double totalAvantTaxes;

        totalAvantTaxes = surfacePiedCarre * prixPiedCarre;

        return totalAvantTaxes;
    }

    /*
     * Cette methode prends 1 parametre et calcule montant de la TPS a partir du
     * montant total avant taxes, puis, retourne la valeur du montant
     * de la TPS.
     * 
     * @param totalAvantaxes
     * 
     * @return montantTPS
     */

    public static double calculMontantTPS(double totalAvantTaxes) {

        double montantTPS;

        montantTPS = totalAvantTaxes * TAUX_TPS;

        return montantTPS;
    }

    /*
     * Cette methode prends 1 parametre et calcule montant de la TVQ a partir du
     * montant total avant taxes, puis, retourne la valeur du montant
     * de la TVQ.
     * 
     * @param totalAvantaxes
     * 
     * @return montantTVQ
     */

    public static double calculMontantTVQ(double totalAvantTaxes) {

        double montantTVQ;

        montantTVQ = totalAvantTaxes * TAUX_TVQ;

        return montantTVQ;
    }

    /*
     * Cette methode prends 3 parametres et calcule le montant total apres taxes a
     * partir du montant total avant taxes, montant de la TPS, et montant
     * de la TVQ, puis, retourne le montant total apres taxes.
     * 
     * @param totalAvantTaxes
     * 
     * @param montantTPS
     * 
     * @param montantTVQ
     * 
     * @return totalFacture
     */

    public static double calculMontantTotal(double totalAvantTaxes, double montantTPS, double montantTVQ) {

        double totalFacture;

        totalFacture = totalAvantTaxes + (montantTPS + montantTVQ);

        return totalFacture;
    }

    /*
     * Cette methode prends 1 parametre et incremente le numero de la facture. Elle
     * retourne la valeur du numero de la facture.
     * 
     * @param numeroFacture
     * 
     * @return numeroFacture
     */

    public static int calculeNumeroFacture(int numeroFacture) {

        numeroFacture += 1;

        return numeroFacture;
    }

    /*
     * Cette methode prends 2 parametres et calcule le montant total de toutes les
     * factures. Elle retourne la valeur du montant total de toutes
     * ces factures.
     * 
     * @param totalFacture
     * 
     * @param totalMontantRecouvrement
     * 
     * @return totalMontantRecouvrement
     */

    public static double calculTotalMontantRecouvrements(double totalFacture, double totalMontantRecouvrement) {

        totalMontantRecouvrement = totalFacture + totalMontantRecouvrement;

        return totalMontantRecouvrement;
    }

    // Méthodes pour l'affichage de la facture

    /*
     * Cette methode prends 1 parametre et retourne la valeur du nom du type de
     * couverture.
     * 
     * @param choixTypeCouvertureToit
     * 
     * @return typeCouvertureToit
     */

    public static String nomTypeCouverture(int choixTypeCouvertureToit) {

        String typeCouvertureToit;

        switch (choixTypeCouvertureToit) {
            case 1:
                typeCouvertureToit = TYPE_COUVERTURE_ELASTOMERE;
                break;
            case 2:
                typeCouvertureToit = TYPE_COUVERTURE_TPO;
                break;
            case 3:
                typeCouvertureToit = TYPE_COUVERTURE_EPDM;
                break;
            case 4:
                typeCouvertureToit = TYPE_COUVERTURE_GRAVIER_BITUME;
                break;
            case 5:
                typeCouvertureToit = TYPE_COUVERTURE_ASPHALTE;
                break;
            case 6:
                typeCouvertureToit = TYPE_COUVERTURE_TOLE;
                break;
            default:
                typeCouvertureToit = TYPE_COUVERTURE_ARDOISE;
                break;
        }

        return typeCouvertureToit;
    }

    /*
     * Cette methode prend 1 parametre et retourne la duree de vie de la couverture
     * a partir de l'identifiant du choix de
     * type de couverture.
     * 
     * @param choixTypeCouvertureToit
     * 
     * @return dureeVieCouverture
     */

    public static String dureeDeVieTypeCouverture(int choixTypeCouvertureToit) {

        String dureeVieCouverture;

        switch (choixTypeCouvertureToit) {
            case 1:
                dureeVieCouverture = DUREE_VIE_ELASTOMERE;
                break;
            case 2:
                dureeVieCouverture = DUREE_VIE_TPO;
                break;
            case 3:
                dureeVieCouverture = DUREE_VIE_EPDM;
                break;
            case 4:
                dureeVieCouverture = DUREE_VIE_GRAVIER_BITUME;
                break;
            case 5:
                dureeVieCouverture = DUREE_VIE_ASPHALTE;
                break;
            case 6:
                dureeVieCouverture = DUREE_VIE_TOLE;
                break;
            default:
                dureeVieCouverture = DUREE_VIE_ARDOISE;
                break;
        }

        return dureeVieCouverture;
    }

    /*
     * Cette methode prend 1 parametre et retourne le mode de paiement a partir de
     * l'identifiant du choix du
     * mode de paiement.
     * 
     * @param choixModePaiement
     * 
     * @return modePaiement
     */

    public static String affichageModeDePaiement(char choixModePaiement) {

        String modePaiement;

        switch (choixModePaiement) {
            case 's':
                modePaiement = PAIEMENT_CASH;
                break;
            case 'S':
                modePaiement = PAIEMENT_CASH;
                break;
            case 'd':
                modePaiement = PAIEMENT_DEBIT;
                break;
            case 'D':
                modePaiement = PAIEMENT_DEBIT;
                break;
            case 'c':
                modePaiement = PAIEMENT_CREDIT;
                break;
            default:
                modePaiement = PAIEMENT_CREDIT;
                break;
        }

        return modePaiement;
    }

    /*
     * Cette methode prend 1 parametre et retourne le nom du type de toit a partir
     * de l'identifiant du choix du
     * type de toit.
     * 
     * @param choixTypeToit
     * 
     * @return typeToit
     */

    public static String nomTypeToit(int choixTypeToit) {

        String typeToit;

        if (choixTypeToit == 1) {
            typeToit = TYPE_TOIT_PLAT;
        } else {
            typeToit = TYPE_TOIT_PENTE;
        }

        return typeToit;
    }

    /*
     * Cette methode prends 1 parametre et additionne 1 sur la valeur du nombre de
     * recouvrement, puis, retourne cette valeur.
     * 
     * @ param nombreRecouvrement
     * 
     * @return nombreRecouvrement
     */

    public static int calculNombreRecouvrement(int nombreRecouvrement) {

        nombreRecouvrement += 1;

        return nombreRecouvrement;
    }

    /*
     * Cette methode prends 15 parametres et affiche la facture a partir des valeurs
     * retournées pour ces parametre. Elle ne retourne aucune valeur.
     * 
     * @param numeroFacture
     * 
     * @param nomClient
     * 
     * @param prenomClient
     * 
     * @param telephoneClient
     * 
     * @param adresseClient
     * 
     * @param typeToit
     * 
     * @param typeCouvertureToit
     * 
     * @param dureeVieCouverture
     * 
     * @param surfacePiedCarre
     * 
     * @param modePaiement
     * 
     * @param prixPiedCarre
     * 
     * @param totalAvantTaxes
     * 
     * @param montantTPS
     * 
     * @param montantTVQ
     * 
     * @param totalFacture
     */

    public static void affichageFacture(int numeroFacture, String nomClient, String prenomClient,
            String telephoneClient, String adresseClient, String typeToit,
            String typeCouvertureToit, String dureeVieCouverture, double surfacePiedCarre,
            String modePaiement, double prixPiedCarre, double totalAvantTaxes, double montantTPS, double montantTVQ,
            double totalFacture) {

        // Ajout de la date sur l'affichage de la facture
        LocalDateTime dateHeureSysteme = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

        System.out.println("\n------------------------------------------------------------------------------------");
        System.out.println("    Toiture-Pour-Tous | 145 boulevard Java, Chisasibi, QC | (816) 218-1010");
        System.out.println(
                "    Facture no: " + numeroFacture + "     | Date et Heure : " + dateHeureSysteme.format(formatter));
        System.out.println("------------------------------------------------------------------------------------");
        System.out.printf("\n    Nom et prénom : %s %s            Téléphone : %s", nomClient, prenomClient,
                telephoneClient);
        System.out.println("\n    Adresse du client : " + adresseClient);
        System.out.println("    Type de toit : " + typeToit);
        System.out.println("    Type de couverture : " + typeCouvertureToit);
        System.out.println("    La durée de vie : " + dureeVieCouverture);
        System.out.println("\n    La surface à couvrir : " + surfacePiedCarre + " pied carré.");
        System.out.println("    Le mode de paiement : " + modePaiement);
        System.out.printf("\n    Prix par pieds carré :              %.2f $", prixPiedCarre);
        System.out.printf("\n    Sous-total :                        %.2f $", totalAvantTaxes);
        System.out.printf("\n    Montant TPS :                       %.2f $", montantTPS);
        System.out.printf("\n    Montant TVQ :                       %.2f $", montantTVQ);
        System.out.printf("\n    Montant total :                     %.2f $", totalFacture);
        System.out.println("\n          ---------------------------------------------------         ");
        System.out.println("                        Merci pour votre confiance          ");
        System.out.println("\n");
    }

    /*
     * Cette methode prends 2 parametres et affiche le nombre de recouvrement ainsi
     * que le montant total de toutes les factures.
     * Elle ne retourne aucune valeur.
     * 
     * @param nombreRecouvrement
     * 
     * @param totalMontantRecouvrement
     */

    public static void affichageRecouvrement(int nombreRecouvrement, double totalMontantRecouvrement) {

        // Ajout de la date sur l'affichage du total de tous les recouvrements
        LocalDateTime dateHeureSysteme = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

        System.out.println("\n------------------------------------------------------------------------------------");
        System.out.println("    Toiture-Pour-Tous | Date et Heure : " + dateHeureSysteme.format(formatter));
        System.out.println("------------------------------------------------------------------------------------");
        System.out.println("\n");
        System.out.println("    Le nombre de recouvrements                                   " + nombreRecouvrement);
        System.out.printf("    Le montant total de toutes les installations                 %.2f $",
                totalMontantRecouvrement);
        System.out.println("\n");
        System.out.println("\n------------------------------------------------------------------------------------");
        System.out.println("\n");
    }

    public static void main(String[] params) {

        // Déclaration des variables
        int choixMenu;
        String nomClient;
        String prenomClient;
        String telephoneClient;
        String adresseClient;
        int choixTypeToit;
        String typeToit;
        int choixTypeCouvertureToit;
        String typeCouvertureToit;
        String dureeVieCouverture;
        char choixModePaiement;
        String modePaiement;
        double surfacePiedCarre;
        double prixPiedCarre;
        double totalAvantTaxes;
        double montantTPS;
        double montantTVQ;
        double totalFacture;
        int numeroFacture = 0;
        int nombreRecouvrement = 0;
        double totalMontantRecouvrement = 0.0;

        // Affichage du message de bienvenu et du menu des options
        affichageMessageBienvenue();

        do {

            // Saisir et valider l'option du Menu choisi
            choixMenu = saisieEtValidationOptionChoisi();

            // Menu choix numéro 1
            if (choixMenu == 1) {

                // Saisir le nom du client
                nomClient = saisirNomClient();

                // Saisir le prenom du client
                prenomClient = saisirPrenomClient();

                // Saisir le numero de telephone du client
                telephoneClient = saisirTelephoneClient();

                // Saisir l'adresse du client
                adresseClient = saisirAdresseClient();

                // Saisir le choix du type de toit
                choixTypeToit = choixTypeDeToit();

                // Retourne le nom du type de toit choisi
                typeToit = nomTypeToit(choixTypeToit);

                if (choixTypeToit == 1) {
                    // Si l'identifiant du type de toit choisi est 1
                    choixTypeCouvertureToit = choixTypeDeCouvertureToitPlat();

                } else {

                    // Si l'identifiant du type de toit choisi est 2
                    choixTypeCouvertureToit = choixTypeDeCouvertureToitPente();

                }

                // Retourne le nom du type de couverture choisi selon le type de toit choisi
                typeCouvertureToit = nomTypeCouverture(choixTypeCouvertureToit);

                // Retourne la duree de vie du type de couverture selon le type de toit choisi
                dureeVieCouverture = dureeDeVieTypeCouverture(choixTypeCouvertureToit);

                // Saisir la surface a couvrir en pied carre
                surfacePiedCarre = saisirSurfaceACouvrir();

                // Saisir le mode de paiement
                choixModePaiement = saisirModeDePaiement();

                // Retourne le nom du mode de paiement choisie
                modePaiement = affichageModeDePaiement(choixModePaiement);

                // Retourne le prix par pied carre
                prixPiedCarre = prixParPiedCarre(choixTypeCouvertureToit);

                // Calcul le montant avant taxes
                totalAvantTaxes = calculSousTotal(surfacePiedCarre, prixPiedCarre);

                // Calcul le montant de la TPS
                montantTPS = calculMontantTPS(totalAvantTaxes);

                // Calcul le montant de la TVQ
                montantTVQ = calculMontantTVQ(totalAvantTaxes);

                // Calcul le montant total apres taxes
                totalFacture = calculMontantTotal(totalAvantTaxes, montantTPS, montantTVQ);

                // Incremente le numero de facture
                numeroFacture = calculeNumeroFacture(numeroFacture);

                // Incremente le nombre total de recouvrement
                nombreRecouvrement = calculNombreRecouvrement(nombreRecouvrement);

                // Calcul le montant total de toutes les factures
                totalMontantRecouvrement = calculTotalMontantRecouvrements(totalFacture, totalMontantRecouvrement);

                // Affiche la facture
                affichageFacture(numeroFacture, nomClient, prenomClient,
                        telephoneClient, adresseClient, typeToit,
                        typeCouvertureToit, dureeVieCouverture, surfacePiedCarre,
                        modePaiement, prixPiedCarre, totalAvantTaxes, montantTPS, montantTVQ, totalFacture);

            } else if (choixMenu == 2) {

                // Affiche le nombre et le montant total de tous les recouvrements
                affichageRecouvrement(nombreRecouvrement, totalMontantRecouvrement);
            } else {

                // Quitte le programme
                choixMenu = 3;
            }

        } while (choixMenu == 1 || choixMenu == 2);

        // Affichage du message de remerciement et arrêt du programme
        affichageMessageFinProgramme();

    } // main

} // FacturationTPT
