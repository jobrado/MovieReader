/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hr.algebra.parser.rss;

import hr.algebra.factory.ParserFactory;
import hr.algebra.factory.UrlConnectionFactory;
import hr.algebra.model.Actor;
import hr.algebra.model.Director;
import hr.algebra.model.Movie;
import hr.algebra.utils.FileUtils;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.Characters;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;

/**
 *
 * @author Jo
 */
public class MovieParser {

    private static final String RSS_URL = "https://www.blitz-cinestar.hr/rss.aspx?najava=1";
    private static final String ATT_URL = "plakat";
    private static final String EXT = ".jpg";
    private static final String DIR = "\\assets";
    private static final String DILIMITER = ",";

    private MovieParser() {
    }

    public static List<Movie> parse() throws IOException, XMLStreamException {
        List<Movie> movies = new ArrayList<>();
        HttpURLConnection con = UrlConnectionFactory.getHttpUrlConnection(RSS_URL);
        try (InputStream is = con.getInputStream()) {
            XMLEventReader reader = ParserFactory.createStaxParser(is);

            Optional<TagType> tagType = Optional.empty();
            Movie movie = null;

            StartElement startElement = null;

            while (reader.hasNext()) {
                XMLEvent event = reader.nextEvent();

                switch (event.getEventType()) {
                    case XMLStreamConstants.START_ELEMENT:
                        startElement = event.asStartElement();
                        String qName = startElement.getName().getLocalPart();
                        tagType = TagType.from(qName);
                        if (tagType.isPresent() && tagType.get().equals(TagType.ITEM)) {
                            movie = new Movie();
                            movies.add(movie);
                        }

                        break;

                    case XMLStreamConstants.CHARACTERS:
                        if (tagType.isPresent() && movie != null) {
                            Characters chars = event.asCharacters();
                            String data = chars.getData().trim();
                            switch (tagType.get()) {
                                case TITLE:
                                    if (!data.isEmpty()) {
                                        movie.setTitle(data);
                                    }
                                    break;
                                case PUB_DATE:
                                    if (!data.isEmpty()) {
                                        movie.setPubDate(
                                                LocalDate.parse(data,
                                                        DateTimeFormatter.RFC_1123_DATE_TIME)
                                        );
                                    }
                                    break;

                                case DESC:
                                    if (!data.isEmpty()) {
                                        movie.setDescription(data);
                                    }
                                    break;
                                case ORIG_TITLE:
                                    if (!data.isEmpty()) {
                                        movie.setOrigiTitle(data);
                                    }
                                    break;
                                case DIRECTOR:
                                    if (!data.isEmpty()) {
                                        movie.setDirector(handleDirector(data));

                                    }
                                    break;
                                case ACTOR:
                                    if (!data.isEmpty()) {
                                        movie.setActors(handleActor(data));
                                    }
                                    break;
                                case DURATION:
                                    if (!data.isEmpty()) {
                                        movie.setDuration(Integer.parseInt(data));
                                    }
                                    break;
                                case GENRE:
                                    if (!data.isEmpty()) {
                                        movie.setGenre(data);
                                    }
                                    break;
                                case PICTURE_PATH:
                                    
                                    if (!data.isEmpty()) {
                                        handlePicture(movie, data);
                                    }
                                    break;

                            }
                        }
                        break;
                }
            }
        }
        return movies;
    }

    private static void handlePicture(Movie movie, String pictureUrl) {
        try {
            String ext = pictureUrl.substring(pictureUrl.lastIndexOf("."));
            if (ext.length() > 4) {
                ext = EXT;

            }
            String name = UUID.randomUUID() + ext;
            String localPath = DIR + File.separator + name;
            FileUtils.copyFromUrl(pictureUrl, localPath);
            movie.setPicturePath(localPath);
        } catch (IOException ex) {
            Logger.getLogger(MovieParser.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private static List<Actor> handleActor(String data) {
        List<Actor> actors = new ArrayList<>();

        String[] resoults = data.split(DILIMITER);
        for (String res : resoults) {
            Actor actor = new Actor(
                    res
            );
            actors.add(actor);
        }
        return actors;
    }

    private static Director handleDirector(String name) {
        return new Director(name);

    }

    private enum TagType {
        ITEM("item"),
        TITLE("title"),
        PUB_DATE("pubDate"),
        DESC("description"),
        ORIG_TITLE("orignaziv"),
        DIRECTOR("redatelj"),
        ACTOR("glumci"),
        DURATION("trajanje"),
        GENRE("zanr"),
        PICTURE_PATH("plakat");

        private final String name;

        private TagType(String name) {
            this.name = name;
        }

        private static Optional<TagType> from(String name) {
            for (TagType value : values()) {
                if (value.name.equals(name)) {
                    return Optional.of(value);
                }
            }

            return Optional.empty();
        }
    }

}
