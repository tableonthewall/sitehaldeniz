package com.denizhal.site.dto;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;

@XmlRootElement(name="Project_Update")
@XmlType(propOrder = {"DENIZHAL","ASESHK"})
public class ProjectUpdate {
    private DENIZHAL DENIZHAL;
    private ASESHK ASESHK;

    public ProjectUpdate(DENIZHAL DENIZHAL, ASESHK ASESHK) {
        this.DENIZHAL = DENIZHAL;
        this.ASESHK = ASESHK;
    }

    public ProjectUpdate() {
    }

    public com.denizhal.site.dto.DENIZHAL getDENIZHAL() {
        return DENIZHAL;
    }

    public void setDENIZHAL(com.denizhal.site.dto.DENIZHAL DENIZHAL) {
        this.DENIZHAL = DENIZHAL;
    }

    public com.denizhal.site.dto.ASESHK getASESHK() {
        return ASESHK;
    }

    public void setASESHK(com.denizhal.site.dto.ASESHK ASESHK) {
        this.ASESHK = ASESHK;
    }

    // getter and setter here
}
