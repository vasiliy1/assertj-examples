/**
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
 *
 * Copyright 2012-2014 the original author or authors.
 */
package org.assertj.examples.neo4j;

import org.assertj.examples.data.neo4j.DragonBallGraph;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.neo4j.graphdb.GraphDatabaseService;
import org.neo4j.test.TestGraphDatabaseFactory;

import java.io.IOException;

public class Neo4jAssertionExamples {

  protected static GraphDatabaseService graphDB;
  protected static DragonBallGraph dragonBallGraph;

  @BeforeClass
  public static void prepare_graph() throws IOException {
    graphDB = new TestGraphDatabaseFactory().newImpermanentDatabase();
    dragonBallGraph = new DragonBallGraph(graphDB);
    dragonBallGraph.importGraph(
      Neo4jAssertionExamples.class.getResourceAsStream("/dragonBall.cypher")
    );
  }

  @AfterClass
  public static void cleanUp() {
    graphDB.shutdown();
  }
}
