package org.dtodo1paco.samples.graphdb.services;

import org.dtodo1paco.samples.graphdb.model.projections.ItemProperties;
import org.dtodo1paco.samples.util.FileUtils;
import org.neo4j.driver.Driver;
import org.neo4j.driver.Record;
import org.neo4j.driver.Session;
import org.neo4j.driver.SessionConfig;
import org.neo4j.driver.types.TypeSystem;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.neo4j.core.Neo4jClient;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Map;

@Service
public class DatabaseService {

  @Value("${spring.data.neo4j.database:neo4j}")
  private String databaseName;

  private final Driver driver;
  private Neo4jClient client;

  public DatabaseService(Driver driver, Neo4jClient client) {
    this.driver = driver;
    this.client = client;
  }

  public void create() {
    String content = FileUtils.readFile("db/create-course-data.txt");
    Session session = getSession();
    session.run(content);
    session.close();
  }

  public void drop() {
    String content = FileUtils.readFile("db/delete-all-data.txt");
    Session session = getSession();
    session.run(content);
    session.close();
  }

  private Session getSession() {
    return driver.session(SessionConfig.forDatabase(databaseName));
  }

  //public <T> Collection<T> query(String query, Class<T> type) {
  public Collection<Map<String, Object>> query(String query) {
    if (logger.isDebugEnabled()) {
      logger.debug("Running query: {}",query);
    }
    Collection<Map<String, Object>> result = client.query(query).fetch().all();
    return result;
  }

  public Collection<ItemProperties> findItems(String query, Integer limit) {
    Neo4jClient.RunnableSpecTightToDatabase res = client.query(query + (limit != null ? " LIMIT $limit" : ""));
    res = res.bind(limit).to("limit");
    if (logger.isDebugEnabled()) {
      logger.debug("Fetching {} records of query: {}" ,limit, query);
    }
    return res.fetchAs(ItemProperties.class)
             .mappedBy((TypeSystem t, Record record) -> {
               return new ItemProperties(record.asMap());
             })
             .all();
  }

  private static Logger logger = LoggerFactory.getLogger(DatabaseService.class);
}
