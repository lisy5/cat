package com.dianping.cat.message.consumer.transactionreport;

import java.io.IOException;

import org.junit.Test;
import org.xml.sax.SAXException;

import com.dianping.cat.consumer.failurereport.entity.FailureReport;
import com.dianping.cat.consumer.failurereport.transform.DefaultJsonBuilder;
import com.dianping.cat.consumer.failurereport.transform.DefaultParser;
import com.site.helper.Files;

public class TransactionReportModelTest {
	@Test
	public void test() throws SAXException, IOException {
		String xml = Files.forIO().readFrom(getClass().getResourceAsStream("/TransactionView.xml"), "utf-8");
		FailureReport report = new DefaultParser().parse(xml);

		System.out.println(report);

		report.getMachines().addMachine("a").addMachine("b");

		System.out.println(report);

		DefaultJsonBuilder jsonBuilder = new DefaultJsonBuilder();

		jsonBuilder.visitFailureReport(report);
		System.out.println(jsonBuilder.getString());
	}
}
