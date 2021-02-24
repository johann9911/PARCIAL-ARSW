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
	private boolean pausado;

	public CovidThread(int limiteinf, int limitesup, List<File> resultFiles, ResultAnalyzer resultAnalyzer,
			TestReader testReader, AtomicInteger amountOfFilesProcessed) {
		this.limiteinf=limiteinf;
		this.limitesup=limitesup;
		this.resultFiles=resultFiles;
		this.resultAnalyzer=resultAnalyzer;
		this.testReader=testReader;
		this.amountOfFilesProcessed=amountOfFilesProcessed;
		pausado = false;

	}

	public void run() {
		System.out.println(limiteinf+"--"+limitesup);
		for(int j=limiteinf;j<=limitesup;j++)
		{       
			List<Result> results = testReader.readResultsFromFile(resultFiles.get(j));
            for (Result result : results) {
            	synchronized (this) {
					while(pausado) {
						try {
							this.wait();
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						
					}
					
				}
                resultAnalyzer.addResult(result);
            }
            amountOfFilesProcessed.incrementAndGet();
		}
	}
	
	public synchronized void pausar() {
		if(pausado) {
			pausado=false;
		}else {
			pausado=true;
		}
		
		notifyAll();
	}


}
