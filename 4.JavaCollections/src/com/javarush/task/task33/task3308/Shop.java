package com.javarush.task.task33.task3308;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.util.List;

@XmlRootElement
@XmlType(name = "shop")
public class Shop {

    @XmlElement(name = "goods")
    public Goods goods;
    @XmlElement(name = "count")
    public int count;
    @XmlElement(name = "profit")
    public double profit;

    @XmlElement(name = "secretData")
    public String[] secretData;

    @XmlType
    public static class Goods {
        @XmlElement(name = "names")
        public List<String> names;
    }
}
