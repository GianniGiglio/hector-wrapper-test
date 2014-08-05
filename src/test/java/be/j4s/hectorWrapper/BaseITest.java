package be.j4s.hectorWrapper;

import org.junit.Before;
import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.Test;

import com.lordofthejars.nosqlunit.annotation.UsingDataSet;
import com.lordofthejars.nosqlunit.cassandra.CassandraRule;
import com.lordofthejars.nosqlunit.cassandra.EmbeddedCassandra;
import com.lordofthejars.nosqlunit.cassandra.EmbeddedCassandraConfigurationBuilder;
import com.lordofthejars.nosqlunit.core.LoadStrategyEnum;
import com.melexis.ape.hector.wrapper.dao.GenericCassandraDao;
import com.melexis.ape.hector.wrapper.dao.GenericDao;


public class BaseITest  {
	
	@ClassRule
	public static EmbeddedCassandra embeddedCassandraRule = EmbeddedCassandra.EmbeddedCassandraRuleBuilder.newEmbeddedCassandraRule().build();
	
	@Rule
	public CassandraRule cassandraRule = new CassandraRule(EmbeddedCassandraConfigurationBuilder.newEmbeddedCassandraConfiguration().clusterName("Test Cluster").build());
	
	 private GenericDao dao;
	
	@Before 
	public void setup() {
		 dao = new GenericCassandraDao(cassandraRule.getDatabaseOperation().connectionManager());
	}

   
	@Test
	@UsingDataSet(locations = "GenericCassandraDaoITest#entityWithNamedColumns-beforeUpdate.json", loadStrategy = LoadStrategyEnum.CLEAN_INSERT)
	public void insertAvailability() {
	//Store availability 
    //key availabityType column date(as long value)
	//dao.store(availability);
	}
	
	@Test
	public void inserAvailabilityWithHandlerName() {
	//Store availability 
    //key composit handler/availabityType column date(as long value)
	}
	
	@Test
	public void readAvailability() {
	//readAvailabilty
	}
	
	@Test
	public void readAvailabilityComposit() {
	//readAvailabilty
	}
	
	@Test
	public void insertReport() {
	//Store Report 
    //key date(as long) columns fields of file
	}
	
	@Test
	public void readReport() {
	//read reports from 4/01/2014 till 06/01/2014 
    //work with a dataset with min 6 rows
	}
	
	@Test
	public void insertKitypeWhitJson() {
	//Store Kittypes as json 
    //key  site/machinetype/kittype  columnName date(as long) value json(json is made by handlers, devices, lots)
	}

   

	
	
}