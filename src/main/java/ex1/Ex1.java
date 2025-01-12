package ex1;
import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.core.exc.StreamWriteException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.io.File;
import java.io.IOException;
import java.sql.SQLOutput;
import java.time.Period;
import java.util.*;
import java.util.stream.Collectors;


public class Ex1 {

    public static void scriere(Map<Integer, Carte> carti) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            mapper.registerModule(new JavaTimeModule());
            mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
            File file = new File("src/main/resources/carti.json");
            mapper.writeValue(file, carti);
        } catch (StreamWriteException e) {
            throw new RuntimeException(e);
        } catch (DatabindException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static Map<Integer, Carte> citire() {
        try {
            File file = new File("src/main/resources/carti.json");
            ObjectMapper mapper = new ObjectMapper();
            mapper.registerModule(new JavaTimeModule());
            Map<Integer, Carte> carti = mapper.readValue(file, new TypeReference<Map<Integer, Carte>>() {
            });
            return carti;
        } catch (StreamReadException e) {
            throw new RuntimeException(e);
        } catch (DatabindException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    public static void main(String[] args) {
int opt;
            Scanner scanner=new Scanner(System.in);
Map<Integer, Carte> map=new HashMap<Integer,Carte>();
map=citire();
        int id;
        String titlul;
        String autorul;
        int anul;
        Set<Carte> carti_set = Set.of();
do{
    System.out.println("\nMeniu: ");
    System.out.println("0.Iesire!");
    System.out.println("1.Afisarea colectiei!");
    System.out.println("2.Stergerea unei carti din colectia Map!");
    System.out.println("3.Adaugarea unei carti la colectia Map!");
    System.out.println("4.Salvarea în fișierul JSON modificările făcute asupra colecției!");
    System.out.println("5.Crearea unei colecții Set<Carte> care extrage din colecția Map cărțile autorului Yual Noah Harari!");
    System.out.println("6.Afisarea ordonata a elementelor din colecția Set, dupa titlul cartii");
    System.out.println("7.Afisarea datelor celei mai vechi cărți din colecția Set");
    System.out.println("Introduceti optiunea");
    opt=scanner.nextInt();
    switch (opt)
    {
        case 0: System.exit(0);
        break;
        case 1:var setentry=map.entrySet();
        var it=setentry.iterator();
        while(it.hasNext())
        {
            var m=it.next();
            Integer key=m.getKey();
            Carte val=m.getValue();
            System.out.println( + key + ":" + val);

        }
            break;
        case 2:    System.out.print("Introduceti id-ul cartii pe care doriti sa o stergeti: ");
            id = scanner.nextInt();
            var entryset=map.entrySet();
            var ite=entryset.iterator();
            while(ite.hasNext())
            {
                var ma=ite.next();
                if(ma.getKey()==id)
                {
                    ite.remove();
                }
            }
            System.out.println();
            break;
        case 3:
            System.out.println("Introduceti id-ul cartii pe care vrei sa o adaugi la colectie");
            int idcartead=scanner.nextInt();
            scanner.nextLine();
            System.out.println("Introduceti titlu:");
            String titlu=scanner.nextLine();
            System.out.println("Introduceti autor:");
            String autor=scanner.nextLine();
            System.out.println("Introduceti anul:");
            int an=scanner.nextInt();
            scanner.nextLine();
            map.putIfAbsent(idcartead,new Carte(titlu,autor,an));
            break;
        case 4:scriere(map);
            System.out.println();
            break;
        case 5:carti_set=
                map.values()
                .stream()
                .filter((a)->a.autorul().equals("Yuval Noah Harari"))
                .collect(Collectors.toSet());
                carti_set.forEach(System.out::println);
            break;
        case 6:carti_set
                .stream()
                .sorted((a,b)->a.titlul().compareTo(b.titlul()))
                .forEach(System.out::println);
            break;
        case 7:Optional<Carte> cartivechi=carti_set
                .stream()
                .min(Comparator.comparing(Carte::anul));
            if(cartivechi.isPresent())

            {
                carti_set
                        .stream()
                        .filter((a)->a.anul()==cartivechi.get().anul())
                        .forEach(System.out::println);
            }
            break;
        default:
            System.out.println("Ati introdus optiunea gresita");
            break;
    }
}while(true);

        }
}
