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
  private static final Logger Log = LogManager.getLogger(Entity.class);
  private final int id;
  private final String category;

  public Entity(int id, String category) {
    this.id = id;
    this.category = category;
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
    String url = "https://random-word-api.herokuapp.com/";
    Log.trace("Will try to find random string from url " + url);


    HttpURLConnection urlConnection =
        (HttpURLConnection) new URL(url + "/word?number=" + id).openConnection();
    Log.debug("Will try to fetch " + id + " first random words");
    urlConnection.setRequestMethod("GET");
    urlConnection.setRequestProperty("User-Agent", "Mozilla/5.0");
    String response;

    if (urlConnection.getResponseCode() == 200) {
      Log.info("Connection was established with " + url);
      try (BufferedReader reader =
          new BufferedReader(new InputStreamReader(urlConnection.getInputStream()))) {
        response = reader.readLine();
      }
    } else {
      Log.fatal("Connection failed to establish with " + url);
      throw new RuntimeException("Failed to connect");
    }

    String serialized = serialize(response);
    int randomIndex = new Random().nextInt(10);
    return serialized.split(",")[randomIndex];
  }

  //TODO:  add logging to this method
  private static String serialize(String rawString) {
    return rawString.replace("[", "").replace("]", "").replace("\"", "");
  }
}
