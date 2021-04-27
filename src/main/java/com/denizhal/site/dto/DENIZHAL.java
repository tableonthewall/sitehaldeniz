package com.denizhal.site.dto;

import javax.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "DENIZHAL")
public class DENIZHAL {

    @XmlElement
    private String version;

    public DENIZHAL(String version) {
        this.version = version;
    }

    public DENIZHAL() {
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }
}
