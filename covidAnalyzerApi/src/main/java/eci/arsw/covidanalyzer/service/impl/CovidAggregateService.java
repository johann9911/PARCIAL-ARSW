package eci.arsw.covidanalyzer.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.stereotype.Service;

import eci.arsw.covidanalyzer.model.Result;
import eci.arsw.covidanalyzer.model.ResultType;
import eci.arsw.covidanalyzer.service.ICovidAggregateService;

@Service
public class CovidAggregateService implements ICovidAggregateService {

	private List<Result> results = new ArrayList<>();
	
	public CovidAggregateService() {
		Result r1=new Result("johann","bogota");
		r1.setResulType(ResultType.TRUE_POSITIVE);
		results.add(r1);
		
		
	}
	
	@Override
	public boolean aggregateResult(Result result, ResultType type) {
		boolean esta=false;
		for(Result r:results) {
			if(r.equals(result)) {
				r.sumResul();
				esta=true;
			}
		}
		if(!esta) {
			results.add(result);
		}
		result.setResulType(type);
		return true;
	}
	

	@Override
	public List<Result> getResult(ResultType type) {
		List<Result> copia = new ArrayList<>();
		for(Result r:results) {
			if(r.getResulType().equals(type)) {
				copia.add(r);
			}
		}
		return copia;
	}

	@Override
	public void upsertPersonWithMultipleTests(UUID id, ResultType type) {
		for(Result r:results) {
			System.out.println("---");
			if(r.equals2(id)) {
				
				r.setResulType(type);
				r.sumResul();
			}
		}
		
	}

}
