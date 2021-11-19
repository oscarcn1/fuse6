package com.example.fuse.beans;

import java.util.List;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import com.example.fuse.InputSOATest;
import com.example.fuse.OutputSOATest;

public class CamelProcessor implements Processor {

    public void process(Exchange exchange) throws Exception {
        OutputSOATest out = new OutputSOATest();
        List soaList = exchange.getIn().getBody(List.class);
        InputSOATest inputSOATest = (InputSOATest) soaList.get(0);
        out.setResult("Welcome " + inputSOATest.getTest().toString());
        exchange.getOut().setBody(out);
    }

}