package com.openclassrooms.entrevoisins.service;

import com.openclassrooms.entrevoisins.model.Neighbour;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;




public abstract class DummyNeighbourGenerator {

    public static List<Neighbour> DUMMY_NEIGHBOURS = Arrays.asList(
           new Neighbour(2, "Jack", "http://i.pravatar.cc/150?u=a042581f4e29026704e","Aurice à 0km",  "+33 6 45 62 90 77", "Bonsoir ! Fraichement débarqué sur ce site et peu habitué des réseaux sociaux, je cherche juste un peu de compagnie pour me faire oublier ma sollitude. Merci de me répondre même si vous n'êtes pas intéressé. "),
            new Neighbour(3, "Chloé", "http://i.pravatar.cc/150?u=a042581f4e29026704f", "Le Leuy à 1km",  "+33 6 56 21 98 31", "Salut tout le monde ! Je viens de déménager et j'aimerais trouver de nouvelles amies pour sortiret me faire découvrir votre belle ville, des volontaires ? ^^"),
            new Neighbour(4, "Vincent", "http://i.pravatar.cc/150?u=a042581f4e29026704a", "Lamothe à 2km",  "+33 7 35 36 23 90", "Bonjour, photographe à mes heures perdues je cherche de nouveaux modèles photo et pourquoi pas celle qui pourra inspirer ma vie, n'hésitez pas à me contacter !"),
            new Neighbour(5, "Elodie", "http://i.pravatar.cc/150?u=a042581f4e29026704b", "Cauna à 2km",  "+33 6 45 62 38 90", " Elodie 26 ans, mannequin et passionnée de mode, si t'as pas confiance en toi ne viens pas me parler merci."),
            new Neighbour(6, "Sylvain", "http://i.pravatar.cc/150?u=a042581f4e29026704c", "Bas-Mauco à 2km",  "+33 6 12 21 34 23", "Gentil Barbu cherche gentils compagnons pour faire des petites balades en ville. Je réponds à tout le monde dès que je peux :-) "),
            new Neighbour(7, "Laetitia", "http://i.pravatar.cc/150?u=a042581f4e29026703d", "Haut-Mauco à 2km",  "+33 6 94 53 48 63", "Je m'ennuie beaucoup et je cherche de quoi passer le temps et me découvrir de nouvelles passions. J'aime les animaux, le cinéma et les sorties en vélos."),
            new Neighbour(8, "Dan", "http://i.pravatar.cc/150?u=a042581f4e29026703b", "Campagne à 3km ",  "+33 6 21 95 46 32", "Beau mec bien dans sa peau. Oui c'est bien moi sur la photo je ne suis pas un fake contrairement à Joseph le trans pas très discret qui a piqué la photo de Caroline..."),
            new Neighbour(9, "Joseph", "http://i.pravatar.cc/150?u=a042581f4e29026704d", "Saint-Perdon à 4km",  "+33 6 97 86 70 86", "Bonjur je sui Joseph belle fille anciennment homme qui recherche quelqu'un qui poura me fair sentir mieux, j'aime les hommes direct et je naime pas perdre mon temps A tout de suite "),
            new Neighbour(10, "Emma", "http://i.pravatar.cc/150?u=a042581f4e29026706d", " Benquet à 4km ",  "+33 7 26 43 10 02", "Jeune directrice et femme d'affaire je n'ai pas peur de ce que l'on pense de moi et fait toujours ce qu'il faut pour obtenir ce que je veux. Malheureusement ça ne m'empêche pas de me sentir seule..."),
            new Neighbour(11, "Patrick", "http://i.pravatar.cc/150?u=a042581f4e29026702d", "Saint-Sever à 4km ",  "+33 7 56 10 83 67", "Bon jour vend de tout : vetements, livres, montres.... Contacter moi à ce numero si vous êtes intéressé : +33 7 56 10 83 67 "),
            new Neighbour(12, "Ludovic", "http://i.pravatar.cc/150?u=a042581f3e39026702d", "Bretagne de Marsan à 5km",  "+33 6 23 56 03 77", "Bonjour, si j'écris tout ici de quoi allons nous parler ? Venez je ne mors pas ! (sauf si on le demande...)"),
            new Neighbour(1, "Caroline", "http://i.pravatar.cc/150?u=a042581f4e29026704d", "Saint pierre du mont à 5km",  "+33 6 86 57 90 14", "Bonjour ! Je souhaiterais faire de le marche nordique. Pas initiée, je recherche une ou plusieurs personnes suceptibles de m\'accompagner !J\'aime les jeux de cartes tels la belote et le tarot... ")

    );

    public static List<Neighbour> DUMMY_NEIGHBOURS_STAR = Arrays.asList(
            new Neighbour(1, "Caroline", "http://i.pravatar.cc/150?u=a042581f4e29026704d", "Saint pierre du mont à 5km",  "+33 6 86 57 90 14", "Bonjour ! Je souhaiterais faire de le marche nordique. Pas initiée, je recherche une ou plusieurs personnes suceptibles de m\'accompagner !J\'aime les jeux de cartes tels la belote et le tarot... "),
            new Neighbour(11, "Patrick", "http://i.pravatar.cc/150?u=a042581f4e29026702d", "Saint-Sever à 4km ",  "+33 7 56 10 83 67", "Bon jour vend de tout : vetements, livres, montres.... Contacter moi à ce numero si vous êtes intéressé : +33 7 56 10 83 67 ")


    );

    static List<Neighbour> generateNeighbours() {
        return new ArrayList<>(DUMMY_NEIGHBOURS);
    }
    static List<Neighbour> generateNeighboursStar() {
        return new ArrayList<>(DUMMY_NEIGHBOURS_STAR);
    }
}
