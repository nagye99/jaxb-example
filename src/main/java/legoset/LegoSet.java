package legoset;

import jakarta.xml.bind.annotation.*;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import lombok.Data;

import java.time.Year;
import java.util.List;
import java.util.Set;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(propOrder = {"name", "theme", "subtheme", "year", "pieces", "packaging",  "tags", "minifigs", "ratings"} )
@Data
public class LegoSet {

    @XmlAttribute
    private String number;

    @XmlAttribute
    private String url;

    @XmlJavaTypeAdapter(YearAdapter.class)
    private Year year;
    private int pieces;

    @XmlEnum
    public enum Packaging{BOX, POLYBAG};
    private Packaging packaging;   
    
    @XmlElementWrapper(name = "tags")
    @XmlElement(name = "tag")
    private Set<String> tags;

    @XmlElementWrapper(name = "minifigs")
    @XmlElement(name = "minifig")
    private List<Minifig> minifigs;
    private String name;
    private String theme;
    private String subtheme;
    private Ratings ratings;
}
