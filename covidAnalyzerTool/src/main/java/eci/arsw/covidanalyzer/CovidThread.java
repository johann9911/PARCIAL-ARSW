package eci.arsw.covidanalyzer;

import java.io.File;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class CovidThread extends Thread {
	private int limiteinf;
	private int limitesup;
	private List<File> resultFiles;
	private TestReader testReader;
	private AtomicInteger amountOfFilesProcessed;
	private ResultAnalyzer resultAnalyzer;

	public CovidThread(int limiteinf, int limitesup, List<File> resultFiles, ResultAnalyzer resultAnalyzer,
			TestReader testReader, AtomicInteger amountOfFilesProcessed) {
		this.limiteinf=limiteinf;
		this.limitesup=limitesup;
		this.resultFiles=resultFiles;
		this.resultAnalyzer=resultAnalyzer;
		this.testReader=testReader;
		this.amountOfFilesProcessed=amountOfFilesProcessed;
		boolean pausado = false;

	}

	public void run() {
		System.out.println(limiteinf+"--"+limitesup);
		for(int j=limiteinf;j<=limitesup;j++)
		{       
			List<Result> results = testReader.readResultsFromFile(resultFiles.get(j));
            for (Result result : results) {
                resultAnalyzer.addResult(result);
            }
            amountOfFilesProcessed.incrementAndGet();
		}
	}

}
