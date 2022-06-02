package dev.br.teaming.domain.video.infra;

import com.google.api.client.googleapis.json.GoogleJsonResponseException;
import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.HttpRequestInitializer;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.services.youtube.YouTube;
import com.google.api.services.youtube.model.ResourceId;
import com.google.api.services.youtube.model.SearchListResponse;
import com.google.api.services.youtube.model.SearchResult;
import com.google.api.services.youtube.model.Thumbnail;
import dev.br.teaming.domain.video.dto.VideoDTO;
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
    public List<VideoDTO> searchYoutubeVideoByKeyWord(String keyword) {
        // Read the developer key from youtube.properties
        List<VideoDTO> response = new ArrayList<>();
        Properties properties = new Properties();
        try {
            InputStream in = YouTube.Search.class.getResourceAsStream("/" + PROPERTIES_FILENAME);
            properties.load(in);
        } catch (IOException e) {
            log.error("There was an error reading " + PROPERTIES_FILENAME + ": " + e.getCause()
                    + " : " + e.getMessage());
            System.exit(1);
        }
        try {
            /*
             * The YouTube object is used to make all API requests. The last argument is required, but
             * because we don't need anything initialized when the HttpRequest is initialized, we override
             * the interface and provide a no-op function.
             */
            youtube = new YouTube.Builder(HTTP_TRANSPORT, JSON_FACTORY, new HttpRequestInitializer() {
                public void initialize(HttpRequest request) throws IOException {}
            }).setApplicationName("youtube-cmdline-search-sample").build();

            // Get query term from user.
            //String queryTerm = getInputQuery();
            String queryTerm = keyword;
            YouTube.Search.List search = youtube.search().list("id,snippet");
            /*
             * It is important to set your API key from the Google Developer Console for
             * non-authenticated requests (found under the Credentials tab at this link:
             * console.developers.google.com/). This is good practice and increased your quota.
             */
            String apiKey = properties.getProperty("youtube.apikey");
            search.setKey(apiKey);
            search.setQ(queryTerm);
            /*
             * We are only searching for videos (not playlists or channels). If we were searching for
             * more, we would add them as a string like this: "video,playlist,channel".
             */
            search.setType("video");
            /*
             * This method reduces the info returned to only the fields we need and makes calls more
             * efficient.
             */
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
                    SearchResult singleVideo = VideoDTO.from(iterator.next());
                }

            }
        } catch (GoogleJsonResponseException e) {
            log.error("There was a service error: " + e.getDetails().getCode() + " : "
                    + e.getDetails().getMessage());
        } catch (IOException e) {
            log.error("There was an IO error: " + e.getCause() + " : " + e.getMessage());
        } catch (Throwable t) {
            t.printStackTrace();
        }
        return response;
    }

    /*
     * Prints out all SearchResults in the Iterator. Each printed line includes title, id, and
     * thumbnail.
     *
     * @param iteratorSearchResults Iterator of SearchResults to print
     *
     * @param query Search query (String)
     */
    private void prettyPrint(Iterator<SearchResult> iteratorSearchResults, String query) {

        log.info("\n=============================================================");
        log.info(
                "   First " + NUMBER_OF_VIDEOS_RETURNED + " videos for search on \"" + query + "\".");
        log.info("=============================================================\n");

        if (!iteratorSearchResults.hasNext()) {
            log.info(" There aren't any results for your query.");
        }

        while (iteratorSearchResults.hasNext()) {

            SearchResult singleVideo = iteratorSearchResults.next();
            ResourceId rId = singleVideo.getId();

            // Double checks the kind is video.
            if (rId.getKind().equals("youtube#video")) {
                Thumbnail thumbnail = (Thumbnail) singleVideo.getSnippet().getThumbnails().get("default");

                log.info(" Video Id: " + rId.getVideoId());
                log.info(" youtuber channelId: " + singleVideo.getSnippet().getChannelId());
                log.info(" youtuber channelTitle: " + singleVideo.getSnippet().getChannelTitle());
                log.info(" Video Title: " + singleVideo.getSnippet().getTitle());
                log.info(" Video description: " + singleVideo.getSnippet().getDescription());
                log.info(" Thumbnail: " + thumbnail.getUrl());
                log.info("\n-------------------------------------------------------------\n");
            }
        }
    }
}
