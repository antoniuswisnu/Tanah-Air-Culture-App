package com.example.tanahair;

import java.util.ArrayList;

public class Data {
    private static String[] nama = {
        "Jogja",
            "Malioboro",
            "Candi Borobudur",
            "Parang Tritis",
            "Taman Sari"
    };

    private static String[] rating = {
            "4.7",
            "3.8",
            "4.9",
            "4.3",
            "4.6"
    };


    private static String[] deskripsi = {
        "Yogyakarta (often called “Jogja”) is a city on the Indonesian island of Java known for its traditional arts and cultural heritage. Its ornate 18th-century royal complex, or kraton, encompasses the still-inhabited Sultan’s Palace. Also within the kraton are numerous open-air pavilions that host classical Javanese dance shows and concerts of gamelan music, characterized by gongs, chimes and plucked string instruments. ",
            "Jalan Malioboro is a major shopping street in Yogyakarta, Indonesia; the name is also used more generally for the neighborhood around the street. It lies north–south axis in the line between Yogyakarta Kraton and Mount Merapi",
            "Borobudur, also transcribed Barabudur is a 9th-century Mahayana Buddhist temple in Magelang Regency, not far from the city of Magelang and the town of Muntilan, in Central Java, Indonesia. It is the world's largest Buddhist temple.",
            "Parangtritis Beach is a tourist beach on the southern coast of Java, in the Bantul Regency within the Special Region of Yogyakarta, Indonesia. There is a road to the area which is about 30 km south of the city of Yogyakarta. ",
            "Taman Sari Water Castle, also known as Taman Sari, is the site of a former royal garden of the Sultanate of Yogyakarta. It is located about 2 km south within the grounds of the Kraton, Yogyakarta, Indonesia. ",
    };

    private static int[] photo = {
        R.drawable.gudeg2,
            R.drawable.malioboro,
            R.drawable.borobudur,
            R.drawable.parang,
            R.drawable.tamansari
    };

    static ArrayList<Cultures> getListData(){
        ArrayList<Cultures> list = new ArrayList<>();
        for(int i = 0; i < nama.length; i++){
            Cultures cultures = new Cultures();
            cultures.setNama(nama[i]);
            cultures.setRating(rating[i]);
            cultures.setDeskripsi(deskripsi[i]);
            cultures.setPhoto(photo[i]);
            list.add(cultures);
        }
        return list;
    }
}
