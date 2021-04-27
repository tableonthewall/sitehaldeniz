package com.denizhal.site.dto;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@XmlRootElement(name = "Project_Update")
@XmlType(propOrder = {"denizhal","aseshk"})
public class Project_Update {


    private DENIZHAL denizhal;
    private ASESHK aseshk;

    public Project_Update() {
    }

    public Project_Update(DENIZHAL denizhal, ASESHK aseshk) {
        this.denizhal = denizhal;
        this.aseshk = aseshk;
    }

    public DENIZHAL getDenizhal() {
        return denizhal;
    }
    @XmlElement(name = "denizhal")
    public void setDenizhal(DENIZHAL denizhal) {
        this.denizhal = denizhal;
    }

    public ASESHK getAseshk() {
        return aseshk;
    }
    @XmlElement(name = "aseshk")
    public void setAseshk(ASESHK aseshk) {
        this.aseshk = aseshk;
    }
}
