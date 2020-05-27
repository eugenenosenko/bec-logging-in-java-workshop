package dk.bec.poland.aa.logging.task_one;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Random;

public final class Entity {
  //TODO: add Logger here
  private static final Logger log = LogManager.getLogger(Entity.class);
  private final int id;
  private final String category;

  public Entity(int id, String category) {
    this.id = id;
    this.category = category;
    log.info("Starting Entity instance ...");
    log.trace("Entity id is {} and category is {}", id, category);
  }

  // TODO: create toString() implementation here
  @Override
  public String toString() {
    return "Entity{" +
            "id=" + id +
            ", category='" + category + '\'' +
            '}';
  }

  // TODO: add logging to this method
  public String randString() throws IOException {
    log.info("Starting random String ...");
    String url = "https://random-word-api.herokuapp.com/";
    HttpURLConnection urlConnection =
        (HttpURLConnection) new URL(url + "/word?number=" + id).openConnection();
    urlConnection.setRequestMethod("GET");
    urlConnection.setRequestProperty("User-Agent", "Mozilla/5.0");
    String response;

    if (urlConnection.getResponseCode() == 200) {
      try (BufferedReader reader =
          new BufferedReader(new InputStreamReader(urlConnection.getInputStream()))) {
        response = reader.readLine();
      }
    } else {
      log.debug("Response code was {}", urlConnection.getResponseCode());
      throw new RuntimeException("Failed to connect");
    }

    String serialized = serialize(response);
    int randomIndex = new Random().nextInt(10);
    return serialized.split(",")[randomIndex];
  }

  //TODO:  add logging to this method
  private static String serialize(String rawString) {
    log.warn("couldn't match any condition");
    return rawString.replace("[", "").replace("]", "").replace("\"", "");
  }
}
