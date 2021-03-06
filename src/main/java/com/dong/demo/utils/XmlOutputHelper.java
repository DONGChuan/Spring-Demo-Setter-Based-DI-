package com.dong.demo.utils;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.PrettyPrintWriter;
import com.thoughtworks.xstream.io.xml.StaxDriver;

import java.io.BufferedOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.stream.Stream;

/**
 * Created by dchuan on 2016/3/13.
 */
public class XmlOutputHelper implements IOutputHelper {

    /**
     * Generate employee info on xml and output on console
     * @param object
     */
    public void generateInfo(Object object) {

        XStream xstream = new XStream(new StaxDriver());

        // Enable pretty xml output
        BufferedOutputStream stdout = new BufferedOutputStream(System.out);
        xstream.marshal(object, new PrettyPrintWriter(new OutputStreamWriter(stdout)));

        String xml = xstream.toXML(object);

        try {
            //write converted xml data to a file named "file.xml"
            FileWriter writer = new FileWriter("file.xml");
            writer.write(xml);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Output on console
        System.out.println(xml);
    }
}
