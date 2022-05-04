package manager;

import models.Contact;
import models.User;
import org.testng.annotations.DataProvider;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MyDataProvider {

    @DataProvider
    public Iterator<Object[]> validLoginData() {

        List<Object[]> list = new ArrayList<>();
        list.add(new Object[]{"noa@gmail.com","Nnoa12345$"});//polojili v kollekziu stringi
        list.add(new Object[]{"mona@gmail.com","Mm12345$"});
        list.add(new Object[]{"zoa@gmail.com","Zoa12345$"});
        list.add(new Object[]{"wick416@gmail.com","Ww12345$"});

        return list.iterator();
    }

    @DataProvider
    public Iterator<Object[]> validModelLogin() {
        List<Object[]> list = new ArrayList<>();
        list.add(new Object[]{new User().withEmail("noa@gmail.com").withPassword("Nnoa12345$")});
        list.add(new Object[]{new User().withEmail("mona@gmail.com").withPassword("Mm12345$")});
        list.add(new Object[]{new User().withEmail("zoa@gmail.com").withPassword("Zoa12345$")});
        list.add(new Object[]{new User().withEmail("wick416@gmail.com").withPassword("Ww12345$")});

        return list.iterator();
    }

    @DataProvider
    public Iterator<Object[]> validModelCSV() throws IOException {
        List<Object[]> list = new ArrayList<>();

        BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/login.csv")));
        String line = reader.readLine(); //"noa@gmail.com,Nnoa12345$"
        while (line != null) {
            String[] split = line.split(",");// [noa@gmail.com] [Nnoa12345$"]
            list.add(new Object[]{new User().withEmail(split[0]).withPassword(split[1])}); //mi ispolzovali tolko pervuyu stroku
            line = reader.readLine();//chitaem 2-yu stroku --> missmira85@gmail.com
            //posle posledney stroki, mi vozvrashaemsia na proverku, no t.k. tam nichego net, to mi poluchiim null
            // null nam ne podhodit, poetomu zikl zakanchivaetsia na etom

        }

        return list.iterator();
    }

    @DataProvider
    public Iterator<Object[]> validDataContact() throws IOException {
        List<Object[]> list = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/contact.csv")));
        String line = reader.readLine();//Mona,Dow,99988897,mona@gmail.com,Haifa,friend

        while (line != null) {
            String[] split = line.split(";");
            list.add(new Object[]{Contact.builder()//mi ispolzovali tolko pervuyu stroku
                    .name(split[0])
                    .lastName(split[1])
                    .phone(split[2])
                    .email(split[3])
                    .address(split[4])
                    .description(split[5])
                    .build()});
            line = reader.readLine();//chitaem 2-yu stroku -->

        }
        return list.iterator();
    }
}
