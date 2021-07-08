package com.denizhal.site.xmlConnetion;

import com.denizhal.site.dto.ProjectUpdate;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.net.MalformedURLException;
import java.net.URL;

public class GetVersion {
    JAXBContext jaxbContext;
    Unmarshaller jaxbUnmarshaller;
    URL xmlFile;
    ProjectUpdate projectUpdate;

    public GetVersion() throws JAXBException, MalformedURLException {
        jaxbContext=JAXBContext.newInstance(ProjectUpdate.class);
        jaxbUnmarshaller=jaxbContext.createUnmarshaller();
        xmlFile=new URL("http://www.asesyazilim.com/update/versiyonupdate.xml");
        projectUpdate= (ProjectUpdate) jaxbUnmarshaller.unmarshal(xmlFile);
    }

    public String getVersion(){
        if(this.projectUpdate==null){
            return null;
        }else{
            return projectUpdate.getDENIZHAL().getVersion();
        }
    }


}
