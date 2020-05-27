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

  private static final Logger log = LogManager.getLogger(Entity.class);

  private final int id;
  private final String category;

  public Entity(int id, String category) {
    this.id = id;
    this.category = category;
  }

  @Override
  public String toString() {
    return "Entity{" +
            "id=" + id +
            ", category='" + category + '\'' +
            '}';
  }


  public String randString() throws IOException {
    String url = "https://random-word-api.herokuapp.com/";

    HttpURLConnection urlConnection =
        (HttpURLConnection) new URL(url + "/word?number=" + id).openConnection();
    urlConnection.setRequestMethod("GET");
    urlConnection.setRequestProperty("User-Agent", "Mozilla/5.0");
    String response;
    log.info("Connection opened to url: " + url + "/word?number=" + id);

    if (urlConnection.getResponseCode() == 200) {
      log.info("The response code is 200");
      try (BufferedReader reader =
          new BufferedReader(new InputStreamReader(urlConnection.getInputStream()))) {
        response = reader.readLine();
        log.info("Correctly read the response from the url connection");
        log.debug("Response from the server " + url + "was" + response);
      }
    } else {
      log.error("Connection is failed");
      throw new RuntimeException("Failed to connect");
    }

    String serialized = serialize(response);
    log.info("String is serialized to: " + serialized);
    int randomIndex = new Random().nextInt(10);
    return serialized.split(",")[randomIndex];
  }

  private static String serialize(String rawString) {
    log.trace("Serializing to strings: " + rawString);
    return rawString.replace("[", "").replace("]", "").replace("\"", "");
  }
}
