package dev.br.teaming.domain.video.infra;

import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.HttpRequestInitializer;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.services.youtube.YouTube;
import com.google.api.services.youtube.model.SearchListResponse;
import com.google.api.services.youtube.model.SearchResult;
import dev.br.teaming.domain.video.domain.Video;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;


@Slf4j
@Component
public class DefaultYoutubeVideoClient implements YoutubeVideoClient {

    /** Global instance properties filename. */
    private String PROPERTIES_FILENAME = "youtube.properties";

    /** Global instance of the HTTP transport. */
    private final HttpTransport HTTP_TRANSPORT = new NetHttpTransport();

    /** Global instance of the JSON factory. */
    private final JsonFactory JSON_FACTORY = new JacksonFactory();

    /** Global instance of the max number of videos we want returned (50 = upper limit per page). */
    private final long NUMBER_OF_VIDEOS_RETURNED = 25;

    /** Global instance of Youtube object to make all API requests. */
    private YouTube youtube;

    @Override
    public List<Video> searchYoutubeVideoByKeyWord(String keyword) throws IOException {

        List<Video> response = new ArrayList<>();
        Properties properties = new Properties();
        InputStream in = YouTube.Search.class.getResourceAsStream("/" + PROPERTIES_FILENAME);
        properties.load(in);

        youtube = new YouTube.Builder(HTTP_TRANSPORT, JSON_FACTORY, new HttpRequestInitializer() {
            public void initialize(HttpRequest request) throws IOException {}
        }).setApplicationName("youtube-cmdline-search-sample").build();

        String queryTerm = keyword;
        YouTube.Search.List search = youtube.search().list("id,snippet");
        String apiKey = properties.getProperty("youtube.apikey");
        search.setKey(apiKey);
        search.setQ(queryTerm);
        search.setType("video");
        //TODO: 채널검색
        search.setChannelId("UCoH2pCzAr6zWDG-LtUiLWRw");
        search.setFields(
                "nextPageToken," +
                "items(id/kind,id/videoId," +
                "snippet/title,snippet/publishedAt,snippet/channelId,snippet/channelTitle,snippet/description,snippet/thumbnails/default/url)"
        );
        search.setMaxResults(NUMBER_OF_VIDEOS_RETURNED);
        SearchListResponse searchResponse = search.execute();

        List<SearchResult> searchResultList = searchResponse.getItems();

        if (searchResultList != null) {
            Iterator<SearchResult> iterator = searchResultList.iterator();
            while (iterator.hasNext()) {
                response.add(Video.from(iterator.next()));
            }
        }
        return response;
    }
}
