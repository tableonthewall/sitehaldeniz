package com.denizhal.site.dto;


import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class test {
//    public static void main(String[] args) {
//
//        DENIZHAL denizhal=new DENIZHAL("1.22.3");
//        ASESHK aseshk=new ASESHK("2.3.45");
//        ProjectUpdate projectUpdate=new ProjectUpdate(denizhal,aseshk);
//
//        try {
//            // create JAXB context and initializing Marshaller
//            JAXBContext jaxbContext = JAXBContext.newInstance(ProjectUpdate.class);
//            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
//
//            // for getting nice formatted output
//            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
//
//            //specify the location and name of xml file to be created
//            File XMLfile = new File("D:\\test\\test.xml");
//
//            // Writing to XML file
//            jaxbMarshaller.marshal(projectUpdate, XMLfile);
//            // Writing to console
//            jaxbMarshaller.marshal(projectUpdate, System.out);
//
//        } catch (JAXBException e) {
//            // some exception occured
//            e.printStackTrace();
//        }
//
//        try {
//
//            // create JAXB context and initializing Marshaller
//            JAXBContext jaxbContext = JAXBContext.newInstance(ProjectUpdate.class);
//
//            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
//
//            // specify the location and name of xml file to be read
//            URL XMLfile = new URL("http://www.asesyazilim.com/update/versiyonupdate.xml");
//            //File XMLfile = new File("D:\\test\\test.xml");
//            // this will create Java object - country from the XML file
//            ProjectUpdate project_update1 = (ProjectUpdate) jaxbUnmarshaller.unmarshal(XMLfile);
//
//            if(project_update1==null){
//                System.out.println("null");
//            }
//            System.out.println("DenizHal Version "+project_update1.getDENIZHAL().getVersion());
//            System.out.println("Ases version: "+project_update1.getASESHK().getVersion());
//
//
//        } catch (JAXBException | MalformedURLException e) {
//            // some exception occured
//            e.printStackTrace();
//        }
//    }
}
