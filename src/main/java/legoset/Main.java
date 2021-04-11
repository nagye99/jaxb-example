package legoset;

import jakarta.xml.bind.JAXBException;
import jaxb.JAXBHelper;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.time.Year;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;


public class Main {

    public static void main(String[] args) throws Exception {
        var legoset = new LegoSet();
        legoset.setName("Imperial TIE Fighter");
        legoset.setTheme("Star Wars");
        legoset.setSubtheme("Solo");
        legoset.setYear(Year.of(2018));
        legoset.setPieces(519);
        legoset.setTags(Set.of("Starfighter", "Stormtrooper", "Star Wars", "Solo"));
        legoset.setPackaging(LegoSet.Packaging.BOX);
        legoset.setNumber("75211");
        legoset.setUrl("https://brickset.com/sets/75211-1/Imperial-TIE-Fighter");

        var minifigs = new ArrayList<Minifig>();
        minifigs.add(new Minifig(2, "Imperial Mudtrooper"));
        minifigs.add(new Minifig(1, "Imperial Pilot"));
        minifigs.add(new Minifig(1, "Mimban Stormtrooper"));
        legoset.setMinifigs(minifigs);

        var ratings = new Ratings(468,4.4);
        legoset.setRatings(ratings);

        JAXBHelper.toXML(legoset, new FileOutputStream("legoset.xml"));

    }

}
