package com.denizhal.site.dto;

import javax.xml.bind.annotation.*;

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

    public DENIZHAL getDENIZHAL() {
        return DENIZHAL;
    }

    public void setDENIZHAL(DENIZHAL DENIZHAL) {
        this.DENIZHAL = DENIZHAL;
    }

    public ASESHK getASESHK() {
        return ASESHK;
    }

    public void setASESHK(ASESHK ASESHK) {
        this.ASESHK = ASESHK;
    }
}
